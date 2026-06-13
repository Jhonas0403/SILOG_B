-- ============================================================
-- V11: Create inventory_movements table
--
-- Depends on: product_variants (V6)
--
-- movement_type values: 'IN' (stock entry) / 'OUT' (stock exit)
-- reference_type values: 'PURCHASE' / 'SALE' (what triggered the movement)
-- ============================================================

CREATE TABLE IF NOT EXISTS inventory_movements (
    movement_id     UUID            PRIMARY KEY DEFAULT gen_random_uuid(),
    variant_id      UUID            NOT NULL REFERENCES product_variants(variant_id),
    movement_type   VARCHAR(10)     NOT NULL,
    quantity        INTEGER         NOT NULL,
    purchase_price  DECIMAL(12, 2),
    sale_price      DECIMAL(12, 2),
    reference_type  VARCHAR(20),
    reference_id    UUID,
    movement_status BOOLEAN         NOT NULL DEFAULT TRUE,

    created_by  UUID        REFERENCES users(user_id),
    updated_by  UUID        REFERENCES users(user_id),
    created_at  TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ,

    CONSTRAINT chk_inventory_movement_type
        CHECK (movement_type IN ('IN', 'OUT')),
    CONSTRAINT chk_inventory_reference_type
        CHECK (reference_type IS NULL OR reference_type IN ('PURCHASE', 'SALE')),
    CONSTRAINT chk_inventory_quantity_positive
        CHECK (quantity > 0)
);

COMMENT ON TABLE  inventory_movements              IS 'Stock movements: every entry/exit of a product variant';
COMMENT ON COLUMN inventory_movements.movement_type IS 'IN = stock entry, OUT = stock exit';
COMMENT ON COLUMN inventory_movements.reference_type IS 'What caused this movement: PURCHASE or SALE';
COMMENT ON COLUMN inventory_movements.reference_id   IS 'ID of the sale or purchase that caused this movement';
