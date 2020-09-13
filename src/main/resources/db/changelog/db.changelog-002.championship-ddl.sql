--liquibase formatted sql logicalFilePath:db.changelog-002.championship-ddl.sql

--changeset afonso.aoc:db.changelog-002.championship-ddl.sql

CREATE TABLE survivor.championship(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `host` BIGINT(20) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `survivor`.`championship`
ADD CONSTRAINT `fk_championship_user`
  FOREIGN KEY (`host`)
  REFERENCES `survivor`.`user` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

--rollback DROP TABLE survivor.championship;