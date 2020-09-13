--liquibase formatted sql logicalFilePath:db.changelog-005-round-ddl.sql

--changeset afonso.aoc:db.changelog-005-round-ddl.sql

CREATE TABLE `survivor`.`round` (
  `id` BIGINT(20) NOT NULL,
`championship_id` BIGINT(20) NOT NULL,
`home_team` BIGINT(20) NOT NULL,
`guest_team` BIGINT(20) NOT NULL,
`round_number` INT NOT NULL,
PRIMARY KEY (`id`),
CONSTRAINT `fk_round_championship`
FOREIGN KEY (`id`)
REFERENCES `survivor`.`championship` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `fk_round_home_team`
FOREIGN KEY (`id`)
REFERENCES `survivor`.`soccer_team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `fk_guest_home`
FOREIGN KEY (`id`)
REFERENCES `survivor`.`soccer_team` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

--rollback DROP TABLE survivor.round;