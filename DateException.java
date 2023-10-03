public class DateException extends RuntimeException {
    public DateException(String partOfData) {
        super("Такой даты не существует:" + partOfData);
    }
}