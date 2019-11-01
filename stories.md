# XP and TDD training
## As part of this training we will be developing Web Application that will allow people to play Rock, Paper, and Scissors
Stories are coded with the story number, 
followed by the type of store A - Angular, J - Java, D - Database
then the difficulity 1 (Easy), 2 (Medium), 3 (Hard)

---------------------------------------------------------------------------------

### (1) A - 1 Leader board throw percentage precision 

**--WHY this story--**: The precision on the percentages makes it difficult to read 

**AS A** [ Player ]  
**I WANT** [ Quickly see and understand the throw percentage statistics   ]  
**SO THAT** [  Determine my strategy quickly ]

**Acceptance Criteria**
 
**Scenario:** Players see fractional percentages clearly  
**Given:** A player has a throw percentage that is fractional  
**When:** It is displayed on the leader board page  
**Then:** The precision is only displayed to a tenth of a percent

---------------------------------------------------------------------------------
### (2) A - 1 Ties field is blank in the Leader board table (Bug)

The Ties column in the leader board table is always blank even when a player has tie games.

---------------------------------------------------------------------------------
### (3) A - 1 Display player name instead of P1_WINS, P2_WINS or TIE

**--WHY this story--**: The current message of P1_WINS is not really clear to the user.

**AS A** [ Player ]  
**I WANT** [ See the name of the winning player  ]    
**SO THAT** [  I can quickly understand who has won ]  

**Acceptance Criteria**
 
**Scenario:** User clicks the submit button on the Play Game page  
**Given:** That the game result is not a Tie  
**When:**  The results are displayed  
**Then:** Then message is [Name of the winning player] Wins  
**Given:** That the game result is a Tie  
**When:**  The results are displayed  
**Then:** The message is The game is a tie

---------------------------------------------------------------------------------
### (4) A - 2 Change Title of player details page to show player name and statistics

**--WHY this story--**: It is not clear which player the the game details are being displayed for

