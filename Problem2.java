class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
        HashMap <Character, Integer> map = new HashMap<>();
        //List<string> li = new ArrayList<>();
        int slow = 0, max = 0;
        for(int fast = 0; fast < s.length(); fast++) {
            char c = s.charAt(fast);
            if(map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, fast+1);
            //int curr = fast-slow+1;
            //if(curr > max) {
             //   li = new ArrayList<>();
             //   li.add(s.substring(slow, fast+1));
           // }
           // else if(curr == max) {
            //    li.add(s.substring(slow, fast+1));
            //}
            
            max = Math.max(max, fast - slow + 1);
        }
    return max;
    }
};
    
