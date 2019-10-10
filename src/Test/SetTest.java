package Test;

import java.util.HashSet;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("1");
		set.add("2");
		set.add("3");
		System.out.println(set);
	}

}
