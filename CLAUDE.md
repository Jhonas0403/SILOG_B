# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Build
./mvnw clean package

# Build (skip tests)
./mvnw clean package -DskipTests

# Run locally (requires PostgreSQL)
./mvnw spring-boot:run

# Run tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=SilogUserApplicationTests

# Docker build
docker build -t silog-user .
```

**Environment variables for local run:**
- `DB_URL` — defaults to `jdbc:postgresql://localhost:5432/silog_db`
- `DB_USERNAME` — defaults to `admin`
- `DB_PASSWORD` — defaults to `1234`
- `PORT` — defaults to `8080`

## Architecture

This project follows **Hexagonal Architecture (Ports & Adapters)** strictly. There are four layers:

```
interfaces/rest/      ← HTTP controllers + DTOs (entry point)
application/service/  ← Use case implementations (orchestration)
domain/               ← Pure models + port interfaces (no framework deps)
infrastructure/       ← JPA entities, mappers, repository adapters, config
```

**Data flow for a request:**

```
Controller → UseCase (port/in) → Service → RepositoryPort (port/out) → Adapter → JPA Repository
```

- **Domain models** (`domain/model/`) are plain Java objects, completely decoupled from JPA.
- **Use cases** are split into granular interfaces: one interface per operation (e.g., `CreateBrandUseCase`, `GetBrandUseCase`). Services implement these interfaces.
- **Repository ports** (`domain/port/out/`) define what the domain needs from persistence; JPA adapters (`infrastructure/repository/adapter/`) implement them.
- **Mappers** (`infrastructure/mapper/`) convert between domain models and JPA entities. They are plain static-method classes (no framework annotation).
- **DTOs** (`interfaces/rest/*/dto/`) use `toDomain()` and `fromDomain()` static methods to convert to/from domain models.

## Domain modules

| Module | Notes |
|---|---|
| User | CRUD + PATCH support |
| Category / Subcategory | Hierarchical taxonomy |
| Brand | Ordered list; order auto-set on create |
| Product / Variant | Products belong to brands/subcategories; variants are product SKUs |
| Expense / ExpenseCategory | Expense tracking |
| Sale / SaleDetail | Sales header + line items; uses `ZonedDateTime` for `saleDate` |
| InventoryMovement | Stock movement log |
| CashSession | Cash register sessions with opening/closing; uses `ZonedDateTime` for `openedAt`/`closedAt` |

## Key conventions

**Auditing:** All entities extend `AuditableEntity`, which auto-fills `createdAt`, `updatedAt`, `createdBy`, `updatedBy` via Spring Data JPA auditing (`@EnableJpaAuditing`). Do **not** set these fields manually in services — the `AuditingEntityListener` handles it. Exception: some older services still set timestamps manually (tech debt).

**Time zones:** 
- Audit fields (`createdAt`, `updatedAt` in `AuditableEntity`) use `LocalDateTime` — these are infrastructure metadata, not business logic.
- Business-critical timestamps (`Sale.saleDate`, `CashSession.openedAt/closedAt`) use `ZonedDateTime` with `America/Lima` zone — this preserves timezone info for correct temporal queries and reconciliation.
- Set `ZonedDateTime` fields in services: `ZonedDateTime.now(ZoneId.of("America/Lima"))` — never rely on JVM timezone.
- Repository queries comparing business timestamps must use `ZonedDateTime` parameters to ensure consistent timezone-aware comparisons.

**Schema migrations:** Flyway owns the database schema. Migration scripts live in `src/main/resources/db/migration/` and follow the naming convention `V{n}__{description}.sql`. JPA is set to `ddl-auto: validate`. Never use `ddl-auto: create` or `update` in production config.

**Tests:** Tests use H2 in-memory with `MODE=PostgreSQL`. Flyway is disabled in tests; H2 creates the schema from JPA entity annotations (`ddl-auto: create-drop`). The test profile is `application-test.yml`.

**Security:** Currently all endpoints are open (`permitAll()`). JWT authentication is planned but not yet implemented — a TODO comment exists in `SecurityConfig.java`.

**Adding a new domain module** — follow this checklist in order:
1. Domain model in `domain/model/`
2. Use case interfaces in `domain/port/in/<Module>/`
3. Repository port in `domain/port/out/`
4. Flyway migration in `db/migration/`
5. JPA entity extending `AuditableEntity` in `infrastructure/entity/`
6. Static mapper in `infrastructure/mapper/`
7. JPA repository (`JpaXxxRepository`) + adapter (`XxxRepositoryAdapter`)
8. Service(s) in `application/service/<Module>/` implementing the use cases
9. Controller + DTOs in `interfaces/rest/<module>/`
