/**
 * Time: O(m+n) m, n length of the s,t strings
 * Space: O(n) n -length of string t
 */
class Solution {
    public String customSortString(String s, String t) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t.length();i++){
            if(!hmap.containsKey(t.charAt(i)))
                hmap.put(t.charAt(i),0);
            hmap.put(t.charAt(i),hmap.get(t.charAt(i))+1);
        }

        for(int i=0;i<s.length();i++){
            if(hmap.containsKey(s.charAt(i))){
                int cnt=hmap.get(s.charAt(i));
                while(cnt>0){
                    cnt--;
                    sb.append(s.charAt(i));
                }
                hmap.remove(s.charAt(i));
            }
        }
        for(Map.Entry<Character,Integer> e: hmap.entrySet()){
            int cnt = e.getValue();
            while(cnt>0){
                cnt--;
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}