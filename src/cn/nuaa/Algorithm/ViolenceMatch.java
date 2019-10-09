package cn.nuaa.Algorithm;
/**
 * 暴力解决字符串匹配问题
 * @author Young
 *
 */
public class ViolenceMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "Hello welcome to my land,i love you";
		String str2 = "i love you";
		System.out.println(violencematch(str1, str2));
	}

	public static int violencematch(String str1,String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		int s1Len = s1.length;
		int s2Len = s2.length;
		
		int i = 0;
		int j = 0;
		while(i<s1Len && j<s2Len) {
			if(s1[i] == s2[j]) {
				i++;
				j++;
			}else {
				i = (i-(j-1));
				j = 0;
			}
		}
		if(j==s2Len) {
			return i-j;
		}else {
			return -1;
		}
	}
}
