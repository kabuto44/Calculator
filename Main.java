import java.util.Scanner;
import java.util.*;

class Main {
  public static void main(String[] args) {
		// toRPN a = new toRPN();
		// Scanner b = new Scanner(System.in);
		// System.out.println("Input expression");
		// a.setSequence(b.nextLine());
		// a.compile();
		Scanner b = new Scanner(System.in);
		Calculator c = new Calculator();
		System.out.println(c.disp());
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