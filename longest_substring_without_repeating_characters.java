class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Time Complexity: O(2n)
        //SpaceComplexity:O(1)
       /* HashSet<Integer> set = new HashSet<>();
        int start =0;
        int max =0;
        for(int i =0; i<s.length();i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                
                while(s.charAt(start) != c) {
                set.remove(s.charAt(start));
                start++;
                }
                start++;
            }
            set.add(c);
            max = Math.max(max,set.size());
            
        }
        return max;*/
       //TimeComplexity:O(n)
       //SpaceComplexity:O(1)
        HashMap<Character,Integer> map = new HashMap<>();
        int start =0;
        int max =0;
        for(int i =0; i<s.length();i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                start = Math.max(start,map.get(c)+1);
            }
            map.put(c,i);
            max = Math.max(max,i-start+1);
            
        }
        return max;
    }
}
