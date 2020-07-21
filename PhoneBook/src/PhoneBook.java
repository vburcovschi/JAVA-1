import java.util.Scanner;

public class PhoneBook {

    public static void main(String[] args) {
        String[][] book = new String [1][1];
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        int i = 0;
        String name = "";
        String number = "";
        boolean isCorrectName;
        boolean isCorrectNumber;
        while (!(operation=="s")) {
            System.out.println("Select operation");
            System.out.println("1. Добавить адресат");
            System.out.println("2. Просмотреть адресную книгу");
            System.out.println("3. Выход");
            operation = scanner.nextLine() ;
            switch (operation) {
                case "1":
                    System.out.print("Введите Имя, Фамилия, Отчество (через пробел): ");
                    name = scanner.nextLine(); //Считывает строку из System.in
                    isCorrectName = false;
                    while (!isCorrectName) {
                        isCorrectName = checkName(name);
                        if (!isCorrectName) {
                            System.out.println("Введите корректное имя!");
                        } //else book[0][i] = name;
                    }
                    System.out.print("Введите номер телефона по формату X XXX XXX XX XX: ");
                    number = scanner.nextLine(); //Считывает строку из System.in
                    isCorrectNumber = false;
                    while (!isCorrectNumber) {
                        isCorrectNumber = checkPhoneNumber(number);
                        if (!isCorrectNumber) {
                            System.out.println("Введите корректный номер! Номер должен содерзать 11 цифр по формату X XXX XXX XX XX");
                        } else {
                            System.out.println("Номер был приведен к требуему формату и записан в базу как: " + formatPhoneNumber(number));
                            //book[1][i] = formatPhoneNumber(number);
                        }
                    }
                    add(book, name, number);
                case "s" :
                        break;
                default:
                    System.out.println("Not correct input");
                    System.out.println("Select operation");
                    System.out.println("1. Добавить адресат");
                    System.out.println("2. Просмотреть адресную книгу");
                    System.out.println("3. Выход");
                    operation = scanner.nextLine() ;
                    break;
            }
            }
        }

    public static boolean checkName(String name) {
        String[] tmp = new String[name.length()];
        tmp = name.split(" ");
        return (tmp.length==3);
    }
    public static String formatName(String name) {
        return "";
    }
    private static boolean checkPhoneNumber(String phoneNumber) {
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        return clean.length() == 11;
    }
    private static String formatPhoneNumber(String phoneNumber) {
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        String result = "+7" + " " + clean.substring(1, 4) + " " +
                clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9);

        return result;
    }

    public static void add(String[][] book, String name, String number) {


    }

    public static void list(String[][] book) {
        //print phone book
    }
}
