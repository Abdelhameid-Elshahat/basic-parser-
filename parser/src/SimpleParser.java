/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class SimpleParser {

    private String Msg;
    private int lookAhead;

    public static enum Type {
        VAR, NUM, ADD, MINUS,POWER, EOF
    };

    public class Token {

        String Symbol;
        Type type;

        public Token(String Symbol, Type type) {
            this.Symbol = Symbol;
            this.type = type;
        }
    }

    public SimpleParser(String Msg) {
        this.Msg = Msg;
        lookAhead = 0;
    }

    public Token getNextToken() throws Exception {
        if (lookAhead >= Msg.length()) {
            return new Token("", Type.EOF);
        }
        char ch = Msg.charAt(lookAhead);
        if (ch >= '0' && ch <= '9') {
            return new Token(ch + "", Type.NUM);
        }
        if (ch == '+') {
            return new Token("+", Type.ADD);
        }
        if (ch == '-') {
            return new Token("-", Type.MINUS);
        }
       
        if (ch == '^') {
            return new Token("^", Type.POWER);
        }
        if ((ch >= 'a' || ch <= 'z') || (ch >= 'A' || ch <= 'Z')){
            return new Token(ch+"",Type.VAR);

        } else {
            Error("Unexpected Token");
        }
        return null;
    }

    public void eat(Type type) throws Exception {
        Token tok = getNextToken();
        if (tok.type == type) {
            lookAhead++;
        } else {
            Error("Unexpected Token");
        }
    }

    public void Expr() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
            case NUM:
            case VAR:
                E();
                eat(Type.EOF);
                break;
            default:
                Error("Unexpected Token");
        }
    }

    public void E() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
           
            case NUM:
            case VAR:
                T();
                E_prime();
                break;
            default:
                Error("Unexpected Token");
        }
    }

    public void E_prime() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
            case ADD:
                eat(Type.ADD);
                T();
                E_prime();
                break;
            case MINUS:
                eat(Type.MINUS);
                T();
                E_prime();
                break;
            case EOF:
                break;
            default:
                Error("Unexpected Token");
        }
    }

    public void T() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
            case VAR:
            case NUM:
                F();
                T_prime();
                break;

            default:
                Error("Unexpected Token");
        }
    }

    public void T_prime() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
             case VAR:
            case NUM:
                F();
                T_prime();
                break;
            case ADD:
            case MINUS:
                break;
            case POWER:
                eat(Type.POWER);
                F();
                T_prime();
                break;
            
            case EOF:
                break;
            default:
                Error("Unexpected Token");
        }
    }

    

    public void F() throws Exception {
        Token nt = getNextToken();
        switch (nt.type) {
            case NUM:
                eat(Type.NUM);
                break;
            case VAR :
                eat(Type.VAR);
                break;
            default:
                Error("Unexpected Token");
        }
    }

    public void Error(String Msg) throws Exception {
        throw new Exception(Msg);

    }


}
