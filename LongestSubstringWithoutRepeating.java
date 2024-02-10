// TC: o(2n) where n is the length of s, SC: o(1)
class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int slow = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                while(s.charAt(slow) != c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }  else {
                set.add(c);
            }
            max = Math.max(max, i-slow+1);
        }
        return max;
        
    }
    
}
