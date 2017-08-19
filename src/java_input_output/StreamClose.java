package java_input_output;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StreamClose {
	public static void main(String[] args) {
		File f = new File("f:/test.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			byte[] all = new byte[(int) f.length()];
			fis.read(all);
			for (byte b : all) {
				System.out.println(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 在finally 里关闭流
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

//使用try(){}自动关闭流
class StreamClose2 {
	public static void main(String[] args) {
		File f = new File("f:/test.txt");
		try(FileInputStream fis = new FileInputStream(f)){
			byte[] all = new byte[(int) f.length()];
			fis.read(all);
			for (byte b : all) {
				System.out.println(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}