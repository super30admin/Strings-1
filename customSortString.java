/*time complexity O(m+n) m=len of S, n=len of T
space complexity O(n) due to string builder
approach: build a hashmap for T then iterate over char of S if found then append into result those many characters and remove from map
after that append all other char remained in T into result
*/


class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb=new StringBuilder();
        HashMap<Character, Integer> map=new HashMap<>();
        if(T==null || T.length()==0){
            return sb.toString();
        }for(int i=0;i<T.length();i++){
            char c=T.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            if(map.containsKey(c)){
                int count=map.get(c);
                while(count>0){
                    sb.append(c);
                    count--;
                }
            }
            map.remove(c);
        }
        for(char c:map.keySet()){
            int count=map.get(c);
            while(count>0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}