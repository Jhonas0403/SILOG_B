CREATE TABLE IF NOT EXISTS expenses (
    expense_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

    company_id UUID NOT NULL REFERENCES companies(company_id),
    store_id UUID REFERENCES stores(store_id),
    expense_category_id UUID NOT NULL REFERENCES expense_categories(expense_category_id),

    expense_description VARCHAR(255),

    amount DECIMAL(12,2) NOT NULL,
    expense_date DATE NOT NULL,

    expense_status BOOLEAN NOT NULL DEFAULT TRUE,

    created_by UUID REFERENCES users(user_id),
    updated_by UUID REFERENCES users(user_id),

    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,

    CONSTRAINT chk_expenses_amount_positive
        CHECK (amount > 0)
);
