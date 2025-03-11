import java.util.Arrays;
//complexity=O(N) time and O(1) space.
public class LengthOfLongestSubstringUniqueChar {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int slow=0;
        int maxLength=0;
        int n=s.length();
        int[] arr=new int[100];
        Arrays.fill(arr,-1);
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(arr[ch-' ']!=-1){
                slow=Math.max(slow,arr[ch-' ']+1);
            }
            arr[ch-' '] =i;
            maxLength=Math.max(maxLength,i-slow+1);
        }
        return maxLength;
    }
}
