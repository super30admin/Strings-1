// Time Complexity : O(M+N)
// Space Complexity: O(1) since 26 chars
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Take a stringbuilder, for the string, make a freq map
iterate over the order, and append the freq times to the string
append remaining characters not in order
*/
public class CustomSort {
    public String customSortString(String order, String s) {
        if(order==null || order.length()==0 || s==null || s.length()==0) return s;
        StringBuilder result= new StringBuilder();
        HashMap<Character,Integer> hm= new HashMap<>();

        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        for(char ch: order.toCharArray()){
            if(hm.containsKey(ch)){
                for(int i=0;i<hm.get(ch);i++)
                    result.append(ch);
                hm.remove(ch);
            }
        }

        if(hm.size()!=0){
            for(char ch: hm.keySet()){
                for(int i=0;i<hm.get(ch);i++)
                    result.append(ch);
            }
        }

        return result.toString();
    }
}
