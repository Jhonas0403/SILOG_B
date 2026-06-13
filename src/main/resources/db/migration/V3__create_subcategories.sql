-- ============================================================
-- V3: Create subcategories table
--
-- Depends on: categories (V2)
-- This table was also MISSING from the old schema files.
-- ============================================================

CREATE TABLE IF NOT EXISTS subcategories (
    subcategory_id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    subcategory_name        VARCHAR(100)    NOT NULL,
    subcategory_status      BOOLEAN         NOT NULL DEFAULT TRUE,
    subcategory_order       INTEGER,
    subcategory_category_id UUID            REFERENCES categories(category_id),

    created_by  UUID        REFERENCES users(user_id),
    updated_by  UUID        REFERENCES users(user_id),
    created_at  TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ
);

COMMENT ON TABLE  subcategories                      IS 'Subcategories within a category';
COMMENT ON COLUMN subcategories.subcategory_category_id IS 'Parent category';
