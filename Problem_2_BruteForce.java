Time complexity - O(n^2)
Space complexity - O(n)

// check all combinations

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < s.length(); i++){
            Set<Character> set = new HashSet<>();
            int count = 1;
            set.add(s.charAt(i));
            for(int j = i+1; j < s.length(); j++){
                if(set.contains(s.charAt(j))){
                    break;
                }else{
                    set.add(s.charAt(j));
                    count++;
                }
            }
            
            max = Math.max(max,count);
        }
        return max;
    }
}
