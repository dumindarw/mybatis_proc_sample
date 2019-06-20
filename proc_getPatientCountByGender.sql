CREATE PROCEDURE `proc_getPatientCountByGender`()
LANGUAGE SQL
NOT DETERMINISTIC
CONTAINS SQL
SQL SECURITY DEFINER
COMMENT ''
BEGIN 
	SELECT count(*) as patientCount , gender 
	FROM patient group by gender;
END