---------------------- Day 2 PRACTISE OF SQL --------------------

-- USING DATABASE :- FREEDOM RANKING

USE MyDatabase

SELECT * FROM country_ab
SELECT * FROM country_cd
SELECT * FROM country_cl
SELECT * FROM country_efg;

-- 1. Find out top 10 countries' which have maximum A and D values.

SELECT TOP 10
a.Country,
MAX(a.A) as max_a,
MAX(d.D) as max_d
FROM country_ab as a
JOIN country_cd as d
ON a.Country = d.Country
GROUP BY a.Country
ORDER BY max_a DESC, max_d DESC

-- Alternate Solution using ROW_NUMBER()

SELECT 
t.Country,
t.max_a,
t.max_d
FROM (
	SELECT 
	a.Country,
	ROW_NUMBER() OVER(ORDER BY MAX(a.A) DESC,MAX(d.D) DESC) as rn,
	MAX(a.A) as max_a,
	MAX(d.D) as max_d
	FROM country_ab as a
	JOIN country_cd as d
	ON a.Country = d.Country
	GROUP BY a.Country
	) AS t
	WHERE t.rn < 11;

-- 2.  Find out highest CL value for 2020 for every region. 
--     Also sort the result in descending order. Also display
--     the CL values in descending order.

SELECT 
d.Region,
c.Edition,
MAX(c.CL) as max_cl
FROM country_cd AS d
JOIN country_cl AS c
ON c.Country = d.Country
WHERE c.Edition = 2020
GROUP BY d.Region,c.Edition
ORDER BY max_cl DESC


/*----------------------------------------------------------------
                 USING NEW DATABASE :- SalesDB
----------------------------------------------------------------*/

USE SalesDB

SELECT * FROM CustomersDB
SELECT * FROM EmployeesDB
SELECT * FROM ProductsDB
SELECT * FROM Sales1DB

--3.  Find top-5 most sold products.

SELECT TOP 5
    ProductID,
    SUM(Quantity) AS total_qty
FROM Sales1DB
GROUP BY ProductID
ORDER BY total_qty DESC;

-- ALternate Solution

SELECT 
    ProductID,
    total_qty
FROM (
    SELECT 
        ProductID,
        SUM(Quantity) AS total_qty,
        ROW_NUMBER() OVER (ORDER BY SUM(Quantity) DESC) AS rn
    FROM Sales1DB
    GROUP BY ProductID
) AS t
WHERE rn <= 5;

--4.  Find sales man who sold most no of products.

SELECT TOP 1
SalesPersonID,
SUM(Quantity) AS most_sales
FROM Sales1DB
GROUP BY SalesPersonID
ORDER BY most_sales DESC

-- Alternate Solution If two salespersons sold the same highest quantity, both should be returned. Use RANK()
-- to handle the ties

SELECT
t.SalesPersonID,
t.most_sales
FROM (
	SELECT
	SalesPersonID,
	SUM(Quantity) AS most_sales,
	RANK() OVER(ORDER BY SUM(Quantity) DESC) AS rn
	FROM Sales1DB
	GROUP BY SalesPersonID
	) AS t
	WHERE t.rn = 1

-- Alternate Solution 

SELECT
t.SalesPersonID,
t.most_sales
FROM (
	SELECT
	SalesPersonID,
	SUM(Quantity) AS most_sales,
	ROW_NUMBER() OVER(ORDER BY SUM(Quantity) DESC) AS rn
	FROM Sales1DB
	GROUP BY SalesPersonID
	) AS t
	WHERE t.rn = 1

--5.  Sales man name who has most no of unique customer.

SELECT 
SalesPersonID,
COUNT( DISTINCT CustomerID) AS most_unique_customers
FROM Sales1DB
GROUP BY SalesPersonID
ORDER BY most_unique_customers DESC

-- Alternate Solution If two salespersons sold the same highest quantity, both should be returned. Use RANK()
-- to handle the ties

SELECT
t.SalesPersonID,
t.most_unique_customers
FROM (
	SELECT
	SalesPersonID,
	COUNT(DISTINCT  CustomerID) AS most_unique_customers,
	RANK() OVER(ORDER BY COUNT(DISTINCT  CustomerID) DESC) AS rn
	FROM Sales1DB
	GROUP BY SalesPersonID
	) AS t
	WHERE t.rn = 1

-- Alternate Solution 

SELECT
t.SalesPersonID,
t.most_unique_customers
FROM (
	SELECT
	SalesPersonID,
	COUNT(DISTINCT  CustomerID) AS most_unique_customers,
	ROW_NUMBER() OVER(ORDER BY COUNT(DISTINCT  CustomerID) DESC) AS rn
	FROM Sales1DB
	GROUP BY SalesPersonID
	) AS t
	WHERE t.rn = 1

--6. Sales man who has generated most revenue. Show top 5.

SELECT TOP 5
s.SalesPersonID,
ROUND(SUM(s.Quantity * p.Price),2) AS Total_Revenue
FROM Sales1DB s
JOIN ProductsDB p
ON s.ProductID = p.ProductID
GROUP BY s.SalesPersonID
ORDER BY Total_Revenue DESC;

-- Using RANK() (Handles Ties Properly)

SELECT SalesPersonID, Total_Revenue
FROM (
    SELECT
    s.SalesPersonID,
    ROUND(SUM(s.Quantity * p.Price),2) AS Total_Revenue,
    RANK() OVER (ORDER BY SUM(s.Quantity * p.Price) DESC) AS rn
    FROM Sales1DB s
    JOIN ProductsDB p
    ON s.ProductID = p.ProductID
    GROUP BY s.SalesPersonID
) t
WHERE rn <= 5;

--7.  List all salespeople who have made sales to more than 5 customers.
SELECT
    SalesPersonID,
    COUNT(DISTINCT CustomerID) AS most_unique_customers
FROM Sales1DB
GROUP BY SalesPersonID
HAVING COUNT(DISTINCT CustomerID) > 5;

-- Alternate Solution 

SELECT
t.SalesPersonID,
t.most_unique_customers
FROM (
	SELECT
	SalesPersonID,
	COUNT(DISTINCT  CustomerID) AS most_unique_customers
	FROM Sales1DB
	GROUP BY SalesPersonID
	) AS t
	WHERE t.most_unique_customers > 5

-- 8. List all customers who have made more than 10 purchases.

SELECT
    CustomerID,
    COUNT(*) AS total_purchases
FROM Sales1DB
GROUP BY CustomerID
HAVING COUNT(*) > 10
ORDER BY total_purchases DESC

-- Alternate Solution

SELECT
t.CustomerID,
t.total_purchases
FROM (
	SELECT
	CustomerID,
	COUNT(*) AS total_purchases
	FROM Sales1DB
	GROUP BY CustomerID
	) t
	WHERE t.total_purchases > 10;

--9. List all pairs of customers who have made purchases with the same salesperson.

SELECT
s1.CustomerID AS Customer1,
s2.CustomerID AS Customer2,
COUNT(DISTINCT s1.SalesPersonID) AS shared_salespersons
FROM Sales1DB s1
JOIN Sales1DB s2
ON s1.SalesPersonID = s2.SalesPersonID
AND s1.CustomerID < s2.CustomerID
GROUP BY s1.CustomerID, s2.CustomerID
ORDER BY shared_salespersons DESC;
