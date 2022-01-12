import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Student {
    String name;
    int korean;
    int english;
    int math;

    Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}

public class Main {
    static int N;
    static Student[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new Student[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            arr[i] = new Student(name, korean, english, math);
        }

        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.korean == s2.korean) {
                    if (s1.english == s2.english) {
                        if (s1.math == s2.math) {
                            return s1.name.compareTo(s2.name);
                        }
                        return s2.math - s1.math;
                    }
                    return s1.english - s2.english;
                }
                return s2.korean - s1.korean;
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i].name);
        }

        br.close();
    }
}
