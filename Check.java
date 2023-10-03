
import java.util.*;

public class Check {
    public static final int countData = 6;
    public static final HashSet<String> numbers = new HashSet<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0"));

    public static String[] userInput() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(" Введите следующие данные разделенные пробелом: \n " +
                    "(Фамилия Имя Отчество) (датарождения (через точку)) (номертелефона) (пол (w/m)) \n");

            String str = scanner.nextLine();
            String[] data = str.split(" ");
            if (data.length == countData) {
                return data;
            } else {
                System.out.println("Количество введенных данных = " + data.length +  ", что не соответсвует трбованию.\n" +
                        "Введите данные заново \n");
            }
        }
    }

    public static String[] parseUserData(String[] data) {
        HashMap<String, String> dataBase = new HashMap<>();
        dataBase.put("surname", null);
        dataBase.put("name", null);
        dataBase.put("middle name", null);
        dataBase.put("date", null);
        dataBase.put("phone number", null);
        dataBase.put("gender", null);
        for (String partOfData : data) {
            if (partOfData.length() == 1) {
                if (partOfData.equalsIgnoreCase("m") || partOfData.equalsIgnoreCase("w")) {
                    dataBase.put("gender", partOfData);
                } else {
                    throw new GenderException(partOfData);
                }
            } else if (partOfData.contains(".")) {
                checkDate(dataBase, partOfData);

            } else if (checkStringForNumbers(partOfData) && partOfData.length() > 1) {
                if (partOfData.length() == 11) {
                    dataBase.put("phone number", partOfData);
                } else {
                    throw new PhoneNumberException(partOfData);
                }
            } else if (checkFullName(partOfData)) {
                if (dataBase.get("surname") == null) {
                    dataBase.put("surname", partOfData);
                } else if (dataBase.get("name") == null) {
                    dataBase.putIfAbsent("name", partOfData);
                } else if (dataBase.get("middle name") == null) {
                    dataBase.putIfAbsent("middle name", partOfData);
                }
            }
        }

        for (String key : dataBase.keySet()) {
            if (dataBase.get(key) == null) {
                throw new DataDontTrue(key);
            }
        }


        String result = dataBase.get("surname") + " " +
                dataBase.get("name") + " " +
                dataBase.get("patronymic") + " " +
                dataBase.get("date") + " " +
                dataBase.get("phone number") + " " +
                dataBase.get("gender");
        String[] date = result.split(" ");
        return date;
    }

    private static void checkDate(HashMap<String, String> dataBase, String partOfData) {
        String[] date = partOfData.split("\\.");
        try {
            int day = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int year = Integer.parseInt(date[2]);
            var array = (year % 4 == 0) ? Month.values() : Month.valuesWithOneMoreDay();
            if (month > 0 && month < 13) {
                if (day <= array[month].getValue() && day > 0) {
                    dataBase.put("date", partOfData);
                }else {
                    throw new DateException(partOfData);
                }
            }
        } catch (NumberFormatException | DateException e) {
            throw new DateException(partOfData);
        }
    }

    public static boolean checkStringForNumbers(String str) {
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (!numbers.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkFullName(String str) {
        List<String> alphabet = new ArrayList<>();
        for (int i = 'а'; i <= 'я'; i++) {
            alphabet.add(String.valueOf((char) i));
        }
        for (int i = 'a'; i <= 'z'; i++) {
            alphabet.add(String.valueOf((char) i));
        }
        alphabet.add("ё");
        char[] chars = str.toLowerCase().toCharArray();
        for (char aChar : chars) {
            if (!alphabet.contains(String.valueOf(aChar))) {
                return false;
            }
        }
        return true;
    }


}