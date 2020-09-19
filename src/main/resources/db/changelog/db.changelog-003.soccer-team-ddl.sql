--liquibase formatted sql logicalFilePath:db.changelog-003.soccer-team-ddl.sql

--changeset afonso.aoc:db.changelog-003.soccer-team-ddl.sql

CREATE TABLE survivor.soccer_team(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `logo_path` VARCHAR(255) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


--rollback DROP TABLE survivor.soccer_team;