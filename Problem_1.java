//Time Complexity:O(t.length)
//space Complexity:O(1) since s length is constant and map size is max 26
class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<T.length();i++){
            char c =T.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        String s="";
        for(int i=0;i<S.length();i++){
            char c =S.charAt(i);
            if(map.containsKey(c)){
                int count =map.get(c);
            while(count>0){
                s=s+c;
                count--;
            }
            map.remove(c);
            }
        }
        for(char c: map.keySet()){
            int count =map.get(c);
            while(count>0){
                s=s+c;
                count--;
            }
        }
        return s;
    }
}