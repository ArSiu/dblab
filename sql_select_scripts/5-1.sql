SELECT PC.model,Product.maker,Product.type FROM PC
INNER JOIN Product
ON PC.model=Product.model
WHERE PC.speed >= 750
UNION ALL
SELECT Laptop.model,Product.maker,Product.type FROM Laptop
INNER JOIN Product
ON Laptop.model=Product.model
WHERE Laptop.speed >= 750;