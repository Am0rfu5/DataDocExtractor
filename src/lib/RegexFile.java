/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import net.htmlparser.jericho.*;
//import javax.swing.text.Segment;
import java.util.*;
import java.io.*;
import java.net.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.jsoup.safety.*;
import org.pojava.datetime.*;

/**
 *
 * @author Am0rfu5
 */
public class RegexFile {
    public String getMatch(String strHtml,String regex) {
        String strMatch = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(strHtml);
        if (matcher.find()) {
            strMatch = matcher.group(1);
        }
        
        return strMatch;
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
            
            String regex = "\n ";

            String strMatch = null;
//            Pattern pattern = Pattern.compile(regex);
//            Matcher matcher = pattern.matcher(cleanedField);
//            while (matcher.find(0)) {
            cleanedField = cleanedField.replace("\n ", "\n");
            cleanedField = cleanedField.replace("\n\n", "\n");
//            }

//            org.jsoup.nodes.Document doc = Jsoup.parse(cleanedField);
//            cleanedField = doc.body().text();

        }
        return cleanedField;
    }
    
    public String fixDate(String probDate, String fileName){
        String fixedDate = probDate;

        try {
            DateTime dt = new DateTime(probDate);
            fixedDate = dt.toString("yyyy-MM-dd");
        } catch (IllegalArgumentException e) { 
//            throw new IllegalArgumentException("fixDate error: improper date for file " + fileName + ".html", e);
            System.out.println("fixDate error: improper date for file: " + fileName + ".html");
        }

        return fixedDate;
    }
    
}
