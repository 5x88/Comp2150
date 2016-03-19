
import java.util.Arrays;
import java.util.Scanner;



public class TextBoard  implements GameDisplay {
	private final int WIDTH = 7;
	private final int HEIGHT = 6;
	private ConnectController cc;
	private Scanner kbd;

	private void drawBoard(Status[][] board) { 
		final char one = 'X';
		final char two = 'O';
		final char blank = '-';
		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) { 
				Status s = board[i][j];
				switch (s) {
				case ONE:
					System.out.print(one);
					break;
				case TWO:
					System.out.print(two);
					break;
				case NEITHER:
					System.out.print(blank);
					break;
				}

			}
			System.out.println();
		}
	}

	private void turn() {
		System.out.println("YOUR TURN...");
		int col = getCol();
		boolean success = cc.addPiece(col);
		while (!success) {
			System.out.println("Error: column full");
			col = getCol();
			success = cc.addPiece(col);
		}
	}


	private void reset() {
		cc.reset();
	}
	
	public TextBoard() { 
 		// following line changed from previous version (feb 29).
		cc = ControllerFactory.makeController(this); 
		kbd = new Scanner(System.in);
		reset();
		// draw empty board and start.
		Status[][] board = new Status[HEIGHT][WIDTH];
		for (int i = 0; i < HEIGHT; i++) {
			Arrays.fill(board[i], Status.NEITHER);
		}
		drawBoard(board);
		while (true) {
			turn();
		}
	}

	@Override
	public void gameOver(Status PlayerNumber) {
		String out = "";
		if (PlayerNumber == Status.NEITHER) {
			out = "It's a draw!";
		} else {
			out = "Player " + PlayerNumber + " won!";
		}
		System.out.println(out);
		System.out.print("Play again? (Y/N)");
		char resp = kbd.nextLine().toUpperCase().charAt(0);

		while (! (resp == 'Y' || resp == 'N')) {
			System.out.print("Play again? (Y/N)");
			resp = kbd.nextLine().toUpperCase().charAt(0);

		}
		if (resp == 'Y') {
			reset();
		} else if (resp == 'N'){
			System.exit(0);
		}

	}

	@Override
	public void updateBoard(Status[][] board) {
		drawBoard(board);
	}

	@Override
	public int promptForOpponentDifficulty(int maxDifficulty) {
		String prompt = "Enter opponent difficulty (a number from 1 to " + maxDifficulty+ "):";
		System.out.println(prompt);
		String res = kbd.nextLine();
		Scanner parse = null;
		int difficulty = -1;
		boolean done = false;
		if (res != null) {
			parse = new Scanner(res);
			difficulty = -1;
			if (parse.hasNextInt()) {
				difficulty = parse.nextInt();
				if (1 <= difficulty && difficulty <= maxDifficulty) {
					done = true;
				}
			}
		}
		while (!done) {
			prompt = "Error in input.\nEnter opponent difficulty (a number from 1 to " + maxDifficulty+ "):";
			System.out.println(prompt);
			res = kbd.nextLine();

			if (res != null) {

				parse = new Scanner(res);
				difficulty = -1;
				if (parse.hasNextInt()) {
					difficulty = parse.nextInt();
					if (1 <= difficulty && difficulty <= maxDifficulty) {
						done = true;
					}
				}
			}
		}
		parse.close();
		return difficulty;
	}

	private int getCol() {
		String prompt = "Where do you want to play (1..7)?";
		System.out.println(prompt);
		String res = kbd.nextLine();
		Scanner parse = null;
		int difficulty = -1;
		boolean done = false;
		if (res != null) {
			parse = new Scanner(res);
			difficulty = -1;
			if (parse.hasNextInt()) {
				difficulty = parse.nextInt();
				if (1 <= difficulty && difficulty <= WIDTH) {
					done = true;
				}
			}
		}
		while (!done) {
			prompt = "Error in input.\nWhere do you want to play (1..7)?";
			System.out.println(prompt);
			res = kbd.nextLine();

			if (res != null) {
				parse = new Scanner(res);
				difficulty = -1;
				if (parse.hasNextInt()) {
					difficulty = parse.nextInt();
					if (1 <= difficulty && difficulty <= WIDTH) {
						done = true;
					}
				}
			}
		}
		parse.close();
		return difficulty-1;
	}


}
