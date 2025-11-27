--liquibase formatted sql
--changeset katya:create_calc_events_table
CREATE TABLE calc_events (
    id BIGSERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    first DOUBLE PRECISION,
    second DOUBLE PRECISION,
    result DOUBLE PRECISION,
    creation_date TIMESTAMP,
    type VARCHAR(200)
);
