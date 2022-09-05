// Time - O(n)
// Space - O(n)

class Solution {
    HashMap<Character,Integer> hm = new HashMap();
    public int lengthOfLongestSubstring(String s) {
        int j=0;
        int i=0;
        int max = 0;
        while(j<s.length()){
            char ch = s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.get(ch)>1){
                max = Math.max(max, j-i);
                char ch1 = s.charAt(i);
                hm.put(ch1,hm.get(ch1)-1);
                i++;   
            }
            j++;
        }
        return Math.max((j-i),max);
    }
}
