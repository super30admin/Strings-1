// Time Complexity : O(n) where n is length of T
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No

// Your code here along with comments explaining your approach: Store the count of each Character of the String t in the HashMap. First 
// iterate through the String S and check the count of each character in the HashMap and add that many times to our result. Also remove 
// character from the HashMap. Now, just iterate throuh the keyset of the remaining hashmap and add it to the result.

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<T.length();i++){
            char c= T.charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);            
            
        }
        for(int j=0;j<S.length();j++){
            char c = S.charAt(j);
            if(map.containsKey(c)){
                int times = map.get(c);
                while(times!=0){
                    result.append(c);
                    times--;
                }
                map.remove(c);
            }
            
        }
        for(char c : map.keySet()){
            if(map.containsKey(c)){
                int times = map.get(c);
                while(times!=0){
                    result.append(c);
                    times--;
                }
            }
        }
        return result.toString();
    }
}