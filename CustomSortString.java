public class CustomSortString {
    public String customSortString(String order, String s) {
        int f[] = new int[26];
        for(char c: s.toCharArray())    f[c-'a']++;

        StringBuilder sb = new StringBuilder();

        for(char c: order.toCharArray()){
            if(f[c-'a']>0){
                while(f[c-'a']-->0)     sb.append(c);

            }
        }
        for(int i=0;i<26;i++){
            if(f[i]>0){
                char c = (char)('a'+i);
                while(f[i]-->0)     sb.append(c);
            }
        }
        return sb.toString();
    }
}
