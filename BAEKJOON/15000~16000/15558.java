import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Point {
    int x;
    int y;
    int time;
    Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
public class Main {
    static int N, k;
    static int[][] map;
    static boolean[][] visited;

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 3; i++) {
                Point next;
                if (i == 0) next = new Point(now.x, now.y + 1, now.time);
                else if (i == 1) next = new Point(now.x, now.y - 1, now.time);
                else next = new Point(1 - now.x, now.y + k, now.time);

                if (next.y >= N) {
                    System.out.println(1);
                    return;
                }

                if (0 <= next.x && next.x <= 1 && 0 <= next.y) {
                    if (!visited[next.x][next.y] && map[next.x][next.y] == 1) {
                        if (next. y > now.time) {
                            queue.offer(new Point(next.x, next.y, now.time + 1));
                            visited[next.x][next.y] = true;
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[2][N];
        visited = new boolean[2][N];

        for (int i = 0; i < 2; i++) {
            String info = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(info.charAt(j)));
            }
        }

        bfs();

        br.close();
    }
}
