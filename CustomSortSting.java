//TC:O(m+n)
//SC:O(m+n)
//Intuit
//Compute a frequency map of characters given in T, use HashMap to store it.Now Iterating over characters in S, we get the desired ordering, put as many copies,as its frequency into the String Builder. Once done, copy remaining letters into the builder.These are the ones for whom we dont have any preference as they are missing in S.Eventually, return the string contained in the StringBuilder.
class Solution {
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0)return s;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){//Iterating over the string
            char c= s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);
            int cnt = 0;
            if(map.containsKey(c)){
                cnt = map.get(c);
                map.remove(c);
            }
            while(cnt>0){
                sb.append(c);
                cnt--;
            }
        }
        for(char key:map.keySet()){
            int cnt = map.get(key);
            while(cnt>0){
                sb.append(key);
                cnt--;
            }
        }
        return sb.toString();
    }
}