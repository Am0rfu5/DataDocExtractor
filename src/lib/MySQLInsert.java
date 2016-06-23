/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

//import com.mysql.fabric.*;
//import com.mysql.jdbc.*;
//import org.gjt.mm.mysql.Driver;
import java.sql.*;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author Am0rfu5
 */
public class MySQLInsert {
    
    public void SqlInsert(String sqlInsert, String identifier) throws Exception {
        // create a mysql database connection
        Statement statement = null;
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/mg_ksheets?autoReconnect=true&useSSL=false";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "3#daBird");
        
        try {
            
            statement = conn.createStatement();
            
            try {
                int sqlExecInsert = statement.executeUpdate(sqlInsert);
//                System.out.println("Insert returned: " + (Integer.toString(sqlExecInsert)));
            } catch (Exception e) {
                throw new Exception("Error for field file: " + identifier + " with sql insert: " + sqlInsert, e);
            } finally {
                statement.close();
            }
            
        } finally {
            conn.close();
        }
    }
    
    public String SqlInsertPrepare(String[][] fieldsArray, String tableName, String fileName) {
        String sqlInsert = "insert into " + tableName;
        // Loop through fields
        String sqlInsertFields = "";
        for (int i=0; i < fieldsArray.length; i++) {
            if (!"".equals(sqlInsertFields)) {
                sqlInsertFields = sqlInsertFields + ',';
            }
            sqlInsertFields = sqlInsertFields  + fieldsArray[i][0];
        }

        String curFieldValue = "";
        String sqlInsertValues = "";
        for (int x=0; x < fieldsArray.length; x++) {
            if (!"".equals(sqlInsertValues)) {
                sqlInsertValues = sqlInsertValues + ',';
            }
            
            curFieldValue = fieldsArray[x][3];            
            if (curFieldValue != null) {
                curFieldValue = curFieldValue.replaceAll("'", "");
            }

            sqlInsertValues = sqlInsertValues + "'" + curFieldValue + "'";
        }
        sqlInsert = sqlInsert + "(File_Name," + sqlInsertFields +") Values ('"+ fileName +" '," + sqlInsertValues + ");";
        
        return sqlInsert;
    }
}
