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




---------------------------------------------------------
--FACILITY
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
  description varchar(50),
  CONSTRAINT facility_pk PRIMARY KEY (hotel_id, room_number, facility_number),
  constraint fk_room_number_facility foreign key (room_number, hotel_id)
      references room (room_number, hotel_id)

);
CREATE SEQUENCE facility_seq START WITH 1 INCREMENT BY   1 NOCACHE NOCYCLE;

--select * from room;

INSERT INTO facility (room_number, hotel_id, facility_number, description)
   VALUES ('4',33 , to_char(facility_seq.nextval), 'Washing machine');
INSERT INTO facility (room_number, hotel_id, facility_number, description)
   VALUES ('6',37 , to_char(facility_seq.nextval), 'big tivi');
INSERT INTO facility (room_number, hotel_id, facility_number, description)
   VALUES ('7',37 , to_char(facility_seq.nextval), '3D Game');
INSERT INTO facility (room_number, hotel_id, facility_number, description)
   VALUES ('1',37 , to_char(facility_seq.nextval), 'big tivi');
INSERT INTO facility (room_number, hotel_id, facility_number, description)
   VALUES ('8',37 , to_char(facility_seq.nextval), 'Sofa');
   
commit;