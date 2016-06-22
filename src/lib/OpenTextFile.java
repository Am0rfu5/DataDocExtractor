/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Am0rfu5
 */
public class OpenTextFile {
    
    public String OpenHTML(String filePath) {
        String str = null;
        try {
           str = FileUtils.readFileToString(new File(filePath), "UTF8");
//           System.out.println(str);
         } catch (IOException e) {
            e.printStackTrace();
            }
        return str;
    }
}
    
