//T.C: O(M+N); Mis length of s, N is length of p
//S.C: O(1)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        int match=0;
        if(s == null || s.length() == 0 || p == null || p.length() == 0){
            return result;
        }

        for(int i=0;i<p.length();i++){
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1);
        }

        for(int i=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0){
                    match++;
                }
            }


            if(i>p.length()-1){
                if(map.containsKey(s.charAt(i-p.length()))) {
                    map.put(s.charAt(i-p.length()), map.get(s.charAt(i-p.length()))+1);
                    if(map.get(s.charAt(i-p.length())) == 1){
                        match--;
                    }
                }

            }

            if(match == map.size()){
                result.add(i+1-p.length());
            }
        }
        return result;
    }
}