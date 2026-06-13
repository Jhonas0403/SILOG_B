-- ============================================================
-- V4: Create brands table
--
-- Depends on: subcategories (V3)
-- This table was also MISSING from the old schema files.
-- ============================================================

CREATE TABLE IF NOT EXISTS brands (
    brand_id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    brand_name           VARCHAR(100)    NOT NULL,
    brand_description    VARCHAR(255),
    brand_subcategory_id UUID            REFERENCES subcategories(subcategory_id),
    brand_status         BOOLEAN         NOT NULL DEFAULT TRUE,
    brand_order          INTEGER,

    created_by  UUID        REFERENCES users(user_id),
    updated_by  UUID        REFERENCES users(user_id),
    created_at  TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ
);

COMMENT ON TABLE  brands                      IS 'Product brands linked to a subcategory';
COMMENT ON COLUMN brands.brand_subcategory_id IS 'Subcategory this brand belongs to';
