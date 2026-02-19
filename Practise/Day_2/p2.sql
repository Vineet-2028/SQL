---------------------- Day 2 PRACTISE OF SQL --------------------

-- USING Sleep_Efficiency Dataset

-- Creating stored procedure, so we do not have to repeatedly to see the data.

CREATE PROCEDURE GetDataSleep AS 
BEGIN
SELECT * FROM Sleep_Efficiency
END

EXEC GetDataSleep

-- 1. Find out the average sleep duration of top 15 male candidates 
--    who's sleep duration are equal to 7.5 or greater than 7.5.

SELECT AVG(Sleep_duration) AS avg_sleep
FROM (
    SELECT TOP 15 Sleep_duration
    FROM Sleep_Efficiency
    WHERE Gender = 'Male'
      AND Sleep_duration >= 7.5
    ORDER BY Sleep_duration DESC
) AS t;

-- ALternative using row_number

SELECT AVG(Sleep_duration) AS avg_sleep
FROM (
    SELECT Sleep_duration,
           ROW_NUMBER() OVER (ORDER BY Sleep_duration DESC) AS rn
    FROM Sleep_Efficiency
    WHERE Gender = 'Male'
      AND Sleep_duration >= 7.5
) AS t
WHERE rn <= 15;


-- 2. Show avg deep sleep time for both gender.
--    Round result at 2 decimal places.
--    Note: sleep time and deep sleep percentage will give you, deep sleep time.

-- USING SUBQUERY :-
SELECT Gender,
ROUND(AVG(deep_sleep_time),2) AS avg_deep_sleep_time
FROM (
	SELECT 
	Gender,
	(Deep_sleep_percentage * Sleep_duration)/100 AS deep_sleep_time
	FROM Sleep_Efficiency
	) AS t
GROUP BY Gender

-- SIMPLE QUERY :-

SELECT Gender,
ROUND(AVG((Deep_sleep_percentage * Sleep_duration)/100),2) AS deep_sleep_time
FROM Sleep_Efficiency
GROUP BY Gender

-- 4. Find out the lowest 10th to 30th light sleep percentage records where deep sleep percentage 
--    values are between 25 to 45. Display age, light sleep percentage and deep sleep percentage columns only.

SELECT 
age,
Light_sleep_percentage,
Deep_sleep_percentage
FROM (
	SELECT 
	*,
	ROW_NUMBER() OVER(ORDER BY Light_sleep_percentage ASC) AS rn
	FROM Sleep_Efficiency
	WHERE Deep_sleep_percentage BETWEEN 25 AND 40
	) AS t
	WHERE rn BETWEEN 10 AND 30

-- If you wanted ties handled properly, you could use:USE RANK()

SELECT 
age,
Light_sleep_percentage,
Deep_sleep_percentage
FROM (
	SELECT 
	*,
	RANK() OVER(ORDER BY Light_sleep_percentage ASC) AS rn
	FROM Sleep_Efficiency
	WHERE Deep_sleep_percentage BETWEEN 25 AND 40
	) AS t
	WHERE rn BETWEEN 10 AND 30

-- 4. Group by on exercise frequency and smoking status and
--   show average deep sleep time, average light sleep time and avg rem sleep time.
--   Note: the differences in deep sleep time for smoking and non smoking status

SELECT 
Smoking_status,
exercise_frequency,
ROUND(AVG(deep_sleep_time),2) AS avg_deep_sleep_time,
ROUND(AVG(light_sleep_time),2) AS avg_light_sleep_time,
ROUND(AVG(REM_sleep_time),2) AS avg_rem_sleep_time
FROM (
	SELECT 
	Smoking_status,
	COALESCE(Exercise_frequency, 0) AS exercise_frequency,
	(Deep_sleep_percentage * Sleep_duration)/100 AS deep_sleep_time,
	(Light_sleep_percentage * Sleep_duration)/100 AS light_sleep_time,
	(REM_sleep_percentage * Sleep_duration)/100 AS rem_sleep_time
	FROM Sleep_Efficiency
	) AS t
GROUP BY exercise_frequency, Smoking_status

