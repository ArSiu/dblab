SELECT * FROM Income ORDER BY inc;

SELECT SUBSTRING_INDEX(name,' ',-1) AS LastName FROM Passenger 
WHERE SUBSTRING_INDEX(name,' ',-1) NOT LIKE '%J%';

SELECT Outcomes.ship,Battles.name,Battles.date,Outcomes.result FROM Outcomes 
INNER JOIN Battles 
ON Outcomes.battle=Battles.name 
WHERE Outcomes.result NOT LIKE 'sunk';

SELECT model, price FROM Laptop
WHERE price > ALL
(SELECT price FROM PC);

SELECT * FROM Product WHERE
`type`='Laptop' AND model = ANY(SELECT model FROM Laptop WHERE speed >= 750)
OR
`type`='PC' AND model = ANY(SELECT model FROM PC WHERE speed >= 750);

SELECT PC.model,Product.maker,Product.type FROM PC
INNER JOIN Product
ON PC.model=Product.model
WHERE PC.speed >= 750
UNION ALL
SELECT Laptop.model,Product.maker,Product.type FROM Laptop
INNER JOIN Product
ON Laptop.model=Product.model
WHERE Laptop.speed >= 750;

SELECT CONCAT('Model: ', model) AS Model,
CONCAT('Gray scale: ', color) AS IsGrayScale,
CONCAT('Type: ', type) AS Type,
CONCAT('Price: ', price) AS Price 
FROM Printer;

SELECT Trip.trip_no,count(*), Pass_in_trip.date FROM Pass_in_trip
JOIN Trip
ON Trip.trip_no=Pass_in_trip.trip_no
WHERE town_from='Moscow' GROUP BY date,trip_no;

SELECT 
	Product.maker,
	COUNT(pc_data.model) AS PC,
	COUNT(laptop_data.model) AS Laptop,
	COUNT(printer_data.model) AS Printer 
FROM Product
LEFT OUTER JOIN 
	(SELECT maker,PC.model 
	FROM PC 
	JOIN Product 
	ON PC.model=Product.model) AS pc_data
ON Product.model=pc_data.model
LEFT OUTER JOIN 
	(SELECT maker,Laptop.model 
	FROM Laptop 
	JOIN Product 
	ON Laptop.model=Product.model) AS laptop_data
ON Product.model=laptop_data.model
LEFT OUTER JOIN 
	(SELECT maker,Printer.model 
	FROM Printer 
	JOIN Product 
	ON Printer.model=Product.model) AS printer_data
ON Product.model=printer_data.model
GROUP BY maker 
ORDER BY 1;

SELECT *,
	CASE
		WHEN not_once > once THEN 'more than once a day'
		WHEN not_once < once THEN 'once a day'
	ELSE 'both'
	END AS status
FROM
(SELECT
	Outcome.point AS point,
	Outcome.date AS date,
	SUM(Outcome.out) AS not_once,
	SUM(Outcome_o.out) AS once
FROM Outcome_o
LEFT OUTER JOIN Outcome
ON Outcome_o.date=Outcome.date
GROUP BY 1,2) AS data1 
WHERE point IS NOT NULL;

SELECT name,launched FROM Ships WHERE launched < 1942;


