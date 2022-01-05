import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            if (!list.contains(num % 42)) {
                list.add(num % 42);
            }
        }

        System.out.println(list.size());
    }
}
