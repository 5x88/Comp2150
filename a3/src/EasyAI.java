
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
		
		
		return  nextMove;
	}

	private void addToBoard(int col)
	{
		for(int i=5;i>=0;i--)
		{
			if(board[i][col] == Status.NEITHER)
			{
				board[i][col] = Status.ONE;
				
			}
		}
	}
	
	
	private boolean checkBoard(int col)
	{
		
			boolean added = false;

			if(board[0][col] != Status.NEITHER)
			{
				added = false;
			}
			else
			{
				boolean filled = false;
				for(int i=5;i>=0 && !filled;i--)
				{
					if(board[i][col] == Status.NEITHER)
					{
						board[i][col] = Status.TWO;
						added = true;
						filled = true;
					}
				}

			}

			return added;
		}
	
	
}


