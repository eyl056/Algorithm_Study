class Solution {
    public int solution(String s) {
        String[] numWord = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        // Convert int to String: String.valueOf(i);
        for (int i = 0; i < 10; i++) {
            // replace: 문자열 -> 대체 문자열
            // replaceAll: 정규식 들어감 ex. [abc] => a, b, c를 대체
            s = s.replace(numWord[i], String.valueOf(i));
        }
        // Convert String to int: Integer.parseInt(str);
        return Integer.parseInt(s);
    }
}
