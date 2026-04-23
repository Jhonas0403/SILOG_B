CREATE TABLE IF NOT EXISTS expense_categories (
    expense_category_id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    company_id UUID NOT NULL REFERENCES companies(company_id),
    category_name VARCHAR(100) NOT NULL,
    category_description VARCHAR(255),
    category_status BOOLEAN NOT NULL DEFAULT TRUE,
    created_by UUID REFERENCES users(user_id),
    updated_by UUID REFERENCES users(user_id),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,

    CONSTRAINT uq_expense_categories_company_name
        UNIQUE (company_id, category_name)
);
