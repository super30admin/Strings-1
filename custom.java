class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer>m=new HashMap<>();
        for(char c:s.toCharArray()){
            m.put(c,m.getOrDefault(c,0)+1);
        }
        StringBuilder sb=new StringBuilder();
        for(char c:order.toCharArray()){
            if(m.containsKey(c)){
                int times=m.get(c);
                for(int i=0;i<times;i++){
                    sb.append(c);
                }
                m.remove(c);
            }
        }
        for(char c:m.keySet()){
            int times=m.get(c);
            for(int i=0;i<times;i++){
                sb.append(c);
            }
        }
        return sb.toString();
        
    }
}