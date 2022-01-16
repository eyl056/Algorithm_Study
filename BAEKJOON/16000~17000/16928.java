import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] board = new int[101];
    static int[] graph = new int[101];
    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == 100) {
                System.out.println(graph[now]);
                return;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = now + dice;
                if (1 <= next && next <= 100) {
                    if (graph[next] == 0) {
                        if (board[next] != 0) {
                            if (graph[board[next]] == 0) {
                                queue.offer(board[next]);
                                graph[board[next]] = graph[now] + 1;
                            }
                        } else {
                            queue.offer(next);
                            graph[next] = graph[now] + 1;
                        }
                    }
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st2.nextToken());
            int to = Integer.parseInt(st2.nextToken());
            board[from] = to;
        }

        bfs();

        br.close();
    }
}
