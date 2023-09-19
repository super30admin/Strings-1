// TC = O(n)
//SC = O(n)

class LongestSubString{
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                //if char present in set then will move slow ptr
                while(s.charAt(slow)!= c){
                    set.remove(s.charAt(slow)); // here we need to remove the char till we reach the next same char.
                    slow++;
                }
                slow++;
            }else{
                set.add(c);
            }
              max = Math.max(max, set.size());
        }
      return max;
    }
}