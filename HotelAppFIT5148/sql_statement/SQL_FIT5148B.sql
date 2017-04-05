-----------------------------------------Begin ROOM-----------------------------------------------
begin 
  execute immediate 'drop table room';
exception
  when others then
    if sqlcode != -942 then
      raise;
    end if;
end;
/
--create table room 
CREATE TABLE  room (
  room_number varchar(20) not null,
  hotel_id number not null,
  room_type varchar(20),
  price number(15,5) not null,
  description varchar(20),
  CONSTRAINT room_pk PRIMARY KEY (hotel_id, room_number),
  constraint room_type_values check (room_type in ('Single', 'Double', 'Studio', 'Suite'))
);

--create sequence for room
CREATE SEQUENCE room_seq START WITH 1 INCREMENT BY   1 NOCACHE NOCYCLE;

--create trigger relating to hotel table in other side
CREATE OR REPLACE TRIGGER room_insert_update_trigger
  BEFORE INSERT OR UPDATE ON room
  FOR EACH ROW
DECLARE
  hotel_id_count varchar(6);
BEGIN
--check foregin key from hotel
  select count(*) into hotel_id_count 
  from hotel@fit5148a tempt where tempt.hotel_id = :new.hotel_id;
  if hotel_id_count = 0 then
   RAISE_APPLICATION_ERROR(-20001, 'hotel_id does not exist in hotel table');
  end if;
END;


--generate data for room
declare
 hotel_id_var number;
begin
SELECT hotel_id into hotel_id_var FROM
( SELECT hotel_id FROM hotel@FIT5148A
ORDER BY dbms_random.value )
WHERE rownum = 1;

INSERT INTO room (room_number, hotel_id, room_type, price, description)
   VALUES (to_char(room_seq.nextval),hotel_id_var , 'Single', 100, 'beach view');
commit;
end;
/

declare
 hotel_id_var number;
begin
SELECT hotel_id into hotel_id_var FROM
( SELECT hotel_id FROM hotel@FIT5148A
ORDER BY dbms_random.value )
WHERE rownum = 1;

INSERT INTO room (room_number, hotel_id, room_type, price, description)
   VALUES (to_char(room_seq.nextval),hotel_id_var , 'Double', 300, 'mountain view');

commit;
end;
/

declare
 hotel_id_var number;
begin
SELECT hotel_id into hotel_id_var FROM
( SELECT hotel_id FROM hotel@FIT5148A
ORDER BY dbms_random.value )
WHERE rownum = 1;

INSERT INTO room (room_number, hotel_id, room_type, price, description)
   VALUES (to_char(room_seq.nextval),hotel_id_var , 'Studio', 500.50, 'desert view');

commit;
end;
/

declare
 hotel_id_var number;
begin
SELECT hotel_id into hotel_id_var FROM
( SELECT hotel_id FROM hotel@FIT5148A
ORDER BY dbms_random.value )
WHERE rownum = 1;

INSERT INTO room (room_number, hotel_id, room_type, price, description)
   VALUES (to_char(room_seq.nextval),hotel_id_var , 'Suite', 900.50, 'sun set view');

commit;
end;
/
declare
 hotel_id_var number;
begin
SELECT hotel_id into hotel_id_var FROM
( SELECT hotel_id FROM hotel@FIT5148A
ORDER BY dbms_random.value )
WHERE rownum = 1;

INSERT INTO room (room_number, hotel_id, room_type, price, description)
   VALUES (to_char(room_seq.nextval),hotel_id_var , 'Double', 700, 'dophil view');

commit;
end;
/
-----------------------------------------Ending ROOM-----------------------------------------------

-----------------------------------------Begin FACILITY-----------------------------------------------

begin 
  execute immediate 'drop table facility';
exception
  when others then
    if sqlcode != -942 then
      raise;
    end if;
end;
/

