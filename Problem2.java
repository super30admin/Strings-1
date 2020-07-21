//Time Complexity: O(n) n- length of the string
//Space Complexity:O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int i = 0,j = 0;
        int count = 0;
        int n = s.length();
        while (i < n && j < n) {
            if(map.containsKey(s.charAt(i))) {
                if(j < map.get(s.charAt(i))) 
                    j = map.get(s.charAt(i));
                
                map.put(s.charAt(i),i+1);
                i++;
                count = Math.max(count,i - j);
                
                
            }
            else {
                map.put(s.charAt(i),i+1);
                i++;
                count = Math.max(count,i - j);
                
            }
        }
        
        return count;
    }
}
