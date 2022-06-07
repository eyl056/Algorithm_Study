import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 버블정렬
         * 시간복잡도 O(N^2)
         **/
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0 ; i < N - 1; i++) {
                for (int j = 0; j < N - 1 - i; j++) { // 루프가 한번 돌수록 맨 뒷부분은 정렬된 데이터로..
                    if (arr[j] > arr[j + 1]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                System.out.println(arr[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
