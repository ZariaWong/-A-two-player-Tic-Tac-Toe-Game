import java.io.*;  
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* The Player1 class creates the tic-tac-toe interface of player 1
* It also send and receive message from the server
* @author  Zaria Wong
* @version 1.0
* @since   5/10/2023
*/
public class Player1 {  
	static public JButton btn_submit = new JButton("Submit"); 
	static public JTextField txt_name = new JTextField(19);
	static public JLabel label_intro = new JLabel();
	/**
	 * Create 9 buttons for the 9 boxes in the tic-tac-toe board
	 */
	static public JButton button0 = new JButton("");
	static public JButton button1 = new JButton("");
	static public JButton button2 = new JButton("");
	static public JButton button3 = new JButton("");
	static public JButton button4 = new JButton("");
	static public JButton button5 = new JButton("");
	static public JButton button6 = new JButton("");
	static public JButton button7 = new JButton("");
	static public JButton button8 = new JButton("");
	/**
	 * @param commandpanel A String to store the output message. 
	 */
	static public String commandpanel;
	/**
	 * @param end An integer to store whether a button is clicked. 
	 */
	static public int end;
	/**
	 * Create an array list to store all the buttons that are clicked
	 */
	static ArrayList <String> buttons = new ArrayList<String>();
	/**
	 * Create an array list to store the buttons that are clicked by player 1
	 */
	static ArrayList <String> player1 = new ArrayList<String>();
	/**
	 * Create an array list to store the buttons that are clicked by player 2
	 */
	static ArrayList <String> player2 = new ArrayList<String>();
	
