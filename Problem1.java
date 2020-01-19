// Time Complexity - O(m+n) where m is the length of T and n is the length of S
// Space Complexity - O(1) since the maximum space used by the hashmap will be for 26 characters

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : T.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);           // Put the characters in the T String in Hashmap; default with 0 if does not exist else increment the value by 1; O(m) time time complexity
        }
        for(char c : S.toCharArray()){      // Iterate through the String S and whichever characters exist in the HashMap add it to the StringBuilder
            if(map.containsKey(c)){
                int count = map.get(c);     
                while(count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){ // The remaining characters of T in the Hashmap which S does not contain will be left and need to be added to the StringBuilder
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
