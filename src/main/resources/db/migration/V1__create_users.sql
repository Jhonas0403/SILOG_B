-- ============================================================
-- V1: Create users table
--
-- Why UUID instead of SERIAL:
--   SERIAL generates sequential integers (1, 2, 3...).
--   UUID is better for microservices because:
--   - IDs are unique across services (no collision if tables are merged)
--   - They don't reveal how many records exist (security)
--
-- Why no FK to companies/stores:
--   Those tables belong to another microservice.
--   Database-level FKs across microservices are a bad practice because:
--   - They create tight coupling between services
--   - A restart of one service can break the other
--   - Use application-level validation instead
-- ============================================================

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS users (
    user_id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    -- External IDs from the ORGANIZATION microservice (no FK — see note above)
    company_id      UUID,
    store_id        UUID,
    user_role_id    UUID            NOT NULL,

    user_name       VARCHAR(100)    NOT NULL,
    user_lastname   VARCHAR(100)    NOT NULL,
    user_dni        VARCHAR(20)     NOT NULL UNIQUE,
    user_email      VARCHAR(255)    NOT NULL UNIQUE,
    user_password   VARCHAR(255)    NOT NULL,
    user_phone      VARCHAR(50)     NOT NULL UNIQUE,
    user_address    VARCHAR(255),
    user_status     BOOLEAN         NOT NULL DEFAULT TRUE,

    -- Audit columns: who created/modified and when
    created_by      UUID,
    updated_by      UUID,
    created_at      TIMESTAMPTZ     NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMPTZ
);

COMMENT ON TABLE  users              IS 'Application users belonging to a company/store';
COMMENT ON COLUMN users.company_id   IS 'Logical ID from ORGANIZATION service — no FK by design';
COMMENT ON COLUMN users.store_id     IS 'Logical ID from ORGANIZATION service — no FK by design';
COMMENT ON COLUMN users.user_role_id IS 'Role ID from ORGANIZATION service — no FK by design';
