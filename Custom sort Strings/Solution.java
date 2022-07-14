// Time Complexity: O(n)
// Space Complexity: O(lenght of input 's')
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<order.length();i++){
            Character c = order.charAt(i);
            int cnt=map.getOrDefault(c,0);
            while(cnt>0){
                res.append(c);
                cnt--;
            }
            map.remove(c);
        }
        
        for(Character key : map.keySet()){
            int cnt=map.get(key);
            while(cnt>0){
                res.append(key);
                cnt--;
            }
            // map.remove(key);
        }
    return res.toString();
    }
}
