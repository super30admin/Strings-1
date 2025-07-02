class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if (l <= 1) return l;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for(int right = 0; right < l; right ++){
            char curr = s.charAt(right);
            if(set.contains(curr)){
                while(s.charAt(left) != curr){
                    char leftChar = s.charAt(left);
                    set.remove(leftChar);
                    left++;
                }
                left++;
            }
            else{
                set.add(curr);
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}