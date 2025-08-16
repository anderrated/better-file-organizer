import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MappingReader { // each mapping reader should have its own map so readFile is not static
   String filePath = "mapping.txt";
   HashMap<String, String> map = new HashMap<String, String>();

   String line;
   public void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null ) {
            String[] parts = line.split(":", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                System.out.println("Ignoring Line: " + line);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
        reader.close();
   }

}
