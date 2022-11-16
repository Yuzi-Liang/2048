<h2 align = "center">
Application Requirements Specification  <br> for <br> Term Project
</h2> 


<center>Prepared By: <br> Jiafan Lin, Yuzi Liang </center>



### **Purpose and Scope Statement**
The purpose of our project is a strategic game for entertainment. The scope of this project includes puzzles, requirements for long-term planning and brainstorming during playtime. It is a good application for users to spend their spare time.



### **Requirements**
In our project, when players enter the game, they will have options to start a new game or exit. Once they start a new game, the requirements for gameplay are as following:

1. Allow players to slide the board with arrow keys if there is space

2. Allow players to select different sizes of game board

3. Allow players to name their games

4. Store records of scores from past players and their names

   


### **Objectives**
Sam is a big fan of *2048.* This weekend he is free and has a lot of spare time. He decides to play *2048.* When he starts the application, an interface with “start” and “exit” options appears. He clicks on the “start” button and chooses to play a quick game with a 3x3 game board. He then names his game “King of 2048” and starts his gameplay. As values of number blocks get larger, the game becomes harder and there are less empty spots. Finally, there is no free space and the game ends. The system saves the score and player name of this game, and Sam returns to the main page.



### **Functional Specification**

1. Generate “2” or “4” number block at a random empty spot on game board with ratio 9:1
2. Evaluate if there is any block can be combined
3. Evaluate if one game is ended
4. Scroll the game board in 4 directions
5. Store records of scores from past players and their names locally
6. Deploy on local machine and web

Required libraries: swing, KeyAdapter, KeyEvent, 2DArray



### **Logic Specification**

<img src="https://github.com/Yuzi-Liang/INFO5100TermProject/blob/main/image/figure_1.png">









