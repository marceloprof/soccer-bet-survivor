--liquibase formatted sql logicalFilePath:db.changelog-001.user-ddl.sql

--changeset afonso.aoc:db.changelog-001.user-ddl.sql

CREATE TABLE survivor.user(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `login` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


--rollback DROP TABLE survivor.user;