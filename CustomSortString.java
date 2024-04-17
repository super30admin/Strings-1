//TC: O(n) -> )(n+m) where n: length of s and m: lenght of order 
//SC: O(1) as max can be O(26)
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
           map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder out = new StringBuilder();
        int cnt;
        for(int i = 0; i<order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c) ){
                cnt = map.get(c);
                while(map.get(c)!=0){
                    out.append(c);
                    cnt--;
                    map.put(c,cnt);
                } 
                map.remove(c); 
            }
        }
        for(char c: map.keySet()){
            cnt = map.get(c);
            for(int k =0; k< cnt; k++){
                out.append(c);
            }
        }
        return out.toString();
    }
}