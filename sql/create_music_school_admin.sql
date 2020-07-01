CREATE DATABASE IF NOT EXISTS `music_school_admin`;
USE `music_school_admin`;

SET FOREIGN_KEY_CHECKS = 0;

-- Table structure for table `teacher_detail`
--
DROP TABLE IF EXISTS `teacher_detail`;
CREATE TABLE `teacher_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `instrument_1` varchar(45) DEFAULT NULL,
  `instrument_2` varchar(45) DEFAULT NULL,
  `webpage` varchar(128) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Table structure for table `teacher`
--
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `teacher_detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  
  CONSTRAINT `FK_TEACHER_DETAIL` FOREIGN KEY (`teacher_detail_id`) 
  REFERENCES `teacher_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- Table structure for table `course`
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `instrument` varchar(45) DEFAULT NULL,
  `level` varchar(45) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  # keep a unique title for each course e.g 'advanced mandolin'
  UNIQUE KEY `TITLE_UNIQUE` (`title`),

  CONSTRAINT `FK_TEACHER` 
  FOREIGN KEY (`teacher_id`) 
  REFERENCES `teacher` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Structure for Table `student`
--
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
`id`	int(11)	NOT NULL AUTO_INCREMENT,
`first_name` varchar(45) DEFAULT NULL, 
`last_name` varchar(45) DEFAULT NULL, 
`email`	varchar(45) DEFAULT NULL, 

PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;

-- Table structure for course-student join table
-- course-student join table maps the course-student relationship
DROP TABLE IF EXISTS `course_student`;

CREATE TABLE `course_student`(
	`course_id` int(11) NOT NULL,
    `student_id` int(11) NOT NULL,
    PRIMARY KEY(`course_id`,`student_id` ),
    
    CONSTRAINT `FK_COURSE`
    FOREIGN KEY (`course_id`)
    REFERENCES `course` (`id`),
    
    CONSTRAINT `FK_STUDENT`
    FOREIGN KEY (`student_id`)
    REFERENCES `student` (`id`)
);

SET FOREIGN_KEY_CHECKS = 1;





