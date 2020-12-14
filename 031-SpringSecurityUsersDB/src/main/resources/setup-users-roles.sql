DROP DATABASE  IF EXISTS `spring_security_roles_demo`;

CREATE DATABASE  IF NOT EXISTS `spring_security_roles_demo`;
USE `spring_security_roles_demo`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
('jonny','{noop}test123',1),
('maria','{noop}test123',1),
('lucrecio','{noop}test123',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('jonny','ROLE_EMPLOYEE'),
('maria','ROLE_EMPLOYEE'),
('maria','ROLE_MANAGER'),
('lucrecio','ROLE_EMPLOYEE'),
('lucrecio','ROLE_ADMIN');


