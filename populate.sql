USE students;

INSERT INTO student (
last_name, 
first_name, 
patronymic, 
avg_rating, 
birth_date, 
income_date, 
number_student_ticket, 
mail, 
city_id, 
school_id,
student_group_id, 
student_has_arrear_id ) 
VALUES
("Pupkin", "Vasya", "Rukovich", 100, "2000-05-05", "2018-06-07", 347898393, "zaluparock@techno.com", 1, 2, 1, 1),
("Debian", "Ubuntu", "Fedora", 200, "2004-05-05", "2021-06-07", 347498444, "boto@nataha.com", 1, 2, 1, 2),
("Montana", "Zabava", "Igorivna", 120, "1999-05-05", "2020-06-07", 949899393, "sontsezamist@shapky.com", 1, 2, 1, 3);

INSERT INTO city (
city,
region_id
) 
VALUES
("Lviv", 1),
("Ternopil", 2),
("Striy", 1);

INSERT INTO region (
region,
zip
)
VALUES
("Lvivskiy", 79001),
("Ternopilskiy", 79001);

INSERT INTO arrear (
subject_name,
student_has_arrear_id
)
VALUES
("Math", 1),
("Physics", 2),
("Eng", 3);

INSERT INTO school(
name,
phone_number,
full_name,
city_id
)
VALUES
("School 6","+380638574453","Ivan Fedorovych Valuiko",1),
("School 5","+380634354589","Stepan Mertviy Stepanovych",2),
("School 4","+380638904329","Roksolana Serhiyvna Stepanivna",3);

INSERT INTO student_group(
name,
number,
date_income
)
VALUES
("Matrosi",56,"2010-01-01"),
("Chainyki",67,"2015-02-02"),
("Ratatui",43,"1999-05-05");
