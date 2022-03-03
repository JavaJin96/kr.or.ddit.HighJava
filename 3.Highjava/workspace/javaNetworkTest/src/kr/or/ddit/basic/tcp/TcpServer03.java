package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer03 {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 준비중입니다...");
		
		Socket socket = server.accept();
		File file = new File("d:/d_other/upload");
		file.mkdir();
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		FileOutputStream fos = new FileOutputStream("d:/d_other/upload/보노보노.png");
		
		
		int ifile;
		while((ifile=dis.read()) != -1) {
			fos.write(ifile);
		}
		System.out.println("복사되었습니다.");
		
		fos.close();
		dis.close();
		server.close();
		
		
	}

}
