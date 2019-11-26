//Time Complexity: O(n), where n is the length of string T.
//Space Complexity: O(n)
/*Approach: 
-> Put all the characters of T in a HashMap along with the count of their occcurences, now iterated through string S.
-> Appended the characters of S to the resultant string, and the extra unique chaarcters in T are also added to the resultant string.*/

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T.length();i++){
            char c = T.charAt(i);
            if(map.containsKey(c)){
                map.replace(c,map.get(c),map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        for(int i=0;i<S.length();i++){
            char k = S.charAt(i);
            if(map.containsKey(k)) {
                while(map.get(k)>0){
                    sb.append(k); map.replace(k,map.get(k),map.get(k)-1);
                }
            }
        }
        for(Character z:map.keySet()){
            if(map.get(z)>0){
                while(map.get(z)>0){
                    sb.append(z); map.replace(z,map.get(z),map.get(z)-1);
                }
            }
        }
        return sb.toString();
    }
}
