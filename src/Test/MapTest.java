package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s= "()";
		System.out.println(isValid(s));
	}

    public static boolean isValid(String s) {
        if(s==""){
            return true;
        }
        
        Map<String,String> map = new HashMap<String,String>();
        map.put(")","(");
        map.put("}","{");
        map.put("]","[");
        
        Stack<String> stack = new Stack<String>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(""+s.charAt(i))){
                String top = (stack.isEmpty())? "#":stack.pop();
                if(!top.equals(map.get(""+s.charAt(i)))){
                	System.out.println(map.get(""+s.charAt(i)));
                    return false;
                }
            }else{
                stack.push(""+s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
