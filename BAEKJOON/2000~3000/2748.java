import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;
    static int n;
    static void fibo() {
        dp = new long[n + 1];

        if (n == 0) dp[0] = 0;
        else if (n == 1) dp[1] = 1;
        else {
            dp[1] = 1;
            for (int i = 2; i < n + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        fibo();

        System.out.print(dp[n]);

        br.close();
    }
}
