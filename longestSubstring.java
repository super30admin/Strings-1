// Tc: O(n),sc:O(1);

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int slow = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                while(s.charAt(slow)!=c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            set.add(c);
            max = Math.max(max,(i-slow+1));
        }
        return max;
    }
}