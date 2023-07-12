//Time Complexity: O(N) length of string
//Space Complexity: O(N)
//Using concatenation
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        String output = "";
        for(int i =0 ; i< s.length() ; i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i =0; i < order.length(); i++){
            char b = order.charAt(i);
            if(map.containsKey(b)){

                int k = map.get(b);
                while(k !=0){
                    output += b;
                    k--;
                }
                map.remove(b);
            }
        }

        // String z = String(map.values());
        // if(!map.isEmpty()){
        for(char c : map.keySet()){
            int k = map.get(c);
            while(k !=0){
                output += c;
                k--;
            }
            // map.remove(c); // shouldn't remove this because we will be removing the element from hashmap on which iteration is being going on, so error will pop up(run time error)

            // }
        }
        // output += z;

        return output;
    }
}