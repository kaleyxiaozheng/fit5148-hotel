
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
  hotel_name varchar(50) not null,
  hotel_type varchar(20),
  construction_year number(6),
  country varchar(20),
  city varchar(20),
  address varchar(50),
  contact_number varchar(20),
  email varchar(50),
  CONSTRAINT hotel_pk PRIMARY KEY (hotel_id),
  constraint hotel_type_values check (hotel_type in ('1 star', '2 star', '3 star', '4 star', '5 star'))
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
   VALUES (null, 'Aman Resort', '1 star', 1991, 'Australia', 'Melbourne', '13 Rose Street', '01254747747', 'diamonddust@gmail.com');
INSERT INTO hotel (hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
 VALUES ('The Ascott Limited', '3 star', 1890, 'Australia', 'New South Wales', '13 Amazing rose', '01254747747', 'Heaven@gmail.com' );
INSERT INTO hotel (hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
   VALUES ('Banyan Tree Holding', '4 star', 1991, 'Australia', 'Tasmania', '13 North Road', '01254747747', 'happinese@gmail.com' );
INSERT INTO hotel (hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
 VALUES ('Best Western Hotel', '5 star', 1990, 'Australia', 'Sydney', '209 Rose Street', '01254734333', 'loveparadise@gmail.com');
INSERT INTO hotel (hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
   VALUES ('Boscolo Hotel', '2 star', 2007, 'Australia', 'Melbourne', '13 Flinder Street', '0125474343', 'bighero@gmail.com');
INSERT INTO hotel (hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
 VALUES ('Cannal', '5 star', 2008, 'Australia', 'Sydney', '13 No way street', '01254574232', 'cannal@gmail.com' );

commit;


--create trigger raise error when delete hotel having referencing from room
CREATE OR REPLACE TRIGGER delete_hotel_trigger
  BEFORE DELETE ON HOTEL
  FOR EACH ROW
DECLARE
  room_count varchar(6);
BEGIN
--check foregin key from hotel
  select count(*) into room_count 
  from room@fit5148b tempt where tempt.hotel_id = :old.hotel_id;
  
  if room_count > 0 then
   RAISE_APPLICATION_ERROR(-20002, 'this hotel has references from other rooms');
  end if;
END;
