import java.util.Scanner;

public class Mani {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner textInput = new Scanner(System.in);

		System.out.println("Hello and Welcome to Casino group 5!");
		System.out.println("What's your name sir/miss?");
		String playerName = textInput.nextLine();

		System.out.println("Hello " + playerName + " how much money do you have? ");
		int money = textInput.nextInt();

		Guest spelare = new Guest(playerName, money);
		Dealer dealer = new Dealer();
		System.out.println("How much would you like to bet?");
		int bet = textInput.nextInt();
		if (bet>money)
			System.out.println(playerName+" don't have that much moeny...");
		spelare.getHand();
		System.out.println(dealer.toString());
		int playerSum = spelare.hit();

		if (playerSum <= 21) {
			int dealerSum = dealer.dealaersChoice();
			if (dealerSum >= playerSum && dealerSum <= 21 || playerSum > 21) {
				System.out.println("Dealer Win");
			} else
				System.out.println("You win!");
		} else
			System.out.println("\nYou got to much, Dealer Win");

		textInput.close();

	}
}
