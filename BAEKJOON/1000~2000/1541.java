import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String expression[] = br.readLine().split("-");

            for (int i = 0; i < expression.length; i++) {
                if (i == 0) answer += mySum(expression[i]);
                else answer -= mySum(expression[i]);
            }

            System.out.println(answer);

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int mySum(String line) {
        int sum = 0;
        String str[] = line.split("[+]");
        for (int i = 0; i < str.length; i++) {
            sum += Integer.parseInt(str[i]);
        }
        return sum;
    }
}
