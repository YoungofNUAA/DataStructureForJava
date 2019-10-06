package Test;

public class LeetCode242 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "anagram";
//		String t = "nagaram";
//		System.out.println(isAnagram(s, t));
		System.out.println(reverse(-123));
		int n = 123;
		System.out.println(n<<1);
	}

	public static boolean isAnagram(String s,String t) {
		if(s.length()!=t.length()) {
			return false;
		}
		int[] alpha = new int[26];
		for(int i =0;i<s.length();i++) {
			alpha[s.charAt(i)-'a']++;
			alpha[t.charAt(i)-'a']--;
		}
		for(int j=0;j<26;j++) {
			if(alpha[j]!=0) {
				return false;
			}
		}
		return true;
	}
	 public static int reverse(int x) {
	        int rev = 0;
	        while (x != 0) {
	            int pop = x % 10;
	            x /= 10;
	            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
	            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
	            rev = rev * 10 + pop;
	        }
	        return rev;
	    }

}
