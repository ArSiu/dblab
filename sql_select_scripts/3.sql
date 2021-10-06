SELECT Outcomes.ship,Battles.name,Battles.date,Outcomes.result FROM Outcomes 
INNER JOIN Battles 
ON Outcomes.battle=Battles.name 
WHERE Outcomes.result NOT LIKE 'sunk';