-- 5. Group By on Awekning and show AVG Caffeine consumption, AVG Deep sleep time 
--    and AVG Alcohol consumption only for people who do exercise atleast 3 days a week. 
--    Show result in descending order awekenings
SELECT 
awakenings,
ROUND(AVG(deep_sleep_time), 2) AS avg_deep_sleep_time,
ROUND(AVG(Caffeine_consumption), 2) AS avg_caffeine_consumption,
ROUND(AVG(Alcohol_consumption), 2) AS avg_alcohol_consumption
FROM (
	SELECT 
	COALESCE(Awakenings,0) as awakenings,
	COALESCE(Exercise_frequency, 0) AS exercise_frequency,
	(Deep_sleep_percentage * Sleep_duration)/100 AS deep_sleep_time,
	Caffeine_consumption,
    Alcohol_consumption
	FROM Sleep_Efficiency
	) AS t
	WHERE exercise_frequency >= 3
	GROUP BY awakenings
	ORDER BY awakenings DESC

/*----------------------------------------------------------------
                 USING NEW DATASET :- PowerGeneration
----------------------------------------------------------------*/

SELECT * FROM PowerGeneration

-- 6. Display those power stations which have average 'Monitored Cap.(MW)' 
--   (display the values) between 1000 and 2000 and the number of occurance of the power stations
--   (also display these values) are greater than 200. Also sort the result in ascending order.

SELECT *
FROM (
    SELECT 
        Power_Station,
        Monitored_Cap_MW,
        COUNT(Power_Station) OVER (PARTITION BY Power_Station) AS no_of_power_stations
    FROM PowerGeneration
    WHERE Monitored_Cap_MW BETWEEN 1000 AND 2000
) AS t
WHERE no_of_power_stations > 200
ORDER BY Power_Station ASC;


/*----------------------------------------------------------------
                 USING NEW DATASET :- AvgUnderGradFees
----------------------------------------------------------------*/

SELECT * FROM AvgUnderGradFees

-- 7. Best state in terms of low education cost (Tution Fees) in 'Public' type university.

SELECT State, total_cost
FROM (
    SELECT 
        State,
        SUM(Value) AS total_cost,
        RANK() OVER (ORDER BY SUM(Value) ASC) AS rnk
    FROM AvgUnderGradFees
    WHERE Type LIKE 'Public%'
    GROUP BY State
) AS t
WHERE rnk = 1;

--8.  2nd Costliest state for Private education in year 2021. Consider, Tution and Room fee both.
WITH StateCosts AS (
    SELECT 
        State,
        SUM(CASE WHEN Expense = 'Fees/Tuition' THEN Value ELSE 0 END) +
        SUM(CASE WHEN Expense = 'Room/Board' THEN Value ELSE 0 END) AS total_cost
    FROM AvgUnderGradFees
    WHERE Type LIKE 'Private%' AND Year = 2021
    GROUP BY State
)
SELECT State, total_cost
FROM (
    SELECT 
        State,
        total_cost,
        RANK() OVER (ORDER BY total_cost DESC) AS rnk
    FROM StateCosts
) AS ranked
WHERE rnk = 2;

--9. Display top 10 lowest "value" State names of which the Year either belong
--   to 2013 or 2017 or 2021 and type is 'Public In-State'. Also the number of 
--   occurance should be between 6 to 10. Display the average value upto 2 decimal places, 
--   state names and the occurance of the states.

SELECT TOP 10
    State,
    ROUND(AVG(Value), 2) AS avg_value,
    COUNT(*) AS occurrences
FROM AvgUnderGradFees
WHERE Type = 'Public In-State' AND Year IN (2013, 2017, 2021)
GROUP BY State
HAVING COUNT(*) BETWEEN 6 AND 10
ORDER BY avg_value ASC;


/*----------------------------------------------------------------
                 USING NEW DATASET :- shipping_ecommerce
----------------------------------------------------------------*/

SELECT * FROM shipping_ecommerce

--10. Display total and average values of Discount_offered for all the combinations
--    of 'Mode_of_Shipment' (display this feature) and 'Warehouse_block' (display this feature also) 
--    for all male ('M') and 'High' Product_importance. Also sort the values in descending order of Mode_of_Shipment 
--    and ascending order of Warehouse_block.

SELECT
    Mode_of_Shipment,
    Warehouse_block,
    SUM(Discount_offered) AS total_discount,
    AVG(Discount_offered) AS avg_discount
FROM shipping_ecommerce
WHERE Gender = 'M' AND Product_importance = 'High'
GROUP BY Mode_of_Shipment, Warehouse_block
ORDER BY Mode_of_Shipment DESC, Warehouse_block ASC;
