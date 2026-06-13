-- ============================================================
-- V7: Create expense_categories table
--
-- Depends on: users (V1)
--
-- Why no FK to companies:
--   company_id comes from the ORGANIZATION microservice.
--   Never add a DB-level FK to a table in another microservice.
-- ============================================================

CREATE TABLE IF NOT EXISTS expense_categories (
    expense_category_id UUID            PRIMARY KEY DEFAULT gen_random_uuid(),
    company_id          UUID            NOT NULL,   -- from ORGANIZATION service, no FK
    category_name       VARCHAR(100)    NOT NULL,
    category_description VARCHAR(255),
    category_status     BOOLEAN         NOT NULL DEFAULT TRUE,

    created_by  UUID        REFERENCES users(user_id),
    updated_by  UUID        REFERENCES users(user_id),
    created_at  TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ,

    -- A company cannot have two expense categories with the same name
    CONSTRAINT uq_expense_categories_company_name
        UNIQUE (company_id, category_name)
);

COMMENT ON TABLE  expense_categories           IS 'Categories for classifying business expenses per company';
COMMENT ON COLUMN expense_categories.company_id IS 'ID from ORGANIZATION service — stored but not FK-constrained';
