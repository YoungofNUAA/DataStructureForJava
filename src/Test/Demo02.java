package Test;

import java.awt.HeadlessException;
/**
 * ��Ϊ��������
 * ԭ��ip��ַ��ÿ�ο��Կ�����һ��0-255����������ÿ�β�ֳ�һ����������ʽ���������Ȼ��������������ת���
һ����������
 * @author Young
 *
 */
public class Demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "10.0.3.193";
		System.out.println(IPtoNums(str));
	}

	public static String IPtoNums(String str) {
		String[] StrNums = str.split("\\.");
		int[] nums = new int[4];
		int[] bits = new int[32];
		int sum = 0;
		for(int i=0;i<nums.length;i++) {
			nums[i] = Integer.parseInt(StrNums[i]);
		}
		sum =(int) (nums[0]*Math.pow(2, 24)+nums[1]*Math.pow(2, 16)+nums[2]*Math.pow(2, 8)+nums[3]);
		for(int j=0;j<nums.length;j++) {
			System.out.println(Integer.toBinaryString(nums[j]));
		}
		
		return ""+sum;
	}
	
}
