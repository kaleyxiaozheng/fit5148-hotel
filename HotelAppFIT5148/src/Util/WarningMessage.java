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

    public final static String MULTIPLE_SELECTION = "Please select one record only.";
    public final static String NO_SELECTION = "Please select at least one record.";
    public final static String CONFIRM_DELETE = "The record information will be deleted. Please click Yes to proceed.";
    public final static String DELETE_S = "record is deleted successfull.";
    public final static String DELETE_F = "Fail to delete record, please re-try later.";
//    public final static String HOTEL_DELETE_TRIGGER_F = "This hotel has references from other rooms, Please delete its rooms in advance.";
    public final static String UPDATE_ACT = "UpdateAct";
    public final static String INSERT_ACT = "InsertAct";
    public final static String FOREIGN_KEY_DELETE = "This record has references from other tables, Please delete its children in advance.";
    public final static String UNKNOWN_ERROR = "Sorry! System has internal error, please wait us to upgrate";
    public final static String UNIQUE_CONSTRAINT_ROOM = "This room number and hotel id exist in database, please input unique ones.";
    public final static String INPUT_FORMAT_ER = "Please input correct format.";
    public final static String NOT_EXIST_HOTEL_ID_ER = "Hotel_id does not exist in hotel table";
}
