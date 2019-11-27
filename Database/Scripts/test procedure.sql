CREATE DEFINER=`root`@`localhost` PROCEDURE `test`()
BEGIN
select d.title from dishes d where d.price > 50;
END