import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[30][30];
    static int combination(int n, int r) {
        if(dp[n][r] > 0) {
            return dp[n][r];
        }

        if(n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int west = Integer.parseInt(st.nextToken());
            int east = Integer.parseInt(st.nextToken());
            System.out.println(combination(east, west));
        }

        br.close();
    }
}
