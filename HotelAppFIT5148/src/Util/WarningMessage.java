/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author thaonguyen
 */
public class WarningMessage {

    public final static String SELECT_ONE_RECORD = "Please select one record.";
    public final static String MULTIPLE_SELECTION = "Please select one record only.";
    public final static String NO_SELECTION = "Please select at least one record.";
    public final static String CONFIRM_DELETE = "The record information will be deleted. Please click Yes to proceed.";
    public final static String DELETE_S = "Record is deleted successfull.";
    public final static String DELETE_F = "Fail to delete record, please re-try later.";
//    public final static String HOTEL_DELETE_TRIGGER_F = "This hotel has references from other rooms, Please delete its rooms in advance.";
    public final static String UPDATE_ACT = "UpdateAct";
    public final static String INSERT_ACT = "InsertAct";
    public final static String FOREIGN_KEY_DELETE = "This record has references from other tables, Please delete its children in advance.";
    public final static String UNKNOWN_ERROR = "Sorry! System has internal error, please wait us to upgrate";
    public final static String UNIQUE_CONSTRAINT_ROOM = "This room number and hotel id exist in database, please input unique ones.";
    public final static String INPUT_FORMAT_ER = "Please input correct format.";
    public final static String NOT_EXIST_HOTEL_ID_ER = "Hotel_id does not exist in hotel table";
    
    public final static String CUSTOMER_INSERT_UPDATE_S = "Customer added/updated successfully. Please go back to Customer page and refresh.";
    public final static String CUSTOMER_INSERT_UPDATE_F = "Failed to add/update customer. Other guest is using this citizen id."
            + "Please double check the information";
    //public final static String MULTIPLE_SELECTION = "Please select one customer only.";
    //public final static String NO_SELECTION = "Please select at least one customer.";
    public final static String CONFIRM_DELETE_CUSTOMER = "The customer information will be deleted. Please click Yes to proceed.";
    public final static String UPDATE_CUSTOMER_S = "Customer is deleted. Please refresh.";
    public final static String UPDATE_CUSTOMER_F = "Fail to delete customer, please re-try later.";
    
    public final static String GUEST_INSERT_UPDATE_S = "Guest added/updated successfully. Please go back to Customer page and refresh.";
    public final static String GUEST_INSERT_UPDATE_F = "Failed to add/update guest. Other customer is using this citizen id."
            + "Please double check the information";
    
    //public final static String MULTIPLE_SELECTION = "Please select one guest only.";
    //public final static String NO_SELECTION = "Please select at least one guest.";
    
    public final static String CONFIRM_DELETE_GUEST = "The guest information will be deleted. Please click Yes to proceed.";
    public final static String DELETE_GUEST = "DELETE GUEST WHERE GUEST_ID = ";
    public final static String UPDATE_GUEST_S = "Membership is deleted. Please refresh.";
    public final static String UPDATE_GUEST_F = "Fail to delete guest, there is booking for this guest in the system.";
    
    public final static String MANDATORY_FIELD_EMPTY = "Please enter required fields.";
    public final static String EMPTY_MEMBERSHIP_TIER = "Please input tier for this membership.";
    public final static String MEMBERSHIP_INSERT_UPDATE_S = "Membership added/updated successfully. Please go back to Membership page and refresh.";
    public final static String MEMBERSHIP_INSERT_UPDATE_F = "Failed to add/update membership. Please double check the information";
    
    public final static String DISCARD_CHANGE = "Your change will be discarded. Please click Yes if you want to stay.";
    
    public final static String CREATE_S = "Create successfully.";
    public final static String UPDATE_S = "Update successfully.";
    
    public final static String CONFIRM_DELETE_MEMBERSHIP = "The membership information will be deleted. Please click Yes to proceed.";
    public final static String UPDATE_MEMBERSHIP_S = "Membership is deleted. Please refresh.";
    public final static String UPDATE_MEMBERSHIP_F = "Fail to delete membership, there is customer attached to this membership. "
            + "Please delete correpondent customer first";
    
    public final static String DIGIT_CREDIT_ONLY = "Please input digit for available credit only.";
    
    
    //public final static String MULTIPLE_SELECTION = "Please select one membership only.";
    //public final static String NO_SELECTION = "Please select at least one membership.";
    
    //public final static String DISCARD_CHANGE = "Your change will be discarded. Please click Yes if you want to stay.";
    public final static String EMPTY_CITIZEN_ID = "Please input Citizen ID.";
    public final static String INVALID_CITIZEN_ID = "Please input digit for Citizen ID.";
    public final static String EXISTED_CITIZEN = "Citizen Id is existed for other customer, please double check";
    
    public final static String EMPTY_HOTEL_NAME = "Please enter hotel name.";
    
    public final static String INCORRECT_DATA_TYPE = "Please enter correct data type.";
    public final static String INCORRECT_EMAIL = "Please enter correct email.";
}
