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
--End of creating table Membership

--Start of creating table Customer
CREATE TABLE Customer (
  customer_id NUMBER(6),
  title VARCHAR(10),
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30),
  citizen_id NUMBER(20) NOT NULL,
  dob VARCHAR(10),
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
-- CREATE OR REPLACE TRIGGER customer_on_insert
--     BEFORE INSERT ON Customer
--     FOR EACH ROW
-- BEGIN
--     SELECT customer_sequence.nextval
--     INTO :new.id
--     FROM dual;
-- END;
--ALTER TRIGGER customer_on_insert ENABLE;



--End of creating table Customer

--Start of creating table Guest
CREATE TABLE Guest (
  guest_id NUMBER(6) PRIMARY KEY,
  title VARCHAR(10),
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  citizen_id NUMBER(20),
  dob DATE,
  country VARCHAR(20),
  city VARCHAR(20),
  street VARCHAR(50),
  email VARCHAR(50),
  CONSTRAINT fk_citizen_id FOREIGN KEY (citizen_id) references Customer (citizen_id)
);
CREATE SEQUENCE guest_sequence START WITH 1 INCREMENT BY 1 MINVALUE 1 NOMAXVALUE NOCYCLE CACHE 2;
CREATE INDEX idx_guest_name ON Guest (first_name, last_name);
--End of creating table Guest

--Create stored procedure to update customer email
create or replace PROCEDURE updateCustomerEmail(
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

--End of stored procedure