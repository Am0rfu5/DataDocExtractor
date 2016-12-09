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
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

/**
 *
 * @author Am0rfu5
 */
public class MySQLInsert {
    
    //TODO: MOVE TO CONFIG FILE
    private String username = "ksheetuser";
    private String pword = "qwe123";
    
    public int SqlInsert(String sqlInsert, String identifier) throws Exception {
        // create a mysql database connection
        Statement statement = null;
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/mg_ksheets?autoReconnect=true&useSSL=false";
        Class.forName(myDriver);
        int sqlExecInsert = 0;
        try {
            
            Connection conn = DriverManager.getConnection(myUrl, this.username, this.pword);
            statement = conn.createStatement();
            
            try {
                sqlExecInsert = statement.executeUpdate(sqlInsert);
            } catch (Exception e) {
                throw new Exception("Error for field file: " + identifier + " with sql insert: " + sqlInsert, e);
            } finally {
                statement.close();
            }
            conn.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sqlExecInsert;
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
    
    public List<String> getNames() throws Exception {
        List<String> listNames = new ArrayList<>();
 
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/mg_ksheets?autoReconnect=true&useSSL=false";
        Class.forName(myDriver);
        String sqlSelect = "select invname from name_list";
        
        try (
            Connection conn = DriverManager.getConnection(myUrl, this.username, this.pword);
            PreparedStatement statement = conn.prepareStatement(sqlSelect);
            ResultSet rs = statement.executeQuery();
        ) {    
            while(rs.next()) {
                listNames.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNames;
    }
    
    public void updateNames(String replaceName, String tableName, String fieldName) throws Exception {
        Statement statement = null;
        String myDriver = "com.mysql.jdbc.Driver";
        String myUrl = "jdbc:mysql://localhost:3306/mg_ksheets?autoReconnect=true&useSSL=false";
        String sqlUpdate = "";
                
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, this.username, this.pword);
        
        // Select names from table 
        sqlUpdate = "update " + tableName + " set "+ fieldName + " = replace("+ 
                fieldName +", '" + replaceName + " ' , \"\")";
        
        try {
            
            statement = conn.createStatement();
            
            try {
                int sqlExecUpdate = statement.executeUpdate(sqlUpdate);
//                System.out.println("Insert returned: " + (Integer.toString(sqlExecInsert)));
            } finally {
                statement.close();
            }
            
        } finally {
            conn.close();
        }        
    }
    
}
