package cn.nuaa.huffmcode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HufmanCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "i like like like java do you like a java";
//		byte[] contentBytes = s.getBytes();
//		System.out.println(contentBytes.length);
//		byte[] huffmanCodesBytes = huffmanZip(contentBytes);
//		System.out.println(Arrays.toString(huffmanCodesBytes));
//		byte[] sourceBytes = decode(huffmanCodes,huffmanCodesBytes);
//		System.out.println(new String(sourceBytes));
//		List<Node> nodes = getNodes(contentBytes);
//		System.out.println(nodes);
//		Node huffmanTreeRoot = createHufmanTree(nodes);
//		preOrder(huffmanTreeRoot);
//		
//		getCodes(huffmanTreeRoot);
//		System.out.println(huffmanCodes);
//		
//		byte[] by = zip(contentBytes,huffmanCodes);
//		System.out.println(Arrays.toString(by));
		//测试压缩文件
		String srcFile = "C:\\Users\\Young\\Desktop\\zipTest.jpg";
		String dstFile = "C:\\Users\\Young\\Desktop\\dst.zip";
		try {
			zipFile(srcFile,dstFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("压缩完成");
		String zipFile =  "C:\\Users\\Young\\Desktop\\dst.zip";
		String dstFileUNzip = "C:\\Users\\Young\\Desktop\\unzip.jpg";
		unZipFile(zipFile, dstFileUNzip);
		System.out.println("解压完成");
	}

	
	public static void unZipFile(String zipFile,String dstFile) {
		InputStream is =null;
		ObjectInputStream ois = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(zipFile);
			ois = new ObjectInputStream(is);
			byte[] huffmanBytes = (byte[])ois.readObject();
			Map<Byte,String> huffmanCodes = (Map<Byte,String>)ois.readObject();
			byte[] bytes = decode(huffmanCodes, huffmanBytes);
			os = new FileOutputStream(dstFile);
			os.write(bytes);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			try {
				os.close();
				ois.close();
				is.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
		}
	}
	
	public static void zipFile(String srcFile,String desFile) throws IOException {
		
		OutputStream os = null;
		ObjectOutputStream oos = null;
		
		FileInputStream is = null;
		try {
			is = new FileInputStream(srcFile);
			byte[] b = new byte[is.available()];
			is.read(b);
			byte[] huffmanBytes = huffmanZip(b);
			os = new FileOutputStream(desFile);
			oos = new ObjectOutputStream(os);
			oos.writeObject(huffmanBytes);
			oos.writeObject(huffmanCodes);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
				os.close();
				oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2.getMessage());
			}
		}
		
	}
	
	//将一个字符串对应的byte【】数组 返回hufman编码处理后的byte【】
	
	public static byte[] zip(byte[] bytes,Map<Byte,String> hufmancodes) {
		StringBuilder sb = new StringBuilder();
		for(byte b:bytes) {
			sb.append(hufmancodes.get(b));
		}
		//转成byte【】
		int len;
		if(sb.length()%8==0) {
			len = sb.length()/8;
		}else {
			len = sb.length()/8+1;
		}
		byte[] by = new byte[len];
		int count = 0;
		for(int i=0;i<sb.length();i+=8) {
			String strByte;
			if(i+8>sb.length()) {
				strByte = sb.substring(i);
			}else {
				strByte = sb.substring(i,i+8);
			}
			by[count] = (byte)Integer.parseInt(strByte, 2);
			count++;
		}
		return by;
	}
	
	static Map<Byte,String> huffmanCodes = new HashMap<>();
	static StringBuilder sb = new StringBuilder(); //用途
	
	public static Map<Byte,String> getCodes(Node root) {
		if(root==null) {
			System.out.println();
		}
		getCodes(root.left,"0",sb);
		getCodes(root.right,"1",sb);
		return huffmanCodes;
	}
	
	//生成hufman编码表
	public static void getCodes(Node node,String code,StringBuilder sb) {
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.append(code);
		if(node!=null) {
			if(node.data==null) {
				getCodes(node.left,"0",sb2);
				getCodes(node.right,"1",sb2);
			}else {
				huffmanCodes.put(node.data, sb2.toString());
			}
		}
	}
	
	public static List<Node> getNodes(byte[] bytes){
		ArrayList<Node> nodes = new ArrayList<Node>();
		Map<Byte,Integer> counts = new HashMap<Byte,Integer>();
		for(byte b:bytes) {
			Integer count = counts.get(b);
			if(count==null) {
				counts.put(b, 1);
			}else {
				counts.put(b, count+1);
			}
		}
		
		for(Map.Entry<Byte, Integer> entry:counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}
	
	public static Node createHufmanTree(List<Node> nodes) {
		while(nodes.size()>1) {
			Collections.sort(nodes);
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parent = new Node(null,leftNode.weight+rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	public static void preOrder(Node root) {
		if(root==null) {
			System.out.println("赫夫曼树为空");
		}else {
			root.preOrder();
		}
		
	}
	
	/**
	 * 
	 * @param huffmanCodes
	 * @param huffmanBytes
	 * @return
	 */
	public static byte[] decode(Map<Byte,String>huffmanCodes,byte[] huffmanBytes) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<huffmanBytes.length;i++) {
			byte b = huffmanBytes[i];
			boolean flag = (i==huffmanBytes.length-1);
			sb.append(byteToBitString(!flag, b));
		}
		
		//把字符串按照指定的赫夫曼编码进行解码
		Map<String,Byte> map=  new HashMap<String,Byte>();
		for(Map.Entry<Byte,String> entry:huffmanCodes.entrySet()) { //反向map
			map.put(entry.getValue(), entry.getKey());
		}
		List<Byte> list = new ArrayList<>();
		for(int i=0;i<sb.length();) {
			int count = 1;
			boolean flag = true;
			Byte b = null;
			while(flag) {
				//取出一个1？0
				String key = sb.substring(i,i+count);
				b = map.get(key);
				if(b==null) {
					count++;
				}else {
					flag = false;
				}
			}
			list.add(b);
			i+=count;
		}
		byte[] b = new byte[list.size()];
		for(int i=0;i<b.length;i++) {
			b[i] = list.get(i);
		}
		return b;
	}
	
	/**
	 * 将byte转成二进制字符串
	 * @param b flag true：需要补高位 
	 * @return b对应的二进制字符串 补码返回
	 */
	public static String byteToBitString(boolean flag,byte b) {
		int temp = b;
		if(flag) {
			temp = temp|256;
		}
		
		String str = Integer.toBinaryString(temp);
		if(flag) {
			return str.substring(str.length()-8);
		}else {
			return str;
		}
	}
	
	public static byte[] huffmanZip(byte[] bytes) {
		List<Node> nodes = getNodes(bytes);
		Node huffmanTreeRoot = createHufmanTree(nodes);
		Map<Byte,String> huffmanCodes = getCodes(huffmanTreeRoot);
		byte[] huffmanCodeBytes = zip(bytes,huffmanCodes);
		return huffmanCodeBytes;
	}
}

class Node implements Comparable<Node>{
	Byte data;
	int weight;
	Node left;
	Node right;
	
	public Node(Byte data, int weight) {
		super();
		this.data = data;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Node [data="+data+",weight="+weight+"]";
	}
	
	public void preOrder() {
		System.out.println(this);
		if(this.left!=null) {
			this.left.preOrder();
		}
		if(this.right!=null) {
			this.right.preOrder();
		}
	}
}