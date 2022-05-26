import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String s_prime = Integer.toString(n, k);
        
        String[] s_a_prime = s_prime.split("0");
        
        System.out.println(Arrays.toString(s_a_prime));
        
        for (int i = 0; i < s_a_prime.length; i++) {
            
            if (s_a_prime[i].equals("")) continue;
            
            Long number = Long.parseLong(s_a_prime[i]);
            
            if (isPrime(number)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(Long n) {
        if (n <= 1) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}
