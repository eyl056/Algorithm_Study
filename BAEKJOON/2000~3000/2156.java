import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];
        long[] wine = new long[n + 1];

        for (int i = 1; i < n + 1; i++) {
            wine[i] = Long.parseLong(br.readLine());
        }

        for (int i = 1; i < n + 1; i++) {
            if (i == 1) dp[i] = wine[1];
            else if (i == 2) dp[i] = wine[i - 1] + wine[i];
            else if (i == 3) {
                if (dp[i - 1] >= wine[i - 1] + wine[i]) dp[i] = Math.max(dp[i - 1], wine[i - 2] + wine[i]);
                else dp[i] = Math.max(wine[i - 1] + wine[i], wine[i - 2] + wine[i]);
            }
            else {
                if (dp[i - 1] >= dp[i - 2] + wine[i]) dp[i] = Math.max(dp[i - 1], dp[i - 3] + wine[i - 1] + wine[i]);
                else dp[i] = Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]);
            }
        }

        long max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            if (max <= dp[i]) max = dp[i];
        }

        System.out.println(max);

        br.close();
    }
}
