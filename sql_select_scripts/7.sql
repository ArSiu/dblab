SELECT Trip.trip_no,count(*), Pass_in_trip.date FROM Pass_in_trip
JOIN Trip
ON Trip.trip_no=Pass_in_trip.trip_no
WHERE town_from='Moscow' GROUP BY date,trip_no;