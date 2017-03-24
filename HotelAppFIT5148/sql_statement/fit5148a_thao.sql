<<<<<<< HEAD
CREATE TABLE  bookingRoomGuest (
  booking_id number(6),
  room_number varchar(10),
  guest_id number(6)
);
=======

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

>>>>>>> b39a1f84601e70a12b37fc581f4cb7a1c8377c30
