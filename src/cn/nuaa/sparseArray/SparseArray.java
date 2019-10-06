package cn.nuaa.sparseArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SparseArray {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[][] chessArr = new int[11][11];
		chessArr[1][2] = 1;
		chessArr[2][3] = 2;
		for(int[] row:chessArr) {
			for(int data:row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		File file = new File("C:\\Users\\Young\\Desktop\\sparseArr.txt");
		try {
			FileWriter out = new FileWriter(file);
			for(int i=0;i<chessArr.length;i++) {
				for(int j=0;j<chessArr[0].length;j++){
					out.write(chessArr[i][j]+"\t");
				}
				out.write("\n");
			}
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		int[][] newArr = new int[chessArr.length][chessArr[0].length];
		String line;
		int row = 0;
		while((line = in.readLine())!=null) {
			String[] temp = line.split("\t");
			for(int i=0;i<temp.length;i++) {
				newArr[row][i] = Integer.parseInt(temp[i]);
			}
			row ++;
		}
		in.close();
		
		System.out.println("ÎÄ¼þ¶ÁÈë~~~~~~~~~");
		for(int[] Row:newArr) {
			for(int data:Row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
	}

}
