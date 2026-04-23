CREATE TABLE IF NOT EXISTS sales (
    sale_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

    sale_date TIMESTAMP DEFAULT NOW(),

    total DECIMAL(10,2) NOT NULL,

    sale_status BOOLEAN NOT NULL DEFAULT TRUE,

    created_by UUID REFERENCES users(user_id),
    updated_by UUID REFERENCES users(user_id),

    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,

    CONSTRAINT chk_sales_total_non_negative
        CHECK (total >= 0)
);
