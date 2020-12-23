/**
 * TC : O(N) SC: O(N)
 * Approach: map the frequency of the target string, now iterate over the chars of the source string and if found in the map add to the result
 *           reducing the frequency. At the end empty the map appending all the remaining element.
 */
class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : T.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder s = new StringBuilder();
        for(char c : S.toCharArray()){
            if(map.containsKey(c)){
                int t = map.get(c);
                while(t > 0){
                    s.append(c);
                    t--;
                }
                map.put(c,t);
            }
        }
        
        for(Character c : map.keySet()){
            int t = map.get(c);
            while(t > 0){
                s.append(c);
                t--;
            }
        }
        return s.toString();
    }
}