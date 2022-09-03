//TC - O(n);
//SC - O(1);
//LC- 3
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        HashMap<Character,Integer> map = new  HashMap<Character,Integer>();
        int start=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)) && start <= map.get(s.charAt(i))){
                start = map.get(s.charAt(i))+1;
            }
            else{
                max = Math.max(max,i-start+1);
            }
            
            map.put(s.charAt(i),i);
            
        }
        return max;
    }
}