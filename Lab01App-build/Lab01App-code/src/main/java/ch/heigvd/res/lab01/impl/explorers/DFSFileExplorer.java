package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered node
 * (file and directory). When the explorer reaches a directory, it visits all files
 * in the directory and then moves into the subdirectories.
 *
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

   @Override
   public void explore(File rootDirectory, IFileVisitor vistor) {
      if (rootDirectory == null) {
         return;
      }
      vistor.visit(rootDirectory);
      if (rootDirectory.isDirectory()) {
         File[] my_files = rootDirectory.listFiles();
         Arrays.sort(my_files);
         for (File f : my_files) {
            if (f.isFile()) {
               vistor.visit(f);
            } else {
               explore(f, vistor);
            }
         }
      }
   }
}
