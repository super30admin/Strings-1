class LongestSubStringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> mySet = new HashSet<>();
        int low = 0;
        int max = 0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(mySet.contains(c)){
                while(s.charAt(low) != c){
                    mySet.remove(s.charAt(low));
                    low++;
                }
                low++;
            }
                mySet.add(c);
                max = Math.max(max, mySet.size());
        }
        return max;
    }
}