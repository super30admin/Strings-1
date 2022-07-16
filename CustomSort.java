//TC - O(n)
//SC - O(n)
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            map.put(c , map.getOrDefault(c,0) + 1);
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i< order.length() ; i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                while(cnt > 0){
                    result.append(c);
                    cnt--;
                }
                map.remove(c);
            }
        }
        for(char key : map.keySet()){
            int cnt = map.get(key);
            while(cnt > 0){
                result.append(key);
                cnt--;
            }
        }
        return result.toString();
    }
}
