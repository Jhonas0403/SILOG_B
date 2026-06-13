CREATE TABLE IF NOT EXISTS companies (
    company_id          UUID            PRIMARY KEY DEFAULT gen_random_uuid(),
    company_name        VARCHAR(255)    NOT NULL UNIQUE,
    company_ruc         VARCHAR(20)     UNIQUE,
    company_address     VARCHAR(255),
    company_phone       VARCHAR(50)     NOT NULL UNIQUE,
    company_description VARCHAR(255),
    company_status      BOOLEAN         NOT NULL DEFAULT TRUE,
    created_by          UUID,
    updated_by          UUID,
    created_at          TIMESTAMPTZ     NOT NULL DEFAULT NOW(),
    updated_at          TIMESTAMPTZ
);

COMMENT ON TABLE companies IS 'Companies managed in the system. Each company has one ADMIN user.';
