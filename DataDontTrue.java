public class DataDontTrue extends RuntimeException {
    public DataDontTrue(String key) {
        super("Не все данные были введены корректно " + key);
    }
}
