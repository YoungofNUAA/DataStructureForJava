package Test;
/**
 * 有一个N阶楼梯，每次可以爬一层 也可以爬两层
 * ladder剩下的阶梯数目
 * maxJump最大阶梯步数
 * @author Young
 *
 */
public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    int ladder = 20;
		    int maxJump = 2;
		    int i = countSteps(ladder, maxJump);
		    System.out.println(i);
	}
	
	private static int countSteps(int ladder, int maxJump) {
	    int jump = 0;
	    if (ladder == 0) {
	        return 1;
	    }
	    if (ladder >= maxJump) {
	        // 剩下的楼梯大于最大可跳跃数
	        for (int i = 1; i <= maxJump; i++) {
	            jump += countSteps(ladder - i, maxJump);
	        }
	    } else {
	        // 剩下的楼梯不足最大可跳跃数
	        jump = countSteps(ladder, ladder);
	    }
	    return jump;
	}
}
