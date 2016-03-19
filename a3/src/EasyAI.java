
public class EasyAI implements ConnectPlayer {

	Status[][] board = new Status[6][7];
	
	
	
	public int makeMove(int lastCol) {
		
		addToBoard(lastCol);
		
		int nextMove = 0 + (int)(Math.random() * 6);
		
		boolean add = checkBoard(nextMove);
		
		while(add)
		{
			nextMove = 0 + (int)(Math.random() * 6);
			add = checkBoard(nextMove);
		}
		
		addToBoard(nextMove);
		
		
		return  nextMove;
	}

	private void addToBoard(int col)
	{
		boolean added = false;
		for(int i=5;i>=0&&!added;i--)
		{
			if(board[i][col] != Status.ONE)
			{
				board[i][col] = Status.ONE;
				added = true;
				
			}
		}
	}
	
	
	private boolean checkBoard(int col)
	{
		
			boolean full = false;

			if(board[0][col] == Status.ONE)
			{
				full = true;
			}
			
			return full;
		}
	
	
}


