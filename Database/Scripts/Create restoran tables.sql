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
  );
  
  CREATE TABLE `restoran`.`onlineorders` (
  `OnlineOrderId` int NOT NULL AUTO_INCREMENT,
  `Adress` varchar(45) DEFAULT NULL,
  `CustomerName` varchar(45) DEFAULT NULL,
  `DishId` int DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`OnlineOrderId`)
);


CREATE TABLE `restoran`.`onlineordereddishes` (
  `OnlineOrderedDishesId` INT NOT NULL AUTO_INCREMENT,
  `OnlineOrderId` INT NULL,
  `DishId` INT NULL,
  `DeliveryCompanyId` INT NULL,
  PRIMARY KEY (`OnlineOrderedDishesId`));
  
  CREATE TABLE `restoran`.`deliverycompanies` (
  `DeliveryCompanyId` INT NOT NULL AUTO_INCREMENT,
  `DeliveryCompanyName` VARCHAR(45) NULL,
  `PricePercent` INT NULL,
  PRIMARY KEY (`DeliveryСompanyId`));
  
  CREATE TABLE `restoran`.`profit` (
  `ProfitId` INT NOT NULL AUTO_INCREMENT,
  `OrderId` INT NULL,
  `OredrCost` FLOAT NULL,
  `PercentDeliveries` INT NULL,
  `NetProfit` FLOAT NULL,
  PRIMARY KEY (`ProfitId`));
  
  CREATE TABLE `restoran`.`сostofcooking` (
  `CostOfCookingId` INT NOT NULL AUTO_INCREMENT,
  `DishId` INT NULL,
  `Cost` FLOAT NULL,
  PRIMARY KEY (`CostOfCookingId`));

  
  
  