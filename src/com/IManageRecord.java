package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.pojava.datetime.DateTime;

/**
 *
 * @author Am0rfu5
 */
public class IManageRecord {

    public int importid;
    public String Open_Date = "";
    public String Case_Number = "";
    public String Case_Name = "";
    public String Relationship_Manager = "";
    public String Case_Manager = "";
    public String Senior_Investigator = "";
    public String Investigator = "";
    public String Originator = "";
    public String Attorney_Name_Address = "";
    public String Attorney_Fax = "";
    public String Attorney_Phone = "";
    public String Attorney_Email = "";
    public String Client_Name_Address = "";
    public String Client_Phone = "";
    public String Client_Fax = "";
    public String Client_Email = "";
    public String Money_Check_Point = "";
    public String Referrer = "";
    public String File_Name = "";
    public String idiManage_UNIQUE = "";

    public IManageRecord () {
    }
    
    public IManageRecord (String fileName) {
        this.File_Name = fileName;
    }

    public void LoadRecordDataFromHTMLDoc(HTMLDoc hDoc){
        HTMLDoc.Row[] rowsArray = hDoc.getRowsArray();
        try {
            this.Open_Date = fixDate(rowsArray[1].cols[24].colText);
            this.Case_Number = rowsArray[2].cols[2].colText;
            this.Case_Name = rowsArray[2].cols[4].colText;
            this.Relationship_Manager = rowsArray[31].cols[4].colText;
            this.Case_Manager = rowsArray[31].cols[6].colText;
            this.Senior_Investigator = rowsArray[32].cols[2].colText;
            this.Investigator = rowsArray[32].cols[4].colText;
            this.Originator = rowsArray[31].cols[2].colText;
            this.Attorney_Name_Address = rowsArray[8].cols[1].colText;
            this.Attorney_Phone = rowsArray[14].cols[2].colText;
            this.Attorney_Fax = rowsArray[15].cols[2].colText;
            this.Attorney_Email = rowsArray[16].cols[2].colText;
            this.Client_Name_Address = rowsArray[7].cols[3].colText;
            this.Client_Phone = rowsArray[14].cols[5].colText;
            this.Client_Fax = rowsArray[15].cols[5].colText;
            this.Client_Email = rowsArray[16].cols[5].colText;
            this.Money_Check_Point = rowsArray[27].cols[2].colText;
            this.Referrer = rowsArray[26].cols[2].colText;
            this.idiManage_UNIQUE = "";
        } catch (Exception e) {
        }
    }
    
    public void Print(){
        System.out.println("Open_Date: "+this.Open_Date);
        System.out.println("Case_Number: "+this.Case_Number);
        System.out.println("Case_Name: "+this.Case_Name);
        System.out.println("Relationship_Manager: "+this.Relationship_Manager);
        System.out.println("Case_Manager: "+this.Case_Manager);
        System.out.println("Senior_Investigator: "+this.Senior_Investigator);
        System.out.println("Investigator: "+this.Investigator);
        System.out.println("Originator: "+this.Originator);
        System.out.println("Attorney_Name_Address: "+this.Attorney_Name_Address);
        System.out.println("Attorney_Phone: "+this.Attorney_Phone);
        System.out.println("Attorney_Fax: "+this.Attorney_Fax);
        System.out.println("Attorney_Email: "+this.Attorney_Email);
        System.out.println("Client_Name_Address: "+this.Client_Name_Address);
        System.out.println("Client_Phone: "+this.Client_Phone);
        System.out.println("Client_Fax: "+this.Client_Fax);
        System.out.println("Client_Email: "+this.Client_Email);
        System.out.println("Money_Check_Point: "+this.Money_Check_Point);
        System.out.println("Referrer: "+this.Referrer);
        System.out.println("File_Name: "+this.File_Name);
        System.out.println("idiManage_UNIQUE: "+this.idiManage_UNIQUE);
    }
    
