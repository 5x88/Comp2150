
public class ConnectLogic implements ConnectController {


	private GameDisplay gd;
	private Status[][] board = new Status[6][7];
	private ConnectPlayer opponent;

	public ConnectLogic(GameDisplay gd)
	{
		this.gd = gd;
	}

	public boolean addPiece(int col) {

		boolean added;

		
			added = false;
		
			added = addPlayerToColumn(col);

			if(added == true)
			{
				addAIToColumn(opponent.makeMove(col));
				gd.updateBoard(board);
			}
			
			if(boardFull())
			{
				
				gd.gameOver(Status.NEITHER);
			}
		

		return added;
	}


	private boolean addPlayerToColumn(int col)
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
					board[i][col] = Status.ONE;
					added = true;
					filled = true;
				}
			}

		}

		return added;
	}

	private boolean addAIToColumn(int col)
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

	private boolean boardFull()
	{
		boolean full = true;

		for(int j=0;j<7;j++)
		{
			if(board[0][j] == Status.NEITHER)
			{
				full = false;
			}
		}

		return full;
	}

	public void reset()
	{
		initializeBoard();
		selectAI();
	}	

	private void selectAI()
	{
		if((gd.promptForOpponentDifficulty(2)==1))
		{
			opponent = new EasyAI();
		}
		else
		{
			opponent = new HardAI();
		}
	}

	private void initializeBoard()
	{
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				board[i][j] = Status.NEITHER;
			}
		}
	}
}
