INSERT INTO client (phone_number_standart,phone_number_formal) VALUES
    ('159000326616','159(00)032-66-16'),
    ('573739272992','57(373)927-29-92'),
    ('93353942708874','933(5394)270-88-74'),
    ('5932138648827','59(3213)864-88-27'),
    ('57843794681','5(784)379-46-81'),
    ('209033809297','2(0903)380-92-97'),
    ('6916861486067','69(1686)148-60-67'),
    ('81850821750','8(185)082-17-50'),
    ('969825109960','96(982)510-99-60'),
    ('419237420505','41(923)742-05-05');

INSERT INTO post_office (name,city,address) VALUES
    ('7','Lviv','Lychakivska St, 8'),
    ('31','Lviv','Tershakovtsiv St, 1'),
    ('10','Lviv','Levytskoho St, 7'),
    ('14','Lviv','Slovatskoho St, 5'),
    ('64','Lviv','Ilariona Svjentsitskoho St, 5'),
    ('60','Lviv','Bohdana Khmelnytskoho St, 72'),
    ('53','Lviv','Bohdana Khmelnytskoho St, 29'),
    ('13','Lviv','Viacheslava Chornovola Ave, 16'),
    ('75','Lviv','Hazova St, 5 а');

INSERT INTO parcel (price,weight,dateSend,dateRecive,address_sender,address_reciver) VALUES
    (102.2,30,'2021-09-25 13:45:00.00','2021-09-29 13:45:00.00','Hazova St, 5 а','Ilariona Svjentsitskoho St, 5'),
    (200.0,2,'2021-09-27 13:45:00.00','2021-09-29 13:45:00.00','Tershakovtsiv St, 1','Slovatskoho St, 5'),
    (500.0,1,'2021-09-25 13:45:00.00','2021-09-29 13:45:00.00','Levytskoho St, 7','Lychakivska St, 8'),
    (10.0,10,'2021-09-25 13:45:00.00','2021-09-29 13:45:00.00','Levytskoho St, 7','Bohdana Khmelnytskoho St, 72'),
    (35.0,45,'2021-09-25 13:45:00.00','2021-09-29 13:45:00.00','Lychakivska St, 8','Ilariona Svjentsitskoho St, 5'),
    (2.0,34,'2021-09-25 13:45:00.00','2021-09-29 13:45:00.00','Viacheslava Chornovola Ave, 16','Hazova St, 5а'),
    (1000.0,100,'2021-09-25 13:45:00.00','2021-09-29 13:45:00.00','Levytskoho St, 7','Ilariona Svjentsitskoho St, 5');

INSERT INTO worker (post_office_id, first_name, last_name, patronymic, position, salary, passport_number, hirring_date, working_hours) VALUES
    (1,'Andriy', 'Kuzma','the sun instead of a hat','head musician of live',999999,77777777,'2015-02-02',8),
    (1,'Zhadan','Sergey','Nataha','head musician of new rock wave ua',10000.0,8888888,'2021-09-29',8),
    (1,'Bassoon','Mikhailuta','Make me hip hop','head tnmk',10000.0,66666666,'2021-09-29',8),
    (1,'Oleksandr','Sydorenko','We made God laugh','head tnmk',10000.0,11111111,'2021-09-29',8),
    (1,'Andrey','Makarevich','Bonfire','top musician',10000.0,55555555,'2021-09-21',8),
    (1,'Alexander','Gudimov','Chameleone','rack star',10000.0,22211222,'2021-09-21',8),
    (1,'Viktor', 'Tsoi','Le Dernier Des Heros','stil alive',10000.0,22222222,'2021-09-21',8);

INSERT INTO delivery (worker_id,price,type,max_weight,min_weight) VALUES
    (1,100000.0,'CAR',1000.0,100.0),
    (2,200000.0,'TRACK',10000.0,1000.0),
    (3,200000.0,'CAR',10000.0,1000.0),
    (4,200000.0,'COURIER',10000.0,1000.0),
    (5,200000.0,'COURIER',10000.0,1000.0),
    (6,200000.0,'COURIER',10000.0,1000.0);

INSERT INTO indent (
post_office_from_id,
post_office_to_id,
sender_id,
reciver_id,
parcel_id,
delivery_id,
status
) VALUES
(1,2,1,2,1,2,'inprogress'),
(2,3,2,3,2,4,'inprogress'),
(1,2,1,2,3,3,'inprogress'),
(1,2,1,2,4,1,'inprogress'),
(1,2,1,2,5,2,'inprogress'),
(1,2,1,2,6,5,'inprogress'),
(1,2,1,2,7,6,'inprogress');