    public String[][] CreateFieldsArray() {
        
        String[][] fieldsArray = new String[16][4];

        //Open_Date
        fieldsArray[0][0] = "Open_Date";
        fieldsArray[0][1] = "";
        fieldsArray[0][2] = "";
        fieldsArray[0][3] = this.Open_Date;

        //Case_Number
        fieldsArray[1][0] = "Case_Number";
        fieldsArray[1][1] = "";
        fieldsArray[1][2] = "";
        fieldsArray[1][3] = this.Case_Number;

        //Case_Name                  
        fieldsArray[2][0] = "Case_Name";
        fieldsArray[2][1] = "";
        fieldsArray[2][2] = "";
        fieldsArray[2][3] = this.Case_Name;

        //Relationship_Manager            
        fieldsArray[3][0] = "Relationship_Manager";
        fieldsArray[3][1] = "";
        fieldsArray[3][2] = "";
        fieldsArray[3][3] = this.Relationship_Manager;

        //Case_Manager            
        fieldsArray[4][0] = "Case_Manager";
        fieldsArray[4][1] = "";
        fieldsArray[4][2] = "";
        fieldsArray[4][3] = this.Case_Manager;

        //Client_Name_Address
        fieldsArray[5][0] = "Client_Name_Address";
        fieldsArray[5][1] = "";
        fieldsArray[5][2] = "";
        fieldsArray[5][3] = this.Client_Name_Address;

        //Attorney_Name_Address
        fieldsArray[6][0] = "Attorney_Name_Address";
        fieldsArray[6][1] = "";
        fieldsArray[6][2] = "";
        fieldsArray[6][3] = this.Attorney_Name_Address;

        //Attorney_Phone
        fieldsArray[7][0] = "Attorney_Phone";
        fieldsArray[7][1] = "";
        fieldsArray[7][2] = "";
        fieldsArray[7][3] = this.Attorney_Phone;

        //Client_Phone
        fieldsArray[8][0] = "Client_Phone";
        fieldsArray[8][1] = "";
        fieldsArray[8][2] = "";
        fieldsArray[8][3] = this.Client_Phone;

        //Attorney_Email               
        fieldsArray[9][0] = "Attorney_Email";
        fieldsArray[9][1] = "";
        fieldsArray[9][2] = "";
        fieldsArray[9][3] = this.Attorney_Email;

        //Client_Email                         
        fieldsArray[10][0] = "Client_Email";
        fieldsArray[10][1] = "";
        fieldsArray[10][2] = "";
        fieldsArray[10][3] = this.Client_Email;

        //Referrer                
        fieldsArray[11][0] = "Referrer";
        fieldsArray[11][1] = "";
        fieldsArray[11][2] = "";
        fieldsArray[11][3] = this.Referrer;                

        //Money_Check_Point
        fieldsArray[12][0] = "Money_Check_Point";
        fieldsArray[12][1] = "";
        fieldsArray[12][2] = "";
        fieldsArray[12][3] = this.Money_Check_Point;

        //Originator
        fieldsArray[13][0] = "Originator";
        fieldsArray[13][1] = "";
        fieldsArray[13][2] = "";
        fieldsArray[13][3] = this.Originator;

        //Senior_Investigator
        fieldsArray[14][0] = "Senior_Investigator";
        fieldsArray[14][1] = "";
        fieldsArray[14][2] = "";
        fieldsArray[14][3] = this.Senior_Investigator;

        //Investigator
        fieldsArray[15][0] = "Investigator";
        fieldsArray[15][1] = "";
        fieldsArray[15][2] = "";
        fieldsArray[15][3] = this.Investigator;
                
        return fieldsArray;
    }
    public String fixDate(String date){
        String dt = date;
        try {
            dt = new DateTime(date).toString("yyyy-MM-dd");
        } catch (IllegalArgumentException e) { 
            System.out.println("fixDate error: could not format date " + date);
        }
        return dt;
    }
}