**AS A** [ Player  ]  
**I WANT** [ See the name of the player I'm seeing the details for  ]  
**SO THAT** [  I can keep track of the players I'm researching ]  

**Acceptance Criteria**
 
**Scenario:** Player sees summary data on details page  
**Given:** Given a player has played one or more games  
**When:** A Player name is clicked on the Leaderboard page   
**Then:** The page header should include the players name, winning percentage and percentages for each throw.

---------------------------------------------------------------------------------
### (5) A - 1 Game results are color coded

**--WHY this story--**: Players want to easily see which games are wins, losses or ties

**AS A** [ Player ]  
**I WANT** [ See quickly which games were wons, losses and ties ]  
**SO THAT** [ I can have a good idea of my performance over time  ]

**Acceptance Criteria**
 
**Scenario:** Select the game details page by selecting a player name from the leader board  
**Given:** A player has some wins, losses and ties  
**When:** When the game records are displayed   
**Then:** The Wins are color coded in Green, the Loses are Red and the Ties are Light Blue

---------------------------------------------------------------------------------
### (6) A - 1 Thrown Percentages are color coded based on values

**--WHY this story--**: Players want to evaluate what throws their opponents may make.

**AS A** [ Player ]  
**I WANT** [ to see if other players have 'Hot' or 'Cold' throws ]  
**SO THAT** [ I can make better decisions about what throws I want to make ]  

**Acceptance Criteria**
 
**Scenario:** Move to the leaderboard table  
**Given:** Players have high or low percentages of throws  
**When:** A percentage is higher than or equal to 85%  
**Then:** It is colored red  
**When:** A percentage is higher than or equal to 70% and lower then 85%  
**Then:** It is colored orange  
**When:** A percentage is lower than or equal to 15%  
**Then:** It is colored blue  
**When:** A percentage is lower than or equal to 30% and higher than 15%  
**Then:** It is colored light blue

---------------------------------------------------------------------------------
### (7) JA - 2 Validation should not allow the same player to be selected for Player 1 and Player 2

**--WHY this story--**: It should not be possible for a player to play against themselves  

**AS A** [  Player ]  
**I WANT** [  Validation to catch when I accidentally select the same player twice  ]  
**SO THAT** [  I don't enter corrupt data into the statistics ]  

**Acceptance Criteria**
 
**Scenario:** When I player enters the play names on the play game page  
**Given:** The player is entering the values for player1 and player2  
**When:** They enter the same player name for both player1 and player2  
**Then:** The submit button is not enabled

---------------------------------------------------------------------------------
### (8) DJA - 2 Add Lizard and Spock as throws to the game

**--WHY this story--**: Make the game more interesting and reduce the number of ties.

**AS A** [ Player ]  
**I WANT** [  Have more possible throws  ]  
**SO THAT** [  The game is more interesting and has fewer ties ]  

**Acceptance Criteria**

Support the following game rules.

Scissors cuts Paper
Paper covers Rock
Rock crushes Lizard
Lizard poisons Spock
Spock smashes Scissors
Scissors decapitates Lizard
Lizard eats Paper
Paper disproves Spock
Spock vaporizes Rock
(and as it always has) Rock crushes Scissors
 
**Scenario:** Player wants to play a game  
**Given:** Player select the Play Game option  
**When:** The list of throws is displayed  
**Then:** The list contains: Rock, Paper, Scissors, Lizard, Spock  
**Given:** Player select options  
**When:** Both players select the same throw  
**Then:** The game result is a Tie  
**Given:** Player select options   
**When:** One Player Throws Scissors and one throws Paper  
**Then:** The player that threw Scissors wins  
**Given:** Player select options   
**When:** One Player Throws Paper and one throws Rock  
**Then:** The player that threw Paper wins  
**Given:** Player select options   
**When:** One Player Throws Rock and one throws Lizard  
**Then:** The player that threw Rock wins  
**Given:** Player select options   
**When:** One Player Throws Lizard and one throws Spock  
**Then:** The player that threw Lizard wins  
**Given:** Player select options   
**When:** One Player Throws Spock and one throws Scissors  
**Then:** The player that threw Spock wins  
**Given:** Player select options   
**When:** One Player Throws Scissors and one throws Lizard  
**Then:** The player that threw Scissors wins  
**Given:** Player select options   
**When:** One Player Throws Lizard and one throws Paper  
**Then:** The player that threw Lizard wins  
**Given:** Player select options   
**When:** One Player Throws Paper and one throws Spock  
**Then:** The player that threw Paper wins  
**Given:** Player select options   
**When:** One Player Throws Spock and one throws Rock  
**Then:** The player that threw Spock wins  
**Given:** Player select options   
**When:** One Player Throws Rock and one throws Scissors  
**Then:** The player that threw Rock wins


---------------------------------------------------------------------------------
### (9) DJA - 3 Add date played to the game result table

**--WHY this story--**: Players want to see how they are doing over time

**AS A** [ A Player  ]  
**I WANT** [  See when individual game results I see the date the game was played  ]  
**SO THAT** [  I can see how may performance has changed over time ]  

**Acceptance Criteria**
 
**Scenario:** Select the game details page by selecting a player name from the leader board  
**Given:** Players have played at least one game  
**When:** When the game records are displayed  
**Then:**  Then I see the date the game was played

---------------------------------------------------------------------------------
### (10) J - 3 Show all players on the leader board even if they have not played any games

**--WHY this story--**: Players should see all every player on the leader board even if they have not played any games 

**AS A** [ Player ]  
**I WANT** [  See all the list of players ]  
**SO THAT** [  I know who I can challenge to a game ]

**Acceptance Criteria**
 
**Scenario:** Player sees full player list on leader board  
**Given:** That there are one or more players that have not played any games  
**When:** A player selects the leader board to be displayed  
**Then:** The table shows all the players and players who have not played any games will have zero values and percentages for each value. 

---------------------------------------------------------------------------------
### (11) A-1 Drop down list of player names from login icon

**--WHY this story--**: The player should be able to interact with a login page.

**AS A** [ Player ]  
**I WANT** [ See the login page with a list of valid users I can log in as  ]  
**SO THAT** [  I can quickly log in to the system ]

**Acceptance Criteria**
 
**Scenario:** User can see a login page with a list of valid players  
**Given:** That there are players defined in the system  
**When:**  The user click the person icon in the upper right hand corner  
**Then:** Then the drop down menu contains a Sign In menu item  
**Given:** That the user has clicked the Sign In menu option  
**When:**  The user clicks the Sign In option  
**Then:** A login page is displayed with a list of valid users

---------------------------------------------------------------------------------
### (12) A-1 Logged in users name should show be displayed in header 

**--WHY this story--**: The player should be able to see who they are logged in as.

**AS A** [ Player ]  
**I WANT** [ See who I am logged in as ]  
**SO THAT** [  I can know I'm logged in ]  

**Acceptance Criteria**
 
**Scenario:** User can see a login name in header  
**Given:** That the user has not logged into the system  
**When:**  The user click selects a user from the login menu  
**Then:** The top page header should contain the user name  
**Given:** That the user has logged in to the system  
**When:**  The user clicks the Sign Out option  
**Then:** The top page header should not contain the user name

---------------------------------------------------------------------------------
### (13) A-1 Users who are not logged in should not be able to navigate to the play game pages

**--WHY this story--**: The player should not be able to go to play game page if they are not logged in.

**AS A** [ Player ]  
**I WANT** [ make sure that only valid users can play games ]  
**SO THAT** [  I know that the game results are valid ]  

**Acceptance Criteria**
 
**Scenario:** Only logged in users can play games  
**Given:** That the user has not logged into the system  
**When:**  The user click the hamburger in the upper right hand corner  
**Then:** The menu does not contain the Play Game Item  
**Given:** That the user has not logged into the system  
**When:**  The user enters the url to play game (eg. http://localhost:4200/play)  
**Then:** The Play Game page is not displayed  
**Given:** That the user has logged in to the system  
**When:**  The user click the hamburger in the upper right hand corner  
**Then:** The menu does contain the Play Game Item

---------------------------------------------------------------------------------
### (14) A-1 When a user goes to the play game page player 1 defaults to their name

**--WHY this story--**: The player 1 value should default to the logged in player

**AS A** [ logged in Player ]    
**I WANT** [ not have to select myself ]    
**SO THAT** [  I can play a game more quickly   ]

**Acceptance Criteria**
 
**Scenario:** Player 1 value is defaulted to logged in user  
**Given:** That the user has logged into the system  
**When:**  The user goes to the PLay Game page  
**Then:** The player1 menu has the logged in user selected
