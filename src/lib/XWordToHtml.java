package lib;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Am0rfu5
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;

public class XWordToHtml {
    
    @SuppressWarnings("ThrowableResultIgnored")
    public void XWordToHtmlConverter(String filePath) {

        File file = null;
        FileInputStream fis = null;
        InputStream is = null;
        XWPFWordExtractor extractor = null;
        String str = null;

        try {

//            file = new File(filePath);
//            String abpath = file.getAbsolutePath();
            is = new FileInputStream(filePath);

            XWPFDocument document = new XWPFDocument(is);
            extractor = new XWPFWordExtractor(document);
            str = extractor.getText();

            XHTMLOptions options = XHTMLOptions.create();
 
            // 3) Convert XWPFDocument to HTML
            OutputStream out = new FileOutputStream(new File(
                    "/sample_html/564565.html"));
            XHTMLConverter.getInstance().convert(document, out, options);

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
    }   
}
