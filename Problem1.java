class Problem1 {
    public int lengthOfLongestSubstring(String s) {
        //null check and also length of 1 check as we don't need to compute anything in these cases.
        if(s==null||s.length()==0) return 0;
        if(s.length() == 1) return 1;
        int slow = 0;
        int max = 0;
        Map<Character, Integer> indexMap = new HashMap<>();

        for(int fast = 0; fast < s.length(); fast++){
            char c = s.charAt(fast);
            if(indexMap.containsKey(c)){
                slow = Math.max(slow, indexMap.get(c));
            }
            max = Math.max(max, (fast+1)-slow);
            indexMap.put(c, fast+1);
        }

        return max;
    }
}