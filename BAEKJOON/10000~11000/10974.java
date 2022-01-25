import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            output[depth] = arr[i];
            permutation(arr, output, visited, depth + 1, n, r);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        output = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        permutation(arr, output, visited, 0, N, N);

        System.out.print(sb);

        br.close();
    }
}
