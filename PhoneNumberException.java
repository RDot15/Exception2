
public class PhoneNumberException extends RuntimeException {
    public PhoneNumberException(String partOfData) {
        super("Номер телефона должен содержать 11 символов вы ввели : " + partOfData);
    }
}
