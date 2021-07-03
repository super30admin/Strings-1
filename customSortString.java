//time complexity O(n) where n is the length of string T. We can ignore the iteration over string S for time complexity because that's constant i.e. 26
//space complexity O(1) since again map will at most have size 26

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < T.length(); i++){
            Character c = T.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            } else{
                map.replace(c, map.get(c) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < S.length(); j++){
            Character c = S.charAt(j);
            if(map.containsKey(c)){
                int numOcc = map.get(c);
                for(int k = 0; k < numOcc; k++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for(Map.Entry<Character, Integer> mapElement : map.entrySet()) {
            int count = mapElement.getValue();
            Character c = mapElement.getKey();
            for(int i = 0; i < count; i++){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
