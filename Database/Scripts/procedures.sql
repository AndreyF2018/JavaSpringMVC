CREATE DEFINER=`root`@`localhost` PROCEDURE `MinPrice`()
BEGIN
select deliverycompanies.DeliveryCompanyId from deliverycompanies where PricePercent = (select min(PricePercent) from deliverycompanies);
END