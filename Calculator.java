import java.util.*;

public class Calculator {
  private List<Object> sequence = new ArrayList<> ();
  private String s;
  private double Stack1;
  private double Stack2;
  private double Stack3;
  private double Stack4;
  private double Stack5;
  private double Stack6;
  private double Stack7;
  private double Stack8;
  public void shiftStack(){
    Stack8 = Stack7;
    Stack7 = Stack6;
    Stack6 = Stack5;
    Stack5 = Stack4;
    Stack4 = Stack3;
    Stack3 = Stack2;
    Stack2 = Stack1;
  }
  public void setStack(double input){
    shiftStack();
    Stack1 = input;
  }
  public void setSequence(String sequence){
    s = sequence;
  }
	public int indexed(char a){
		if(s.indexOf(a)!=-1){
			return s.indexOf(a);
		} else {
			return Integer.MAX_VALUE;
		}
	}
  public int firstNum(){
    int num = Math.min(indexed('0'),Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(Math.min(indexed('1'),indexed('2')),indexed('3')),indexed('4')),indexed('5')),indexed('6')),indexed('7')),indexed('8')),indexed('9')));
			return num;
  }
  public int firstSym(){
    int symbol = Math.min(Math.min(Math.min(Math.min(indexed('+'),indexed('-')),indexed('/')),indexed('*')),indexed('^'));

			return symbol;
	}
  public void compile(){
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
			if(s.trim() == ""){
				break;
			}
    }
  }
}
