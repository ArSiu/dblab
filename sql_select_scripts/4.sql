SELECT model, price FROM Laptop
WHERE price > ALL
(SELECT price FROM PC);