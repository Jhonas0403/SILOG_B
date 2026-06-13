CREATE TABLE IF NOT EXISTS cash_sessions (
    cash_session_id UUID        PRIMARY KEY DEFAULT gen_random_uuid(),
    store_id        UUID        NOT NULL,
    opened_by       UUID        NOT NULL REFERENCES users(user_id),
    closed_by       UUID        REFERENCES users(user_id),
    opened_at       TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    closed_at       TIMESTAMPTZ,
    status          VARCHAR(10) NOT NULL DEFAULT 'OPEN',
    notes           VARCHAR(500),
    created_by      UUID,
    updated_by      UUID,
    created_at      TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMPTZ,
    CONSTRAINT chk_cash_session_status CHECK (status IN ('OPEN', 'CLOSED'))
);

CREATE INDEX idx_cash_sessions_store_status ON cash_sessions(store_id, status);

COMMENT ON TABLE  cash_sessions          IS 'Daily cash register sessions per store';
COMMENT ON COLUMN cash_sessions.status   IS 'OPEN: session active, CLOSED: session finished';

CREATE TABLE IF NOT EXISTS cash_session_opening_amounts (
    id                UUID           PRIMARY KEY DEFAULT gen_random_uuid(),
    cash_session_id   UUID           NOT NULL REFERENCES cash_sessions(cash_session_id),
    payment_method_id UUID           NOT NULL REFERENCES payment_methods(payment_method_id),
    amount            DECIMAL(12, 2) NOT NULL DEFAULT 0,
    CONSTRAINT chk_opening_amount_non_negative CHECK (amount >= 0),
    CONSTRAINT uq_session_payment_method UNIQUE (cash_session_id, payment_method_id)
);

COMMENT ON TABLE cash_session_opening_amounts IS 'Initial cash amounts per payment method at session open';