CREATE TABLE  facility (
  facility_number varchar(10) not null,
  room_number varchar(10) not null,
  hotel_id number not null,
  description varchar(50) not null,
  CONSTRAINT facility_pk PRIMARY KEY (hotel_id, room_number, facility_number),
  constraint fk_room_number_facility foreign key (room_number, hotel_id)
      references room (room_number, hotel_id)

);
CREATE SEQUENCE facility_seq START WITH 1 INCREMENT BY   1 NOCACHE NOCYCLE;

declare
 hotel_id_var number;
 room_number_var varchar(20);
begin
SELECT hotel_id, room_number into hotel_id_var, room_number_var FROM
( SELECT hotel_id, room_number FROM room@FIT5148B
ORDER BY dbms_random.value )
WHERE rownum = 1;

INSERT INTO facility (room_number, hotel_id, facility_number, description)
   VALUES (room_number_var ,hotel_id_var , to_char(facility_seq.nextval), 'Washing machine.');
commit;
end;
/
declare
 hotel_id_var number;
 room_number_var varchar(20);
begin
SELECT hotel_id, room_number into hotel_id_var, room_number_var FROM
( SELECT hotel_id, room_number FROM room@FIT5148B
ORDER BY dbms_random.value )
WHERE rownum = 1;

INSERT INTO facility (room_number, hotel_id, facility_number, description)
   VALUES (room_number_var ,hotel_id_var , to_char(facility_seq.nextval), 'Big tivi.');
commit;
end;
/

declare
 hotel_id_var number;
 room_number_var varchar(20);
begin
SELECT hotel_id, room_number into hotel_id_var, room_number_var FROM
( SELECT hotel_id, room_number FROM room@FIT5148B
ORDER BY dbms_random.value )
WHERE rownum = 1;

INSERT INTO facility (room_number, hotel_id, facility_number, description)
   VALUES (room_number_var ,hotel_id_var , to_char(facility_seq.nextval), '3D Game.');
commit;
end;
/
declare
 hotel_id_var number;
 room_number_var varchar(20);
begin
SELECT hotel_id, room_number into hotel_id_var, room_number_var FROM
( SELECT hotel_id, room_number FROM room@FIT5148B
ORDER BY dbms_random.value )
WHERE rownum = 1;

INSERT INTO facility (room_number, hotel_id, facility_number, description)
   VALUES (room_number_var ,hotel_id_var , to_char(facility_seq.nextval), 'Iron.');
commit;
end;
/

declare
 hotel_id_var number;
 room_number_var varchar(20);
begin
SELECT hotel_id, room_number into hotel_id_var, room_number_var FROM
( SELECT hotel_id, room_number FROM room@FIT5148B
ORDER BY dbms_random.value )
WHERE rownum = 1;

INSERT INTO facility (room_number, hotel_id, facility_number, description)
   VALUES (room_number_var ,hotel_id_var , to_char(facility_seq.nextval), 'Sofa');

commit;
end;
/
commit;

-----------------------------------------Ending FACILITY-----------------------------------------------

-----------------------------------------Begin MEMBERSHIP-----------------------------------------------
--Start of creating table Membership
CREATE TABLE Membership (
  tier_id NUMBER(6) PRIMARY KEY,
  membership_tier VARCHAR(20) NOT NULL UNIQUE,
  tier_credit NUMBER(10) NOT NULL,
  discount NUMBER(4,2) NOT NULL,
  other_rewards VARCHAR(255)
);
CREATE SEQUENCE membership_sequence START WITH 1 INCREMENT BY 1 MINVALUE 1 NOMAXVALUE NOCYCLE CACHE 2;
CREATE INDEX idx_membership_tier_credit ON Membership (tier_credit);

CREATE OR REPLACE TRIGGER membership_auto_increment
  BEFORE INSERT ON Membership
  FOR EACH ROW
BEGIN
    :new.tier_id := membership_sequence.nextval;
END;

