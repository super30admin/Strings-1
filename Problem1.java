// Time Complexity : O(N)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : no


class Problem1{
    public String customSortString(String order, String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);


        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){

                int count = map.get(c);
                for(int k=0; k<count; k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }

        //to get all the remaining characters
        for(Character c : map.keySet()){

            int count = map.get(c);
            for(int k =0; k<count; k++){
                sb.append(c);
            }

        }
        return sb.toString();
    }
}