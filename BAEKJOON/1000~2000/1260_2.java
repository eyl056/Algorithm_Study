import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static Queue<Integer> queue;
    static boolean[] visited;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N + 1];
            for (int i = 1; i < N + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                graph[y].add(x);
            }

            for (int i = 1; i < N + 1; i++) {
                Collections.sort(graph[i]);
            }

            visited = new boolean[N + 1];
            dfs(V);
            System.out.println();

            queue = new LinkedList<>();
            visited = new boolean[N + 1];
            bfs(V);

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int r) {
        System.out.print(r + " ");
        visited[r] = true;
        for (int x : graph[r]) {
            if (!visited[x]) {
                dfs(x);
            }
        }
    }

    public static void bfs(int r) {
        System.out.print(r + " ");
        queue.offer(r);
        visited[r] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int x : graph[node]) {
                if (!visited[x]) {
                    queue.offer(x);
                    System.out.print(x + " ");
                    visited[x] = true;
                }
            }
        }
    }
}
