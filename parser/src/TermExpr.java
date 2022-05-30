public class TermExpr extends Expression
{
	int c;  //coefficient
	int p;  //power

	public TermExpr(int c, int p){
		this.c = c;
		this.p = p;
	}
	public String toString(){
		if(c == 0)
			return "";
		if(c == 1 && p == 1)
			return "+x";
		else if(c == -1 && p == 1)
			return "-x";
		else if(c > 0 && p == 0)
			return "+" + c;
		else if(c < 0 && p == 0)
			return ""  + c;
		else if(c > 0 && p == 1)
			return "+"+c+"x";
		else if(c < 0 && p == 1)
			return c+"x";
		else if(c > 0)
			return "+"+c+"x^"+p;
		else
			return c+"x^"+p;
	}
	public void diffrentiate(){
		this.c = this.c * p;
		this.p = this.p - 1;
	}
}