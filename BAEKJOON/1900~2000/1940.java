import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 투 포인터
         * 크기 비교 => 정렬 !! (N <= 15000) 시간 복잡도 ㅇㅋ
         * 양쪽 끝의 위치를 투 포인터로 지정
         * A[i] + A[j] > M : j--
         * A[i] + A[j] < M : i++
         * A[i] + A[j] == M : i++, j--, count++
         **/
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[] A = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);

            int count = 0;
            int i = 0; int j = N - 1;

            while (i < j) {
                if (A[i] + A[j] < M) i++;
                else if (A[i] + A[j] > M) j--;
                else {
                    i++;
                    j--;
                    count++;
                }
            }
            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
