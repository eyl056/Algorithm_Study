import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    static void permutation(int[] arr, int[] output, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (depth >= 1 && output[depth - 1] > arr[i]) continue;
            output[depth] = arr[i];
            permutation(arr, output, depth + 1, n, r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        output = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        permutation(arr, output, 0, N, M);

        System.out.print(sb);

        br.close();
    }
}
