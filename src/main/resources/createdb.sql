CREATE SCHEMA IF NOT EXISTS nova_poshta;
USE nova_poshta;

DROP TABLE IF EXISTS indent;
DROP TABLE IF EXISTS delivery;
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS parcel;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS post_office;

CREATE TABLE IF NOT EXISTS post_office (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  city VARCHAR(45) NOT NULL,
  address VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS client (
  id INT NOT NULL AUTO_INCREMENT,
  phone_number_standart VARCHAR(20) NOT NULL,
  phone_number_formal VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS parcel (
  id INT NOT NULL AUTO_INCREMENT,
  price FLOAT NOT NULL,
  weight FLOAT NOT NULL,
  dateSend DATE NOT NULL,
  dateRecive DATE NOT NULL,
  address_sender VARCHAR(45) NOT NULL,
  address_reciver VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS worker (
  id INT NOT NULL AUTO_INCREMENT,
  post_office_id INT NOT NULL,
  first_name VARCHAR(45) NOT NULL,
  last_name VARCHAR(45) NOT NULL,
  patronymic VARCHAR(45) NOT NULL,
  position VARCHAR(45) NOT NULL,
  salary FLOAT NOT NULL,
  passport_number INT NOT NULL,
  hirring_date DATE NOT NULL,
  working_hours INT NOT NULL,
  PRIMARY KEY (id),
  INDEX idPostOffice_idx (post_office_id),
  UNIQUE INDEX passport_number_UNIQUE (passport_number),
  CONSTRAINT post_office_id
    FOREIGN KEY (post_office_id)
    REFERENCES post_office (id)
);


CREATE TABLE IF NOT EXISTS delivery (
  id INT NOT NULL AUTO_INCREMENT,
  worker_id INT NOT NULL,
  price FLOAT NOT NULL,
  type ENUM('CAR', 'TRACK', 'COURIER') NOT NULL,
  max_weight FLOAT NOT NULL,
  min_weight FLOAT NOT NULL,
  PRIMARY KEY (id),
  INDEX worker_id_idx (worker_id),
  CONSTRAINT worker_id
    FOREIGN KEY (worker_id)
    REFERENCES worker (id)
);



CREATE TABLE IF NOT EXISTS indent (
  id INT NOT NULL AUTO_INCREMENT,
  post_office_from_id INT NOT NULL,
  post_office_to_id INT NOT NULL,
  sender_id INT NOT NULL,
  reciver_id INT NOT NULL,
  parcel_id INT NOT NULL,
  delivery_id INT NOT NULL,
  status VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  INDEX post_office_from_id_idx (post_office_from_id),
  INDEX post_office_to_id_idx (post_office_to_id),
  INDEX sender_id_idx (sender_id),
  INDEX reciver_id_idx (reciver_id),
  INDEX parcel_id_idx (parcel_id),
  INDEX delivery_id_idx (delivery_id),
  CONSTRAINT post_office_from_id
    FOREIGN KEY (post_office_from_id)
    REFERENCES post_office (id),
  CONSTRAINT post_office_to_id
    FOREIGN KEY (post_office_to_id)
    REFERENCES post_office (id),
  CONSTRAINT sender_id
    FOREIGN KEY (sender_id)
    REFERENCES client (id),
  CONSTRAINT reciver_id
    FOREIGN KEY (reciver_id)
    REFERENCES client (id),
  CONSTRAINT parcel_id
    FOREIGN KEY (parcel_id)
    REFERENCES parcel (id),
  CONSTRAINT delivery_id
    FOREIGN KEY (delivery_id)
    REFERENCES delivery (id)
);

