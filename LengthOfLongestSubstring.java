class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null ) return 0;
        if(s.length() <= 1) return s.length();
        
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int max = 0;
        int curr = 0;
        for(int i=0; i < s.length();i++){
            char c = s.charAt(i);
            if(!hashMap.containsKey(c)){
                hashMap.put(c,i);
                curr += 1;               
            }else{
                curr = 0;
                i = hashMap.get(c);
                hashMap.clear();
            }
            max = Math.max(max, curr);
        }
        
        return max;
    }
}
