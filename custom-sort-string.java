//HashMap, to store char from 'source'(key) and it's frequency(value)
//Time complexity = O(n)
//Space complexity = O(n), using StringBuilder

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        //Compute frequencies of each character in s
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c, map.get(c)+1);
        }
        for(int i = 0; i<order.length(); i++){
            char ch = order.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                for(int k = 0; k<count; k++){
                    sb.append(ch);
                }
                map.remove(ch); //we are not iterating over map here
            }
        }
        for(char ch: map.keySet()){
            int count = map.get(ch);
            for(int k = 0; k<count; k++){
                sb.append(ch);
            }
            //map.remove(ch); this fails //we're iterating over map at line 26 //don't modify the data structure we are iterating over
        }
        return sb.toString();
    }
}