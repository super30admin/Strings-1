// Time Complexity : 0(S.len + T.len)
// Space Complexity : 0(1) as we will have constant(26) space for map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class CustomSort {
    public String customSortString(String S, String T) {
        //initiate map for storing character and it's frequency
        HashMap<Character, Integer> map = new HashMap<>();

        //iterate through string T to find characters & their frequency
        for(int i=0;i<T.length();i++){
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        //iterate through S to get sorting order
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }

        //putting rest of the characters (not present in S) from T in stringbuilder
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            int count = entry.getValue();
            char c = entry.getKey();
            while(count > 0){
                sb.append(c);
                count--;
            }
        }

        return sb.toString();

    }
}