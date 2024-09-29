package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareTwoListOfListDemo {

	public static void main(String[] args) {

		List<List<Integer>> act = new ArrayList<List<Integer>>();
		List<Integer> a1 = Arrays.asList(1, 2, 3);
		List<Integer> a2 = Arrays.asList(4, 5, 6);
		List<Integer> a3 = Arrays.asList(7, 8, 9);
		List<Integer> a4 = Arrays.asList(10, 11, 12);
		act.add(a1);
		act.add(a2);
		act.add(a3);
		act.add(a4);
		System.out.println(act);
		
		List<List<Integer>> exp = new ArrayList<List<Integer>>();
		List<Integer> e1 = Arrays.asList(1, 2, 3);
		List<Integer> e4 = Arrays.asList(10, 11, 12);
		List<Integer> e2 = Arrays.asList(4, 5, 6);
		List<Integer> e3 = Arrays.asList(7, 8, 9);
		
		exp.add(e1);
		exp.add(e2);
		exp.add(e4);
		exp.add(e3);
		
		System.out.println(exp);
		
		
		
		System.out.println("\n---------------------\n");
		
		for(int i = 0 ; i < act.size() ; i++) {
			List<Integer> actList = act.get(i);
			System.out.println("actList: "+actList);
			
			int actFirstEle = actList.get(0);
			System.out.println("actEle: "+actFirstEle);
			
			List<Integer> expListFirstEles = exp.stream().map(ele-> ele.get(0)).collect(Collectors.toList());
			System.out.println("expListFirstEles: " + expListFirstEles);
			System.out.println("expEle: "+expListFirstEles.get(i));
			
			
			if(expListFirstEles.contains(actFirstEle)) {
				for(int j = 0 ; j < expListFirstEles.size() ; j++ ) {
					if(actFirstEle == expListFirstEles.get(j)) {
						List<Integer> expList = exp.get(j);
						System.out.println("actList: "+actList);
						System.out.println("expList: "+expList);
					}
				}
			}
			
			System.out.println("\n~~~~~~~~~~~~~~~\n");
		}
		
		
	}

}
