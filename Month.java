public class Month {
    public static final Month JANUARY = new Month(1,31);
    public static final Month FEBRUARY = new Month(2,28);
    public static final Month FEBRUARYWITHONEMOREDAY = new Month(2,29);
    public static final Month MARCH = new Month(3,31);
    public static final Month APRIL = new Month(4,30);
    public static final Month MAY = new Month(5,31);
    public static final Month JUNE = new Month(6,30);
    public static final Month JULY = new Month(7,31);
    public static final Month AUGUST = new Month(8,31);
    public static final Month SEPTEMBER = new Month(9,30);
    public static final Month OCTOBER = new Month(10,31);
    public static final Month NOVEMBER = new Month(11,30);
    public static final Month DECEMBER = new Month(12,31);
    public static final Month[] array = {
            JANUARY,FEBRUARY,MARCH,
            APRIL,MAY,JUNE,
            JULY, AUGUST,SEPTEMBER,
            OCTOBER,NOVEMBER,DECEMBER};
    public static final Month[] arrayWithOneMoreDay = {
            JANUARY,FEBRUARYWITHONEMOREDAY,MARCH,
            APRIL,MAY,JUNE,
            JULY, AUGUST,SEPTEMBER,
            OCTOBER,NOVEMBER,DECEMBER};
    private final int place;
    private final int value;


    public Month(int place,int value) {
        this.place = place;
        this.value = value;
    }

    public int getPlace() {
        return place;
    }

    public int getValue() {
        return value;
    }

    public static Month[] values(){
        return array;
    }
    public static Month[] valuesWithOneMoreDay(){
        return array;
    }
}