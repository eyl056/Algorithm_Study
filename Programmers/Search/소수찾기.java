import java.util.*;

class Solution {
    // 숫자 조합 저장
    HashSet<Integer> set = new HashSet<>();
    
    // 숫자 조합 만들기
    public void recursive(String comb, String others) {
        // set에 추가
        if (!comb.equals("")) {
            set.add(Integer.parseInt(comb));
        }
        // 사용한 숫자는 others에서 제외
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }
    
    // 소수 판별
    public boolean isPrime(int num) {
        if (num == 0 || num == 1) return false;
        
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) return false; 
        }
        return true;
    }
    
    public int solution(String numbers) {
        
        recursive("", numbers);
        
        int count = 0; // 소수의 개수
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            if (isPrime(num)) count++;
        }
        
        return count;
        
    }
}
