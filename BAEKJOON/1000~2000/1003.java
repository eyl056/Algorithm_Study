import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static void fiboCnt(int num) {
        ArrayList<Integer> zeroCnt = new ArrayList<>(Arrays.asList(1, 0));
        ArrayList<Integer> oneCnt = new ArrayList<>(Arrays.asList(0, 1));

        if (num <= 1) {
            sb.append(zeroCnt.get(num) + " " + oneCnt.get(num) + "\n");
            return;
        }

        for (int i = 2; i < num + 1; i++) {
            zeroCnt.add(zeroCnt.get(i - 1) + zeroCnt.get(i - 2));
            oneCnt.add(oneCnt.get(i - 1) + oneCnt.get(i - 2));
        }

        sb.append(zeroCnt.get(num) + " " + oneCnt.get(num) + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            fiboCnt(num);
        }

        System.out.println(sb);

        br.close();
    }
}
