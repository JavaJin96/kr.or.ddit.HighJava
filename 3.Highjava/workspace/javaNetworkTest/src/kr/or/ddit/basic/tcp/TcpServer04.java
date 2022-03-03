package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer04 {

	private ServerSocket server;
	private Socket socket;
	private BufferedInputStream bis;
	private BufferedOutputStream bos;
	private DataInputStream dis;

	public static void main(String[] args) {
		new TcpServer04().serverStart();
	}

	public void serverStart() {
		File saveDir = new File("d:/d_ohter/upload"); // 저장할 폴더 
		
		// 저장할 폴더가 없으면 새로 생성한다.
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}
		
		try {
			server = new ServerSocket(7777);
			
			System.out.println("서버가 준비되었습니다...");
			
			socket = server.accept();
			
			System.out.println("파일 다운로드를 시작합니다.");
			
			// 클라이언트가 처음으로 보낸 '파일명'을 받는다.
			dis = new DataInputStream(socket.getInputStream());
			
			String fileName = dis.readUTF();
			
			// 저장할 파일 위치와 파일명을 지정하여 File객체 생성
			File saveFile = new File(saveDir, fileName);
			
			// 수신용 스트림 객체 생성
			bis = new BufferedInputStream(socket.getInputStream());
			
			
			// 파일 저장용 스트림 객체 생성
			bos = new BufferedOutputStream(new FileOutputStream(saveFile));
			
			// 1kb씩 데이터를 전송할 배열 생성
			byte[] temp = new byte[1024];
			int len = 0;
			
			// 소켓으로 읽어서 파일로 출력한다.
			while((len=bis.read()) > 0) {
				bos.write(temp, 0, len);
			}
			bos.flush();
			
			System.out.println("파일 다운로드 완료...");
			
		} catch (Exception e) {
			System.out.println("파일 다운로드 실패..");
			e.printStackTrace();
		}finally {
			if(dis != null) try { dis.close(); } catch(IOException e) {}	
			if(bis != null) try { bis.close(); } catch(IOException e) {}	
			if(bos != null) try { bos.close(); } catch(IOException e) {}	
			if(socket != null) try { socket.close(); } catch(IOException e) {}	
			if(server != null) try { server.close(); } catch(IOException e) {}	
		}
		
	}
	
}
