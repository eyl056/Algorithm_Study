import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    static void permutation(int[][] arr, boolean[] visited, int idx, int depth, int n) {
        if (depth == n / 2) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        start += arr[i][j];
                        start += arr[j][i];
                    } else if (!visited[i] && !visited[j]) {
                        link += arr[i][j];
                        link += arr[j][i];
                    }
                }
            }
            int num = Math.abs(start - link);
            min = Math.min(min, num);
            return;
        }

        for (int i = idx; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permutation(arr, visited, idx + 1, depth + 1, n);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permutation(arr, visited, 0, 0, N);

        System.out.print(min);

        br.close();
    }
}
