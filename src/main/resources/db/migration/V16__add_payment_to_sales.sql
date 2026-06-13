-- Add payment method to sales.
-- Existing rows default to EFECTIVO so the NOT NULL constraint is satisfied.
ALTER TABLE sales
    ADD COLUMN payment_method_id UUID
        NOT NULL
        DEFAULT '00000000-0000-0000-0001-000000000001'
        REFERENCES payment_methods(payment_method_id);

ALTER TABLE sales
    ADD COLUMN operation_code VARCHAR(100);

COMMENT ON COLUMN sales.payment_method_id IS 'Payment method used for this sale';
COMMENT ON COLUMN sales.operation_code    IS 'Optional operation/transaction code for card, Yape or Plin payments';
