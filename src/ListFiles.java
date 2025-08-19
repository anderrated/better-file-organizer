import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.*;

public class ListFiles {
    public static void listFilesinDirectory(File directory){
        File[] files = directory.listFiles(); // list files in the selected directory
        MappingReader map = new MappingReader();
        try {
            map.readFile();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        if(files != null) {
            for (File file : files) {
                if (!file.isFile()) continue;
                // System.out.println(file.getName());
                String filename = file.getName();
                // find last occurrence of '.' in the filename
                int dotIndex = filename.lastIndexOf('.');
                String extension = (dotIndex > 0) ? filename.substring(dotIndex + 1).toLowerCase() : "";
                String selectedMapping = map.map.get(extension); // returns the folder name assoc with the extension

                File targetFolder;
                if (selectedMapping == null || selectedMapping.isEmpty()) {
                    selectedMapping = "Other"; // default folder if mapping is missing
                }

                File mappingFile = new File(selectedMapping);

                if (mappingFile.isAbsolute()) {
                    // it's an absolute path, use selectedMapping directly
                    targetFolder = mappingFile;
                } else {
                    // it's a relative folder, create inside the selected directory
                    targetFolder = new File(directory, selectedMapping);
                    if (!targetFolder.exists()) {
                        targetFolder.mkdir(); // create new folder if it doesnt exist
                    }
                }

                Path source = file.toPath();
                Path target = new File(targetFolder, filename).toPath();

                try {
                    if (Files.exists(target)) {
                         System.out.println("Skipping...(already exists): " + target.getFileName());
                    } else {
                    Files.move(source, target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    continue;
                } 
            }
        }
    }
}
