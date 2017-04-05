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

-----------------------------------------Begin BOOKING AND BOOKING_ROOM_GUEST AND PAYMENT-----------------------------------------------
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
  guest_id number(6),
  CONSTRAINT FK_bookingroomguest_booking FOREIGN KEY (booking_id) REFERENCES booking(booking_id),
  CONSTRAINT FK_bookingroomguest_room FOREIGN KEY (room_number, hotel_id) REFERENCES room(room_number, hotel_id),
  CONSTRAINT FK_bookingroomguest_guest FOREIGN KEY (guest_id) REFERENCES guest(guest_id),
  CONSTRAINT PK_Person PRIMARY KEY (booking_id, hotel_id, room_number,guest_id)
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

-----------------------------------------Ending BOOKING AND BOOKING_ROOM_GUEST  AND PAYMENT-----------------------------------------------

commit;

------------------------------------------Begin PROCEDURES------------------------------------------------------------------
--Create stored procedure to update customer email
CREATE OR REPLACE PROCEDURE updateCustomerEmail(
  in_customer_id IN CUSTOMER.CUSTOMER_ID%TYPE,
  in_email IN CUSTOMER.EMAIL%TYPE,
  out_status OUT VARCHAR)
AS
  existFlag NUMBER;
BEGIN
  SELECT COUNT(1) INTO existFlag FROM CUSTOMER WHERE CUSTOMER_ID = in_customer_id;
  IF existFlag = 1 THEN
    UPDATE CUSTOMER SET EMAIL = in_email WHERE CUSTOMER_ID = in_customer_id;
    UPDATE GUEST SET EMAIL = in_email WHERE CITIZEN_ID = 
      (SELECT CITIZEN_ID FROM CUSTOMER WHERE CUSTOMER_ID = in_customer_id);
    out_status := 'S';
  ELSE
    out_status := 'F';
  END IF;
END;

CREATE OR REPLACE PROCEDURE insertOrUpdateCustomer(
  in_cust_id IN CUSTOMER.CUSTOMER_ID%TYPE,
  in_title IN CUSTOMER.TITLE%TYPE,
  in_first_name IN CUSTOMER.FIRST_NAME%TYPE,
  in_last_name IN CUSTOMER.LAST_NAME%TYPE,
  in_citizen_id IN CUSTOMER.CITIZEN_ID%TYPE,
  in_dob IN VARCHAR2,
  in_country IN CUSTOMER.COUNTRY%TYPE,
  in_city IN CUSTOMER.CITY%TYPE,
  in_street IN CUSTOMER.STREET%TYPE,
  in_postal_code IN CUSTOMER.POSTAL_CODE%TYPE,
  in_phone IN CUSTOMER.PHONE_NUM%TYPE,
  in_email IN CUSTOMER.EMAIL%TYPE,
  in_action IN VARCHAR2,
  out_result OUT VARCHAR2)
AS
  temp NUMBER;
  t_count NUMBER;
  t_first_name GUEST.FIRST_NAME%TYPE;
  t_last_name GUEST.LAST_NAME%TYPE;
