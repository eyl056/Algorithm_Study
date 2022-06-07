import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 투 포인터
         * 1) sum > N : sum = sum - start_index; start_index++;
         * 2) sum < N : end_index++; sum = sum + end_index++;
         * 3) sum == N : end_index++; sum = sum + end_index; count++;
         **/
        try {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();

            int count = 1; // 자기 자신 하나로 이루어진 경우의 수 미리 저장
            int start_index = 1;
            int end_index = 1;
            int sum = 1;

            while (end_index != N) {
                if (sum == N) {
                    end_index++;
                    count++;
                    sum += end_index;
                }
                else if (sum > N) {
                    sum -= start_index;
                    start_index++;
                }
                else if (sum < N) {
                    end_index++;
                    sum += end_index;
                }
            }

            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
