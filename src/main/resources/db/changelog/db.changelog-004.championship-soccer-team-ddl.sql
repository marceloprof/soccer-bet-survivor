--liquibase formatted sql logicalFilePath:db.changelog-004.championship-soccer-team-ddl.sql

--changeset afonso.aoc:db.changelog-004.championship-soccer-team-ddl.sql

CREATE TABLE `survivor`.`championship_soccer_team` (
  `championship_id` BIGINT(20) NOT NULL,
`soccer_team_id` BIGINT(20) NOT NULL,
PRIMARY KEY (`championship_id`, `soccer_team_id`),
INDEX `fk_soccer_team_id_idx` (`soccer_team_id` ASC),
CONSTRAINT `fk_championship_id`
FOREIGN KEY (`championship_id`)
REFERENCES `survivor`.`championship` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `fk_soccer_team_id`
FOREIGN KEY (`soccer_team_id`)
REFERENCES `survivor`.`soccer_team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

--rollback DROP TABLE survivor.championship_soccer_team;