import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] f;
    static int recursionCount = 0;
    static int dynamicCount = 0;

    static int recursion(int n) {
        if (n == 1 || n == 2) {
            recursionCount++;
            return 1;
        }
        else return recursion(n - 1) + recursion(n - 2);
    }

    static int dynamic(int n) {
        f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            dynamicCount++;
        }
        return f[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        recursion(n);
        dynamic(n);

        System.out.print(recursionCount + " " + dynamicCount);

        br.close();
    }
}
