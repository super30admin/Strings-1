class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;

        HashMap<Character, Integer> set = new HashMap<>();
        int result = 0;
        char c, c2;
        while(fast<s.length()){
            c = s.charAt(fast++);

            if(set.getOrDefault(c, -1) >= slow)
                slow = set.get(c);
            set.put(c, fast);


            // if(set.containsKey(c))
            //     slow = Math.max(slow, set.get(c));
            // set.put(c, fast);

            result = Math.max(result, fast-slow);

        }
        return result;
    }
}