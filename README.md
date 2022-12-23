# Strings-1

## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s==null || s.length()==0 || p.length()>s.length()){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int match = 0;
        
        for(int i =0;i < p.length();i++){
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for(int i =0; i < s.length(); i++){
            char incoming = s.charAt(i);
            if(map.containsKey(incoming)){
                int cnt = map.get(incoming);
                cnt--;
                if(cnt == 0);{
                    match++;
                }
                map.put(incoming, cnt);             
            }
            
            if(i >= p.length()){
                char outgoing = s.charAt(i - p.length());   
                
                if(map.containsKey(outgoing)){
                    int cnt = map.get(outgoing);
                    cnt++;
                    if(cnt ==1){
                        match--;
                    } 
                    map.put(outgoing,cnt);
                }
            }
            if(match == map.size()){
                result.add(i - p.length() + 1);
            }
        }
            return result;
        }
    }
  
  Time complexity : O(n)
  Space complexity : O(1)



## Problem2 

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()== 0) return 0;
        
        int max=0;
        HashMap<Character,Integer> map = new HashMap<>();
        int start =0;
        
        for(int i =0; i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c));
            }
            map.put(c,i+1);
            max= Math.max(max,i-start+1);
        }
        return max;
    
        
    }
}
Time complexity : O(n)
Space complexity : O(1)
