import java.io.*;
import java.util.*;

public class Main {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        /**
         * 연결요소: 에지로 연결된 노드의 집합
         * DFS : 완전탐색으로 이미 방문한 노드를 제외하여 연결 요소 구하기
         **/
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 방문 배열 초기화
            visited = new boolean[N + 1];
            A = new ArrayList[N + 1];

            for (int i = 1; i < N + 1; i++) {
                A[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                // 그래프를 인접 리스트로 저장
                // 방향이 없는 그래프이기 때문에 양쪽 방향으로 에지 모두 저장
                A[u].add(v);
                A[v].add(u);
            }

            int count = 0;
            for (int i = 1; i < N + 1; i++) {
                // 방문하지 않은 노드 -> 연결 요소 + 1
                if (!visited[i]) {
                    count++;
                    DFS(i);
                }
            }
            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    public static void DFS(int v) {
        if (visited[v]) return;
        visited[v] = true;
        // 방문 노드에 인접한 노드 찾기
        for (int node : A[v]) {
            DFS(node);
        }
    }
}
