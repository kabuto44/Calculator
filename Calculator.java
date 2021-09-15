import java.util.*;

public class Calculator {
	private List<String> rpn = new ArrayList<> ();
	private double Stack1;
  private double Stack2;
  private double Stack3;
  private double Stack4;
  private double Stack5;
  private double Stack6;
  private double Stack7;
  private double Stack8;
  public void shiftStackUp(){
    Stack8 = Stack7;
    Stack7 = Stack6;
    Stack6 = Stack5;
    Stack5 = Stack4;
    Stack4 = Stack3;
    Stack3 = Stack2;
    Stack2 = Stack1;
  }
	public void shiftStackDown(){
		Stack2 = Stack3;
		Stack3 = Stack4;
		Stack4 = Stack5;
		Stack5 = Stack6;
		Stack6 = Stack7;
		Stack7 = Stack8;
		Stack8 = 0.0;
	}
	public Calculator(List<String> a){
		rpn = a;
	}
	public Calculator(){
		
	}
	public String disp(){
		System.out.println();
		return Stack2 + "\n" + Stack1;
	}
	public boolean isInteger( String input ) {
    try {
        Integer.parseInt( input );
        return true;
    }
    catch( Exception e ) {
        return false;
    }
}
  public String push(String func){
		if (isInteger(func)){
			setStack((double)(int)(Integer.parseInt(func)));
		} else if (func.equals("+")) {
			add();
		} else if (func.equals("-")) {
			subtract();
		} else if (func.equals("*")) {
			multiply();
		} else if (func.equals("/")) {
			divide();
		} else if (func.equals("^")) {
			exponent();
		}
		return disp();
	}
	public String run(){
		List<String> active = rpn;
		while(active.size()!=0){
			if(isInteger(active.get(0))){
				setStack((double)(int)Integer.parseInt(active.get(0)));
			} else if (active.get(0).equals("+")) {
				add();
			} else if (active.get(0).equals("-")) {
				subtract();
			} else if (active.get(0).equals("*")) {
				multiply();
			} else if (active.get(0).equals("/")) {
				divide();
			} else if (active.get(0).equals("^")) {
				exponent();
			}
			active.remove(0);
		}
		return disp();
	}
  public void setStack(double input){
    shiftStackUp();
    Stack1 = input;
  }
	public void multiply(){
		Stack1 = Stack1 * Stack2;
		shiftStackDown();
	}
	public void divide(){
		Stack1 = Stack2/Stack1;
		shiftStackDown();
	}
	public void add(){
		Stack1 = Stack1 + Stack2;
		shiftStackDown();
	}
	public void subtract(){
		Stack1 = Stack2-Stack1;
		shiftStackDown();
	}
	public void exponent(){
		Stack1 = Math.pow(Stack2,Stack1);
		shiftStackDown();
	}
}