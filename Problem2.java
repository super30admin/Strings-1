class Problem2 {
    public int lengthOfLongestSubstring(String s) {
        

        int i = 0;
        int max =0;
        Map<Character, Integer> map = new HashMap<>(); 
        for(int j=0; j<s.length();j++) {
            char ch = s.charAt(j);
            if(map.containsKey(ch)) {
                i = Math.max(i, map.get(ch)+1);
            } 
            map.put(ch,j);
            max = Math.max(max, j -i+1);
        }

        return max;
    }
}
