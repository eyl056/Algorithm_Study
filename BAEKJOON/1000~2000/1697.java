import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
    static int N, K;
    static int[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[100001]; // 움직인 거리 표시
        visited = new boolean[100001]; // 방문 여부 확인

        System.out.println(bfs(N));

        br.close();
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        int x = 0, nx = 0;

        while(!queue.isEmpty()) {
            x = queue.poll();

            if (x == K) return graph[x];

            for (int i = 0; i < 3; i++) {
                if (i == 0) nx = x - 1;
                if (i == 1) nx = x + 1;
                if (i == 2) nx = 2 * x;
                if (0 <= nx && nx <= 100000) {
                    if (!visited[nx]) {
                        visited[nx] = true;
                        graph[nx] = graph[x] + 1;
                        queue.offer(nx);
                    }
                }
            }

        }

        return graph[x];
    }
}
