import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] seq = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Long.parseLong(st.nextToken());
        }
        long[] dp = seq.clone();

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(seq[i], dp[i - 1] + seq[i]);
        }

        long max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) max = dp[i];
        }

        System.out.print(max);

        br.close();
    }
}
