class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<Character>();
        int max =0 ;
        int i = 0;
        int j =0;
        
        while(j<s.length()){
            if(!hs.contains(s.charAt(j))){
                hs.add(s.charAt(j));
                j++;
                max = Math.max(max, hs.size());
            }else{
                hs.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
