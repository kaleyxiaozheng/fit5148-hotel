/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Room;

/**
 *
 * @author thaonguyen
 */
public class RoomBean {
    
    private String roomNumber;
    private Long hotelId;
    private String roomType;
    private float price;
    private String description;

    public RoomBean() {
    }

    public RoomBean(String roomNumber, Long hotelId, String roomType, float price, String description) {
        this.roomNumber = roomNumber;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.price = price;
        this.description = description;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public String getRoomType() {
        return roomType;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
