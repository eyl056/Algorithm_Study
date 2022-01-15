import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Point {
    int r;
    int c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int N;
    static int[][] chess;
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};

    static boolean isInChess(int r, int c) {
        if (0 <= r && r < N && 0 <= c && c < N) return true;
        else return false;
    }

    static void bfs(int startR, int startC, int endR, int endC) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(startR, startC));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.r == endR && now.c == endC) {
                System.out.println(chess[now.r][now.c]);
                return;
            }

            for (int i = 0; i < 6; i++) {
                Point next = new Point(now.r + dr[i], now.c + dc[i]);
                if (isInChess(next.r, next.c)) {
                    if (chess[next.r][next.c] == 0) {
                        queue.offer(next);
                        chess[next.r][next.c] = chess[now.r][now.c] + 1;
                    }
                }
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        chess = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        bfs(r1, c1, r2, c2);

        br.close();
    }
}
