class Solution {
    //Time Complexity:O(n)
    //Space Somplexity:O(1)
    public List<Integer> findAnagrams(String s, String p) {

        ArrayList<Integer> res= new ArrayList<>();
        int pLen = p.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i =0; i <pLen;i++){
            char c = p.charAt(i);
            map.put (c,map.getOrDefault(c,0)+1);
        }
        int match =0;
        
        for (int i =0; i < s.length();i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                int count = map.get(c);
                count--;
                if (count ==0)
                match++;
                map.put(c,count);
            }
            if (i >= pLen){
                int endPos = i - pLen;
                char endC = s.charAt(endPos);
             if (map.containsKey(endC)){
                int count = map.get(endC);
                count++;
                if (count ==1)
                match--;
                map.put(endC,count);
            }    
            }
            if (match == map.size()){
                res.add(i-pLen+1);
            }
        }
        return res;
    }
}
