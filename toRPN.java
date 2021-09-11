import java.util.*;

public class toRPN {
  private List<String> sequence = new ArrayList<> ();
	private List<String> rpn = new ArrayList<> ();
  private String s;

  public void setSequence(String sequence){
    s = sequence;
  }
	public List<String> dispRPN(){
		return rpn;
	}
	public int indexed(char a){
		if(s.indexOf(a)!=-1){
			return s.indexOf(a);
		} else {
			return Integer.MAX_VALUE;
		}
	}
	public int indexed(char a, String b){
		if(b.indexOf(a)!=-1){
			return b.indexOf(a);
		} else {
			return Integer.MAX_VALUE;
		}
	}
  public int firstNum(){
    int num = Math.min(indexed('0'),Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(indexed('1'),indexed('2')),indexed('3')),indexed('4')),indexed('5')),indexed('6')),indexed('7')),indexed('8')),indexed('9')));
			return num;
  }
  public int firstNum(String a){
    int num = Math.min(indexed('0', a),Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(indexed('1', a),indexed('2', a)),indexed('3', a)),indexed('4', a)),indexed('5', a)),indexed('6', a)),indexed('7', a)),indexed('8', a)),indexed('9', a)));
			return num;
  }
  public int firstSym(){
    int symbol = Math.min(indexed(')'),Math.min(indexed('('),Math.min(Math.min(Math.min(Math.min(indexed('+'),indexed('-')),indexed('/')),indexed('*')),indexed('^'))));
			return symbol;
	}
  public int firstSym(String a){
    int symbol = Math.min(indexed(')', a),Math.min(indexed('(', a),Math.min(Math.min(Math.min(Math.min(indexed('+', a),indexed('-', a)),indexed('/', a)),indexed('*', a)),indexed('^', a))));
			return symbol;
	}
	public void otherSym(){
		String r = s;
		for(;;){
			r = r.trim();
			if(firstNum(r)==0 || firstSym(r)==0){
				r = r.substring(1);
			} else {
				System.out.println("Error: Unknown character \"" + r.charAt(0) + "\"");
				System.exit(0);
			}
			if(r.length()==0){
				break;
			}
		}
	}
	public void bracketCheck(){
		String b = s;
		int open=0;
		int close=0;
		for(int i = 0; i<s.length(); i++){
			if(b.charAt(0)=='('){
				open++;
			} else {
				if(b.charAt(0)==')'){
					close++;
				}
			}
			b=b.substring(1);
		}
		if(open!=close){
			System.out.println("Error: Brackets do not match");
			System.exit(0);
		}
	}
  public void compile(){
		otherSym();
		bracketCheck();
    for(;;){
      if(firstNum() < firstSym()){
				if(firstSym()!=Integer.MAX_VALUE){
					sequence.add(s.substring(firstNum(),firstSym()).trim());
					s=s.substring(firstSym());
				} else {
						sequence.add(s.substring(firstNum()).trim());
						s="";
					}
      } else {
				if(firstSym() < firstNum()){
				sequence.add(s.substring(firstSym(),firstSym()+1));
				if(firstSym()<=s.length()){
					s=s.substring(firstSym()+1);
					} else {
						s="";
					}
				}
			}
			System.out.println(sequence);
			if(s.trim().length()==0){
				break;
			}
    }
  }
}