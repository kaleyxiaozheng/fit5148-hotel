-- Select hotel ID based on known country and city
SELECT hotel_id, hotel_name from hotel@FIT5148A WHERE country = 'USA'and city = 'New York'; 

-- Select room based on hotel_id
SELECT room_type, price from room@FIT5148B r, hotel@FIT5148A h WHERE h.country = 'USA'and h.city = 'New York' and h.hotel_id = r.hotel_id;


SELECT hotel_name, room_number, room_type, price from room@FIT5148B r, hotel@FIT5148A h WHERE h.country =  'USA' and h.city = 'New York' and h.hotel_id = r.hotel_id;