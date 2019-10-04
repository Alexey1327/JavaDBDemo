CREATE TABLE `peoples` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `middlename` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `address` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `people_id` int(11) NOT NULL,
                           `city` varchar(255) NOT NULL,
                           `street` varchar(255) NOT NULL,
                           `house` varchar(255) NOT NULL,
                           `flat` int(4) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           KEY `fk_people_id` (`people_id`),
                           CONSTRAINT `fk_people_id` FOREIGN KEY (`people_id`) REFERENCES `peoples` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
