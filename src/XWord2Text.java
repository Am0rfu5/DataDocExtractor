package com;

//package lib;

/**
 *
 * @author Am0rfu5
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.regex.Pattern;

import org.apache.xmlbeans.XmlException;
import org.apache.poi.POIXMLDocumentPart;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XWord2Text {
    
    public void XWord(String filePath) {
        String convertWord = this.XWord2TextConverter(filePath);
        String matchFound = this.regexString(convertWord);
    }
    
    public String XWord2TextConverter(String filePath) {

        File file = null;
        FileInputStream fis = null;
        InputStream is = null;
        XWPFWordExtractor extractor = null;
        String str = null;

        try {

            is = new FileInputStream(filePath);
            XWPFDocument document = new XWPFDocument(is);
            extractor = new XWPFWordExtractor(document);
            str = extractor.toString();

        } catch (final Exception ex) {

            ex.printStackTrace();

        } finally {

            try {
                if (fis != null) {
                    fis.close();
                }

                if (extractor != null) {
                    extractor.close();
                }

            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        return str;

    }   
   
    public String regexString(String str) {
        String fieldMatch = null;
        
        String pattern = "NEW CASE SHEET\\sOPEN DATE:\\s(.*)\\s";
        Pattern regexPat = Pattern.compile(pattern);
        
        Matcher m = regexPat.matcher(str);
        if (m.find( )) {
           fieldMatch = m.group(0);
        }
    
        return fieldMatch;

    }
    
    public static void insertSQL() {
        
    }
    
}
