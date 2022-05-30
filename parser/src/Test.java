import java.util.Scanner;

public class Test  
{
   static long coeffTerm(String pTerm)
  {
 
    // Get coefficient
    String coeffStr = "";
    int i;
    for (i = 0; pTerm.charAt(i) != 'x' ; i++)
    {
      if(pTerm.charAt(i)==' ')
        continue;
      coeffStr += (pTerm.charAt(i));
    }
 
    long coeff = Long.parseLong(coeffStr);
    // Get Power (Skip 2 characters for x and ^)

       return coeff;

  }
   
   
   
  static long powerTerm(String pTerm)
  {
 
    // Get coefficient
    String powStr = ""; 
    int i=1;
   
    for (i = i + 2; i != pTerm.length() && pTerm.charAt(i) != ' '; i++)
    {
      powStr += pTerm.charAt(i);
    }
   
   long power=Long.parseLong(powStr);
    // Get Power (Skip 2 characters for x and ^)

       return power;
  }
  
  

	public static void main(String []args) throws Exception
	{
//        Scanner s=new Scanner(System.in);
//            System.out.println("Please Enter the vaild polynomial Equation :");
//        String msg=s.next();
//        
        String msg="3x^6+3x^2+3x^2-2x^2";
        SimpleParser p=new SimpleParser(msg);
        p.Expr();
        System.out.println("Sucess");
        PolynomialExpr e = new PolynomialExpr();
        int i=0;
        String[] stSplit = msg.split("[- +]");
         while(i<stSplit.length){
            int cof = (int) coeffTerm(stSplit[i]);
            int pow= (int) powerTerm(stSplit[i]);
            
             TermExpr e1 = new TermExpr(cof,pow);
             e.addTerm(e1);
             
        
             ++i;
         }

      
		
              System.out.println(e);

	      e.diffrentiate();

              System.out.println(e);
            
		

	}
           
}