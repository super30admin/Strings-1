class Solution {
	//Time Complexity :O(n)
	//Space Complexity: O(1) since number of chars are fixed
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0;
        // HashMap<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (map.containsKey(c)){
        //         start = Math.max(start, map.get(c));
        //     }
        //      res  =Math.max( res,i - start+1);
        //      map.put (c, i+1);
        // }
        HashSet<Character> set = new HashSet<>();
        for (int i =0;i < s.length();i++){
            char c = s.charAt(i);
            if (set.contains(c)){
                while (set.contains(c)){
                    set.remove(s.charAt(start));
                    start++;
                }}
                set.add(c);
             res  =Math.max( res,i - start+1);
        }
        return res;
    }
}
