import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        permutation(0, 0);
        System.out.println(min);

    }

    static void permutation(int idx, int depth) {
        if(depth == N / 2) {
            difference();
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    static void difference() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] == true && visited[j] == true) {
                    start += arr[i][j];
                    start += arr[j][i];
                }
                else if (visited[i] == false && visited[j] == false) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }
        int num = Math.abs(start - link);
        if (num == 0) {
            System.out.println(num);
            System.exit(0);
        }
        min = Math.min(num, min);
    }
}
