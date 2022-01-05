import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String quiz = br.readLine();
            int score = 0;
            int total = 0;
            for (int j = 0; j < quiz.length(); j++) {
                if (quiz.charAt(j) == 'O') {
                    score += 1;
                    total += score;
                } else if (quiz.charAt(j) == 'X') {
                    score = 0;
                }
            }
            System.out.println(total);
        }

        br.close();
    }
}
