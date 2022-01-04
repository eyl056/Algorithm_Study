import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int plus(int A, int B) {
        return A + B;
    }
    public static int minus(int A, int B) {
        return A - B;
    }
    public static int multiple(int A, int B) {
        return A * B;
    }
    public static int quotient(int A, int B) {
        return A / B;
    }
    public static int remainder(int A, int B) {
        return A % B;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(plus(A, B));
        System.out.println(minus(A, B));
        System.out.println(multiple(A, B));
        System.out.println(quotient(A, B));
        System.out.println(remainder(A, B));

        br.close();
    }
}
