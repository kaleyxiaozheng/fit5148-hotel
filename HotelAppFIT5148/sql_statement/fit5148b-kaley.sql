-- Create table 
CREATE TABLE  bookingRoomGuest (
  booking_id number(6),
  room_number varchar(10),
  guest_id number(6)
);
----------------------------------------
/*begin 
  execute immediate 'drop table hotel';
exception
  when others then
    if sqlcode != -942 then
      raise;
    end if;
end;
/
*/
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
----------------------------------------------

-- Create booking table
/*DELIMITER //
    begin 
    execute immediate 'drop table booking';
    exception
    when others then
    if sqlcode != -942 then
      raise;
    end if;
end;
 /
*/
CREATE TABLE booking (
  booking_id number(6) NOT NULL,
  customer_id number(6),
  hotel_id number(6),
  check_in_date date,
  check_out_date date,
  total_amount numeric(20,2),
  payment_status varchar(1),
  CONSTRAINT PK_booking PRIMARY KEY (booking_id),
  --CONSTRAINT FK_booking_customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
  --CONSTRAINT FK_booking_hotel FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id)
);

------------------------------------
-- Create payment table
/*
DELIMITER //
    begin 
    execute immediate 'drop table payment';
    exception
    when others then
    if sqlcode != -942 then
      raise;
    end if;
end;
 /
 */

CREATE TABLE  payment (
  booking_id number(6),
  payment_day date,
  payment_method varchar(10),
  payment_amount number(20,2),
  CONSTRAINT PK_payment PRIMARY KEY (booking_id, payment_day)
);

------------------------------------
-- Create bookingRoomGuest table
/*
DELIMITER //
    begin 
    execute immediate 'drop table bookingRoomGuest';
    exception
    when others then
    if sqlcode != -942 then
      raise;
    end if;
end;
 /
 */

CREATE TABLE  bookingRoomGuest (
  booking_id number(6),
  room_number varchar(10),
  guest_id number(6)
);

-------------------------------------------
-- Create sequence of booking booking_id
CREATE SEQUENCE seq_booking_id start with 1 INCREMENT BY 1;

-- Create a trigger in order to create booking_id automatically. 

CREATE OR REPLACE TRIGGER tri_booking_id
  BEFORE INSERT ON booking
  FOR EACH ROW
BEGIN
  :new.booking_id := seq_booking_id.nextval;
END;

--------------------------------------------
-- insert data into table of booking
INSERT INTO booking VALUES(seq_booking_id.NEXTVAL, 1, 1, TO_DATE('12/03/2017', 'DD/MM/YYYY'), TO_DATE('24/03/2017', 'DD/MM/YYYY'), 2000.00, 'S');
INSERT INTO booking VALUES(seq_booking_id.NEXTVAL, 1, 1, TO_DATE('16/03/2017', 'DD/MM/YYYY'), TO_DATE('24/03/2017', 'DD/MM/YYYY'), 1590.00, 'S');
INSERT INTO booking VALUES(seq_booking_id.NEXTVAL, 1, 1, TO_DATE('19/03/2017', 'DD/MM/YYYY'), TO_DATE('24/03/2017', 'DD/MM/YYYY'), 800.00, 'F');
INSERT INTO booking VALUES(seq_booking_id.NEXTVAL, 1, 1, TO_DATE('16/03/2017', 'DD/MM/YYYY'), TO_DATE('24/03/2017', 'DD/MM/YYYY'), 1590.00, 'P');
INSERT INTO booking VALUES(seq_booking_id.NEXTVAL, 1, 1, TO_DATE('01/02/2017', 'DD/MM/YYYY'), TO_DATE('05/02/2017', 'DD/MM/YYYY'), 440.00, 'S');

INSERT INTO booking VALUES(null, 1, 1, TO_DATE('12/03/2015', 'DD/MM/YYYY'), TO_DATE('24/03/2015', 'DD/MM/YYYY'), 2000.00, 'S');
INSERT INTO booking VALUES(null, 1, 1, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'S');
INSERT INTO booking VALUES(null, 1, 1, TO_DATE('19/03/2014', 'DD/MM/YYYY'), TO_DATE('24/03/2014', 'DD/MM/YYYY'), 800.00, 'F');
INSERT INTO booking VALUES(null, 1, 1, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'P');
INSERT INTO booking VALUES(null, 1, 1, TO_DATE('01/02/2014', 'DD/MM/YYYY'), TO_DATE('05/02/2014', 'DD/MM/YYYY'), 440.00, 'S');

-- add a foreign key in table booking
ALTER TABLE booking
ADD CONSTRAINT FK_booking_customer
FOREIGN KEY (customer_id) REFERENCES customer(customer_id);

-- drop the sequence 
--DROP SEQUENCE seq_booking_id; 

-- add foreign keys and primary key in table bookingroomguest
ALTER TABLE bookingroomguest
ADD CONSTRAINT FK_bookingroomguest_booking
FOREIGN KEY (booking_id) REFERENCES booking(booking_id);

/*
ALTER TABLE bookingroomguest
ADD CONSTRAINT FK_bookingroomguest_room
FOREIGN KEY (room_number) REFERENCES room(room_number);
*/

ALTER TABLE bookingroomguest
ADD CONSTRAINT FK_bookingroomguest_guest
FOREIGN KEY (guest_id) REFERENCES guest(guest_id);

ALTER TABLE bookingroomguest
ADD CONSTRAINT PK_Person PRIMARY KEY (booking_id,room_number,guest_id);