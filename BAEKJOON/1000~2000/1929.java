import java.io.*;
import java.util.*;

public class Main {
    /**
     * 소수 구하기 : 에라토스테네스의 체
     *
     */
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int A[] = new int[N + 1];

            // 0과 1은 소수에서 제외 => 어차피 0이니까 초기화 X
            for (int i = 2; i <= N; i++) {
                A[i] = i;
            }

            for (int i = 2; i <= Math.sqrt(N); i++) {
                // 소수가 아니면 0으로 체크 -> 넘어감
                if (A[i] == 0) continue;
                // 어떤 수의 배수 => 소수가 아님 => 0
                for (int j = i + i; j <= N; j += i) {
                    A[j] = 0;
                }
            }

            for (int i = M; i <= N; i++) {
                if (A[i] != 0) {
                    System.out.println(A[i]);
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
