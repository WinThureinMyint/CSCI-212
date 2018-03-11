package edu.cuny.qc;

/***********************************************************************/
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.*;

/***********************************************************************/
public class Sudoku extends JFrame implements ActionListener {

	private JButton[][] gridButton = new JButton[9][9]; // buttons that make up the Sudoku grid
	private JButton[] numberButton = new JButton[11]; // numbers and other command buttons

	int number = 1;

	// background colors of the grid
	public static final Color BEIGE = new Color(0xF5F5DC);
	public static final Color GAINSBORO = new Color(0xDCDCDC);

	// menu bar and menu options
	private MenuBar menuBar = new MenuBar();
	private Menu menuFile = new Menu("File");
	private Menu menuHelp = new Menu("Help");
	private MenuItem menuNew = new MenuItem("New Puzzle");
	private MenuItem menuFill = new MenuItem("Fill Grid");
	private MenuItem menuFileExit = new MenuItem("Exit");

	private MenuItem menuAbout = new MenuItem("About");
	private MenuItem menuSudokuHelp = new MenuItem("Sudoku Help");

	/**
	 * Sudoku constructor
	 */
	public Sudoku() {
		// Add action listener for the new menu option
		menuNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetGrid();
			}
		});

		// Add action listener for the fill grid option
		menuFill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillGrid();
			}
		});

		// Add action listener for the about menu option
		menuAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("images/logo.jpg");
				String message = "Sudoku version 0.99\nCopyright \u00A9 2018\nAndy Abreu";
				JOptionPane.showMessageDialog(null, message, "Sudoku", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});

		// Add action listener for the help menu option
		menuSudokuHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("images/sudoku.jpg");
				String message = "Complete the grid so that every row, column"
						+ "\nand 3x3 box contains every digit from 1 to 9 inclusive."
						+ "\n\nClick the button, at the bottom of the window, with the"
						+ "\nnumber you wish to enter, then click the button in the grid."
						+ "\n\nClick the pen to evaluate, and the pencil does nothing.";
				JOptionPane.showMessageDialog(null, message, "Sudoku Help", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		});

		// Add action listener for the exit menu option
		menuFileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sudoku.this.windowClosed();
			}
		});

		// add new, fill, and exit to the file menu
		menuFile.add(menuNew);
		menuFile.add(menuFill);
		menuFile.addSeparator();
		menuFile.add(menuFileExit);

		// add about and help to the help menu
		menuHelp.add(menuAbout);
		menuHelp.add(menuSudokuHelp);

		// add menu options to menu bar
		menuBar.add(menuFile);
		menuBar.add(menuHelp);

		// add the menubar to the frame
		setMenuBar(menuBar);

		// create a panel with a grid layout for the grid
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(9, 9));

		for (int i = 0; i < 9; i++) {
			gridButton[i] = new JButton[9];
			for (int j = 0; j < 9; j++) {
				gridButton[i][j] = new JButton();
				// gridButton[i][j].setSize(51,42);
				gridButton[i][j].setFont(new Font("Courier New", Font.BOLD, 16));
				gridButton[i][j].setForeground(Color.blue);
				gridButton[i][j].setText("");
				gridButton[i][j].setFocusable(false);
				gridButton[i][j].addActionListener(this);
				gridButton[i][j].setBackground(GAINSBORO);
				switch (i) {
				case 0:
				case 1:
				case 2:
				case 6:
				case 7:
				case 8:
					if (j < 3 || j > 5)
						gridButton[i][j].setBackground(BEIGE);
					break;
				case 3:
				case 4:
				case 5:
					if (j > 2 && j < 6)
						gridButton[i][j].setBackground(BEIGE);
				}
				// add buttons to the panel
				panel1.add(gridButton[i][j]);
			}
		}

		// create another panel with a grid layout for the numbers
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 11));

		for (int i = 0; i < 11; i++) {
			if (i < 9) {
				numberButton[i] = new JButton("" + (i + 1));
				numberButton[i].setBackground(Color.blue);

			} else {
				numberButton[i] = new JButton(new ImageIcon("images/" + i + ".jpg"));
				numberButton[i].setBackground(Color.white);
			}
			numberButton[i].addActionListener(this);
			numberButton[i].setForeground(Color.white);
			numberButton[i].setFocusable(false);
			panel2.add(numberButton[i]);
		}

		// set default number to 1 by giving that button the focus
		numberButton[0].requestFocus();

		// set the frame's layout to a Border Layout and add the panels
		setLayout(new BorderLayout());
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);

		// Add a window listener to the frame
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Sudoku.this.windowClosed();
			}
		});
	}

	/***********************************************************************/
	public void resetGrid() {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				gridButton[i][j].removeActionListener(this);
				gridButton[i][j].setForeground(Color.red);
				gridButton[i][j].setText("");
				gridButton[i][j].setFocusable(false);
				gridButton[i][j].addActionListener(this);
			}
	}

	/************************************************************************
	 * Fill the grid with data read from a file You will have to complete the code
	 * for this method
	 */
	public void fillGrid() {
		Scanner scan;
		URL url;
		try {
			url = new URL("http://venus.cs.qc.cuny.edu/~aabreu/cs212/project1/Sudoku7.txt");
			scan = new Scanner(url.openStream());

			// write the code to fill the grid
			// JOptionPane.showMessageDialog(this, "Write the necessary code to fill the
			// grid.");
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					String input = scan.next();
					gridButton[i][j].setText(input);
				}
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/***********************************************************************/
	public void actionPerformed(ActionEvent e) {
		boolean commandButtonClicked = false;

		// check to see if user pressed 1 of the buttons - 1 thru 9
		for (int i = 0; i < 11 && !commandButtonClicked; i++) {
			if (((JButton) e.getSource()) == numberButton[i]) {
				commandButtonClicked = true;

				// if a number was pressed, convert the text to a number
				// and store it in the variable 'number'
				if (i < 9) {
					number = Integer.parseInt(((JButton) e.getSource()).getText());
				} else if (i == 9) {
					if (evaluate())
						JOptionPane.showMessageDialog(this, "Sudoku");
					else
						JOptionPane.showMessageDialog(this, "Not Sudoku");
				} else if (i == 10)
					JOptionPane.showMessageDialog(this, "CS212 - Program #1\nWritten by Win Thurein Myint");
			}
		}

		// check to see if user pressed 1 of the buttons in the grid
		// otherwise erase it
		if (!commandButtonClicked) {
			JButton temp = (JButton) e.getSource();

			// replace the text of the grid button with the number clicked
			if (!String.valueOf(number).equals(temp.getText())) {
				temp.setText("" + number);
			} else
				temp.setText("");
		}
	}

	/***********************************************************************
	 * Check to see if the grid represents a Sudoku You will have to write the code
	 * for this method
	 ***********************************************************************/
	public boolean evaluate() {
		// JOptionPane.showMessageDialog(this, "Write the necessary code to see if this
		// is a Sudoku.");

		// seprate into 3x3 matrix
		int[][][] three_three = new int[9][3][3];
		int l = -1;
		for (int i = 0; i < 9; i += 3) { // 9 row
			for (int j = 0; j < 9; j += 3) { // 9 col
				l++;
				int p = -1;
				int threeSquare = 0;
				for (int k = i; k < i + 3; k++) { // 3 row
					int q = 0;
					p++;
					for (int h = j; h < j + 3; h++) { // 3 col
						threeSquare += Integer.parseInt(gridButton[k][h].getText());
						three_three[l][p][q] = Integer.parseInt(gridButton[k][h].getText());
						q++;
					}
				}
			}
		}

		for (int i = 0; i < three_three.length - 1; i++) {
			int[] allNumberInARow = new int[9];
			int a = 0;
			// 3x3 matrix to one row array
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					allNumberInARow[a] = three_three[i][j][k];
					a++;
				}

			}
			// check the duplicate number in array
			// if duplicate return false
			for (int g = 0; g < allNumberInARow.length - 1; g++) {
				for (int j = g + 1; j < allNumberInARow.length; j++) {
					if ((allNumberInARow[g] == allNumberInARow[j]) && (g != j)) {
						return false;
					}
					if (allNumberInARow[g] < 0) {
						return false;
					}
				}
			}
		}
		// check duplicate of horizontal and vertical row
		// if duplicate return false
		for (int q = 0; q < 9; q++) {
			for (int r = 0; r < 9; r++) {
				int source = Integer.parseInt(gridButton[q][r].getText());
				for (int h = 0; h < r; h++) {
					if (source == Integer.parseInt(gridButton[q][h].getText())) {
						return false;}
				}
				for (int s = 0; s < q; s++) {
					if (source == Integer.parseInt(gridButton[s][r].getText())) {
						return false;
					}
				}
			}
		}

		return true;
	}

	/***********************************************************************
	 * Close window and exit application
	 ***********************************************************************/
	protected void windowClosed() {
		System.exit(0);
	}

	/***********************************************************************
	 * main menu and start of program
	 ***********************************************************************/
	public static void main(String[] args) {
		Sudoku frame = new Sudoku(); // Create application frame.
		frame.setTitle("Sudoku v0.99"); // add title to the frame
		frame.setSize(new Dimension(470, 480)); // set the size of the frame
		frame.setResizable(false); // frame's size is fixed
		frame.setVisible(true); // Show frame
	}
}
