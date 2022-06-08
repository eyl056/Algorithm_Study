import java.io.*;
import java.util.*;

public class Main {
    /**
     * 유니온 파인드
     * 원소의 개수가 큰 편이기 때문에 경로 압축 필요
     */

    static int parent[]; // 대표 노드 저장 배열

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            parent = new int[n + 1];

            // 0 ~ n 까지의 집합 초기화
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }

            // m 번의 연산
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int question = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                // 합집합
                if (question == 0) {
                    union(a, b);
                } else { // 두 원소가 같은 집합인지 확인
                    boolean result = checkSame(a, b);
                    if (result) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void union(int a, int b) {
        // 대표 노드를 찾아서 연결
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) return a; // 대표노드
        else {
            return parent[a] = find(parent[a]); // value를 index로 바꿔서 대표노드까지 반복 찾기
            // 매번 parent[a] 에 넣어주면서 경로 압축
        }
    }

    public static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return true;
        else return false;
    }
}
