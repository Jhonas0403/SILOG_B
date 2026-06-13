-- ============================================================
-- V12: Seed super-user admin
--
-- Password is stored as plain text because authentication
-- (JWT / PasswordEncoder) is not yet implemented.
-- Replace with a hashed value once Spring Security is wired up.
-- ============================================================

INSERT INTO users (
    user_id,
    user_role_id,
    user_name,
    user_lastname,
    user_dni,
    user_email,
    user_password,
    user_phone,
    user_address,
    user_status,
    created_at
)
VALUES (
    gen_random_uuid(),
    '00000000-0000-0000-0000-000000000001',  -- placeholder super-admin role ID
    'admin',
    'admin',
    '00000000',
    'admin@silog.com',
    'admin',
    '000000000',
    'N/A',
    TRUE,
    NOW()
)
ON CONFLICT DO NOTHING;
