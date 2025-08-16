import java.io.File;

public class ListFiles {
    public static void listFilesinDirectory(File directory){
        File[] files = directory.listFiles(); // list files in the selected directory

        if(files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}
