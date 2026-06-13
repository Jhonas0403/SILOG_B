ALTER TABLE sales ADD COLUMN store_id UUID;

COMMENT ON COLUMN sales.store_id IS 'Store that made the sale, taken from the authenticated user JWT at creation time';
