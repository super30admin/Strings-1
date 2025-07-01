class Solution {
    public String customSortString(String order, String s) {
        StringBuilder output = new StringBuilder();
        //frequency map to store count of characters in string s
        HashMap<Character,Integer>map = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch , 1);
            }
            else{
                map.put(ch , map.get(ch) + 1);
            }
        }
        //we will iterate through every character in order
        for(char curr : order.toCharArray()){
            if(map.containsKey(curr)){
                int freq = map.get(curr);
                for(int i = 0 ; i < freq ; i++){
                    output.append(curr);
                }
                map.remove(curr);
            }

        }
        //append remaining characters from string s to the output
        for(char ch : map.keySet()){
            int freq = map.get(ch);
            for(int i = 0 ; i < freq ; i++){
                output.append(ch);
            }
        }
        return output.toString();

    
        
    }
}