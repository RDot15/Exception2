
//import static Main.Check.parseUserData;
//import static Main.Check.userInput;
import java.io.File;

public class Main {


    public static void main(String[] args) {
       String[] data = Check.parseUserData(Check.userInput());
        String fileName = data[0] + ".txt";
        WriteToFile.writeUserData(data, fileName);
    }
}

