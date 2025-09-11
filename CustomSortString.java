class Solution {
    //Idea is to use a hashmap to track the characters and use them to construct a new string 
    //to follow the given string order
    //Time Complexity:O(m)
    //Space Complexity:O(m)
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<order.length();i++)
        {
            if(hm.containsKey(order.charAt(i)))
            {
                char ch = order.charAt(i);
                int count = hm.get(order.charAt(i));
                while(count>0)
                {
                    sb.append(ch);
                    count--;
                }
                hm.remove(ch);

            }
        }

        for(char c : hm.keySet()){
            int cnt = hm.get(c);
            for(int k=0; k<cnt; k++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}