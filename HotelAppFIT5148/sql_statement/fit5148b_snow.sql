/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  situsnow
 * Created: Mar 22, 2017
 */

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

INSERT INTO membership VALUES (NULL, 'Bronze', 500, 90.00, 'Free breakfast');
INSERT INTO membership VALUES (NULL, 'Silver', 1000, 95.00, 'Free buffet');
INSERT INTO membership VALUES (NULL, 'Gold', 5000, 80.00, 'Access all facilities');
INSERT INTO membership VALUES (NULL, 'Platinum', 10000, 85.00, 'Access all facilities + pick up');
INSERT INTO membership VALUES (NULL, 'VIP', 20000, 70.00, 'Upgrade to Presidential suite');
--End of creating table Membership

--Start of creating table Customer
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

--End of creating table Customer

--Start of creating table Guest
CREATE TABLE Guest (
  guest_id NUMBER(6) PRIMARY KEY,
  title VARCHAR(10),
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  citizen_id NUMBER(20) UNIQUE NOT NULL,
  dob DATE,
  country VARCHAR(20),
  city VARCHAR(20),
  street VARCHAR(50),
  email VARCHAR(50)
);
CREATE SEQUENCE guest_sequence START WITH 1 INCREMENT BY 1 MINVALUE 1 NOMAXVALUE NOCYCLE CACHE 2;
CREATE INDEX idx_guest_name ON Guest (first_name, last_name);

CREATE OR REPLACE TRIGGER guest_auto_increment_insert
  BEFORE INSERT ON Guest
  FOR EACH ROW
BEGIN
    :new.guest_id := guest_sequence.nextval;
END;

INSERT INTO Guest (guest_id,title, first_name, last_name, citizen_id, dob, country, city, street, email) 
    VALUES (NULL, 'Miss', 'Xuelin', 'Situ', 6);
INSERT INTO Guest (guest_id,title, first_name, last_name, citizen_id, dob, country, city, street, email) 
    VALUES (NULL, 'MR', 'Ryan', 'Reynolds', 5);
INSERT INTO Guest (guest_id,title, first_name, last_name, citizen_id, dob, country, city, street, email) 
    VALUES (NULL, 'MR', 'Eddie', 'Redmayne', 4);
INSERT INTO Guest (guest_id,title, first_name, last_name, citizen_id, dob, country, city, street, email) 
    VALUES (NULL, 'Miss', 'Thao', 'Thao', 4);
INSERT INTO Guest (guest_id,title, first_name, last_name, citizen_id, dob, country, city, street, email) 
    VALUES (NULL, 'Miss', 'Kaley', 'Kaley', 8);
--End of creating table Guest

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
  in_action IN VARCHAR2)
AS
  temp NUMBER;
BEGIN
  IF in_action = 'Insert' THEN
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
--End of stored procedure