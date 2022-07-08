import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine().toLowerCase();

            int[] arr = new int[26];
            for (char c = 'a' ; c <= 'z'; c++) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == c) {
                        arr[c - 97] += 1;
                    }
                }
            }
            int max = 0;
            char c = 'a';

            boolean question = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    c = (char) (i + 97);
                    question = false;
                } else if (arr[i] == max && arr[i] != 0) {
                    question = true;
                }
            }

            if (question) System.out.println("?");
            else System.out.print(String.valueOf(c).toUpperCase());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
