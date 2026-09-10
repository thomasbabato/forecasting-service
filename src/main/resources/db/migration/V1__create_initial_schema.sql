/*
    First version of the Postgres DB managed with Firefly
 */

CREATE TABLE users
(
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE restaurants
(
    id BIGSERIAL PRIMARY KEY,
    owner_id BIGINT NOT NULL REFERENCES users(id),
    name VARCHAR(255) NOT NULL,
    timezone VARCHAR(255) NOT NULL DEFAULT 'Europe/Copenhagen',
    created_at TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE products
(
    id BIGSERIAL PRIMARY KEY,
    restaurant_id BIGINT NOT NULL REFERENCES restaurants(id),
    name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    unit_price NUMERIC(10,2) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now(),
    UNIQUE (restaurant_id, name)
);

CREATE TABLE sales_records
(
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT NOT NULL REFERENCES products(id),
    sold_at TIMESTAMP NOT NULL,
    quantity_sold INTEGER NOT NULL,
    price_at_sale NUMERIC(10,2) NOT NULL
);

CREATE TABLE forecasts
(
    id BIGSERIAL PRIMARY KEY,
    product_id BIGINT NOT NULL REFERENCES products(id),
    forecast_date DATE NOT NULL,
    predicted_quantity NUMERIC(10,2) NOT NULL,
    generated_at TIMESTAMP NOT NULL DEFAULT now()
);