BEGIN
  --NEED TO CHECK CITIZEN_ID EXISTS IN GUEST WITH OTHER NAME OR NOT.
  SELECT COUNT(1) INTO t_count FROM GUEST WHERE CITIZEN_ID = in_citizen_id;
  IF t_count = 1 THEN
    SELECT FIRST_NAME, LAST_NAME INTO t_first_name, t_last_name FROM GUEST WHERE CITIZEN_ID = in_citizen_id;
    
    IF t_first_name <> in_first_name OR t_last_name <> in_last_name THEN
      --The citizen id is occupied by someone else
      out_result := 'F';
      RETURN;
    END IF;
  END IF;
  
  IF in_action = 'InsertCustomer' THEN
    --By default, the membership is Bronze and credit is 0
    SELECT TIER_ID INTO temp FROM MEMBERSHIP WHERE MEMBERSHIP_TIER = 'Bronze';
  
    INSERT INTO CUSTOMER VALUES (NULL, in_title, in_first_name,in_last_name, in_citizen_id, 
    TO_DATE(in_dob,'yyyy/mm/dd') ,in_country, in_city, in_street, in_postal_code, temp, 0, 
    in_phone, in_email);
  ELSE
    --Membership and credit is not allowed to update manually
    UPDATE CUSTOMER SET TITLE = in_title, FIRST_NAME = in_first_name, LAST_NAME = in_last_name,
    CITIZEN_ID = in_citizen_id, DOB = TO_date(in_dob,'yyyy/mm/dd'), COUNTRY = in_country,
    CITY = in_city, STREET = in_street, POSTAL_CODE = in_postal_code, PHONE_NUM = in_phone,
    EMAIL = in_email WHERE CUSTOMER_ID = in_cust_id;
  END IF;
  
  out_result := 'S';
END;

CREATE OR REPLACE PROCEDURE insertOrUpdateGuest(
  in_guest_id IN GUEST.GUEST_ID%TYPE,
  in_title IN GUEST.TITLE%TYPE,
  in_first_name IN GUEST.FIRST_NAME%TYPE,
  in_last_name IN GUEST.LAST_NAME%TYPE,
  in_citizen_id IN GUEST.CITIZEN_ID%TYPE,
  in_dob IN VARCHAR2,
  in_country IN GUEST.COUNTRY%TYPE,
  in_city IN GUEST.CITY%TYPE,
  in_street IN GUEST.STREET%TYPE,
  in_email IN GUEST.EMAIL%TYPE,
  in_action IN VARCHAR2,
  out_result OUT VARCHAR2)
AS
  temp NUMBER;
  t_count NUMBER;
  t_first_name CUSTOMER.FIRST_NAME%TYPE;
  t_last_name CUSTOMER.LAST_NAME%TYPE;
BEGIN
  --NEED TO CHECK CITIZEN_ID EXISTS IN CUSTOMER WITH OTHER NAME OR NOT.
  SELECT COUNT(1) INTO t_count FROM CUSTOMER WHERE CITIZEN_ID = in_citizen_id;
  IF t_count = 1 THEN
    SELECT FIRST_NAME, LAST_NAME INTO t_first_name, t_last_name FROM CUSTOMER WHERE CITIZEN_ID = in_citizen_id;
    
    IF t_first_name <> in_first_name OR t_last_name <> in_last_name THEN
      --The citizen id is occupied by someone else
      out_result := 'F';
      RETURN;
    END IF;
  END IF;
  
  IF in_action = 'InsertGuest' THEN
    
    INSERT INTO GUEST VALUES (NULL, in_title, in_first_name,in_last_name, in_citizen_id, 
    TO_DATE(in_dob,'yyyy/mm/dd') ,in_country, in_city, in_street, in_email);
  ELSE
    --Membership and credit is not allowed to update manually
    UPDATE GUEST SET TITLE = in_title, FIRST_NAME = in_first_name, LAST_NAME = in_last_name,
    CITIZEN_ID = in_citizen_id, DOB = TO_date(in_dob,'yyyy/mm/dd'), COUNTRY = in_country,
    CITY = in_city, STREET = in_street, EMAIL = in_email WHERE GUEST_ID = in_guest_id;
  END IF;
  
  out_result := 'S';
END;

create or replace PROCEDURE insertOrUpdateMembership(
  in_tier_id IN MEMBERSHIP.TIER_ID%TYPE,
  in_membership_tier IN MEMBERSHIP.MEMBERSHIP_TIER%TYPE,
  in_tier_credit IN MEMBERSHIP.TIER_CREDIT%TYPE,
  in_discount IN MEMBERSHIP.DISCOUNT%TYPE,
  in_other_rewards IN MEMBERSHIP.OTHER_REWARDS%TYPE,
  in_action IN VARCHAR2)
AS
  temp NUMBER;
