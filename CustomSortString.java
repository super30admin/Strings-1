//Time Complexity:O(m+n), m - length of order, n - length of s
//Space Complexity:O(1)
//Use hashmap for mapping freq in given string, compare with order string and add remaining 
class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        //get the freq of characters
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
           map.put(c,map.getOrDefault(c,0)+1);
        }
        //add the charcters from order string
        for(int i =0;i<order.length();i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int freq = map.get(c);
                while(freq>0){
                    sb.append(c);
                    freq--;
                }
                map.remove(c);
            }
        }
        //
        for(char c:map.keySet())
        {
            int freq = map.get(c);
                while(freq>0){
                    sb.append(c);
                    freq--;
                }
        }

        return sb.toString();

    }
}