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
		hashset1.add("����");
		hashset1.add("�Ϻ�");
		hashset1.add("���");
		
		HashSet<String> hashset2 = new HashSet<String>();
		hashset2.add("����");
		hashset2.add("����");
		hashset2.add("����");
		
		HashSet<String> hashset3 = new HashSet<String>();
		hashset3.add("�ɶ�");
		hashset3.add("�Ϻ�");
		hashset3.add("����");
		
		HashSet<String> hashset4 = new HashSet<String>();
		hashset4.add("�Ϻ�");
		hashset4.add("���");
	
		HashSet<String> hashset5 = new HashSet<String>();
		hashset5.add("����");
		hashset5.add("����");
		
		broadcasts.put("K1", hashset1);
		broadcasts.put("K2", hashset2);
		broadcasts.put("K3", hashset3);
		broadcasts.put("K4", hashset4);
		broadcasts.put("K5", hashset5);
		
		HashSet<String> allAreas = new HashSet<String>();
		allAreas = getAllAreas(broadcasts);
		System.out.println(allAreas);
//		HashSet<String> allAreas = new HashSet<String>();
//		allAreas.add("����");
//		allAreas.add("�Ϻ�");
//		allAreas.add("���");
//		allAreas.add("����");
//		allAreas.add("����");
//		allAreas.add("�ɶ�");
//		allAreas.add("����");
//		allAreas.add("����");
		
		List<String> selects = new ArrayList<String>();
		HashSet<String> tempSet = new HashSet<String>();
		String maxKey = null;
		while(allAreas.size()!=0) {
			maxKey = null;
			for(String key:broadcasts.keySet()) {
				tempSet.clear();
				HashSet<String> areas = broadcasts.get(key);
				tempSet.addAll(areas);
				tempSet.retainAll(allAreas);  //ȡ��tempSet��AllAreas�Ľ��� �����ظ�tempSet
				//�����ǰ���ϰ�����δ���ǵ�����������maxKeyָ���δ���ǵ�������
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

	//�������г��� ����Set���ϲ�������ظ�Ԫ�ص�����
	public static HashSet<String> getAllAreas(Map<String,HashSet<String>> broad){
		HashSet<String> set = new HashSet<String>();
		for(String key:broad.keySet()) {
			set.addAll(broad.get(key));
		}
//		System.out.println(set);
		return set;
		
	}
}
