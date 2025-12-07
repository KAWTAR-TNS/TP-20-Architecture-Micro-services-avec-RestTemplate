CREATE TABLE client
(
    id  BIGINT AUTO_INCREMENT NOT NULL,
    nom VARCHAR(255)          NULL,
    age FLOAT                 NULL,
    CONSTRAINT pk_client PRIMARY KEY (id)
);