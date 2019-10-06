package Test;
/**
 * ��һ��N��¥�ݣ�ÿ�ο�����һ�� Ҳ����������
 * ladderʣ�µĽ�����Ŀ
 * maxJump�����ݲ���
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
	        // ʣ�µ�¥�ݴ���������Ծ��
	        for (int i = 1; i <= maxJump; i++) {
	            jump += countSteps(ladder - i, maxJump);
	        }
	    } else {
	        // ʣ�µ�¥�ݲ���������Ծ��
	        jump = countSteps(ladder, ladder);
	    }
	    return jump;
	}
}
