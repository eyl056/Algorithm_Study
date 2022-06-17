import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static Queue<Integer> q;
    static boolean[] visited;
    static int[] answer;
    static int count = 0;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            q = new LinkedList<>();
            visited = new boolean[N + 1];
            answer = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            for (int i = 1; i < N + 1; i++) {
                Collections.sort(graph[i]);
            }

            visited[R] = true;
            bfs(R);

            for (int i = 1; i < N + 1; i++) {
                System.out.println(answer[i]);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bfs(int r) {
        answer[r] = ++count;
        visited[r] = true;
        q.offer(r);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int x : graph[node]) {
                if (!visited[x]) {
                    visited[x] = true;
                    answer[x] = ++count;
                    q.offer(x);
                }
            }
        }
    }
}
