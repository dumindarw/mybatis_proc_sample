CREATE PROCEDURE `proc_getPatientCount`(
	OUT `total` INTEGER
)
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN    
	SELECT count(*) into total    
	FROM patient;
END