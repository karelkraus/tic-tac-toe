import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
	
	ImageIcon icon = new ImageIcon("joystick.png");
	JPanel titlePanel = new JPanel();
	JPanel gamePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	JButton resetButton = new JButton("New Game");
	boolean player1turn;
	
	MyFrame() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,600);
		this.setIconImage(icon.getImage());
		this.setTitle("Tic Tac Toe");
		this.setResizable(false);
		this.getContentPane().setBackground(Color.pink);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		
		textfield.setBackground(Color.gray);
		textfield.setForeground(Color.pink);
		textfield.setFont(new Font("MV Boli", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,800,100);
		titlePanel.add(textfield);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		
		resetButton.setFocusable(false);
		resetButton.setBackground(Color.pink);
		resetButton.addActionListener(this);
		
		gamePanel.setLayout(new BorderLayout());
		gamePanel.setBounds(0,0,800,100);
		gamePanel.add(resetButton);
		
		for(int i=0; i<9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD, 120));
			buttons[i].setBackground(Color.darkGray);
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		this.add(titlePanel,BorderLayout.NORTH);
		this.add(gamePanel,BorderLayout.SOUTH);
		this.add(buttonPanel);
		this.setVisible(true);
		
		firstTurn();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
				if(player1turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.orange);
						buttons[i].setText("X");
						player1turn = false;
						textfield.setText("O is playing");
						check();
					}
				} else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(Color.magenta);
						buttons[i].setText("O");
						player1turn = true;
						textfield.setText("X is playing");
						check();
					}
				}
			}
		}
		
		if(e.getSource()==resetButton) {
			//this.dispose();
			//new MyFrame();
			for(int i=0; i<9; i++) {
				buttons[i].setText("");
				buttons[i].setBackground(Color.darkGray);
				buttons[i].setEnabled(true);
			}
			firstTurn();
		}
		
	}
	
	public void firstTurn() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Random random = new Random();
				
		if((random.nextInt(2))==0) {
			player1turn = true;
			textfield.setText("X is playing");
		} else {
			player1turn = false;
			textfield.setText("O is playing");
		}
	}
	
	public void check() {
		if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")) {
			xWins(0,1,2);
		}
		if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")) {
			xWins(3,4,5);
		}
		if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(6,7,8);
		}
		if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {
			xWins(0,3,6);
		}
		if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {
			xWins(1,4,7);
		}
		if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(2,5,8);
		}
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {
			xWins(0,4,8);
		}
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {
			xWins(2,4,6);
		}
		if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {
			oWins(0,1,2);
		}
		if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")) {
			oWins(3,4,5);
		}
		if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(6,7,8);
		}
		if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {
			oWins(0,3,6);
		}
		if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {
			oWins(1,4,7);
		}
		if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(2,5,8);
		}
		if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {
			oWins(0,4,8);
		}
		if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
			oWins(2,4,6);
		}
	}
	
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X won");
	}
	
	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for(int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O won");
	}

}
