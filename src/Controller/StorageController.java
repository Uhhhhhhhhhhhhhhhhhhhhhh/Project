/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.SQLStorage;
import static Model.SQLStorage.*;
import Model.Storage;
import Model.Time_Period;
import java.util.ArrayList;

/**
 *
 * @author Derek
 */
public class StorageController {
    private static boolean dbConnection = false;
    private static String dbUsername;
    private static String dbPassword;
    private static String dbIP;
    
    public static void setDBInfo(String ip, String un, String pw) {
        dbIP = ip;
        dbUsername = un;
        dbPassword = pw;
    }
    
    //Methods to store data using storage, check if dbConnection to use sql or not
    public static void tryConnectionToDB() {
        dbConnection = ConnectSQLStorage(dbIP, dbUsername, dbPassword);
    }
    
    public static void addNewFaculty(String psu_id, String first_name, String last_name, String major_college, boolean[] preferred_days) {
        if(!dbConnection)
            tryConnectionToDB();
        
        if(dbConnection)
            SQLStorage.addNewFaculty(psu_id, first_name, last_name, major_college, preferred_days);
        else
            Storage.addNewFaculty(psu_id, first_name, last_name, major_college, preferred_days);
    }
    

    
}
