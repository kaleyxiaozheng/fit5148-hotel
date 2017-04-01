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
public class FacilityBean {
    
    private String facilityNumeber;
    private String roomNumber;
    private Long hotelId;
    private String description;

    public FacilityBean() {
    }

    public FacilityBean(String facilityNumeber, String roomNumber, Long hotelId, String description) {
        this.facilityNumeber = facilityNumeber;
        this.roomNumber = roomNumber;
        this.hotelId = hotelId;
        this.description = description;
    }

    public String getFacilityNumeber() {
        return facilityNumeber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public String getDescription() {
        return description;
    }

    public void setFacilityNumeber(String facilityNumeber) {
        this.facilityNumeber = facilityNumeber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
