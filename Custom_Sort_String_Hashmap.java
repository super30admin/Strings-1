TC: O(T.length())
 SC: O(T.length())
 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Custom Sort String.
Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Custom Sort String.
 
 Approach: First we take the count of T characters in count array. Then we traverse through the S array and append all characters by the 
 number of times they are in T array to a new String. Then we append the characters that are in T but not in S to the end.
 


class Solution {
    public String customSortString(String S, String T) {
       if(S.length()==0 || S== null || T.length() ==0 || T==null)
           return T;
       Map<Character,Integer> map = new HashMap<>();
       for(char c: T.toCharArray())
               map.put(c,map.getOrDefault(c,0)+1);
       StringBuilder result = new StringBuilder();
       for(char c: S.toCharArray()) {
           if(map.containsKey(c)){
               for(int i=0; i<map.get(c);i++){
                   result.append(c);
               }
               map.remove(c);
           }
       }
        for(char c: map.keySet()){
            for(int i=0;i<map.get(c); i++)
                result.append(c);
        }
        
    return result.toString();
    }
}
