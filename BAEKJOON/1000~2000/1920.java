import java.io.*;
import java.util.*;

public class Main {
    /**
     * 이진탐색 O(nlogn)
     * 정렬을 미리 가정 - 자바의 기본 정렬은 O(nlogn)의 시간 복잡도를 가짐
     */
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());

            int[] A = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // 이분탐색 전 정렬 O(nlogn)
            Arrays.sort(A);

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                boolean find = false;
                int target = Integer.parseInt(st.nextToken());
                int start = 0; int end = A.length - 1;
                while (start <= end) {
                    int mid_index = (start + end) / 2;
                    int mid_value = A[mid_index];
                    if (mid_value > target) {
                        end = mid_index - 1;
                    } else if (mid_value < target) {
                        start = mid_index + 1;
                    } else {
                        find = true;
                        break;
                    }
                }
                if (find) System.out.println(1);
                else System.out.println(0);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
