
import javax.imageio.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;

public class ConnectBoard implements GameDisplay {
	private JFrame frame;
	private ArrayList<JButton> dropButtons;
	private JPanel panel;
	private final int WIDTH = 7;
	private final int HEIGHT = 6;
	private final int IMG_SIZE = 150;
	private final String IMG_PATH_EMPTY = "src/Circle.jpg";
	private final String IMG_PATH_RED = "src/CircleRed.jpg";
	private final String IMG_PATH_YELLOW = "src/CircleYellow.jpg";
	private final int FRAME_WIDTH = WIDTH*IMG_SIZE;
	private final int FRAME_HEIGHT = (HEIGHT+1)*IMG_SIZE+20;
	private ImageIcon icon_empty;
	private ImageIcon icon_one;
	private ImageIcon icon_two;
	private ConnectController cc;

	class DropListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int ind;
			Object o = e.getSource();
			if (o instanceof JButton) { 
				JButton button = (JButton) o;
				ind = dropButtons.indexOf(button);
				//System.out.println(ind);
				boolean success = cc.addPiece(ind);
				if (!success) {
					JOptionPane.showMessageDialog(frame, "ERROR! Column Full");
					button.setEnabled(false);
				}
			} else {
				System.out.println("Error: got " + o.getClass().toString());
			}
		}

	}


	private void drawBoard(Status[][] board) { 


		panel.removeAll();
		this.drawTops();

		for (int i = 0; i < HEIGHT; i++) {
			for (int j = 0; j < WIDTH; j++) { 
				ImageIcon icon = null;
				Status s = board[i][j];
				//System.out.println(s);
				switch (s) {
				case ONE:
					icon = icon_one;
					break;
				case TWO:
					icon = icon_two;
					break;
				case NEITHER:
					icon = icon_empty;
					break;
				}
				JLabel label = new JLabel(icon);
				panel.add(label);
			}
			//System.out.println();
		}
		panel.revalidate();

		panel.repaint();


	}

	private void drawTops() {
		for (int i = 0; i < WIDTH ; i++) { 
			panel.add(dropButtons.get(i));
		}
	}

	private void reset() {

		panel.removeAll();
		drawTops();
		for (int i = 0; i < WIDTH*(HEIGHT); i++) {
			JLabel label = new JLabel(icon_empty);
			panel.add(label);

		}
		for (JButton j : dropButtons) {
			j.setEnabled(true);
		}
		panel.revalidate();
		panel.repaint();
		cc.reset();

	}
	public ConnectBoard() { 
		cc = ControllerFactory.makeController(this);
		
		frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		panel = new JPanel();
		frame.add(panel);
		panel.setLayout( new GridLayout (WIDTH, HEIGHT)); 

		dropButtons = new ArrayList<JButton>();
		for (int i = 0; i < WIDTH ; i++) { 
			JButton currButton = new JButton("DROP HERE");
			//currButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			currButton.addActionListener(new DropListener());
			dropButtons.add(currButton);
		}

		try {
			BufferedImage img_empty = ImageIO.read(new File(IMG_PATH_EMPTY));
			icon_empty = new ImageIcon(img_empty);
			BufferedImage img_one = ImageIO.read(new File(IMG_PATH_RED));
			icon_one = new ImageIcon(img_one);
			BufferedImage img_two = ImageIO.read(new File(IMG_PATH_YELLOW));
			icon_two = new ImageIcon(img_two);

		} catch (IOException e) {
			e.printStackTrace();
		}


		reset();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	@Override
	public void gameOver(Status PlayerNumber) {
		String out = "";
		if (PlayerNumber == Status.NEITHER) {
			out = "It's a draw!";
		} else {
			out = "Player " + PlayerNumber + " won!";
		}
		JOptionPane.showMessageDialog(frame,out);
		for (JButton j : dropButtons) {
			j.setEnabled(false);
		}
		int ans = JOptionPane.showConfirmDialog(frame, "Play again?","Play again?", JOptionPane.OK_CANCEL_OPTION);

		if (ans == JOptionPane.OK_OPTION) {
			reset();
		} else {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}

	}

	@Override
	public void updateBoard(Status[][] board) {
		drawBoard(board);
	}

	@Override
	public int promptForOpponentDifficulty(int maxDifficulty) {
		String prompt = JOptionPane.showInputDialog(frame, "Enter opponent difficulty (a number from 1 to " + maxDifficulty+ "):");
		Scanner parse = null;
		int difficulty = -1;
		boolean done = false;
		if (prompt != null) {
			parse = new Scanner(prompt);
			difficulty = -1;
			if (parse.hasNextInt()) {
				difficulty = parse.nextInt();
				if (1 <= difficulty && difficulty <= maxDifficulty) {
					done = true;
				}
			}
		}
		while (!done) {
			prompt = JOptionPane.showInputDialog(frame, "Error in input.\nEnter opponent difficulty (a number from 1 to " + maxDifficulty+ "):");
			if (prompt != null) {
				parse = new Scanner(prompt);
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

	public void closeColumn(int colNum) {
		JButton button = dropButtons.get(colNum);
		button.setEnabled(false);
	}
}
