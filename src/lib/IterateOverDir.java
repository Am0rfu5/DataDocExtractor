/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.io.File;

/**
 *
 * @author Am0rfu5
 */
public class IterateOverDir {
  
  public static void returnFile(String dirPath) {
    File dir = new File(dirPath);
    File[] directoryListing = dir.listFiles();
    if (directoryListing != null) {
      for (File child : directoryListing) {
        // Do something with child
      }
    } else {
      // Handle the case where dir is not really a directory.
      // Checking dir.isDirectory() above would not be sufficient
      // to avoid race conditions with another process that deletes
      // directories.
    }
  }
    
}
