package kr.or.ddit.basic.tcp;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient03 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 7777);
			System.out.println("서버에 연결되었습니다..");
			
			
			File file = new File("d:/d_other/보노보노.png");
			FileInputStream fis = new FileInputStream(file);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			int newfile;
			
			while( ((newfile = fis.read()) != -1 ) ) {
				dos.write(newfile);
			}
			
			dos.flush();
			dos.close();
			socket.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
