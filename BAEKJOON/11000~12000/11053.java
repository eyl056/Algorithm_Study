import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] A = new long[N];
        long[] dp = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Long.parseLong(st.nextToken());

        for (int i = 0; i < N; i++) {
            long min = 0;
            for (int j = 0; j < N; j++) {
                if (A[i] > A[j]) {
                    min = Math.max(min, dp[j]);
                }
            }
            dp[i] = min + 1;
        }

        long max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) max = dp[i];
        }

        System.out.print(max);

        br.close();
    }
}
