-- =========================================
-- USERS SERVICE - DB MIGRATION
-- V1: Create users table (no FK cross microservices)
-- =========================================

CREATE TABLE IF NOT EXISTS users (
                                     user_id SERIAL PRIMARY KEY,

    -- IDs lógicos provenientes del microservicio ORGANIZATION
                                     company_id INTEGER NOT NULL,
                                     store_id INTEGER,

    -- ID lógico del rol (también en ORGANIZATION)
                                     user_role_id INTEGER NOT NULL,

                                     user_name VARCHAR(100) NOT NULL,
    user_lastname VARCHAR(100) NOT NULL,
    user_dni VARCHAR(20) NOT NULL UNIQUE,
    user_email VARCHAR(255) NOT NULL UNIQUE,
    user_password VARCHAR(255) NOT NULL,
    user_phone VARCHAR(50) NOT NULL UNIQUE,
    user_address VARCHAR(255),
    user_status BOOLEAN NOT NULL DEFAULT TRUE,

    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
    );