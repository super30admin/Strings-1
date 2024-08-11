# Strings-1

## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> hmap=new HashMap<>();
        for(Character c:s.toCharArray()){
            if(hmap.containsKey(c)){
                hmap.put(c,hmap.get(c)+1);
            }
            else
                hmap.put(c,1);
        }
        StringBuilder sb=new StringBuilder();
        for(Character d:order.toCharArray()){
            if(hmap.containsKey(d)){
                for(int i=hmap.get(d);i>0;i--)
                    sb.append(d);
                hmap.put(d,0);
            }
        }
        for(Character c:s.toCharArray()){
            if(hmap.get(c)>0)
                for(int i=hmap.get(c);i>0;i--){
                    sb.append(c);
                }
            hmap.put(c,0);
        }
        return String.valueOf(sb);
    }
}

## Problem2 

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashSet<Character> hset=new HashSet<>();
        // int sl=0,maxi=0;
        // for(int i=0;i<s.length();i++)
        // {
        //     char c=s.charAt(i);
        //     if(hset.contains(c)){
        //         while(s.charAt(sl)!=c){
        //             hset.remove(s.charAt(sl));
        //             sl++;
        //         }
        //         sl++;
        //     }
        //     hset.add(s.charAt(i));
        //     maxi=Math.max(maxi,hset.size());
        // }
        // return maxi;  
        
        HashMap<Character,Integer> hmap=new HashMap<>();
        int sl=0,maxi=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(hmap.containsKey(c)){
                sl=Math.max(sl,hmap.get(c)+1);
            }
            hmap.put(c,i);
            maxi=Math.max(maxi,i-sl+1);
        }
        return maxi;
    }
}