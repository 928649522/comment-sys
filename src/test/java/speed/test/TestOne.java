package speed.test;

public class TestOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         TestOne one=  new TestOne();
     
         long start =System.currentTimeMillis();
         String test=one.getTest();
        
         for(int i=0;i<500000;i++){
        	 String temp;
        	 temp=one.getTest()+i;
         }
         long stop =System.currentTimeMillis();
         System.out.println(stop-start);
         

        
        
	}
   public String getTest(){
	   return "20";
   }
}
