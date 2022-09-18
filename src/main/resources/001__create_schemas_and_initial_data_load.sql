CREATE TABLE account_entity (
    account_id  varchar(100),
    smtp        varchar(100),
    pop3_imap   varchar(100),
    username    varchar(100)    NOT NULL    UNIQUE,
    password    varchar(100)    NOT NULL,
    PRIMARY KEY (account_id)
);

INSERT INTO account_entity (account_id, smtp, pop3_imap, username, password)
VALUES ('1', 'smtp1', 'pop3', 'user@gmail.com', 'cBrlgyL2GI2GINuLUUwgojITuIufFycpLG4490dhGtY=');

INSERT INTO account_entity (account_id, smtp, pop3_imap, username, password)
VALUES ('2', 'smtp2', 'imap', 'admin@gmail.com', 'dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=');