//package entity;
//
//
//import static utilz.Constants.PlayerConstants.*;
//import static utilz.HelpMethods.*;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Point;
//import java.awt.geom.Rectangle2D;
//import java.awt.image.BufferedImage;
//
//import gamestates.Playing;
//import main.Game;
//import utilz.LoadSave;
//
//public class Player extends Entity {
//	private BufferedImage[][] animations;
//	private int aniTick, aniIndex, aniSpeed = 25;
//	private int playerAction = IDLE;
//	private boolean moving = false, attacking = false;
//	private boolean left, up, right, down, jump;
//	private float playerSpeed = 1.0f * Game.SCALE;
//	private int[][] lvlData;
//	private float xDrawOffset = 21 * Game.SCALE;
//	private float yDrawOffset = 4 * Game.SCALE;
//
//	// AttackBox
//	private Rectangle2D.Float attackBox;
//
//	private int flipX = 0;
//	private int flipW = 1;
//
//	private boolean attackChecked;
//	private Playing playing;
//
//	public Player(float x, float y, int width, int height, Playing playing) {
//		super(x, y, width, height);
//		this.playing = playing;
//		loadAnimations();
//		initHitbox(x, y, (int) (20 * Game.SCALE), (int) (27 * Game.SCALE));
//		initAttackBox();
//	}
//
//	public void setSpawn(Point spawn) {
//		this.x = spawn.x;
//		this.y = spawn.y;
//		hitbox.x = x;
//		hitbox.y = y;
//	}
//
//	private void initAttackBox() {
//		attackBox = new Rectangle2D.Float(x, y, (int) (20 * Game.SCALE), (int) (20 * Game.SCALE));
//	}
//
//	public void update() {
//
//		if (currentHealth <= 0) {
//			playing.setGameOver(true);
//			return;
//		}
//
//		updatePos();
//		if (attacking)
//			checkAttack();
//		updateAnimationTick();
//		setAnimation();
//	}
//
//	private void checkAttack() {
//		if (attackChecked || aniIndex != 1)
//			return;
//		attackChecked = true;
//		playing.checkEnemyHit(attackBox);
//
//	}
//
//	private void updateAttackBox() {
//		if (right)
//			attackBox.x = hitbox.x + hitbox.width + (int) (Game.SCALE * 10);
//		else if (left)
//			attackBox.x = hitbox.x - hitbox.width - (int) (Game.SCALE * 10);
//
//		attackBox.y = hitbox.y + (Game.SCALE * 10);
//	}
//
//
//	public void render(Graphics g, int lvlOffset) {
//		g.drawImage(animations[playerAction][aniIndex], (int) (hitbox.x - xDrawOffset) - lvlOffset + flipX, (int) (hitbox.y - yDrawOffset), width * flipW, height, null);
////		drawHitbox(g, lvlOffset);
////		drawAttackBox(g, lvlOffset);
//		drawUI(g);
//	}
//
//
//	private void updateAnimationTick() {
//		aniTick++;
//		if (aniTick >= aniSpeed) {
//			aniTick = 0;
//			aniIndex++;
//			if (aniIndex >= GetSpriteAmount(playerAction)) {
//				aniIndex = 0;
//				attacking = false;
//				attackChecked = false;
//			}
//
//		}
//
//	}
//
//	private void setAnimation() {
//		int startAni = playerAction;
//
//		if (moving)
//			playerAction = RUNNING;
//		else
//			playerAction = IDLE;
//
//		if (attacking) {
//			playerAction = ATTACK;
//			if (startAni != ATTACK) {
//				aniIndex = 1;
//				aniTick = 0;
//				return;
//			}
//		}
//		if (startAni != playerAction)
//			resetAniTick();
//	}
//
//	private void resetAniTick() {
//		aniTick = 0;
//		aniIndex = 0;
//	}
//
//	private void updatePos() {
//		moving = false;
//
//
//		if (left) {
//			xSpeed -= playerSpeed;
//			flipX = width;
//			flipW = -1;
//		}
//		if (right) {
//			xSpeed += playerSpeed;
//			flipX = 0;
//			flipW = 1;
//		}
//
//
//	private void updateXPos(float xSpeed) {
//		if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData))
//			hitbox.x += xSpeed;
//		else
//			hitbox.x = GetEntityXPosNextToWall(hitbox, xSpeed);
//	}
//
//	public void changeHealth(int value) {
//		currentHealth += value;
//
//		if (currentHealth <= 0)
//			currentHealth = 0;
//		else if (currentHealth >= maxHealth)
//			currentHealth = maxHealth;
//	}
//
//	private void loadAnimations() {
//		BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
//		animations = new BufferedImage[7][8];
//		for (int j = 0; j < animations.length; j++)
//			for (int i = 0; i < animations[j].length; i++)
//				animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
//
//		statusBarImg = LoadSave.GetSpriteAtlas(LoadSave.STATUS_BAR);
//	}
//
//
//	public void resetDirBooleans() {
//		left = false;
//		right = false;
//		up = false;
//		down = false;
//	}
//
//	public void setAttacking(boolean attacking) {
//		this.attacking = attacking;
//	}
//
//	public boolean isLeft() {
//		return left;
//	}
//
//	public void setLeft(boolean left) {
//		this.left = left;
//	}
//
//	public boolean isUp() {
//		return up;
//	}
//
//	public void setUp(boolean up) {
//		this.up = up;
//	}
//
//	public boolean isRight() {
//		return right;
//	}
//
//	public void setRight(boolean right) {
//		this.right = right;
//	}
//
//	public boolean isDown() {
//		return down;
//	}
//
//	public void setDown(boolean down) {
//		this.down = down;
//	}
//
//	public void setJump(boolean jump) {
//		this.jump = jump;
//	}
//
//	public void resetAll() {
//		resetDirBooleans();
//
//		moving = false;
//		playerAction = IDLE;
//		currentHealth = maxHealth;
//
//		hitbox.x = x;
//		hitbox.y = y;
//	}
//
//}