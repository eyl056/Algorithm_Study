class Solution {
    public boolean solution(String s) {
        boolean checkLength = false;
        boolean checkNumber = true;
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        
        if (s.length() == 4 || s.length() == 6) checkLength = true;
        
        for (int i = 0; i < s.length(); i++) {
            if (alpha.contains(String.valueOf(s.charAt(i)))) checkNumber = false;
        }
        
        return checkLength && checkNumber;
    }
}
