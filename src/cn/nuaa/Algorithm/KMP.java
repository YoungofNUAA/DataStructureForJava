package cn.nuaa.Algorithm;

import java.util.Arrays;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		int[] next = kmpNext(str2);
		System.out.println(Arrays.toString(next));
		System.out.println(kmpSearch(str1, str2, next));
	}
	
	public static int kmpSearch(String str1,String str2,int[] next) {
		for(int i=0,j=0;i<str1.length();i++) {
			
			while(j>0 && str1.charAt(i)!=str2.charAt(j)) {
				j = next[j-1];
			}
			
			if(str1.charAt(i)==str2.charAt(j)) {
				j++;
			}
			if(j==str2.length()) {
				return i-j+1;
			}
		}
		return -1;
	}

	//生成一个字符串的部分匹配值
	public static  int[] kmpNext(String dest) {
		int[] next = new int[dest.length()];
		next[0] = 0;  //一个字符的next=0
		for(int i=1,j=0;i<dest.length();i++) {
			//dest.charAt(i)!=dest.charAt(j) 需要从next[j-1]获取新的j
			//知道 dest.charAt(i)==dest.charAt(j)退出
			while(j>0 && dest.charAt(i)!=dest.charAt(j)) {
				j = next[j-1];
			}
			//dest.charAt(i)==dest.charAt(j)
			if(dest.charAt(i)==dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}
	
}
