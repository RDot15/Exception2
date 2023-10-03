import java.util.Scanner;

public class GenderException extends RuntimeException {
    public GenderException(String partOfData) {
        super("Такого гендера не существует:" + partOfData);
    }

}