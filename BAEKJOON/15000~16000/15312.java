import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] count = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    static String name1, name2;
    static String collaboration(String name1, String name2) {
        String collabo = "";
        for (int i = 0; i < name1.length(); i++) {
            collabo += name1.charAt(i);
            collabo += name2.charAt(i);
        }

        String collaboStr = "";
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < collabo.length(); j++) {
                if (count[i] == (collabo.charAt(j) - 'A')) {
                    collaboStr += count[i];
                }
            }
        }

        while (collaboStr.length() > 2) {
            String collaboSstr = "";
            for (int i = 0; i < collaboStr.length() - 1; i++) {
                int sum = Integer.parseInt(String.valueOf(collaboStr.charAt(i))) + Integer.parseInt(String.valueOf(collaboStr.charAt(i + 1)));
                collaboSstr = String.valueOf(sum % 10);
            }
            collabo = collaboSstr;
        }

        return collabo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        name1 = br.readLine();
        name2 = br.readLine();

        System.out.print(collaboration(name1, name2));

        br.close();
    }
}