	/**
	 * A method to create the interface for the game.
	 */
	public static void create() {
		 /**
		 *Creates a frame
		 *Creates a menu with an item to close game windows
		 */
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenu menu1;JMenu menu2;
		JMenuItem i1; JMenuItem i2;
		JMenuBar mb=new JMenuBar();  
        menu1=new JMenu("Control");  
        menu2=new JMenu("Help");  
        i1=new JMenuItem("Exit");  
        i2=new JMenuItem("Instruction");  
        menu1.add(i1);
        menu2.add(i2);
        mb.add(menu1);  
        mb.add(menu2);  
        frame.setJMenuBar(mb);  

		/**
		 * Create sub-panels
		 */
        JPanel MainPanel = new JPanel();
		JPanel NamePanel = new JPanel();
		JPanel InfoPanel = new JPanel();
		label_intro.setText("Enter your player name...");
		label_intro.setHorizontalAlignment(SwingConstants.LEFT);
		NamePanel.add(label_intro);	
        JPanel GridPanel = new JPanel(new GridLayout(3, 3));
        GridPanel.setSize(400, 200);
        GridPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

		 /**
		 *Set buttons on panel 
		 */
        button0.setPreferredSize(new Dimension(100, 66));
		button0.setBackground(Color.WHITE);
        button0.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridPanel.add(button0);
        button1.setPreferredSize(new Dimension(100, 66));
		button1.setBackground(Color.WHITE);
        button1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridPanel.add(button1);
        button2.setPreferredSize(new Dimension(100, 66));
		button2.setBackground(Color.WHITE);
        button2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridPanel.add(button2);
        button3.setPreferredSize(new Dimension(100, 66));
		button3.setBackground(Color.WHITE);
        button3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridPanel.add(button3);
        button4.setPreferredSize(new Dimension(100, 66));
		button4.setBackground(Color.WHITE);
        button4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridPanel.add(button4);
        button5.setPreferredSize(new Dimension(100, 66));
		button5.setBackground(Color.WHITE);
        button5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridPanel.add(button5);
        button6.setPreferredSize(new Dimension(100, 66));
		button6.setBackground(Color.WHITE);
        button6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridPanel.add(button6);
        button7.setPreferredSize(new Dimension(100, 66));
		button7.setBackground(Color.WHITE);
        button7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridPanel.add(button7);
        button8.setPreferredSize(new Dimension(100, 66));
		button8.setBackground(Color.WHITE);
        button8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridPanel.add(button8);
        button0.setEnabled(false);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        button5.setEnabled(false);
        button6.setEnabled(false);
        button7.setEnabled(false);
        button8.setEnabled(false);

		InfoPanel.add(txt_name);
		InfoPanel.add(btn_submit);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(MainPanel);
		frame.setTitle("Tic Tac Toe");
		frame.setSize(300, 340);
		frame.setVisible(true);
		
		/**
		 * Set components on Main Panel
		 */
		MainPanel.add(NamePanel);
		MainPanel.add(GridPanel);
		MainPanel.add(InfoPanel);
		
		/**
		 * Create an action listener for start button
		 */
		btn_submit.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (txt_name.getText().isEmpty()  == false) {
					label_intro.setText("WELCOME "+txt_name.getText());  
					txt_name.setEnabled(false);
					btn_submit.setEnabled(false);
				}
			}  
		});
		
		/**
		 * Create an action listener for the exit menu item
		 */
		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent g) {
				System.exit(0);
			}
		});
		
		/**
		 * Create an action listener for the Instruction menu item
		 */
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent g) {
				JOptionPane.showMessageDialog(null, "Some information about the game:\nCriteria for a valid move:\n-The move is not occupied by any mark.\n-The move is made in the player's turn.\n-The move is made within 3 x 3 board.\nThe game would continue and switch among the opposite player until it reaches either one of the following conditions:\n-Player 1 wins.\n-Player 2 wins.\n-Draw");
			}
		});
		
		ImageIcon Cross = new ImageIcon("Cross.png");
		/**
		 * Create an action listener for button0
		 */
		button0.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				button0.setIcon(Cross);
				commandpanel="POnebutton0";
				buttons.add("PTwobutton0");
				player1.add("button0");
		        button0.setEnabled(false);
		        button1.setEnabled(false);
		        button2.setEnabled(false);
		        button3.setEnabled(false);
		        button4.setEnabled(false);
		        button5.setEnabled(false);
		        button6.setEnabled(false);
		        button7.setEnabled(false);
		        button8.setEnabled(false);
		        label_intro.setText("Valid move, wait for your opponent.");
		        end=1;
			}  
		});
		
		/**
		 * Create an action listener for button1
		 */
		button1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				button1.setIcon(Cross);
				commandpanel="POnebutton1";
				buttons.add("PTwobutton1");
				player1.add("button1");
		        button0.setEnabled(false);
		        button1.setEnabled(false);
		        button2.setEnabled(false);
		        button3.setEnabled(false);
		        button4.setEnabled(false);
		        button5.setEnabled(false);
		        button6.setEnabled(false);
		        button7.setEnabled(false);
		        button8.setEnabled(false);
		        label_intro.setText("Valid move, wait for your opponent.");
		        end=1;
			}  
		});
		/**
		 * Create an action listener for button2
		 */
		button2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				button2.setIcon(Cross);
				commandpanel="POnebutton2";
				buttons.add("PTwobutton2");
				player1.add("button2");
		        button0.setEnabled(false);
		        button1.setEnabled(false);
		        button2.setEnabled(false);
		        button3.setEnabled(false);
		        button4.setEnabled(false);
		        button5.setEnabled(false);
		        button6.setEnabled(false);
		        button7.setEnabled(false);
		        button8.setEnabled(false);
		        label_intro.setText("Valid move, wait for your opponent.");
		        end=1;
			}  
		});
		/**
		 * Create an action listener for button3
		 */
		button3.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				button3.setIcon(Cross);
				commandpanel="POnebutton3";
				buttons.add("PTwobutton3");
				player1.add("button3");
		        button0.setEnabled(false);
		        button1.setEnabled(false);
		        button2.setEnabled(false);
		        button3.setEnabled(false);
		        button4.setEnabled(false);
		        button5.setEnabled(false);
		        button6.setEnabled(false);
		        button7.setEnabled(false);
		        button8.setEnabled(false);
		        label_intro.setText("Valid move, wait for your opponent.");
		        end=1;
			}  
		});
		/**
		 * Create an action listener for button4
		 */
		button4.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				button4.setIcon(Cross);
				commandpanel="POnebutton4";
				buttons.add("PTwobutton4");
				player1.add("button4");
		        button0.setEnabled(false);
		        button1.setEnabled(false);
		        button2.setEnabled(false);
		        button3.setEnabled(false);
		        button4.setEnabled(false);
		        button5.setEnabled(false);
		        button6.setEnabled(false);
		        button7.setEnabled(false);
		        button8.setEnabled(false);
		        label_intro.setText("Valid move, wait for your opponent.");
		        end=1;
			}  
		});
		/**
		 * Create an action listener for button5
		 */
		button5.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				button5.setIcon(Cross);
				commandpanel="POnebutton5";
				buttons.add("PTwobutton5");
				player1.add("button5");
		        button0.setEnabled(false);
		        button1.setEnabled(false);
		        button2.setEnabled(false);
		        button3.setEnabled(false);
		        button4.setEnabled(false);
		        button5.setEnabled(false);
		        button6.setEnabled(false);
		        button7.setEnabled(false);
		        button8.setEnabled(false);
		        label_intro.setText("Valid move, wait for your opponent.");
		        end=1;
			}  
		});
		/**
		 * Create an action listener for button6
		 */
		button6.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				button6.setIcon(Cross);
				commandpanel="POnebutton6";
				buttons.add("PTwobutton6");
				player1.add("button6");
		        button0.setEnabled(false);
		        button1.setEnabled(false);
		        button2.setEnabled(false);
		        button3.setEnabled(false);
		        button4.setEnabled(false);
		        button5.setEnabled(false);
		        button6.setEnabled(false);
		        button7.setEnabled(false);
		        button8.setEnabled(false);
		        label_intro.setText("Valid move, wait for your opponent.");
		        end=1;
			}  
		});
		/**
		 * Create an action listener for button7
		 */
		button7.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				button7.setIcon(Cross);
				commandpanel="POnebutton7";
				buttons.add("PTwobutton7");
				player1.add("button7");
		        button0.setEnabled(false);
		        button1.setEnabled(false);
		        button2.setEnabled(false);
		        button3.setEnabled(false);
		        button4.setEnabled(false);
		        button5.setEnabled(false);
		        button6.setEnabled(false);
		        button7.setEnabled(false);
		        button8.setEnabled(false);
		        label_intro.setText("Valid move, wait for your opponent.");
		        end=1;
			}  
		});
		/**
		 * Create an action listener for button8
		 */
		button8.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				button8.setIcon(Cross);
				commandpanel="POnebutton8";
				buttons.add("PTwobutton8");
				player1.add("button8");
		        button0.setEnabled(false);
		        button1.setEnabled(false);
		        button2.setEnabled(false);
		        button3.setEnabled(false);
		        button4.setEnabled(false);
		        button5.setEnabled(false);
		        button6.setEnabled(false);
		        button7.setEnabled(false);
		        button8.setEnabled(false);
		        label_intro.setText("Valid move, wait for your opponent.");
		        end=1;
			}  
		});
	}
	
	Socket sock;
	PrintWriter writer;
	
	/**
	 * A method to connect Player 1 with server.
	 * It receives messages and outputs messages
	 */
	public void go() { 
		this.create();
		try {
			sock = new Socket("127.0.0.1", 5000); 
			writer = new PrintWriter(sock.getOutputStream(), true);  
			
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());  
			BufferedReader reader = new BufferedReader(streamReader);  			

			String command;
			/**
			 * Set the message from reader as command
			 */
			while ((command = reader.readLine()) != null) {
				end=0;
				commandpanel=null;
				/**
				 * Player 1 could not start the game until he/she enter the name.
				 */
				while (btn_submit.isEnabled()==true) {
		            Thread.sleep(20);
				}
		        button0.setEnabled(false);
		        button1.setEnabled(false);
		        button2.setEnabled(false);
		        button3.setEnabled(false);
		        button4.setEnabled(false);
		        button5.setEnabled(false);
		        button6.setEnabled(false);
		        button7.setEnabled(false);
		        button8.setEnabled(false);
				/**
				 * Disconnect player 1 and server if player 2 left
				 */
				if (command.startsWith("BREAKPlayer")) {
					JOptionPane.showMessageDialog(null, "Game Ends. One of the players left.");
					System.exit(0);
				}
				/**
				 * Start the game if player 2 enter the game.
				 */
				if (command.startsWith("CLIENT2 CONNECTED")){
					while (btn_submit.isEnabled()==true) {
			            Thread.sleep(20);
					}
					if (buttons.isEmpty()==true) {
				        button0.setEnabled(true);
				        button1.setEnabled(true);
				        button2.setEnabled(true);
				        button3.setEnabled(true);
				        button4.setEnabled(true);
				        button5.setEnabled(true);
				        button6.setEnabled(true);
				        button7.setEnabled(true);
				        button8.setEnabled(true);
				        while (commandpanel==null) {
				            Thread.sleep(20);
						}
				        writer.println(commandpanel);
				        System.out.println(commandpanel);
					}
			    }
				if (command.startsWith("BREAKPlayer")) {
					JOptionPane.showMessageDialog(null, "Game Ends. One of the players left.");
					System.exit(0);
				}
				
				/**
				 * Check if player 1 meet the winning conditions.
				 */
				if (player1.contains("button1")&&player1.contains("button4")&&player1.contains("button7")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("POneWin");
					System.exit(0);
				}
				if (player1.contains("button0")&&player1.contains("button1")&&player1.contains("button2")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("POneWin");
					System.exit(0);
				}
				if (player1.contains("button3")&&player1.contains("button4")&&player1.contains("button5")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("POneWin");
					System.exit(0);
				}
				if (player1.contains("button6")&&player1.contains("button7")&&player1.contains("button8")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("POneWin");
					System.exit(0);
				}
				if (player1.contains("button0")&&player1.contains("button3")&&player1.contains("button6")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("POneWin");
					System.exit(0);
				}
				if (player1.contains("button2")&&player1.contains("button5")&&player1.contains("button8")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("POneWin");
					System.exit(0);
				}
				if (player1.contains("button0")&&player1.contains("button4")&&player1.contains("button8")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("POneWin");
					System.exit(0);
				}
				if (player1.contains("button2")&&player1.contains("button4")&&player1.contains("button6")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("POneWin");
					System.exit(0);
				}
				
				ImageIcon Circle = new ImageIcon("Circle.png");			
				/**
				 * Start player 1's round if player 2 makes a valid move.
				 */
				if (command.startsWith("PTwobutton")) {
					if (buttons.contains(command)==false) {
					commandpanel=null;
					label_intro.setText("Your opponent has moved, now is your turn");
					if (command.startsWith("PTwobutton0")) {
						button0.setEnabled(false);
						buttons.add("PTwobutton0");
						button0.setIcon(Circle);
						player2.add("button0");
					}
					if (command.startsWith("PTwobutton1")) {
						button1.setEnabled(false);
						buttons.add("PTwobutton1");
						button1.setIcon(Circle);
						player2.add("button1");
					}
					if (command.startsWith("PTwobutton2")) {
						button2.setEnabled(false);
						buttons.add("PTwobutton2");
						button2.setIcon(Circle);
						player2.add("button2");
					}
					if (command.startsWith("PTwobutton3")) {
						button3.setEnabled(false);
						buttons.add("PTwobutton3");
						button3.setIcon(Circle);
						player2.add("button3");
					}
					if (command.startsWith("PTwobutton4")) {
						button4.setEnabled(false);
						buttons.add("PTwobutton4");
						button4.setIcon(Circle);
						player2.add("button4");
					}
					if (command.startsWith("PTwobutton5")) {
						button5.setEnabled(false);
						buttons.add("PTwobutton5");
						button5.setIcon(Circle);
						player2.add("button5");
					}
					if (command.startsWith("PTwobutton6")) {
						button6.setEnabled(false);
						buttons.add("PTwobutton6");
						button6.setIcon(Circle);
						player2.add("button6");
					}
					if (command.startsWith("PTwobutton7")) {
						button7.setEnabled(false);
						buttons.add("PTwobutton7");
						button7.setIcon(Circle);
						player2.add("button7");
					}
					if (command.startsWith("PTwobutton8")) {
						button8.setEnabled(false);
						buttons.add("PTwobutton8");
						button8.setIcon(Circle);
						player2.add("button8");
					}
					/**
					 * Check if player 1 meet the losing conditions.
					 */
					if (player2.contains("button1")&&player2.contains("button4")&&player2.contains("button7")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player2.contains("button0")&&player2.contains("button1")&&player2.contains("button2")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player2.contains("button3")&&player2.contains("button4")&&player2.contains("button5")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player2.contains("button6")&&player2.contains("button7")&&player2.contains("button8")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player2.contains("button0")&&player2.contains("button3")&&player2.contains("button6")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player2.contains("button2")&&player2.contains("button5")&&player2.contains("button8")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player2.contains("button0")&&player2.contains("button4")&&player2.contains("button8")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player2.contains("button2")&&player2.contains("button4")&&player2.contains("button6")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					/**
					 * Enable valid buttons for player1 to make a move
					 */
					if (buttons.contains("PTwobutton0")== false) {
						  button0.setEnabled(true);
					}
					if (buttons.contains("PTwobutton1")== false) {
						  button1.setEnabled(true);
					}
					if (buttons.contains("PTwobutton2")== false) {
						  button2.setEnabled(true);
					}
					if (buttons.contains("PTwobutton3")== false) {
						  button3.setEnabled(true);
					}
					if (buttons.contains("PTwobutton4")== false) {
						  button4.setEnabled(true);
					}
					if (buttons.contains("PTwobutton5")== false) {
						  button5.setEnabled(true);
					}
					if (buttons.contains("PTwobutton6")== false) {
						  button6.setEnabled(true);
					}
					if (buttons.contains("PTwobutton7")== false) {
						  button7.setEnabled(true);
					}
					if (buttons.contains("PTwobutton8")== false) {
						  button8.setEnabled(true);
					}
					
					/**
					 * The thread sleeps until player 1 makes a move.
					 */
					while (end==0) {						
						Thread.sleep(20);					
					}
					
					/**
					 * Send message to server regarding which move does player1 makes
					 */
					writer.println(commandpanel);
					System.out.println(commandpanel);
				}
				}
				
				/**
				 * Player1 draws if none of the players meet winning or losing conditions when all the grids are filled
				 */
				if (buttons.size()==9) {
					JOptionPane.showMessageDialog(null, "Draw");
					System.exit(0);
				}
				}
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			System.out.println("Player1Exit");
		}
		writer.println("BREAKPlayer1");
	}
	
		/**
		  * Our main method which implements player1
		  * @param args The command line arguments.
		 */
		public static void main(String[] args) {
		Player1 d = new Player1();
		d.go();
	}
}
