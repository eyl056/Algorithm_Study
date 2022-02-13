import java.io.IOException;
        import java.io.BufferedReader;
        import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];

        dp[1][0] = 0;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 2; i < N + 1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][1] % 1000000000;
                else if (j == 9) dp[i][j] = dp[i - 1][8] % 1000000000;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }

        System.out.print(sum % 1000000000);

        br.close();
    }
}
