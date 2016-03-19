
public class ConnectLogic implements ConnectController {


	GameDisplay gd;
	Status[][] board = new Status[6][7];

	public ConnectLogic(GameDisplay gd)
	{
		this.gd = gd;

		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				board[i][j] = Status.NEITHER;
			}
		}
	}

	public boolean addPiece(int col) {

		boolean added = false;

		if(board[0][col] != Status.NEITHER)
		{
			added = false;
		}
		else
		{
			for(int i=5;i>0;i--)
			{
				if(board[i][col] !=Status.NEITHER)
				{
					
				}
			}
			board[5][col] = Status.ONE;
			added = true;
			gd.updateBoard(board);
		}



		return added;
	}


	public void reset() {



	}

}
