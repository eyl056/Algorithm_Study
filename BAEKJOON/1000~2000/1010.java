import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int collaboration(int x, int y) {
        int[][] dp = new int[31][31];

        for (int i = 1; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
            }
        }

        for (int i = 1; i < 31; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        return dp[x][y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int west = Integer.parseInt(st.nextToken());
            int east = Integer.parseInt(st.nextToken());
            System.out.print(collaboration(west, east));
        }

        br.close();
    }
}