BEGIN
  IF in_action = 'InsertMembership' THEN
    INSERT INTO MEMBERSHIP VALUES (NULL, in_membership_tier, in_tier_credit, in_discount, in_other_rewards);
    
  ELSE
    
      UPDATE MEMBERSHIP SET MEMBERSHIP_TIER = in_membership_tier, TIER_CREDIT = in_tier_credit,
        DISCOUNT = in_discount, OTHER_REWARDS = in_other_rewards WHERE TIER_ID = in_tier_id;
      
  END IF;
END;

create or replace PROCEDURE addCustomerToGuest(
  in_cust_id IN CUSTOMER.CUSTOMER_ID%Type,
  out_guest_id OUT GUEST.GUEST_ID%TYPE
)
AS
  temp NUMBER;
  t_citizen_id NUMBER;
BEGIN
  
  SELECT COUNT(1), GUEST.CITIZEN_ID INTO temp, t_citizen_id FROM GUEST WHERE EXISTS (
    SELECT * FROM CUSTOMER WHERE GUEST.CITIZEN_ID = CUSTOMER.CITIZEN_ID
    AND CUSTOMER_ID = in_cust_id) group by GUEST.CITIZEN_ID;
    
  IF temp = 1 THEN
    SELECT GUEST_ID INTO out_guest_id FROM GUEST WHERE GUEST.CITIZEN_ID = t_citizen_id;
  ELSE
    --Due to the uniqueness of citizen_id, it will only insert one record into GUEST table
    FOR cust_rec IN (SELECT TITLE, FIRST_NAME, LAST_NAME, CITIZEN_ID, DOB, COUNTRY, CITY, STREET, EMAIL
      FROM CUSTOMER WHERE CUSTOMER_ID = in_cust_id) LOOP
      
      INSERT INTO GUEST(GUEST_ID, TITLE, FIRST_NAME, LAST_NAME, CITIZEN_ID, DOB, COUNTRY, CITY, STREET, EMAIL)
        VALUES (NULL, cust_rec.TITLE, cust_rec.FIRST_NAME, cust_rec.LAST_NAME, cust_rec.CITIZEN_ID, cust_rec.DOB,
        cust_rec.COUNTRY, cust_rec.CITY, cust_rec.STREET, cust_rec.EMAIL) RETURNING GUEST_ID INTO out_guest_id;
      
    END LOOP;  
  END IF;
END;



create or replace PROCEDURE upgradeCustomer(
  in_booking_id IN BOOKING.BOOKING_ID%Type
)
AS
  cur_credit NUMBER;
  new_credit NUMBER;
  cust_id CUSTOMER.CUSTOMER_ID%TYPE;
  total_amt NUMBER;
  --cur_membership NUMBER;
  tier_credit NUMBER;
  tmp NUMBER;
  new_tier NUMBER;
BEGIN
  
  SELECT CUSTOMER_ID, TOTAL_AMOUNT INTO cust_id, total_amt FROM BOOKING WHERE BOOKING_ID = in_booking_id;
  
  SELECT c.MEMBERSHIP_CREDITS INTO cur_credit 
  FROM CUSTOMER c WHERE c.CUSTOMER_ID = cust_id;
  
  new_credit := cur_credit + total_amt;
  
  SELECT COUNT(1) INTO tmp FROM MEMBERSHIP WHERE TIER_CREDIT <= new_credit AND TIER_CREDIT > cur_credit AND ROWNUM = 1 ORDER BY TIER_CREDIT DESC;
  
  IF tmp > 0 then
    --update both credit and membership tier
    SELECT TIER_ID INTO new_tier FROM MEMBERSHIP WHERE TIER_CREDIT <= new_credit AND TIER_CREDIT > cur_credit;
    UPDATE customer set tier_id = new_tier, membership_credits = new_credit where customer_id = cust_id;
  ELSE
    --only update new credit
    update customer set membership_credits = new_credit where customer_id = cust_id;
  end if;
END; 
--End of stored procedure
