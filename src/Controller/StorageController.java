/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Derek
 */
public class StorageController {
    private static boolean dbConnection = false;
    private static String dbUsername;
    private static String dbPassword;
    private static String dbIP;
    private static String dbDB;
    
    public static void setDBInfo(String ip, String db, String un, String pw) {
        dbIP = ip;
        dbUsername = un;
        dbPassword = pw;
        dbDB = db;
    }
    
    //Methods to store data using storage, check if dbConnection to use sql or not
    public static void tryConnectionToDB() {
        if(dbIP == null || dbUsername == null || dbPassword == null)
            dbConnection = false;
        else
            dbConnection = SQLStorage.ConnectSQLStorage(dbIP, dbDB, dbUsername, dbPassword);
    }
    
    public static void disconnectFromDB() {
        if(dbConnection)
            SQLStorage.DisconnectSQLStorage();
        else
            JOptionPane.showMessageDialog(null, "Not connected to a SQL Server!", "DB Storage Disconnect", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void addNewFaculty(String psu_id, String first_name, String last_name, String major_college, boolean[] preferred_days) {
        if(!dbConnection)
            tryConnectionToDB();
        
        if(dbConnection)
            SQLStorage.addNewFaculty(psu_id, first_name, last_name, major_college, preferred_days);
        else
            Storage.addNewFaculty(psu_id, first_name, last_name, major_college, preferred_days);
    }
    
    public static void addNewRoom(String psu_id, String first_name, String last_name, String major_college, boolean[] preferred_days) {
        if(!dbConnection)
            tryConnectionToDB();
        
        if(dbConnection)
            SQLStorage.addNewFaculty(psu_id, first_name, last_name, major_college, preferred_days);
        else
            Storage.addNewFaculty(psu_id, first_name, last_name, major_college, preferred_days);
    }
    
}
