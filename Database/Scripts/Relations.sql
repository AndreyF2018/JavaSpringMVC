ALTER TABLE `restoran`.`onlineordereddishes` 
ADD INDEX `dish_fk0_idx` (`DishId` ASC) VISIBLE;
;
ALTER TABLE `restoran`.`onlineordereddishes` 
ADD CONSTRAINT `dish_fk0`
  FOREIGN KEY (`DishId`)
  REFERENCES `restoran`.`dishes` (`DishID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `restoran`.`onlineordereddishes` 
ADD INDEX `online_order_fk0_idx` (`OnlineOrderId` ASC) VISIBLE;
;
ALTER TABLE `restoran`.`onlineordereddishes` 
ADD CONSTRAINT `online_order_fk0`
  FOREIGN KEY (`OnlineOrderId`)
  REFERENCES `restoran`.`onlineorders` (`OnlineOrderId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `restoran`.`onlineordereddishes` 
ADD INDEX `DevCompId_fk0_idx` (`DeliveryCompanyId` ASC) VISIBLE;
;
ALTER TABLE `restoran`.`onlineordereddishes` 
ADD CONSTRAINT `DevCompId_fk0`
  FOREIGN KEY (`DeliveryCompanyId`)
  REFERENCES `restoran`.`deliverycompanies` (`DeliveryCompanyId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `restoran`.`сostofcooking` 
ADD INDEX `cost_dish_fk0_idx` (`DishId` ASC) VISIBLE;
;
ALTER TABLE `restoran`.`сostofcooking` 
ADD CONSTRAINT `cost_dish_fk0`
  FOREIGN KEY (`DishId`)
   REFERENCES `restoran`.`dishes` (`DishID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
  
ALTER TABLE `restoran`.`profit` 
ADD INDEX `order_id_fk0_idx` (`OrderId` ASC) VISIBLE;
;
ALTER TABLE `restoran`.`profit` 
ADD CONSTRAINT `order_id_fk0`
  FOREIGN KEY (`OrderId`)
  REFERENCES `restoran`.`onlineorders` (`OnlineOrderId`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  

  
  