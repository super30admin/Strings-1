public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int maxLength = Integer.MIN_VALUE;
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c) > startIndex){
                    startIndex = map.get(c);
                }
            }
            map.put(c, i+1);
            maxLength = Math.max(maxLength, i-startIndex + 1);
        }
        return maxLength;
    }
}
