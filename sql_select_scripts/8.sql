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