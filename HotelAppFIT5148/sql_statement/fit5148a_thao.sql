CREATE TABLE  hotel (
  hotel_id number(6),
  name varchar(50),
  hotel_type varchar(20),
  construction_year number(6),
  country varchar(20),
  city varchar(20),
  address varchar(50),
  contact_number varchar(20),
  email varchar(50),
  CONSTRAINT hotel_pk PRIMARY KEY (hotel_id)
);