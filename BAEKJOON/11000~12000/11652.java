import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        HashMap<Long, Integer> map = new HashMap<>();

        // 해시맵 <수, 빈도 수> 생성
        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(br.readLine());
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        // keyset 이용
        List<Long> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, new Comparator(){
            public int compare(Object k1, Object k2){
                Object v1 = map.get(k1);
                Object v2 = map.get(k2);

                if(v1.equals(v2)){
                    return ((Comparable)k1).compareTo(k2);
                }else{
                    return ((Comparable)v2).compareTo(v1);
                }
            }
        });

        for(long key : keySetList) {
            System.out.println(key);
            break;
        }

        br.close();
    }
}
