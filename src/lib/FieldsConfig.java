/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

/**
 *
 * @author Am0rfu5
 */
public class FieldsConfig {
    public String[][] FieldsArray() {
        
        String[][] fieldsArray = new String[16][4];
                  /*array example*/
        //        fieldsArray[][0] = "field_name"s;
        //        fieldsArray[][1] = "first word match";
        //        fieldsArray[][2] = "second word to match";
        //        fieldsArray[][3] = "result";

                fieldsArray[0][0] = "Open_Date";
                fieldsArray[0][1] = "OPEN\\s*DATE:";
                fieldsArray[0][2] = "CASE\\s*#:";
                fieldsArray[0][3] = "";
        //
                fieldsArray[1][0] = "Case_Number";
                fieldsArray[1][1] = "CASE\\s*#:";
                fieldsArray[1][2] = "CASE\\s*NAME:";
                fieldsArray[1][3] = "";
        //        
                fieldsArray[2][0] = "Case_Name";
                fieldsArray[2][1] = "CASE\\s*NAME:";
                fieldsArray[2][2] = "DIFFERENT\\s*CASE NAME IN CLIENT COMMUNICATIONS";
                fieldsArray[2][3] = "";

                fieldsArray[3][0] = "Relationship_Manager";
                fieldsArray[3][1] = "Relationship\\s*Manager:";
                fieldsArray[3][2] = "Case\\s*Manager:";
                fieldsArray[3][3] = "";

                fieldsArray[4][0] = "Case_Manager";
                fieldsArray[4][1] = "Case\\s*Manager:";
                fieldsArray[4][2] = "Senior\\s*Investigator:";
                fieldsArray[4][3] = "";
        //
                fieldsArray[5][0] = "Client_Name_Address";
                fieldsArray[5][1] = "CONSULTANT\\s*NAME/ADDRESS";
                fieldsArray[5][2] = "<td rowspan=\\\"7\\\"";
                fieldsArray[5][3] = "";
        //
                fieldsArray[6][0] = "Attorney_Name_Address";
                fieldsArray[6][1] = "<td rowspan=\\\"7\\\" colspan=\\\"9\\\"[()</\\w\\s\\\"#&;=\\-:\\.,]*>";
                fieldsArray[6][2] = "PHONE:";
                fieldsArray[6][3] = "";
        //

                fieldsArray[7][0] = "Attorney_Phone";
                fieldsArray[7][1] = "PHONE:";
                fieldsArray[7][2] = "PHONE:[\\p{L}()</\\w\\s\"#&;=\\-:\\.,>]*PHONE:";
                fieldsArray[7][3] = "";

                fieldsArray[8][0] = "Client_Phone";
                fieldsArray[8][1] = "PHONE:[\\p{L}()</\\w\\s\"#&;=\\-:\\.,>]*PHONE:";
                fieldsArray[8][2] = "PHONE:";
                fieldsArray[8][3] = "";
                
                fieldsArray[9][0] = "Attorney_Email";
                fieldsArray[9][1] = "EMAIL:";
                fieldsArray[9][2] = "EMAIL:</b></font></font></p>\\s*</td>\\s*<td colspan=\"13\"[/\\w\\s\\\"#&;=\\-:\\.,]*>";
                fieldsArray[9][3] = "";
                
                fieldsArray[10][0] = "Client_Email";
                fieldsArray[10][1] = "<td colspan=\"3\"[/\\w\\s\\\"#&;=\\-:\\.,]*>\\s*<p><font[/\\w\\s\\\"#&;=\\-:\\.,]*><font[/\\w\\s\\\"#&;=\\-:\\.,]*><b>EMAIL:</b></font></font></p>\\s*</td>\\s*<td[/\\w\\s\\\"#&;=\\-:\\.,]*>";
                fieldsArray[10][2] = "</td>\\s*<td[/\\w\\s\\\"#&;=\\-:\\.,]*>[\\p{L}()</\\w\\s\\\"#&;=\\-:\\.,>]*<td[/\\w\\s\\\"#&;=\\-:\\.,]*>[\\p{L}()</\\w\\s\\\"#&;=\\-:\\.,>]*EMAIL:";
                fieldsArray[10][3] = "";
                
                fieldsArray[11][0] = "Referrer";
                fieldsArray[11][1] = "Who\\s*referred this client to us\\?";
                fieldsArray[11][2] = "Money\\s*Check-point \\(Phase1\\):";
                fieldsArray[11][3] = "";                

                fieldsArray[12][0] = "Init_Budget";
                fieldsArray[12][1] = "Money\\s*Check-point\\s\\(Phase1\\):";
                fieldsArray[12][2] = "Conflict\\s*Checks Done\\?";
                fieldsArray[12][3] = "";

                fieldsArray[13][0] = "Originator";
                fieldsArray[13][1] = "Originator:";
                fieldsArray[13][2] = "Relationship\\s*Manager:";
                fieldsArray[13][3] = "";

                fieldsArray[14][0] = "Senior_Investigator";
                fieldsArray[14][1] = "Senior\\s*Investigator:";
                fieldsArray[14][2] = "Investigator:";
                fieldsArray[14][3] = "";
                
                fieldsArray[15][0] = "Investigator";
                fieldsArray[15][1] = "Senior\\s*Investigator:[\\p{L}()</\\w\\s\"#&;=\\-:\\.,>]*Investigator:";
                fieldsArray[15][2] = "Subs:";
                fieldsArray[15][3] = "";
                
        return fieldsArray;
    }
    
}
