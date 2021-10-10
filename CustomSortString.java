// Time Complexity : O(M+N) where N is length of String s and M is Length of string order;
// Space Complexity : O(N) appending characters in StringBuilder
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Three line explanation of solution in plain english: Create a frequesncy map by iterating over String s.
// Then iterate through the order string and form the string to return in the required order using the frequency map and then also append the
// remaining characters in the frequency map which don't have order restrictions to the String and then return.


class CustomSortString {
    public String customSortString(String order, String s) {
        Map<Character, Integer> hms = new HashMap<>();

        // for(int i = 0 ; i < s.length() ; i++){
        //     if(hms.containsKey(s.charAt(i))){
        //         hms.put(s.charAt(i), hms.get(s.charAt(i))+1);
        //     }else{
        //         hms.put(s.charAt(i), 1);
        //     }
        // }

        //anotherway to build a freq map

        for(int i = 0 ; i < s.length() ; i++){ //Creating a freq map - O(N)
            char c = s.charAt(i);
            hms.put(c, hms.getOrDefault(c,0)+1);
        }

        StringBuilder sb = new StringBuilder(); //SC: O(n)
        int n = 0;
        for(int j = 0 ; j < order.length() ; j++){ //iterating over the order str O(M)

            if(hms.containsKey(order.charAt(j))){
                n = hms.get(order.charAt(j));

                for(int k = 0 ; k < n ; k++){
                    sb.append(order.charAt(j));
                }

                hms.remove(order.charAt(j));
            }
        }

        if(!hms.isEmpty()){
            for(Map.Entry<Character, Integer> entry: hms.entrySet()){
                char c = entry.getKey();
                int l = entry.getValue();

                for(int m = 0 ; m < l ; m++){
                    sb.append(c);
                }
            }
        }

        //alternate to iteratimg the map like above
        // for(char c: hm.keySet()){
        //     int cnt = hm.get(c);
        //     while(cnt > 0){
        //         sb.append(c);
        //         cnt--;
        //     }
        // this will cause "ConcurrentModifictaionexception" as you are trying to iterate through the map  and emove elements at the same time.
        //hms.remove();

        // }

        return sb.toString();


    }
}