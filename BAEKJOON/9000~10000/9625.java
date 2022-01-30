import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long[] dpA;
    static long[] dpB;
    static void babba(int K) {
        dpA = new long[46];
        dpB = new long[46];

        dpA[1] = 0;
        dpB[1] = 1;
        dpA[2] = 1;
        dpB[2] = 1;

        if (K < 3) return;
        for (int i = 3; i <= 45; i++) {
            dpA[i] = dpA[i - 1] + dpA[i - 2];
            dpB[i] = dpB[i - 1] + dpB[i - 2];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        babba(K);

        System.out.print(dpA[K] + " " + dpB[K]);

        br.close();
    }
}
