CREATE TABLE IF NOT EXISTS roles (
    role_id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    role_name        VARCHAR(100)  NOT NULL UNIQUE,
    role_description VARCHAR(255),
    role_status      BOOLEAN       NOT NULL DEFAULT TRUE,
    created_by       UUID,
    updated_by       UUID,
    created_at       TIMESTAMPTZ   NOT NULL DEFAULT NOW(),
    updated_at       TIMESTAMPTZ
);

-- Seed the super-admin role so the admin user seeded in V12 has a valid role
INSERT INTO roles (role_id, role_name, role_description, role_status, created_at)
VALUES ('00000000-0000-0000-0000-000000000001', 'SUPER_ADMIN', 'Full system access', TRUE, NOW())
ON CONFLICT DO NOTHING;
