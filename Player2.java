import java.io.*;  
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* The Player2 class creates the tic-tac-toe interface of player 2
* It also send and receive message from the server
* @author  Zaria Wong
* @version 1.0
* @since   5/10/2023
*/
public class Player2 {  
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
				if (txt_name.getText().isEmpty() == false) {
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
		
		ImageIcon Circle = new ImageIcon("Circle.png");
		/**
		 * Create an action listener for button0
		 */
		button0.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (buttons.contains("button0")==false&&end!=1) {
				button0.setIcon(Circle);
				commandpanel="PTwobutton0";
				buttons.add("POnebutton0");
				player2.add("button0");
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
			}  
		});
		/**
		 * Create an action listener for button1
		 */
		button1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				if (buttons.contains("button1")==false&&end!=1) {
				button1.setIcon(Circle);
				commandpanel="PTwobutton1";
				buttons.add("POnebutton1");
				player2.add("button1");
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
			}  
		});
		/**
		 * Create an action listener for button2
		 */
		button2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (buttons.contains("button2")==false&&end!=1) {
				button2.setIcon(Circle);
				commandpanel="PTwobutton2";
				buttons.add("POnebutton2");
				player2.add("button2");
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
			}  
		});
		/**
		 * Create an action listener for button3
		 */
		button3.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (buttons.contains("button3")==false&&end!=1) {
				button3.setIcon(Circle);
				commandpanel="PTwobutton3";
				buttons.add("POnebutton3");
				player2.add("button3");
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
			}  
		});
		/**
		 * Create an action listener for button4
		 */
		button4.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (buttons.contains("button4")==false&&end!=1) {
				button4.setIcon(Circle);
				commandpanel="PTwobutton4";
				buttons.add("POnebutton4");
				player2.add("button4");
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
			}  
		});
		/**
		 * Create an action listener for button5
		 */
		button5.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (buttons.contains("button5")==false&&end!=1) {
				button5.setIcon(Circle);
				commandpanel="PTwobutton5";
				buttons.add("POnebutton5");
				player2.add("button5");
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
			}  
		});
		/**
		 * Create an action listener for button6
		 */
		button6.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (buttons.contains("button6")==false&&end!=1) {
				button6.setIcon(Circle);
				commandpanel="PTwobutton6";
				buttons.add("POnebutton6");
				player2.add("button6");
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
			}  
		});
		/**
		 * Create an action listener for button7
		 */
		button7.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (buttons.contains("button7")==false&&end!=1) {
				button7.setIcon(Circle);
				commandpanel="PTwobutton7";
				buttons.add("POnebutton7");
				player2.add("button7");
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
			}  
		});
		/**
		 * Create an action listener for button8
		 */
		button8.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				if (buttons.contains("button8")==false&&end!=1) {
				button8.setIcon(Circle);
				commandpanel="PTwobutton8";
				buttons.add("POnebutton8");
				player2.add("button8");
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
			}  
		});
	}
	
	Socket sock;
	PrintWriter writer;
	
	/**
	 * A method to connect Player 2 with server.
	 * It receives messages and outputs messages
	 */
	public void go() { 
		this.create();
		try {
			sock = new Socket("127.0.0.1", 5000); 
			writer = new PrintWriter(sock.getOutputStream(), true);  

			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());  
			BufferedReader reader = new BufferedReader(streamReader);  	
			
			/**
			 * Set the message to server that client 2 is connected
			 */
			writer.println("CLIENT2 CONNECTED");
			
			String command;
			/**
			 * Set the message from reader as command
			 */			
			while ((command = reader.readLine()) != null) {
				commandpanel=null;
				end=0;
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
				 * Player 2 could not start the game until he/she enter the name.
				 */
				while (btn_submit.isEnabled()==true) {
		            Thread.sleep(20);
				}
				
				/**
				 * Disconnect player 1 and server if player 2 left
				 */
				if (command.startsWith("BREAKPlayer")) {
					JOptionPane.showMessageDialog(null, "Game Ends. One of the players left.");
					System.exit(0);
				}
				
				/**
				 * Check if player 2 meet the winning conditions.
				 */
				if (player2.contains("button1")&&player2.contains("button4")&&player2.contains("button7")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("PTwoWin");
					System.exit(0);
				}
				if (player2.contains("button0")&&player2.contains("button1")&&player2.contains("button2")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("PTwoWin");
					System.exit(0);
				}
				if (player2.contains("button3")&&player2.contains("button4")&&player2.contains("button5")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("PTwoWin");
					System.exit(0);
				}
				if (player2.contains("button6")&&player2.contains("button7")&&player2.contains("button8")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("PTwoWin");
					System.exit(0);
				}
				if (player2.contains("button0")&&player2.contains("button3")&&player2.contains("button6")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("PTwoWin");
					System.exit(0);
				}
				if (player2.contains("button2")&&player2.contains("button5")&&player2.contains("button8")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("PTwoWin");
					System.exit(0);
				}
				if (player2.contains("button0")&&player2.contains("button4")&&player2.contains("button8")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("PTwoWin");
					System.exit(0);
				}
				if (player2.contains("button2")&&player2.contains("button4")&&player2.contains("button6")) {
					JOptionPane.showMessageDialog(null, "Congratulations.You Win.");
					writer.println("PTwoWin");
					System.exit(0);
				}

				ImageIcon Cross = new ImageIcon("Cross.png");
				/**
				 * Start player 2's round if player 1 makes a valid move.
				 */
				if (command.startsWith("POnebutton")) {
					if(buttons.contains(command)==false) {
					System.out.println(command);
					commandpanel=null;
					label_intro.setText("Your opponent has moved, now is your turn");
					if (command.startsWith("POnebutton0")) {
						button0.setEnabled(false);
						buttons.add("POnebutton0");
						button0.setIcon(Cross);
						player1.add("button0");
					}
					if (command.startsWith("POnebutton1")) {
						button1.setEnabled(false);
						buttons.add("POnebutton1");
						button1.setIcon(Cross);
						player1.add("button1");
					}
					if (command.startsWith("POnebutton2")) {
						button2.setEnabled(false);
						buttons.add("POnebutton2");
						button2.setIcon(Cross);
						player1.add("button2");
					}
					if (command.startsWith("POnebutton3")) {
						button3.setEnabled(false);
						buttons.add("POnebutton3");
						button3.setIcon(Cross);
						player1.add("button3");
					}
					if (command.startsWith("POnebutton4")) {
						button4.setEnabled(false);
						buttons.add("POnebutton4");
						button4.setIcon(Cross);
						player1.add("button4");
					}
					if (command.startsWith("POnebutton5")) {
						button5.setEnabled(false);
						buttons.add("POnebutton5");
						button5.setIcon(Cross);
						player1.add("button5");
					}
					if (command.startsWith("POnebutton6")) {
						button6.setEnabled(false);
						buttons.add("POnebutton6");
						button6.setIcon(Cross);
						player1.add("button6");
					}
					if (command.startsWith("POnebutton7")) {
						button7.setEnabled(false);
						buttons.add("POnebutton7");
						button7.setIcon(Cross);
						player1.add("button7");
					}
					if (command.startsWith("POnebutton8")) {
						button8.setEnabled(false);
						buttons.add("POnebutton8");
						button8.setIcon(Cross);
						player1.add("button8");
					}
					/**
					 * Check if player 2 meet the losing conditions.
					 */
					if (player1.contains("button1")&&player1.contains("button4")&&player1.contains("button7")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player1.contains("button0")&&player1.contains("button1")&&player1.contains("button2")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player1.contains("button3")&&player1.contains("button4")&&player1.contains("button5")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player1.contains("button6")&&player1.contains("button7")&&player1.contains("button8")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player1.contains("button0")&&player1.contains("button3")&&player1.contains("button6")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player1.contains("button2")&&player1.contains("button5")&&player1.contains("button8")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player1.contains("button0")&&player1.contains("button4")&&player1.contains("button8")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					if (player1.contains("button2")&&player1.contains("button4")&&player1.contains("button6")) {
						JOptionPane.showMessageDialog(null, "You lose.");
						writer.println("PTwoWin");
						System.exit(0);
					}
					/**
					 * Enable valid buttons for player2 to make a move
					 */
					if (buttons.contains("POnebutton0")== false) {
						  button0.setEnabled(true);
					}
					if (buttons.contains("POnebutton1")== false) {
						  button1.setEnabled(true);
					}
					if (buttons.contains("POnebutton2")== false) {
						  button2.setEnabled(true);
					}
					if (buttons.contains("POnebutton3")== false) {
						  button3.setEnabled(true);
					}
					if (buttons.contains("POnebutton4")== false) {
						  button4.setEnabled(true);
					}
					if (buttons.contains("POnebutton5")== false) {
						  button5.setEnabled(true);
					}
					if (buttons.contains("POnebutton6")== false) {
						  button6.setEnabled(true);
					}
					if (buttons.contains("POnebutton7")== false) {
						  button7.setEnabled(true);
					}
					if (buttons.contains("POnebutton8")== false) {
						  button8.setEnabled(true);
					}
					/**
					 * The thread sleeps until player 2 makes a move.
					 */
					while (end==0) {
							Thread.sleep(20);	
					}
					
					/**
					 * Send message to server regarding which move does player2 makes
					 */
					writer.println(commandpanel);
					System.out.println(commandpanel);
				}
				}
				
				/**
				 * Player2 draws if none of the players meet winning or losing conditions when all the grids are filled
				 */
				if (buttons.size()==9) {
					JOptionPane.showMessageDialog(null, "Draw");
					System.exit(0);
				}			
				}
				

		} catch (Exception ex) { 
			writer.println("BREAKPlayer2");
			ex.printStackTrace(); 
		}
		
		writer.println("BREAKPlayer2");
		
	}
	
		/**
		  * Our main method which implements player2
		  * @param args The command line arguments.
		 */
		public static void main(String[] args) {
		Player2 d = new Player2();
		d.go();
	}
}