// Time Complexity :O(M+N) M is the String s length and N is Sring order length
// Space Complexity :O(1) As we are keepinh only 26 alphabates in HashMap
// Did this code successfully run on Leetcode :yes

class Solution {
    StringBuilder result = new StringBuilder();
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i =0; i< order.length();i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int j =0; j<count;j++){
                    result.append(c);
                }
            }
            map.remove(c);
        }
        for(char key : map.keySet()){
            int count = map.get(key);
                for(int j =0; j<count;j++){
                    result.append(key);
                }
        }
        return result.toString();
    }
}

// Time Complexity :O(N) length of the string
// Space Complexity :O(1) as we are keeping only alphabates in map
// Did this code successfully run on Leetcode :yes
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int slow =0;
        int max =0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(slow,map.get(c)); 
            }
                map.put(c,i+1);
                max = Math.max(max, i - slow +1);
        }
        return max;
    }
}
