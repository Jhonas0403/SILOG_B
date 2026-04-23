CREATE TABLE IF NOT EXISTS inventory_movements (
    movement_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

    variant_id UUID NOT NULL REFERENCES product_variants(variant_id),

    movement_type VARCHAR(10) NOT NULL,
    quantity INTEGER NOT NULL,

    purchase_price DECIMAL(10,2),
    sale_price DECIMAL(10,2),

    reference_type VARCHAR(20),
    reference_id UUID,

    movement_status BOOLEAN NOT NULL DEFAULT TRUE,

    created_by UUID,
    updated_by UUID,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,

    CONSTRAINT chk_inventory_movement_type
        CHECK (movement_type IN ('IN', 'OUT')),

    CONSTRAINT chk_inventory_reference_type
        CHECK (reference_type IS NULL OR reference_type IN ('PURCHASE', 'SALE')),

    CONSTRAINT chk_inventory_quantity_positive
        CHECK (quantity > 0)
);
