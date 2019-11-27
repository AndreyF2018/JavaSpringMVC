CREATE TABLE `restoran`.`dishes` (
  `DishID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  `Price` FLOAT NULL,
  PRIMARY KEY (`DishID`));

CREATE TABLE `restoran`.`Orders` (
  `OrdersID` INT NOT NULL AUTO_INCREMENT,
  `TableID` INT NOT NULL,
  FulfillmentOfOrder bit NOT NULL,
  PRIMARY KEY (`OrdersID`));
  
  CREATE TABLE `restoran`.`OrderedDishes` (
  `OrdersID` INT NOT NULL,
  `DishID` INT NOT NULL,
  Quantity int NOT NULL
  )
  
  