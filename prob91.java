class Solution {
    public String customSortString(String S, String T) {
        //if(S==null||S.length()==0||T==null||T.length()==0) return T;
        
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:T.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
                    
        StringBuilder result = new StringBuilder();
        for(char c : S.toCharArray()){
            if(map.containsKey(c)){
                for(int i=0;i<map.get(c);i++)
                    result.append(c);
            }
            map.remove(c);
        }
        for(char c:map.keySet()){
            for(int i=0;i<map.get(c);i++)
                result.append(c);
        }
        return result.toString();
    }
}