INSERT INTO membership VALUES (NULL, 'Bronze', 500, 0.9, 'Free breakfast');
INSERT INTO membership VALUES (NULL, 'Silver', 1000, 0.95, 'Free buffet');
INSERT INTO membership VALUES (NULL, 'Gold', 5000, 0.8, 'Access all facilities');
INSERT INTO membership VALUES (NULL, 'Platinum', 10000, 0.85, 'Access all facilities + pick up');
INSERT INTO membership VALUES (NULL, 'VIP', 20000, 0.7, 'Upgrade to Presidential suite');
--End of creating table Membership


-----------------------------------------Ending MEMBERSHIP-----------------------------------------------

-----------------------------------------Begin CUSTOMER-----------------------------------------------
CREATE TABLE Customer (
  customer_id NUMBER(6),
  title VARCHAR(10),
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30),
  citizen_id NUMBER(20) NOT NULL,
  dob DATE,
  country VARCHAR(20),
  city VARCHAR(20),
  street VARCHAR(50),
  postal_code NUMBER(4),
  tier_id NUMBER(6),
  membership_credits NUMBER(10),
  phone_num NUMBER(20),
  email VARCHAR(50),
  CONSTRAINT pk_customer_id PRIMARY KEY (customer_id),
  CONSTRAINT uq_citizen_id UNIQUE(citizen_id),
  CONSTRAINT fk_tier_id FOREIGN KEY (tier_id) references Membership (tier_id)
);

CREATE SEQUENCE customer_sequence START WITH 1 INCREMENT BY 1 MINVALUE 1 NOMAXVALUE NOCYCLE CACHE 2;
CREATE INDEX idx_customer_name ON Customer (first_name, last_name);

CREATE OR REPLACE TRIGGER customer_auto_increment_insert
  BEFORE INSERT ON Customer
  FOR EACH ROW
BEGIN
    :new.customer_id := customer_sequence.nextval;
END;

INSERT INTO CUSTOMER VALUES (NULL, 'MR', 'Tom','Hiddleston', 1, TO_date('1981/02/09','yyyy/mm/dd')
,'Australa', 'Melbourn','Caulfield',1234,1,800,12345678,'tom.hiddleson@test.com');
INSERT INTO CUSTOMER VALUES (NULL, 'MR', 'Hugh','Jackman', 2, TO_date('1968/10/12','yyyy/mm/dd')
,'Australa', 'Melbourn','Clayton',2345,2,1200,12345678,'hugh.jackman@test.com');
INSERT INTO CUSTOMER VALUES (NULL, 'MR', 'James','Mcavoy', 3, TO_date('1979/04/21','yyyy/mm/dd')
,'Australa', 'Sydney','CBD',3456,3,6000,12345678,'james.mcavoy@test.com');
INSERT INTO CUSTOMER VALUES (NULL, 'MR', 'Eddie','Redmayne', 4, TO_date('1982/01/06','yyyy/mm/dd')
,'Australa', 'Adelaide','CBD',1234,4,12000,12345678,'eddie.redmayne@test.com');
INSERT INTO CUSTOMER VALUES (NULL, 'MR', 'Ryan','Reynolds', 5, TO_date('1976/10/23','yyyy/mm/dd')
,'Australa', 'Canberra','CBD',1234,5,25000,12345678,'ryan.reynolds@test.com');

-----------------------------------------Ending CUSTOMER-----------------------------------------------

-----------------------------------------Begin BOOKING AND BOOKING_ROOM_GUEST-----------------------------------------------
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
ADD CONSTRAINT FK_bookingroomguest_hotel
FOREIGN KEY (hotel_id) REFERENCES hotel(hotel_id);


ALTER TABLE bookingroomguest
ADD CONSTRAINT FK_bookingroomguest_guest
FOREIGN KEY (guest_id) REFERENCES guest(guest_id);

ALTER TABLE bookingroomguest
ADD CONSTRAINT PK_Person PRIMARY KEY (booking_id,room_number,guest_id);

-----------------------------------------Ending BOOKING AND BOOKING_ROOM_GUEST-----------------------------------------------

commit;