CREATE TABLE IF NOT EXISTS stores (
    store_id        UUID            PRIMARY KEY DEFAULT gen_random_uuid(),
    company_id      UUID            NOT NULL REFERENCES companies(company_id),
    store_name      VARCHAR(255)    NOT NULL,
    store_address   VARCHAR(255),
    store_phone     VARCHAR(50),
    store_status    BOOLEAN         NOT NULL DEFAULT TRUE,
    created_by      UUID,
    updated_by      UUID,
    created_at      TIMESTAMPTZ     NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMPTZ,
    CONSTRAINT uq_store_name_per_company UNIQUE (company_id, store_name)
);

COMMENT ON TABLE  stores                         IS 'Stores belonging to a company';
COMMENT ON CONSTRAINT uq_store_name_per_company
    ON stores                                    IS 'Store name must be unique within the same company';

-- FK constraints from existing tables to stores and companies
ALTER TABLE users
    ADD CONSTRAINT fk_users_company FOREIGN KEY (company_id) REFERENCES companies(company_id),
    ADD CONSTRAINT fk_users_store   FOREIGN KEY (store_id)   REFERENCES stores(store_id);

ALTER TABLE sales
    ADD CONSTRAINT fk_sales_store FOREIGN KEY (store_id) REFERENCES stores(store_id);

ALTER TABLE cash_sessions
    ADD CONSTRAINT fk_cash_sessions_store FOREIGN KEY (store_id) REFERENCES stores(store_id);
