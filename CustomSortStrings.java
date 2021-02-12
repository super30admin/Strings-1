// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class CustomSortStrings {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        //edge
        if(T == null || T.length() == 0) return sb.toString();

        HashMap<Character, Integer> hash = new HashMap<>();

        for(int i = 0; i < T.length(); i++){
            //current char
            char c = T.charAt(i);
            hash.put(c, hash.getOrDefault(c,0) + 1);
        }


        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            //if in T's hashmap
            if(hash.containsKey(c)){

                int count = hash.get(c);
                //loop count times
                while(count > 0){
                    //put into the string
                    sb.append(c);
                    count --;
                }
                //remove from hashmap
                hash.remove(c);
            }
        }


        for(Map.Entry<Character, Integer> ent : hash.entrySet()){
            char c = ent.getKey();
            //count based on curr hashmap key value
            int count = ent.getValue();

            //loop count times
            while(count > 0){
                //put into the string
                sb.append(c);
                count --;
            }
        }
        return sb.toString();
    }
}