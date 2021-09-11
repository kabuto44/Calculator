// Calculator
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
		Calculator a = new Calculator();
		Scanner b = new Scanner(System.in);
		System.out.println("Input equation");
		a.setSequence(b.nextLine());
		a.compile();
  }
}
