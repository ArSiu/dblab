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