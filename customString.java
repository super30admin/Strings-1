/*Running Time Complexity: O(n)
Space Complexity: constant or only 26 alphabets
Successfully Run and Compiled on leetcode

*/
class Solution {
    public String customSortString(String order, String str) {
        if(order.length()==0 || str.length()==0) return null;
        HashMap<Character, Integer> hmap = new HashMap<>();
        //insert the str in hmap with index number
        for(int i = 0; i<str.length();i++){
            char c = str.charAt(i);
            hmap.put(c,hmap.getOrDefault(c,0) + 1);
        }
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<order.length();i++){
            char c = order.charAt(i);
            if(hmap.containsKey(c)){
                int count = hmap.get(c);
                while(count!=0){
                    s.append(c);
                    count--;
                }
                hmap.remove(c);
            }
            
        }
        for(char c : hmap.keySet()){
            int count = hmap.get(c);
            while(count!=0){
                 s.append(c);
                count--;
            }
           
        }
        
     return s.toString();   
    }
}