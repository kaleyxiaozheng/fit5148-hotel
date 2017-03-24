
begin 
  execute immediate 'drop table hotel';
exception
  when others then
    if sqlcode != -942 then
      raise;
    end if;
end;
/
CREATE TABLE  hotel (
  hotel_id number(6) not null,
  hotel_name varchar(50),
  hotel_type number(2),
  construction_year number(6),
  country varchar(20),
  city varchar(20),
  address varchar(50),
  contact_number varchar(20),
  email varchar(50),
  CONSTRAINT hotel_pk PRIMARY KEY (hotel_id),
  constraint hotel_type_values check (hotel_type in (1, 2, 3, 4, 5))
);

CREATE SEQUENCE hotel_seq START WITH 1 INCREMENT BY   1 NOCACHE NOCYCLE;

CREATE OR REPLACE TRIGGER hotel_auto_increment_insert
  BEFORE INSERT ON hotel
  FOR EACH ROW
BEGIN
  :new.hotel_id := hotel_seq.nextval;
END;

CREATE INDEX hotel_type_index ON hotel(hotel_type);

--DROP SEQUENCE hotel_seq; 

INSERT INTO hotel (hotel_id, hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
   VALUES (null, 'Diamond Dust', 5, 1991, 'USA', 'New York', '13 Rose Street', '01254747747', 'diamonddust@gmail.com' );
INSERT INTO hotel (hotel_id, hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
 VALUES (null, 'Heaven', 4, 1890, 'Vietnam', 'HCM', '13 Amazing rose', '01254747747', 'Heaven@gmail.com' );
INSERT INTO hotel (hotel_id, hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
   VALUES (null, 'Happinese', 3, 1991, 'USA', 'New York', '13 North Road', '01254747747', 'happinese@gmail.com' );
INSERT INTO hotel (hotel_id, hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
 VALUES (null, 'Love Paradise', 2, 1990, 'China', 'Bejjing', '209 Rose Street', '01254734333', 'loveparadise@gmail.com' );
INSERT INTO hotel (hotel_id, hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
   VALUES (null, 'Big Hero', 5, 2007, 'Australia', 'Melbourne', '13 Flinder Street', '0125474343', 'bighero@gmail.com' );
INSERT INTO hotel (hotel_id, hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
 VALUES (null, 'Cannal', 1, 2008, 'Indonesia', 'Bali', '13 No way street', '01254574232', 'cannal@gmail.com' );

commit;

--select * from hotel;