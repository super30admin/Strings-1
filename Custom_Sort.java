// Time => O( s.length())
// Space => O(1)
class Solution {
    public String customSortString(String order, String s) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            map[curr - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < order.length(); i++){
            char curr = order.charAt(i);
            int size = map[curr - 'a'];
            for(int j = 0; j < size; j++){
                result.append(curr);
            }
            map[curr - 'a'] = 0;
        }

        for(int i = 0; i < map.length; i++){
            if(map[i] != 0){
                int size = map[i];
                char curr = (char) (i + 97);
                for(int j = 0; j < size; j++){
                    result.append(curr);
                }
            }
        }

        return result.toString();
    }
}
