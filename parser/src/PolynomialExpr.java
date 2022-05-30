import java.util.ArrayList;
public class PolynomialExpr extends Expression{
	ArrayList<TermExpr> allTerms;

	public PolynomialExpr(){
		allTerms = new ArrayList<>();
	}

	public void addTerm(TermExpr term){
		allTerms.add(term);
	}
        

	public String toString(){
		String msg = "";
		for(TermExpr t : allTerms)
			msg = msg + t.toString();
		return msg;
	}

	public void diffrentiate(){
		for(TermExpr t : allTerms)
			t.diffrentiate();
	}
}