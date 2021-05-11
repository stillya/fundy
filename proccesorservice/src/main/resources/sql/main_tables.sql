CREATE TABLE IF NOT EXISTS users
(
    id   UUID         NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS accounts
(
    id          UUID         NOT NULL,
    user_id     UUID         NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    balance     BIGINT DEFAULT (0),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS transactions
(
    id               UUID         NOT NULL,
    account_id       UUID         NOT NULL,
    name             VARCHAR(255) NOT NULL,
    description      TEXT,
    transaction_type VARCHAR(30)  NOT NULL,
    category         VARCHAR(100),
    amount           BIGINT       NOT NULL,
    current_balance  BIGINT       NOT NULL,
    creation_date    TIMESTAMPTZ  NOT NULL DEFAULT NOW(),
    PRIMARY KEY (id),
    FOREIGN KEY (account_id) REFERENCES accounts (id)
);