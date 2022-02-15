import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static int[][] visited;
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

            for (int i = 0; i < N; i++) {
                String[] list = br.readLine().split("");
                int[] listN = Arrays.stream(list).mapToInt(Integer::parseInt).toArray();
                graph[i] = listN;
            }

            // 방문한 지점 확인 (0으로 초기화)
            visited = new int[N][M];

            // 출발 지점 +1
            visited[0][0] = 1;

            // queue를 사용한 BFS 방식으로 완전 탐색
            // 0, 0 시작 지점
            bfs(0, 0);

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bfs(int x, int y) {
        try {
            Queue<int[]> queue = new LinkedList<>();
            // 처음 출발 지점 0, 0 삽입
            queue.add(new int[] {x, y});
            int nx = 0, ny = 0;

            while(!queue.isEmpty()) {
                // 가장 최근에 방문한 지점
                int[] now = queue.poll();
                x = now[0];
                y = now[1];

                // 방문 지점이 도착 위치인 경우
                if (x == N - 1 && y == M - 1) {
                    // 이동 거리 출력
                    System.out.print(visited[x][y]);
                    break;
                }

                // 상 하 좌 우 방향으로 dfs 완전 탐색
                for (int i = 0; i < 4; i++) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                    if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                        // 아직 방문하지 않고 이동 가능한 경로일 경우에
                        if (visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                            // 방문함. 이동거리 +1
                            visited[nx][ny] = visited[x][y] + 1;
                            // 해당 방문 지점 queue에 삽입
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
