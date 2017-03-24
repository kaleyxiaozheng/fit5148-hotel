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

--------------------------------------------
-- insert data into table of booking
INSERT INTO booking VALUES()