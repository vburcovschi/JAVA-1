import java.util.Arrays;

public class ChangeArraylength {
    public static void main(String[] args) {
        int[] masiv= new int [5];
        arrayLengthChange(masiv, 10);

    }
    public static int[] arrayLengthChange(int[] arr, int newLength) {
        int[] arrNew = new int[newLength];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        return arrNew;
    }
}
