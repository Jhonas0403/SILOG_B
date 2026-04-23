CREATE TABLE IF NOT EXISTS sale_details (
    sale_detail_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

    sale_id UUID NOT NULL REFERENCES sales(sale_id) ON DELETE CASCADE,
    variant_id UUID NOT NULL REFERENCES product_variants(variant_id),

    quantity INTEGER NOT NULL,

    sale_price DECIMAL(10,2) NOT NULL,
    purchase_price DECIMAL(10,2) NOT NULL,

    subtotal DECIMAL(10,2) NOT NULL,

    sale_detail_status BOOLEAN NOT NULL DEFAULT TRUE,

    created_by UUID REFERENCES users(user_id),
    updated_by UUID REFERENCES users(user_id),

    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,

    CONSTRAINT chk_sale_details_quantity_positive
        CHECK (quantity > 0),

    CONSTRAINT chk_sale_details_sale_price_non_negative
        CHECK (sale_price >= 0),

    CONSTRAINT chk_sale_details_purchase_price_non_negative
        CHECK (purchase_price >= 0),

    CONSTRAINT chk_sale_details_subtotal_non_negative
        CHECK (subtotal >= 0)
);
