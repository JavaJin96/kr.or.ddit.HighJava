package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;


// 이 스레드는 소켓을 통해서 메시지를 받아서 화면에 출력하는 역할을 담당한다.
public class Receiver extends Thread{
	private Socket socket;
	private DataInputStream dis;
	
	
	public Receiver(Socket socket) {
		super();
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while(dis!=null) {
			try {
				
				System.out.println(dis.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}


