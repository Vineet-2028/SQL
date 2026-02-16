-- Dat_1 of practising SQL.

-- Creating stored procedure to retrieve data easily without reusability of code.

CREATE PROCEDURE GetData AS
BEGIN
SELECT * FROM Insurence
END
GO

-- Executing Stored Procedure
EXEC GetData

--1. Show records of 'male' patient from 'southwest' region.

SELECT *
FROM Insurence 
WHERE gender = 'male' AND region = 'southwest'

--2. Show all records having bmi in range 30 to 45 both inclusive.

SELECT *
FROM Insurence 
WHERE bmi BETWEEN 30 AND 45

--3. Show minimum and maximum bloodpressure of diabetic patient who smokes. 
   --Make column names as MinBP and MaxBP respectively.

SELECT 
    MIN(bloodpressure) AS min_bp,
    MAX(bloodpressure) AS max_bp
FROM Insurence
WHERE smoker = 'No';

--4. Find no of unique patients who are not from southwest region.

SELECT 
COUNT(DISTINCT patientID) AS unique_patient
FROM Insurence
WHERE region <> 'southwest'

 --          OR          --

 SELECT 
 COUNT(*) AS unique_patient
FROM (
	 SELECT DISTINCT patientID
	 FROM Insurence
	 WHERE region <> 'southwest'
) AS t


--5. Total claim amount from male smoker.

SELECT 
ROUND(SUM(claim),0) AS total_claim_amount
FROM Insurence
WHERE gender = 'male' AND smoker = 'Yes'

--6. Select all records of south region.

SELECT 
*
FROM Insurence
WHERE region LIKE 'south%'

-- 7. No of patient having normal blood pressure. Normal range[90-120]

SELECT 
COUNT(PatientID) AS no_of_patients
FROM Insurence
WHERE bloodpressure BETWEEN 90 AND 120

--8. No of pateint belo 17 years of age having normal blood pressure as per below formula -
  -- BP normal range = 80+(age in years × 2) to 100 + (age in years × 2)
  -- Note: Formula taken just for practice, don't take in real sense.
  
  SELECT COUNT(PatientID) as ans_value
  FROM (
	SELECT 
	PatientID,
	bloodpressure,
	80 + COALESCE(age, 0)*2 AS min_range,
	100 + COALESCE(age, 0)*2 AS max_range
	FROM Insurence
	) AS t
	WHERE bloodpressure BETWEEN min_range AND max_range

	--      OR      --

	SELECT COUNT(PatientID) AS ans_value
	FROM Insurence
	WHERE bloodpressure BETWEEN 
		  80 + COALESCE(age, 0)*2
	  AND 100 + COALESCE(age, 0)*2;

--9. What is the average claim amount for non-smoking female patients who are diabetic?

SELECT 
ROUND(AVG(claim),0) AS avg_claim_amount_female
FROM Insurence
WHERE smoker = 'Yes' AND gender = 'female'

--10. Write a SQL query to update the claim amount for the patient with PatientID = 1234 to 5000.

UPDATE Insurence
SET claim = 5000
WHERE PatientID = 1234

--11. Write a SQL query to delete all records for patients who are smokers and have no children.

DELETE Insurence
WHERE smoker = 'Yes' AND children = 0

SELECT 
COUNT(DISTINCT patientID) AS unique_patient
FROM Insurence
