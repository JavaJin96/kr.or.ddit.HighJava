package kr.or.ddit.basic;

public class LprodVO {
   private int lprod_id;
   private String lprod_nm;
   private String lprod_gu; //sql 문은 대문자 이지만 java에서 작성할때는 소문자로 자동으로 찾아준다
   
   public int getLprod_id() {
      return lprod_id;
   }
   public void setLprod_id(int lprod_id) {
      this.lprod_id = lprod_id;
   }
   public String getLprod_nm() {
      return lprod_nm;
   }
   public void setLprod_nm(String lprod_nm) {
      this.lprod_nm = lprod_nm;
   }
   public String getLprod_gu() {
      return lprod_gu;
   }
   public void setLprod_gu(String lprod_gu) {
      this.lprod_gu = lprod_gu;
   }
   
}