DELIMITER $$

CREATE FUNCTION decimal_a_binari(n INT) RETURNS VARCHAR(100)
DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(100) DEFAULT '';
    DECLARE remainder INT;
    
    WHILE n > 0 DO
        SET remainder = n % 2;
        SET result = CONCAT(remainder, result);
        SET n = n DIV 2;
    END WHILE;
    
    RETURN result;
END $$

DELIMITER ;

