import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 각 종류의 옷 별로 입지 않은 경우 + 1
        // headgear 3 가지, eyewear 2가지 => 조합 경우의 수 3 * 2 = 6
        // 아무것도 입지 않은 경우 6 - 1 = 5
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            // 옷 종류 별 개수
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        int answer = 1;
        Iterator<Integer> iter = map.values().iterator();
        while (iter.hasNext()) {
            // 입지 않을 경우 + 1
            answer *= (iter.next().intValue() + 1);
        }
        
        // 전체 아무것도 입지 않은 경우
        return answer - 1;
    }
}
