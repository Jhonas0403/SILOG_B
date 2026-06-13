-- ============================================================
-- V6: Create product_variants table
--
-- Depends on: products (V5)
-- This table was also MISSING from the old schema files.
--
-- Why DECIMAL(12,2) instead of DOUBLE PRECISION:
--   DOUBLE PRECISION (= Java Double) stores numbers in binary floating point.
--   This causes rounding errors with decimal money values.
--   Example: 0.1 + 0.2 = 0.30000000000000004 in floating point.
--   DECIMAL/NUMERIC stores numbers exactly — required for prices.
-- ============================================================

CREATE TABLE IF NOT EXISTS product_variants (
    variant_id              UUID            PRIMARY KEY DEFAULT gen_random_uuid(),
    variant_product_id      UUID            NOT NULL REFERENCES products(product_id),
    variant_name            VARCHAR(150)    NOT NULL,
    variant_barcode         VARCHAR(100)    UNIQUE,
    variant_stock           INTEGER         NOT NULL DEFAULT 0,

    -- Use DECIMAL, not FLOAT/DOUBLE, for all money columns
    variant_purchase_price  DECIMAL(12, 2)  NOT NULL,
    variant_sale_price      DECIMAL(12, 2)  NOT NULL,
    variant_min_sale_price  DECIMAL(12, 2),

    variant_order           INTEGER,
    variant_status          BOOLEAN         NOT NULL DEFAULT TRUE,

    created_by  UUID        REFERENCES users(user_id),
    updated_by  UUID        REFERENCES users(user_id),
    created_at  TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ,

    CONSTRAINT chk_variant_stock_non_negative
        CHECK (variant_stock >= 0),
    CONSTRAINT chk_variant_purchase_price_non_negative
        CHECK (variant_purchase_price >= 0),
    CONSTRAINT chk_variant_sale_price_non_negative
        CHECK (variant_sale_price >= 0)
);

COMMENT ON TABLE  product_variants                       IS 'A product can have multiple variants (size, color, etc.)';
COMMENT ON COLUMN product_variants.variant_purchase_price IS 'Price paid to the supplier';
COMMENT ON COLUMN product_variants.variant_sale_price     IS 'Standard selling price';
COMMENT ON COLUMN product_variants.variant_min_sale_price IS 'Minimum allowed selling price (floor)';
