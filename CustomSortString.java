
public class CustomSortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] pattern = "cba".toCharArray(); 
        char[] s = "abcd".toCharArray(); 
        customSortString(s, pattern); 
        System.out.println(String.valueOf(s));

	}
	public static void customSortString(char[] s, char[] pattern) {
		int[] count = new int[26];
		
		for(int i = 0; i < s.length; i++) {
			count[s[i] - 'a']++;
		}
		int index = 0;
		for(int i = 0; i<pattern.length;i++) {
			for(int j = 0; j < count[pattern[i]- 'a']; j++) {
				s[index++] = pattern[i];
			}
		}
	}
}
