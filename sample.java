class Solution {
    public String customSortString(String order, String s) {
        
        Map<Character, Integer> m = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<order.length();i++) {
            if(m.containsKey(order.charAt(i))) {
                int freq = m.get(order.charAt(i));
                for(int j=0;j<freq;j++) {
                    sb.append(order.charAt(i));
                }
                m.remove(order.charAt(i));
            }
        }

        for (Character c : m.keySet())  {
            int freq = m.get(c);
            for(int j=0;j<freq;j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int start=0;
        Map<Character, Integer> m = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            if(!m.containsKey(s.charAt(i))) {
                m.put(s.charAt(i), i+1);
            } else {
                start = Math.max(start, m.get(s.charAt(i)));
                m.put(s.charAt(i), i+1);
            }
            max = Math.max(max, i-start+1);
        }
        return max;

    }
}
