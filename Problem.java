
//Time Complexity: O(n+m) where n is the length of order and m is the length of s
//Space Complexity: O(1) since the hashmap will store at most 26 characters

//we first store the frequency of each character in s in a hashmap
//then we iterate through the order string and for each character in order we append it to the result string
//as many times as it appears in s and remove it from the hashmap   
//finally we append the remaining characters in the hashmap to the result string

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        StringBuilder sb=new StringBuilder();

        for(char c:order.toCharArray()){
            if(map.containsKey(c)){
                int freq=map.get(c);
                while(freq!=0){
                    sb.append(c);
                    freq--;
                }
                map.remove(c);
            }
        }
        for(char c:map.keySet()){
            int freq=map.get(c);
            while(freq!=0){
                sb.append(c);
                freq--;
            }
        }
        return sb.toString();
    }
}