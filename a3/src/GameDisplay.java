
public interface GameDisplay {
	public void gameOver(Status PlayerNumber);
	public void updateBoard(Status[][] board);
	public int promptForOpponentDifficulty(int maxDifficulty);
}
