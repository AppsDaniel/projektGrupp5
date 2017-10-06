import java.util.InputMismatchException;
import java.util.Scanner;

public class Guest extends Hand {

	String name;
	int cash;

	public Guest(String name, int cash) {
		this.name = name;
		this.cash = cash;
	}
	
	String kort = newCard();
	String färg = newSuit();
	int värde = changeCard(kort);

	String kort1 = newCard();
	String färg1 = newSuit();
	int värde1 = changeCard(kort1);

	void getHand() {
		
		System.out.println(kort+" of "+färg+ " and "+kort1+" of "+färg1);
		int totalsum = värde + värde1;
		System.out.println("Your total sum is: " + totalsum);
	}

	Scanner textInput = new Scanner(System.in);

	protected int hit() {

		int newSum = värde + värde1;

		do {
			if (newSum < 21) {
//				System.out.println("\nDo you want to Hit or Stay?");

				String hit = textInput.nextLine();
				System.out.println("\nDo you want to Hit or Stay?");
				String kort2 = newCard();
				String färg2 = newSuit();
				int värde2 = changeCard(kort2);

				if (hit.equals("hit")) {
					System.out.println("New card: " + kort2 + " of " + färg2);

					 System.out.println("New total: " + (newSum + värde2));
					newSum += värde2;

				} else if (hit.equals("stay")) {

					break;
				}


			}
		} while (newSum != 21 && newSum <= 20);
		textInput.close();
		return newSum;

	}

	protected int Money()
	{
		int money=0;
		boolean yourMoney = false;	
		while (!yourMoney) {
			try {
				money = textInput.nextInt();
				yourMoney = true;
			} catch (InputMismatchException e) {
				System.out.println("Wrong operator, please try agian! ");
				textInput.nextLine();
				yourMoney = false;

			}
		}
		return money;
		
	}
	
	protected int beta()
	{
		int bet=0;
		System.out.println("How much would you like to bet?");
		boolean betMoney = false;
		while (!betMoney) {
			try {
				bet = textInput.nextInt();
				betMoney = true;
			} catch (InputMismatchException e) {
				System.out.println("Wrong operator, please try to bet again! ");
				textInput.nextLine();
				betMoney = false;

			}
		}
		return bet;
	}

}
