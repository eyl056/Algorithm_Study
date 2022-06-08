import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[][] visited;
    // 상 하 좌 우 4 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // N X M 크기의 미로
            graph = new int[N][M];

            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String line = st.nextToken();
                for (int j = 0; j < M; j++) {
                    graph[i][j] = Integer.parseInt(line.substring(j, j+1));
                }
            }

            BFS(0, 0);
            System.out.println(graph[N - 1][M - 1]);
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (graph[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        graph[x][y] = graph[now[0]][now[1]] + 1;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
