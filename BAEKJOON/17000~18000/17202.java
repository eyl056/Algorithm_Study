import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static String collaboration(String phone1, String phone2) {
        String collabo = "";
        for (int i = 0; i < 8; i++) {
            collabo += phone1.charAt(i);
            collabo += phone2.charAt(i);
        }

        while (collabo.length() > 2) {
            String collaboStr = "";
            for (int i = 0; i < (collabo.length() - 1); i++) {
                int sum = Integer.parseInt(String.valueOf(collabo.charAt(i))) + Integer.parseInt(String.valueOf(collabo.charAt(i + 1)));
                collaboStr += String.valueOf(sum % 10);
            }
            collabo = collaboStr;
        }

        return collabo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String phone1 = br.readLine();
        String phone2 = br.readLine();

        System.out.print(collaboration(phone1, phone2));

        br.close();
    }
}
