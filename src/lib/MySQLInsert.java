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

/**
 *
 * @author Am0rfu5
 */
public class MySQLInsert {
    
    public void SqlInsert(String sqlInsert) throws Exception {
        // create a mysql database connection
        Statement statement = null;
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/mg_ksheets?autoReconnect=true&useSSL=false";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "3#daBird");
        
        try {
            
            statement = conn.createStatement();
            
            try {
                statement.executeUpdate(sqlInsert);                        
            } finally {
                statement.close();
            }
            
        } finally {
            conn.close();
        }
    }
    
    public String SqlInsertPrepare(String[][] fieldsArray, String tableName) {
        String sqlInsert = "insert into " + tableName;
        // Loop through fields
        String sqlInsertFields = "";
        for (int i=0; i < fieldsArray.length; i++) {
            if (!"".equals(sqlInsertFields)) {
                sqlInsertFields = sqlInsertFields + ',';
            }
            sqlInsertFields = sqlInsertFields + "'" + fieldsArray[i][0] +"'";
        }
        sqlInsertFields = sqlInsertFields.replaceAll("\\\'", "");
        
        String sqlInsertValues = "";
        for (int x=0; x < fieldsArray.length; x++) {
            if (!"".equals(sqlInsertValues)) {
                sqlInsertValues = sqlInsertValues + ',';
            }

            sqlInsertValues = sqlInsertValues + "'" + fieldsArray[x][3] +"'";
        }
        
        sqlInsert = sqlInsert + "(" + sqlInsertFields +") Values ("+ sqlInsertValues + ");";
        
        return sqlInsert;
    }
}
