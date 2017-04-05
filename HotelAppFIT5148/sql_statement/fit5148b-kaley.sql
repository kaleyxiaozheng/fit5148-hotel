
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
  check_in_date date,
  check_out_date date,
  total_amount numeric(20,2),
  payment_status varchar(1),
  CONSTRAINT PK_booking PRIMARY KEY (booking_id)
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
  hotel_id number(6),
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
INSERT INTO booking VALUES(null, 1, TO_DATE('12/03/2015', 'DD/MM/YYYY'), TO_DATE('24/03/2015', 'DD/MM/YYYY'), 2000.00, 'S');
INSERT INTO booking VALUES(null, 1, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'S');
INSERT INTO booking VALUES(null, 1, TO_DATE('19/03/2014', 'DD/MM/YYYY'), TO_DATE('24/03/2014', 'DD/MM/YYYY'), 800.00, 'F');
INSERT INTO booking VALUES(null, 1, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'P');
INSERT INTO booking VALUES(null, 1, TO_DATE('01/02/2014', 'DD/MM/YYYY'), TO_DATE('05/02/2014', 'DD/MM/YYYY'), 440.00, 'S');

INSERT INTO booking VALUES(null, 2, TO_DATE('12/03/2015', 'DD/MM/YYYY'), TO_DATE('24/03/2015', 'DD/MM/YYYY'), 2000.00, 'S');
INSERT INTO booking VALUES(null, 2, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'S');
INSERT INTO booking VALUES(null, 2, TO_DATE('19/03/2014', 'DD/MM/YYYY'), TO_DATE('24/03/2014', 'DD/MM/YYYY'), 800.00, 'F');
INSERT INTO booking VALUES(null, 2, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'P');
INSERT INTO booking VALUES(null, 2, TO_DATE('01/02/2014', 'DD/MM/YYYY'), TO_DATE('05/02/2014', 'DD/MM/YYYY'), 440.00, 'S');

INSERT INTO booking VALUES(null, 3, TO_DATE('12/03/2015', 'DD/MM/YYYY'), TO_DATE('24/03/2015', 'DD/MM/YYYY'), 2000.00, 'S');
INSERT INTO booking VALUES(null, 3, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'S');
INSERT INTO booking VALUES(null, 3, TO_DATE('19/03/2014', 'DD/MM/YYYY'), TO_DATE('24/03/2014', 'DD/MM/YYYY'), 800.00, 'F');
INSERT INTO booking VALUES(null, 3, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'P');
INSERT INTO booking VALUES(null, 3, TO_DATE('01/02/2014', 'DD/MM/YYYY'), TO_DATE('05/02/2014', 'DD/MM/YYYY'), 440.00, 'S');

INSERT INTO booking VALUES(null, 4, TO_DATE('12/03/2015', 'DD/MM/YYYY'), TO_DATE('24/03/2015', 'DD/MM/YYYY'), 2000.00, 'S');
INSERT INTO booking VALUES(null, 4, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'S');
INSERT INTO booking VALUES(null, 4, TO_DATE('19/03/2014', 'DD/MM/YYYY'), TO_DATE('24/03/2014', 'DD/MM/YYYY'), 800.00, 'F');
INSERT INTO booking VALUES(null, 4, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'P');
INSERT INTO booking VALUES(null, 4, TO_DATE('01/02/2014', 'DD/MM/YYYY'), TO_DATE('05/02/2014', 'DD/MM/YYYY'), 440.00, 'S');

INSERT INTO booking VALUES(null, 5, TO_DATE('12/03/2015', 'DD/MM/YYYY'), TO_DATE('24/03/2015', 'DD/MM/YYYY'), 2000.00, 'S');
INSERT INTO booking VALUES(null, 5, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'S');
INSERT INTO booking VALUES(null, 5, TO_DATE('19/03/2014', 'DD/MM/YYYY'), TO_DATE('24/03/2014', 'DD/MM/YYYY'), 800.00, 'F');
INSERT INTO booking VALUES(null, 5, TO_DATE('16/03/2016', 'DD/MM/YYYY'), TO_DATE('24/03/2016', 'DD/MM/YYYY'), 1590.00, 'P');
INSERT INTO booking VALUES(null, 5, TO_DATE('01/02/2014', 'DD/MM/YYYY'), TO_DATE('05/02/2014', 'DD/MM/YYYY'), 440.00, 'S');

-- add foreign keys and primary key in table bookingroomguest
ALTER TABLE bookingroomguest
ADD CONSTRAINT FK_bookingroomguest_booking
FOREIGN KEY (booking_id) REFERENCES booking(booking_id);


ALTER TABLE bookingroomguest
ADD CONSTRAINT FK_bookingroomguest_room
FOREIGN KEY (room_number) REFERENCES room(room_number);

ALTER TABLE bookingroomguest
ADD CONSTRAINT FK_bookingroomguest_guest
FOREIGN KEY (guest_id) REFERENCES guest(guest_id);

ALTER TABLE bookingroomguest
ADD CONSTRAINT PK_Person PRIMARY KEY (booking_id,room_number,guest_id);


