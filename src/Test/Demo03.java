package Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 华为笔试题编程：
 * 给定一组非负整数，重新排列元素使其成为最大整数
 * @author Young
 *
 */
public class Demo03{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {10,3,4};
		System.out.println(method(nums));
	}
	
	
	public static String method(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++) {
			list.add(nums[i]);
		}
		
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if((o1.toString()+o2.toString()).compareTo(o2.toString()+o1.toString())>0){
					return 1;
				}else{
					return -1;
				}
			}
		});
		
		String temp = "";
		while(!list.isEmpty()) {
			temp = temp+list.remove(list.size()-1);
		}
		return temp;
	}


}


