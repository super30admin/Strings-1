/**
LeetCode Submitted : YES
Space Complexity : O(Constant) only characters
Time Complexity : O(length of S) + O(length of T)

The idea is to store character and frequency of each characters in the hash map for string T. Then iterate each charcters in S if it finds in hashmap append to final results with the frequency time and lastly add those characters remaining in the hashmap.
**/
class Solution {
    public String customSortString(String S, String T) {
        StringBuffer results = new StringBuffer();
        HashMap<Character,Integer> count = new HashMap<>();
        
        //Implement counter for T String
        for(int i = 0; i<T.length();i++){
            char  c = T.charAt(i);
            if(count.containsKey(c)){
                count.put(c,count.get(c) + 1);
            }else{
                count.put(c,1);
            }
        }
        
        
        //Now iterate for "S" String to find the exact matching pattern with "T" String
        
        for(int i = 0; i<S.length();i++){
            char  c = S.charAt(i);
            //If Character present in counter hash map
            if(count.containsKey(c)){
                int num = count.get(c);
                while(num > 0){
                    results.append(c);
                    num--;
                }
                count.remove(c);
            }
        }
        
        //Iterate remaining characters in Counter Map
        
        for (Map.Entry<Character,Integer> entry : count.entrySet()){
            char c = entry.getKey();
            int num = entry.getValue();
            while(num > 0){
                    results.append(c);
                    num--;
            } 
        }
        
        return results.toString(); 
    }
}
