package cn.nuaa.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GreedyAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,HashSet<String>> broadcasts = new HashMap<String,HashSet<String>>();
		HashSet<String> hashset1 = new HashSet<String>();
		hashset1.add("北京");
		hashset1.add("上海");
		hashset1.add("天津");
		
		HashSet<String> hashset2 = new HashSet<String>();
		hashset2.add("广州");
		hashset2.add("北京");
		hashset2.add("深圳");
		
		HashSet<String> hashset3 = new HashSet<String>();
		hashset3.add("成都");
		hashset3.add("上海");
		hashset3.add("杭州");
		
		HashSet<String> hashset4 = new HashSet<String>();
		hashset4.add("上海");
		hashset4.add("天津");
	
		HashSet<String> hashset5 = new HashSet<String>();
		hashset5.add("杭州");
		hashset5.add("大连");
		
		broadcasts.put("K1", hashset1);
		broadcasts.put("K2", hashset2);
		broadcasts.put("K3", hashset3);
		broadcasts.put("K4", hashset4);
		broadcasts.put("K5", hashset5);
		
		HashSet<String> allAreas = new HashSet<String>();
		allAreas = getAllAreas(broadcasts);
		System.out.println(allAreas);
//		HashSet<String> allAreas = new HashSet<String>();
//		allAreas.add("北京");
//		allAreas.add("上海");
//		allAreas.add("天津");
//		allAreas.add("广州");
//		allAreas.add("深圳");
//		allAreas.add("成都");
//		allAreas.add("杭州");
//		allAreas.add("大连");
		
		List<String> selects = new ArrayList<String>();
		HashSet<String> tempSet = new HashSet<String>();
		String maxKey = null;
		while(allAreas.size()!=0) {
			maxKey = null;
			for(String key:broadcasts.keySet()) {
				tempSet.clear();
				HashSet<String> areas = broadcasts.get(key);
				tempSet.addAll(areas);
				tempSet.retainAll(allAreas);  //取出tempSet和AllAreas的交集 并返回给tempSet
				//如果当前集合包含的未覆盖地区的数量比maxKey指向的未覆盖地区还多
				if(tempSet.size()>0 && (maxKey==null || tempSet.size()>broadcasts.get(maxKey).size())) {
					maxKey = key;
				}
			}
			if(maxKey!=null) {
				selects.add(maxKey);
				allAreas.removeAll(broadcasts.get(maxKey));
			}
		}
		
		System.out.println(selects);
	}

	//返回所有城市 利用Set集合不能添加重复元素的性质
	public static HashSet<String> getAllAreas(Map<String,HashSet<String>> broad){
		HashSet<String> set = new HashSet<String>();
		for(String key:broad.keySet()) {
			set.addAll(broad.get(key));
		}
//		System.out.println(set);
		return set;
		
	}
}
