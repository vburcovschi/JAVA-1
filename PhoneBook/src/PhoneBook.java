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
        String searchString = "";
        boolean isCorrectName;
        boolean isCorrectNumber;
        while (!("4".equals(selection))) {
            System.out.println("*****************************************************************************");
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить адресат");
            System.out.println("2. Просмотреть адресную книгу");
            System.out.println("3. Поиск");
            System.out.println("4. Выход");
            System.out.println("*****************************************************************************");
            selection = scanner.nextLine() ;
            switch (selection) {
                case "1":
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
                            System.out.print("Введите корректный номер! Номер должен содерзать 11 цифр по формату X XXX XXX XX XX: ");
                        } else {
                            System.out.println("Номер был приведен к требуему формату и записан в базу как: " + formatPhoneNumber(number));
                        }
                    }
                    add(book, formatName(name), formatPhoneNumber(number));
                    id = id+1;
                    break;
                case "2" :
                    list(book);
                    break;
                case "3" :
                    System.out.print("Введите номер телефона по формату X XXX XXX XX XX: ");
                    isCorrectNumber = false;
                    while (!isCorrectNumber) {
                        number = scanner.nextLine();
                        isCorrectNumber = checkPhoneNumber(number);
                        if (!isCorrectNumber) {
                            System.out.print("Введите корректный номер! Номер должен содерзать 11 цифр по формату X XXX XXX XX XX: ");
                        }
                    }
                    while (!("s".equals(number))) {
                        isCorrectNumber = checkPhoneNumber(number);
                        if (isCorrectNumber) {
                            bookSearch(book, formatPhoneNumber(number));
                            System.out.print("Введите другой номер телефона по формату X XXX XXX XX XX или нажмите клавишу 's' для выхода:");
                        }else{
                            System.out.print("Введите корректный номер! Номер должен содерзать 11 цифр по формату X XXX XXX XX XX или нажмите клавишу 's' для выхода:");
                        }
                        number = scanner.nextLine();
                        }
                    break;
                case "4" :
                        break;
                default:
                    System.out.println("Ошибочный ввод!!!");
                    System.out.println("-------------------------");
                    System.out.println("Выберите действие:");
                    System.out.println("1. Добавить адресат");
                    System.out.println("2. Просмотреть адресную книгу");
                    System.out.println("3. Поиск");
                    System.out.println("4. Выход");
                    selection = scanner.nextLine();
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
        String[] tmp = new String[name.length()];
        String formatedName = "";
        tmp = name.split(" ");
        for (int i=0; i<tmp.length; i++){
            tmp[i] = tmp[i].substring(0,1).toUpperCase()+tmp[i].substring(1,tmp[i].length());
            formatedName = formatedName + tmp[i]+" ";
        }
        return formatedName;
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
        book[id][0] = formatName(name);
        book[id][1] = number;
    }

    public static void list(String[][] tmpbook) {
        String [] tmparr = new String[tmpbook.length];
        System.out.printf("%-35s%-12s","Имя","Телефон");
        System.out.println();
        for (int i=0; i<tmpbook.length; i++) {
            tmparr[i] = String.format("%-35s%-12s",tmpbook[i][0],tmpbook[i][1]);
        }
        Arrays.sort(tmparr);
        for (int i=0; i<tmparr.length; i++) {
            System.out.println(tmparr[i]);
            }
        }
    public static String[][] arrayLengthChange(String[][] arr, int newLength) {
        String[][] arrNew = new String[newLength][2];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        return arrNew;
    }

    public static String[] arrayLengthChange1(String[] arr, int newLength) {
        String[] arrNew = new String[newLength];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        return arrNew;
    }

    public static boolean bookSearch(String [][] book, String text) {
        String[] searchresult = new String[0];
        boolean found = false;
        for (int i=0; i<book.length; i++) {
            if (book[i][1].equals(text)) {
                searchresult = arrayLengthChange1(searchresult, searchresult.length+1);
                searchresult[searchresult.length-1] = book[i][0];
                found = true;
            }
        }
        if (found) {
            System.out.println("Были найдены следующие записи:");
            System.out.println("Имя");
            Arrays.sort(searchresult);
            for (int i=0; i<searchresult.length; i++){
                System.out.println(searchresult[i]);
            }
            } else {
            System.out.println("Ничего не найдено!");
        }
        return found;
    }
}
