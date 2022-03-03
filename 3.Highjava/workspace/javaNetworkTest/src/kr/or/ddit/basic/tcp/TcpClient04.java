package kr.or.ddit.basic.tcp;
/*서버와 클라이언트가 연결되면

클라이언드가 'd:/d_other/국화.jpg' 파일을 서버로 전소하고
서버는 클라이언트가 보내온 파일을 받아서 'd:/d_other/uplioad/'폴더에 저장하는
네트워크 프로그램을 작성하시오

클라이어트 --> 파일 읽어서 소켓으로 출력
서버 ==> 소켓에서 읽어서 파일로 출력*/

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TcpClient04 {
   private Socket socket;
   private BufferedInputStream bis; //읽어온다
   private BufferedOutputStream bos; //내보낸다
   private DataOutputStream dos;  //내보낸다
   
   
   public static void main(String[] args) {
      new TcpClient04().clientStart();
   
   }
   public void clientStart() {
      //전송할 파일을 이용한 File 객체 생성
      //File file = new File("d:/d_other/국화.jpg"); // file 이 없어도 파일은 생긴다
      File file = selectFile();
      
      if(file == null) {
         System.out.println("전송할 파일을 선택하지 않았습니다. 찌:발럼아!!!!!");
         return;
      }
      
      String fileName = file.getName();  
      
      if(!file.exists()) {//실제 저자리에 있나 확인하는것
         System.out.println(fileName + "파일이 없습니다.");
         return;
      }
      try {
         socket = new Socket("localhost", 7777);
         
         System.out.println("파일 전송 시작...");
         
         //전송할 파일의 이름을 전송하는 작업을 진행한다.
         dos = new DataOutputStream(socket.getOutputStream());
         dos.writeUTF(fileName);
         
         //파일 데이터 전송하는 작업 진행하기
         
         // 파일 읽기용 스트림 객체 생성
         bis = new BufferedInputStream(new FileInputStream(file));
         
         //서버로 전송할 스트림 객체생성
         bos = new BufferedOutputStream(socket.getOutputStream());
         
         byte[] temp = new byte[1024]; // 더빠르게 읽기위해 배열사용
         int len = 0; //새로운 변수에 저장
         
         // 파일 내용을 읽어서 소켓으로 출려한다.
         while((len=bis.read(temp)) > 0 ) {
            bos.write(temp, 0, len);
            
         }
         bos.flush(); //버퍼니까 플러쉬 사용
         System.out.println("파일 전송완료 ....");
      
         
      } catch (Exception e) {
         System.out.println("파일 전송 실패!!...");
         e.printStackTrace();
      }finally {         
         // 사용했던 스트림과 소켓을 전부 닫아준다..
         
         if(dos!=null) try {dos.close();}catch (IOException e) {}
         if(bos!=null) try {bos.close();}catch (IOException e) {}
         if(bis!=null) try {bis.close();}catch (IOException e) {}
         if(socket!=null) try {socket.close();}catch (IOException e) {}
         
      }
      
      
   }
   
   //전송할 파일을 선택하고 선택한 파일 정보를 갖는 File 객체를 반환하는 메서드
   private File selectFile() {
      
      // SWING의 파일 열기, 저장 창 연습
      JFileChooser chooser = new JFileChooser();
      
      // 선택할 파일의 확장자 설정
      FileNameExtensionFilter doc = 
         new FileNameExtensionFilter("MS Word File", "docx", "doc");
      
      FileNameExtensionFilter img = 
         new FileNameExtensionFilter(
               "Image File", new String[] {"png", "jpg", "gif"}) ;
      
      FileNameExtensionFilter txt = 
         new FileNameExtensionFilter("Text File", "txt");
      
      chooser.addChoosableFileFilter(doc);
      chooser.addChoosableFileFilter(img);
      chooser.addChoosableFileFilter(txt);
      
      chooser.setFileFilter(txt);  // 확장자 목록 중에 기본적으로 선택될 확장자 지정
      
      // Dialog창이 나타낼 기본 경로 설정
      chooser.setCurrentDirectory(new File("d:/d_other"));
      
      
      int result = chooser.showOpenDialog(new Panel());  // 열기용 창
      //int result = chooser.showSaveDialog(new Panel());  // 저장용 창
      
      File seletedFile= null;
      
      // '저장' 또는 '열기' 버튼을 눌렀을 경우...
      if(result == JFileChooser.APPROVE_OPTION) {
         
         // 선택한 파일 정보 가져오기
         
         /*File */seletedFile = chooser.getSelectedFile();
         System.out.println("선택한 파일 : " + seletedFile.getAbsolutePath());
      }
      
      return seletedFile;
      
   }
   
   

}