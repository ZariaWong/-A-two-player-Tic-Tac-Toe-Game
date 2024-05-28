# A-two-player-Tic-Tac-Toe-Game
This is a two-player Tic-Tac-Toe Game. The game only starts when the Tic-Tac-Toe Server runs and two players are connected to the server. When the game starts, players need to input their player's name first (i.e., the player cannot make any move if he/she does not enter his/her player's name). Players are not allowed to re-input their names again once they have submitted their names (i.e., the textboxes and the submit buttons should be disabled). In addition, their names should be displayed in the frame's title (i.e., change from Tic Tac Toe to Tic Tac Toe-Player: (player's name)) and the message title (located below the menu bar) should change from "Enter your player name…" to "WELCOME (player's name)".

After entering the player's name, the game always starts with player 1 (the player's mark with a "x")'s first move (i.e., player 2 (the player's mark with a "o") cannot make his/her first move until player 1 makes his/her first move). If player 1's move is valid, his/her move would be marked as a "x" on the 3 x 3 board (The mark "x" on the 3 x 3 board should be displayed on both player 1's and player 2's board). The message title in the player 1's board would be changed to "Valid move, wait for your opponent." while the message title in the player 2's board would be changed to "Your opponent has moved, now is your turn.". Besides, player 1 is not allowed to make the next move until his/her opponent moves (i.e., if player 1 makes the next move before his/her opponent moves, it would be considered as an invalid move and nothing would be displayed on the board). The turn would be switched to the opponent (this time player 2) and if player 2's move is valid, it would be marked as a "o" on the 3 x 3 board on both players. The message displayed in the message title of the player 2's board would be changed to "Valid move, wait for your opponent." while the message title of the player 1's board would be changed to "Your opponent has moved, now is your turn." Similarly, the turn would be switched to player 1 again and player 2 cannot make his/her next move until player 1 makes the move.

The game continues and switches among the opposite player until it reaches either one of the following conditions: player 1 wins, player 2 wins, or it's a draw. The winning condition is that when there is any row, column or diagonal that is filled with the same mark (e.g., player 1 would win if there is any row, column or diagonal that is filled with "x", player 2 would win if there is any row, column or diagonal that is filled with "o"). The game will draw if no players satisfy the winning condition after all the board locations are filled with marks. Once it reaches either one of the above conditions, a Message Dialog would be displayed on both players (the content of the Message Dialog would be different, based on the condition reached) and both players cannot make further moves.

In addition, the system needs to handle the case when one of the players leaves during the game process. In this case, the game would terminate immediately (i.e., the remaining player cannot make further moves), and a Message Dialog "Game Ends. One of the players left." would be displayed on the remaining player.

Furthermore, the game interface includes a JMenuBar with two JMenus: Control and Help. The Control menu has a JMenuItem named Exit, and the Help menu has a JMenuItem named Instruction. When the player clicks "Exit", they would exit the game and the game would be terminated immediately. When the player clicks "Instruction", a Dialog Frame consisting of some game information would be displayed.

# Program Execution
ENVIRONMENT REQUIREMENTS: Please run the program in Eclipse environment

STEPS
1. Open the "Server.java" and click the "run server" button. A sentence "Server is running..."should be printed in terminal
2. Open the "Player1.java" and click the "run server" button. A sentence "Server is connected to client1" should be printed in terminal.
3. Open the "Player2.java" and click the "run server" button. A sentence "Server is connected to client2" should be printed in terminal.
4. If one of the player leave, multiple sentences of "BREAKPlayer" commands will be printed in the terminal. 
The message of "Game Ends. One of the players left" message will pop out on the interface of another player when he/she tries a make a new move.

ASSUMPTIONS
1. Assume that player 1 with class player 1 is always the player who enters the game first.
2. Assume that player 2 with class player 2 is always the player who enters the game later.
3. Assume that no more players can be connected to the server. (i.e. player 1 class can only be runned once to create one player 1 object, player 2 class can only be runned once to create one player 2 object. 
4. Assume that only server, player1 and player2 classes are located on local host (i.e., with IP address 127.0.0.1). 

SPECIAL NOTES
The message of "Game Ends. One of the players left" will also appears in the following conditions:
1. Connection between Player 1 and server is not successful ("Connection reset" will be printed in terminal")
2. Connection between Player 2 and server is not successful("Connection reset" will be printed in terminal")
3. The server faces an ConcurrentModificationException("ConcurrentModificationException" will be printed in terminal")
In this case, even if connection reset, we still have to terminate the server, player 1 class and player 2 class.
We can restart the game by repeating steps 1 - 3.

If "Exception in thread "main" java.lang.NullPointerException" is printed in terminal. Please close the Eclipse envionment to restart the game.
Repeat steps 1 - 3.
