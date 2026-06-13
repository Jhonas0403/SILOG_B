-- ============================================================
-- V5: Create products table
--
-- Depends on: brands (V4)
-- This table was also MISSING from the old schema files.
-- ============================================================

CREATE TABLE IF NOT EXISTS products (
    product_id       UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_name     VARCHAR(150)    NOT NULL,
    product_brand_id UUID            REFERENCES brands(brand_id),
    product_status   BOOLEAN         NOT NULL DEFAULT TRUE,
    product_order    INTEGER,

    created_by  UUID        REFERENCES users(user_id),
    updated_by  UUID        REFERENCES users(user_id),
    created_at  TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ
);

COMMENT ON TABLE products IS 'Products catalog, each product belongs to a brand';
