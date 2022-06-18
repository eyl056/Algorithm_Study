import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int v = Integer.parseInt(br.readLine());
            int e = Integer.parseInt(br.readLine());

            graph = new ArrayList[v + 1];
            for (int i = 1; i < v + 1; i++) {
                graph[i] = new ArrayList<>();
            }
            visited = new boolean[v + 1];

            for (int i = 0; i < e; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x].add(y);
                graph[y].add(x);
            }

            dfs(1);

            int answer = 0;
            for (int i = 1; i < v + 1; i++) {
                if (visited[i]) answer++;
            }

            System.out.println(answer - 1);

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dfs(int r) {
        visited[r] = true;
        for (int node : graph[r]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }
}
