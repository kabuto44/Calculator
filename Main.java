import java.util.Scanner;
import java.util.*;

class Main {
  public static void main(String[] args) {
		
		Scanner b = new Scanner(System.in);
		System.out.println("Select function: evaluate or push");
		String function = b.nextLine();
		if ("evaluate".indexOf(function)!=-1&&"push".indexOf(function)==-1) {
		System.out.println("Input expression");
		toRPN a = new toRPN();
		a.setSequence(b.nextLine());
		a.compile();
		a.shuntingYard();
		System.out.println(a.dispRPN());
		Calculator c = new Calculator(a.dispRPN());
		System.out.println(c.run());
		b.close();
		} else if ("evaluate".indexOf(function)==-1&&"push".indexOf(function)!=-1) {
			Calculator c = new Calculator();
			String input;
			for(;;){
			input = b.nextLine();
			if(input.equals("off")) {
				b.close();
				break;
			}
			System.out.println(c.push(input));
		}
		}
  }
}