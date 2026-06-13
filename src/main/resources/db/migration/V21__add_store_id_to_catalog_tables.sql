ALTER TABLE categories         ADD COLUMN store_id UUID REFERENCES stores(store_id);
ALTER TABLE subcategories      ADD COLUMN store_id UUID REFERENCES stores(store_id);
ALTER TABLE brands             ADD COLUMN store_id UUID REFERENCES stores(store_id);
ALTER TABLE products           ADD COLUMN store_id UUID REFERENCES stores(store_id);
ALTER TABLE product_variants   ADD COLUMN store_id UUID REFERENCES stores(store_id);
ALTER TABLE expense_categories ADD COLUMN store_id UUID REFERENCES stores(store_id);
ALTER TABLE inventory_movements ADD COLUMN store_id UUID REFERENCES stores(store_id);

COMMENT ON COLUMN categories.store_id          IS 'Store that owns this category';
COMMENT ON COLUMN subcategories.store_id        IS 'Store that owns this subcategory';
COMMENT ON COLUMN brands.store_id               IS 'Store that owns this brand';
COMMENT ON COLUMN products.store_id             IS 'Store that owns this product';
COMMENT ON COLUMN product_variants.store_id     IS 'Store that owns this variant';
COMMENT ON COLUMN expense_categories.store_id   IS 'Store that owns this expense category';
COMMENT ON COLUMN inventory_movements.store_id  IS 'Store that owns this inventory movement';
