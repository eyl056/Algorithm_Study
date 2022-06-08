import java.io.*;
import java.util.*;

public class Main {
    /**
     * 이분그래프
     * 트리 : 항상 이분 그래프
     * 사이클이 발생하지 않으면 탐색을 하며서 다음 노드를 이번 노드와 다른 집합으로 지정
     * 사이클이 발생했을 때는 이분 그래프
     * 모든 노드에서 DFS 실행 => 끊겨 있을 수도 있기 때문에
     */
    static ArrayList<Integer>[] A;
    static int[] check; // 이분 그래프 다른 집합인지 체크 배열 (1, 0, 1, 0 ...)
    static boolean[] visited;
    static boolean isEven;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int testCase = Integer.parseInt(br.readLine());
            for (int t = 0; t < testCase; t++) {
                String[] s = br.readLine().split(" ");
                int V = Integer.parseInt(s[0]); // 노드
                int E = Integer.parseInt(s[1]); // 에지
                A = new ArrayList[V + 1];
                visited = new boolean[V + 1];
                check = new int[V + 1];
                isEven = true;
                for (int i = 1; i <= V; i++) {
                    A[i] = new ArrayList<Integer>();
                }
                // 에지 데이터 저장
                for (int i = 0; i < E; i++) {
                    s = br.readLine().split(" ");
                    int start = Integer.parseInt(s[0]);
                    int end = Integer.parseInt(s[1]);
                    A[start].add(end);
                    A[end].add(start);
                }
                // 모든 노드에서 DFS 실행 해야함
                for (int i = 1; i <= V; i++) {
                    if (isEven) { // 이미 이분그래프가 아니면 바로 다음거
                        DFS(i);
                    } else {
                        break;
                    }
                }
                if (isEven) System.out.println("YES");
                else System.out.println("NO");
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DFS(int start) {
        visited[start] = true;
        for (int i : A[start]) { // 인접 리스트로 받아서 start에서 연결된 모든 노드 탐색
            if (!visited[i]) {
                // 바로 직전에 있는 노드와 다른 집합으로 분류해야 함
                check[i] = (check[start] + 1) % 2;
                DFS(i);
            } else {
                // 이미 방문했던 노드에 도착했을 때 같은 집합이면 -> 사이클 발생 -> 이분 그래프 아님
                if (check[start] == check[i])
                    isEven = false;
            }
        }
    }
}
