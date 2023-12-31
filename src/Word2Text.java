package com;

/**
 *
 * @author Am0rfu5
 */
//package lib;


import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;

public class Word2Text {

    public String ConvertWord2Text(final String filePath) {

        File file = null;
        FileInputStream fis = null;
        WordExtractor extractor = null;
        WordToHtmlConverter converter = null;
        String str = null;

        try {

            file = new File(filePath);
            String fp = file.getAbsolutePath();
            fis = new FileInputStream(file);

            HWPFDocument document = new HWPFDocument(fis);
            extractor = new WordExtractor(document);

            str = extractor.getText();
//            converter = new WordToHtmlConverter();

//            str = converter.getText();
           
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
   
}