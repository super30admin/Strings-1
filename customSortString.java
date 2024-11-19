class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c =order.charAt(i);
            for(int j=0;j<map.getOrDefault(c,0);j++){
                res.append(c);
            }
            map.remove(c,map.get(c));
        }
        for(char c:map.keySet()){
            for(int i=0;i<map.get(c);i++){
                res.append(c);
            }
        }
        return res.toString();
    }
}
