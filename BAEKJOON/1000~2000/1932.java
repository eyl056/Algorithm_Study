import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] tri = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = tri.clone();

        dp[0][0] = tri[0][0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][0] + tri[i][0];
                else if (i == j) dp[i][j] = dp[i - 1][j - 1] + tri[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j - 1] + tri[i][j], dp[i - 1][j] + tri[i][j]);
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (max < dp[i][j]) max = dp[i][j];
            }
        }

        System.out.print(max);

        br.close();
    }
}
