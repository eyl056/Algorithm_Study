import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, K;
    static int cnt = 0;
    static int min = Integer.MAX_VALUE;
    static int[] graph = new int[100001];

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        graph[start] = 1;

        while(!queue.isEmpty()) {
            int x = queue.poll();

            // 이미 최소 시간보다 크면 더 이상 확인 X
            if (min < graph[x]) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) nx = x + 1;
                else if (i == 1) nx = x - 1;
                else nx = 2 * x;

                if (0 <= nx && nx <= 100000) {
                    if (nx == K) {
                        min = graph[x];
                        cnt++;
                    }

                    // 아직 방문하지 않은 곳
                    // 또는 방문했더라도 같은 시간에 방문한 곳
                    // 큐에 삽입
                   if (graph[nx] == 0 || graph[nx] == graph[x] + 1) {
                       graph[nx] = graph[x] + 1;
                       queue.offer(nx);
                   }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K <= N) {
            System.out.println(N - K);
            System.out.println(1);
        } else {
            bfs(N);

            System.out.println(min);
            System.out.println(cnt);
        }

        br.close();
    }
}
