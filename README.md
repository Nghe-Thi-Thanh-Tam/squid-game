# Squid Game
OOP final project

We are **JABON**

**Team Member**

	Nghê Thị Thanh Tâm ITITIU20302

	email: ITITIU20302@student.hcmiu.edu.vn

	Nguyễn Vũ Nhật Quang ITITIU20149

	email: ITITIU201492@student.hcmiu.edu.vn

	Nguyễn Trần Trung Kỳ ITITIU20240

	email: ITITIU20240@student.hcmiu.edu.vn

	Nguyễn Hoàng Thiên Phúc ITITIU20279

	email: ITITIU20279@student.hcmiu.edu.vn


**Motivation**

Several months ago, there was a viral movie on Netflix called Squid Game, and we watched it and found it quite interesting to implement a 2D game for this movie. The game is simple to understand, and fun to play. So, we wanted to take the challenge to do this game. However, we faced many new concepts in the process of making this game. At first, we proposed to make only 1 game out of the 5 games, but Tom said it would be more challenging if player play the whole sequence of Squid Game. Therefore, we made 2 more games. We wanted to make a game feature 8-bit art of style.

## CONCEPT:
This includes 3 games:

### Red light green light:
This game has two team, 👧the catcher and🏃the player.

🟩 The player _can only_ run when the catcher said **green light** and face **the back**.

🟥 The player cannot move when the catcher said **red light** and face **the front**. 

❌ If the player get caught moving when catcher said red light, he lose. You only lose the game not your life in the movie.

✅ The player win if he reach the finish line before time is ran out without get caught.


**Primary Feature(must-have):**
- Fully Functional GUI,
- One bot to catch the player
- A timer to count the time left for each game, and it display on the screen for the player to see
- Player clock to count the difference in time(this is subject to change if we found better method)
- Bots playing with player(10+, but most of them will lose the game)

**Secondary Feature(nice-to-have):**
          
- SFX (Game start, Game-over, Win,...)
- Due to licensing fee, I won't get "Fly me to the moon in the game"
- Multiplayer, possibly in the same wifi, not online.
- Nice Backdrop(2D only)
- Eliminate player animation.
- Booster item to go faster or invisible in the game

**Language**
Java

**Task allocation**

Quang: code for main class

Tam: create images, code for bots

Phuc: code for player

Ky: code for catcher

**Results:**

![rlgl1](https://user-images.githubusercontent.com/93080032/173177561-67549a46-1985-49ec-81d8-fe6bdca52997.png)

![rlgl](https://user-images.githubusercontent.com/93080032/173177572-add8c18d-007e-41c3-8c0b-e5ae8a871792.png)


**Previous Implementation**
  https://github.com/0shuvo0/squidgame
  
**UML**
![newuml](https://user-images.githubusercontent.com/93000383/173159124-f0f0c175-52f1-4d4d-b6d3-2d87e6fbd7ad.png)

**Unfinished feature**
**No LogicGame due to bugs**

## Tug of war

**How to play:**
- This game has two team, player team (on the right) and opponent team (on the left)
- :computer_mouse: Use your mouse to click on the screen
- Try to click fast to drag the opponent team
- :trophy: The game ends when the outmost person of the team reach the wall behind, :skull: that's when the other team will all fall down.

**Unfinished features**
:mute: SFX

**Language**
Java

**Task allocation**
Tam: code, create images

**Results:**

![image](https://user-images.githubusercontent.com/91868406/173172780-f6bbadf6-1749-4d8c-a850-cee756efcc32.png)

![image](https://user-images.githubusercontent.com/91868406/173172793-d6b7a9ba-3ea9-4ea3-a600-a1a90f1dcf16.png)

![image](https://user-images.githubusercontent.com/91868406/173172816-e57e67bf-141f-4495-bea5-d6de6bb12a4c.png)


**UML**
![UML class (2)](https://user-images.githubusercontent.com/91868406/173173000-35d9ccad-af67-44b2-a95b-d775a3bf9484.png)


## Glass bridge

**How to play:**

The goal of the game was for players to successfully cross the bridges by jumping across the tempered glass while avoiding the regular glass
This game has only 1 player and you use keyboard to make player move.
	Press W to move up.
	Press S to move down

Try to guess and pick the tempered glass 

The game ends when the player take over the glass bridge or pick the wrong glass panel

**Unfinished features**
:mute: SFX; 
Jump animation

**Language** 
Java


**Task allocation**

Tam: create images;
 
Phuc: code for map & main;

Ky: code for player



![image](https://user-images.githubusercontent.com/91868450/173168691-2b7f6020-1c83-4898-8561-b8fb4024a995.png)
![image](https://user-images.githubusercontent.com/91868450/173175965-ec678dde-dd73-47e6-a601-4730bf7d0afc.png)
![image](https://user-images.githubusercontent.com/91868450/173175970-6e21efbe-3500-41d9-be9d-141998ce77b1.png)



**UML**
![image](https://user-images.githubusercontent.com/91868450/173116364-3a3ca030-fb3a-4c2b-8e7b-0f39d2ecd63f.png)

## Library: 

java.awt.image

java.awt.event.KeyEvent

java.awt.event.KeyListener

java.io.File

java.io.IOExeption

javax.swing.ImageIcon

java.awt.event.ActionEvent

java.awt.event.ActionListener

java.util.ArrayList

java.awt.Graphics2D

javax.swing.JFrame

java.awt.event.MouseEvent

java.awt.event.MouseListener

## References: 

https://www.youtube.com/watch?v=om59cwR7psI 

https://www.youtube.com/watch?v=VpH33Uw-_0E

https://www.youtube.com/watch?v=wT9uNGzMEM4
