class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int low = 0;
        int high = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
                char c = s.charAt(i);

                if(set.contains(c)){              
                    while(s.charAt(low)!=c){
                        set.remove(s.charAt(low));
                        low = low+1;
                    
                    }
                    low++;
                }else{
                set.add(c);
                }
                max = Math.max(max,i-low+1);
        }


        return max;
    }
}