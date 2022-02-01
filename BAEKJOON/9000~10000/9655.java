import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new boolean[N + 1];
        Arrays.fill(dp, false);

        if (N == 1) {
            System.out.print("SK");
            System.exit(0);
        }

        dp[1] = true;
        dp[2] = false;

        for (int i = 3; i < N + 1; i++) {
            if (dp[i - 1] == false || dp[i - 3] == false) {
                dp[i] = true;
            }
        }

        if (dp[N]) System.out.print("SK");
        else System.out.print("CY");

        br.close();
    }
}
