package Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		//��Ϊÿ����ֵ��һ������ÿһ��i����Ӧһ��Integer����
		for(int i=0;i<4;i++) {
			list.add(i);
		}
		List<Integer> list1 = new ArrayList<>();
		//Integer����������ִ�С��ͬ debugʱ�� idһ��  ������һ��ָ��ͬһ���ڴ�����
		list1.add(1);
		list1.add(1);
		list1.add(2);
	}

}
