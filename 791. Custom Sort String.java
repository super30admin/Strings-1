class Solution {// time of O(S.len + T.len) and space of O(T.len)
    public String customSortString(String S, String T) {
        StringBuilder result = new StringBuilder();
        HashMap<Character,Integer> hmap = new HashMap<>();
        
        //Iterate the T to calculate the frequency
        for(int i = 0 ; i< T.length() ; i++){
            hmap.put(T.charAt(i), hmap.getOrDefault(T.charAt(i),0)+1);
        }
        //Iterate the S string
        for(int j = 0 ; j < S.length() ; j++){
            int freq = hmap.getOrDefault(S.charAt(i),0);
            while(freq > 0){
                result.append(S.charAt(i));
                freq--;
            }
            hmap.remove(S.charAt(i));
        }
        // Add chahracter that are not in S but in T
        for(Map.Entry<Character,Integer> entry: hmap.entrySet()){
            char ch = entry.getKey();
            int count = entry.getValue();
            while(count > 0){
                result.append(ch);
                count--;
            }
        }
        return result.toString();
    }
}