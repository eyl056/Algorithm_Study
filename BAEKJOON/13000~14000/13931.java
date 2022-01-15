import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    static int N, K;
    static int[] graph = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001]; // 직전 위치

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int x = queue.poll();

            if (x == K) System.out.println(graph[x]);

            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) nx = x + 1;
                else if (i == 1) nx = x - 1;
                else nx = 2 * x;

                if (0 <= nx && nx <= 100000) {
                    if (!visited[nx]) {
                        visited[nx] = true;
                        graph[nx] = graph[x] + 1;
                        queue.offer(nx);
                        parent[nx] = x;
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

        bfs(N);

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;
        // 목적지 K 부터 출발점 N까지 직전위치로 차례대로 push, pop
        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

        br.close();
    }
}
