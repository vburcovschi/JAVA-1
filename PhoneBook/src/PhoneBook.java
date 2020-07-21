import java.util.Scanner;
import java.util.Arrays;

public class PhoneBook {
    public static int id = 0;
    public static void main(String[] args) {
        String[][] book = new String [0][2];
        Scanner scanner = new Scanner(System.in);
        String selection = "";
        String name = "";
        String number = "";
        boolean isCorrectName;
        boolean isCorrectNumber;
        while (!("3".equals(selection))) {
            System.out.println("*****************************************************************************");
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить адресат");
            System.out.println("2. Просмотреть адресную книгу");
            System.out.println("3. Выход");
            System.out.println("*****************************************************************************");
            selection = scanner.nextLine() ;
            switch (selection) {
                case "1": {
                    book = arrayLengthChange(book, book.length+1);
                    System.out.print("Введите Имя, Фамилия, Отчество (через пробел): ");
                    isCorrectName = false;
                    while (!isCorrectName) {
                        name = scanner.nextLine();
                        isCorrectName = checkName(name);
                        if (!isCorrectName) {
                            System.out.println("Введите корректное имя!");
                        } else {
                        }
                    }
                    System.out.print("Введите номер телефона по формату X XXX XXX XX XX: ");
                    isCorrectNumber = false;
                    while (!isCorrectNumber) {
                        number = scanner.nextLine(); 
                        isCorrectNumber = checkPhoneNumber(number);
                        if (!isCorrectNumber) {
                            System.out.println("Введите корректный номер! Номер должен содерзать 11 цифр по формату X XXX XXX XX XX");

                        } else {
                            System.out.println("Номер был приведен к требуему формату и записан в базу как: " + formatPhoneNumber(number));
                        }
                    }
                    add(book, name, number);
                    id = id+1;
                    break;
                }
                case "2" : {
                    list(book);
                    break;
                }
                case "3" :{
                        break;
                }
                default: {
                    System.out.println("Not correct input");
                    System.out.println("-------------------------");
                    System.out.println("Select operation");
                    System.out.println("1. Добавить адресат");
                    System.out.println("2. Просмотреть адресную книгу");
                    System.out.println("3. Выход");
                    selection = scanner.nextLine();
                    break;
                }
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
    public static boolean checkPhoneNumber(String phoneNumber) {
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        return clean.length() == 11;
    }
    public static String formatPhoneNumber(String phoneNumber) {
        String clean = phoneNumber.replaceAll("[^0-9]", "");
        String result = "+7" + " " + clean.substring(1, 4) + " " +
                clean.substring(4, 7) + " " + clean.substring(7, 9) + " " + clean.substring(9);

        return result;
    }

    public static void add(String[][] book, String name, String number) {
        book[id][0] = name;
        book[id][1] = number;
    }

    public static void list(String[][] tmpbook) {
            for (int i=0; i<=tmpbook.length-1; i++){
                System.out.println(tmpbook[i][0]+ " "+tmpbook[i][1]);
            }
        }
    public static String[][] arrayLengthChange(String[][] arr, int newLength) {
        String[][] arrNew = new String[newLength][2];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        return arrNew;
    }
}
