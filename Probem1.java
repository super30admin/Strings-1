//time o(n)
//space o(1)

class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        
        for(char c: s.toCharArray()) {
            count[c-'a'] = count[c-'a']+1;
        }
        
        System.out.print(Arrays.toString(count));
        StringBuilder res = new StringBuilder();
        
        for(char ch: order.toCharArray()) {
            int c = count[ch-'a'];
            //System.out.println(c);
            for(int i=0;i<c;i++) {
                res.append(ch);
            }
            count[ch-'a'] = 0;
        }
        
        for(char c = 'a'; c<= 'z'; c++) {
            //if(count[c - 'a'] > 0)
                
                //res.append(c);
            for(int i=0; i<count[c-'a']; i++) {
                res.append(c);
            }
        }
        
        return res.toString();
    }
}
