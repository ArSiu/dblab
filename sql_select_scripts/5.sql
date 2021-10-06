SELECT * FROM Product WHERE
`type`='Laptop' AND model = ANY(SELECT model FROM Laptop WHERE speed >= 750)
OR
`type`='PC' AND model = ANY(SELECT model FROM PC WHERE speed >= 750);
