

public class Main {

	public static void main (String[] args) {

		final int NUM_OF_AI = 2;
		boolean gameOver = false;
		ConnectPlayer opponent;

		ConnectBoard board = new ConnectBoard();

		if((board.promptForOpponentDifficulty(NUM_OF_AI)==1))
		{
			opponent = new EasyAI();
		}
		else
		{
			opponent =new HardAI();
		}

		while(!gameOver)
		{
			
			


			
			
		}


	}
}
