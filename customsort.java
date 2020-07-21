//Time complexity:O(n) Length of T
//Space complexity:O(1)

class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb=new StringBuilder();
        Map<Character,Integer> map=new HashMap();
        for(char c:T.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char c:S.toCharArray()){
            if(map.containsKey(c)){
                int count=map.get(c);
                for(int i=0;i<count;i++){
                    sb.append(c);
                }
                map.remove(c);    
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            char c=entry.getKey();
            int times=entry.getValue();
            for(int i=0;i<times;i++){
                sb.append(c);
            }
        }
        return sb.toString();
        
    }
}