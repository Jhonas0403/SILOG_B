-- ============================================================
-- V8: Create expenses table
--
-- Depends on: users (V1), expense_categories (V7)
--
-- Why no FK to companies/stores:
--   Those tables live in another microservice — no DB-level FK.
-- ============================================================

CREATE TABLE IF NOT EXISTS expenses (
    expense_id          UUID            PRIMARY KEY DEFAULT gen_random_uuid(),
    company_id          UUID            NOT NULL,   -- from ORGANIZATION service, no FK
    store_id            UUID,                       -- from ORGANIZATION service, no FK
    expense_category_id UUID            NOT NULL REFERENCES expense_categories(expense_category_id),
    expense_description VARCHAR(255),
    amount              DECIMAL(12, 2)  NOT NULL,
    expense_date        DATE            NOT NULL,
    expense_status      BOOLEAN         NOT NULL DEFAULT TRUE,

    created_by  UUID        REFERENCES users(user_id),
    updated_by  UUID        REFERENCES users(user_id),
    created_at  TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ,

    CONSTRAINT chk_expenses_amount_positive
        CHECK (amount > 0)
);

COMMENT ON TABLE expenses IS 'Business expenses recorded per company/store';
