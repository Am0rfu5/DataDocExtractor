package com;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.pojava.datetime.DateTime;

/**
 *
 * @author Am0rfu5
 */
public class HTMLDoc {

    private String fileText = "";
    private Row[] rowsArray;
    private String htmlBody = "";
            
    public HTMLDoc(String fileText) {    
        try {
            this.fileText = fileText;
            this.htmlBody = fileText.split("<body")[1];
            this.rowsArray = setRowsArray(this.htmlBody);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private Row[] setRowsArray(String rowText) {
        String[] strArray = rowText.split("<tr");
        Row[] rows = new Row[strArray.length];
        for (int i = 0; i < strArray.length; i++){
            rows[i] = new Row(i, strArray[i]);
        }
        return rows;
    }

    public int getRowCount(){
        return rowsArray.length;
    }
    public Column[] getColumns(int row){
      return rowsArray[row].cols;
    } 
    public String getHTMLBody() {
        return this.htmlBody;
    }
    public Row[] getRowsArray() {
        return this.rowsArray;
    }
    
    class Row {
        public int rowNumber = 0;
        public String rowText = "";
        public Column[] cols;
        public Row (int row, String text){
            this.rowNumber = row;
            this.rowText = text;
            String[] arr = text.split("<td");
            cols = new Column[arr.length];
            for (int i = 0; i < arr.length; i++){
                String colText = cleanField("<td "+arr[i]);
                cols[i] = new Column(this.rowNumber, colText, arr[i]);
            }
        }
    }
    
    class Column {
        public int rowNumber = 0;
        public String colText = "";
        public String colHTML = "";
        public Column (int row, String text, String html){
            this.rowNumber = row;
            this.colText = text;
            this.colHTML = html;
        }
    }
    
    public String cleanField(String str) {
        String cleanedField = null;
        if (str != null){
            // this adds a line break instead of a paragraph
            Whitelist whitelist = new Whitelist();
            whitelist.addTags("p");
            cleanedField = Jsoup.clean(str, whitelist);
            cleanedField = cleanedField.replace("<p></p>", "");
            cleanedField = cleanedField.replace("<p>", "");
            cleanedField = cleanedField.replace("</p>", "\n");
            cleanedField = cleanedField.trim();
            cleanedField = cleanedField.replace("\n ", "\n");
            cleanedField = cleanedField.replace("\n\n", "\n");
        }
        return cleanedField;
    }
        
}
