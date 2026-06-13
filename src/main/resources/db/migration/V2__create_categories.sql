-- ============================================================
-- V2: Create categories table
--
-- This table was MISSING from the old schema files — it existed
-- only as a JPA entity. Flyway makes this reproducible.
-- ============================================================

CREATE TABLE IF NOT EXISTS categories (
    category_id     UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    category_name   VARCHAR(100)    NOT NULL,
    category_status BOOLEAN         NOT NULL DEFAULT TRUE,
    category_order  INTEGER,

    created_by      UUID            REFERENCES users(user_id),
    updated_by      UUID            REFERENCES users(user_id),
    created_at      TIMESTAMPTZ     NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMPTZ
);

COMMENT ON TABLE categories IS 'Product categories (e.g. Electronics, Clothing)';
