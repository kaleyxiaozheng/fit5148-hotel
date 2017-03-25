
List of sql Thao
--hotel
Select hotel_id, hotel_name, hotel_type, construction_year, country, city, address, contact_number, email
from hotel;

INSERT INTO hotel (hotel_id, hotel_name, hotel_type, construction_year, country, city, address, contact_number, email)
   VALUES (null, 'thao Dust', 5, 1991, 'USA', 'New York', '13 Rose Street', '01254747747', 'diamonddust@gmail.com');


Select hotel_id, hotel_name, hotel_type, construction_year, country, city, address, contact_number, email
from hotel where hotel_id = 1;


UPDATE hotel
   SET hotel_name = 'name',
       hotel_type = 1,
       construction_year = 1999,
       country = 'country'
       city = 'city',
       address = 'address',
       contact_number = 'number',
       email = 'email'
where hotel_id = 1;

      

Delete from hotel where hotel_id = 1;


Select hotel_id, hotel_name, hotel_type, construction_year, country, city, address, contact_number, email 
from hotel 
where hotel_type = 1;


Select room_number
from room 
where hotel_id = ‘id’ and room_number = ‘id’

Select room_number, hotel_id, room_type, price, description  
from room, facility 
where room.room_number = facility.room_number and room.hotel_id = facility.hotel_id and facility.description = ‘%description%’

Select room_number, hotel_id, room_type, price, description   
from room

Update room 
set room_number = 'room_num', 
hotel_id = 'hotel_id', 
room_type = 'type', 
price = price, 
description = 'description'
where 
room_number = 'num' and hotel_id = 1

delete room 
where hotel_id = 1

delete room where room_number = 1 and hotel_id = 1

Booking
Make booking:

Select * from booking where customer_id = ‘id’
