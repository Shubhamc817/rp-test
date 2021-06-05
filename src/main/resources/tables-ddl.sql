

CREATE SCHEMA IF NOT EXISTS `rp-test` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `rp-test` ;

-- -----------------------------------------------------
-- Table `rp-test`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rp-test`.`course` (
  `course_id` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`course_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



CREATE TABLE IF NOT EXISTS `rp-test`.`student` (
  `roll_no` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`roll_no`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



CREATE TABLE IF NOT EXISTS `rp-test`.`course_enrolled` (
  `student_roll` VARCHAR(255) NOT NULL,
  `course_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`student_roll`, `course_id`),
  INDEX `FKn9osuxnv6otcsuy8qjrlj3ctj` (`course_id` ASC) VISIBLE,
  CONSTRAINT `FK92iqxfveqa9jwlfni4cgmpa5t`
    FOREIGN KEY (`student_roll`)
    REFERENCES `rp-test`.`student` (`roll_no`),
  CONSTRAINT `FKn9osuxnv6otcsuy8qjrlj3ctj`
    FOREIGN KEY (`course_id`)
    REFERENCES `rp-test`.`course` (`course_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;