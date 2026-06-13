CREATE TABLE IF NOT EXISTS payment_methods (
    payment_method_id       UUID            PRIMARY KEY DEFAULT gen_random_uuid(),
    name                    VARCHAR(50)     NOT NULL UNIQUE,
    description             VARCHAR(255),
    requires_operation_code BOOLEAN         NOT NULL DEFAULT FALSE,
    status                  BOOLEAN         NOT NULL DEFAULT TRUE,
    created_by              UUID,
    updated_by              UUID,
    created_at              TIMESTAMPTZ     NOT NULL DEFAULT NOW(),
    updated_at              TIMESTAMPTZ
);

COMMENT ON TABLE  payment_methods                           IS 'Payment methods available in the system';
COMMENT ON COLUMN payment_methods.requires_operation_code  IS 'TRUE for card/Yape/Plin — allows entering an operation code for reconciliation';

INSERT INTO payment_methods (payment_method_id, name, description, requires_operation_code, status)
VALUES
    ('00000000-0000-0000-0001-000000000001', 'EFECTIVO', 'Pago en efectivo',                    FALSE, TRUE),
    ('00000000-0000-0000-0001-000000000002', 'TARJETA',  'Pago con tarjeta de crédito/débito',  TRUE,  TRUE),
    ('00000000-0000-0000-0001-000000000003', 'YAPE',     'Pago por Yape',                       TRUE,  TRUE),
    ('00000000-0000-0000-0001-000000000004', 'PLIN',     'Pago por Plin',                       TRUE,  TRUE)
ON CONFLICT DO NOTHING;
