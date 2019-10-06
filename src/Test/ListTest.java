package Test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		//因为每个数值不一样所以每一个i都对应一个Integer对象
		for(int i=0;i<4;i++) {
			list.add(i);
		}
		List<Integer> list1 = new ArrayList<>();
		//Integer对象如果数字大小相同 debug时候 id一致  即引用一致指向同一个内存区域
		list1.add(1);
		list1.add(1);
		list1.add(2);
	}

}
