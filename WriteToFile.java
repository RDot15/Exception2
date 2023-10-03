import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class WriteToFile {
    public static  void writeUserData(String[] data,String path){
        try (FileWriter fw = new FileWriter(path,true)){
            fw.append(Arrays.toString(data));
            fw.append("\n");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
