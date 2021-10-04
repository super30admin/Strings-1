// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// set all the string element in to the hash map and then based on the apperance of in the order put it in the sb
// Your code here along with comments explaining your approach
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for( int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c,0)+1);
        }
        StringBuilder  sb = new StringBuilder();
        for( int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            if(hm.containsKey(c)){
                int cnt = hm.get(c);
                while(cnt>0){
                    sb.append(c);
                    cnt--;
                }
                hm.remove(c);
            }
        }
        for(char c: hm.keySet()){
            int cnt = hm.get(c);
            while(cnt>0){
                sb.append(c);
                cnt--;
            }
        }
        return sb.toString();
    }
}

// class Solution {
//     public String customSortString(String order, String s) {
//         StringBuilder sb = new StringBuilder();
//         for(int i = 0; i < order.length(); i++){
//             if(s.contains(Character.toString(order.charAt(i)))){
//                 sb.append(order.charAt(i));
//             }
//         }
//         for( int i= 0; i < s.length(); i++){
//             if(sb.indexOf(Character.toString(s.charAt(i))) == -1){
//                 sb.append(s.charAt(i));
//             }
//         }
//         return sb.toString();
//     }
// }