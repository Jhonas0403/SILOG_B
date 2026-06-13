-- ============================================================
-- V9: Create sales table
--
-- Depends on: users (V1)
-- ============================================================

CREATE TABLE IF NOT EXISTS sales (
    sale_id     UUID            PRIMARY KEY DEFAULT gen_random_uuid(),
    sale_date   TIMESTAMPTZ     NOT NULL DEFAULT NOW(),
    total       DECIMAL(12, 2)  NOT NULL,
    sale_status BOOLEAN         NOT NULL DEFAULT TRUE,

    created_by  UUID        REFERENCES users(user_id),
    updated_by  UUID        REFERENCES users(user_id),
    created_at  TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMPTZ,

    CONSTRAINT chk_sales_total_non_negative
        CHECK (total >= 0)
);

COMMENT ON TABLE sales IS 'Sales transactions header';
