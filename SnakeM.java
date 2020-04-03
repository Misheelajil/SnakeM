package Snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SnakeM {
	static boolean game = true;
	static boolean left = false;
	static boolean right = true;
	static boolean up = false;
	static boolean down = false;
	static final int WIDTH_BG = 800;
	static final int HEIGHT_BG = 800;
	static final int WIDTH_B = 800;
	static final int HEIGHT_B = 600;
	static Random random = new Random();
	// alim hiih Position
	static int RX = random.nextInt(WIDTH_B / 25) * 25;
	static int RY = random.nextInt(HEIGHT_B / 25) * 25;
	static Point snake = new Point(50, 50); // snake position
	static int a = 0; // snake size inc
	static int b = 1; // snake size limitter
	static final int nud = 25;
	static int gamespeed = 1000;
	static ArrayList<Point> snakeM = new ArrayList<Point>(); // snake position hadgalah arraylist
	static int score = 0; // onoo
	static int sizeShow = 3; // Snake urtiigni delgetsendeer uzuuleh
	static String str = "Score: " + score + " Size:" + sizeShow;
	static int gamespeedscoremodifier = 1;
	static boolean cheatpower = false;
	static String tip = "Press from 0 - 9 for gamespeed";
	static String CheatTip = "Press Numpad 1 for CheatPower" + "     Numpad 0 for disabling CheatPower";
	static boolean fastgrowth = false;
	static String growth = "Press Numpad 4 for Fast Growth" + "      Press Numpad 5 for default growth";
	static ArrayList<Point> freePositions = new ArrayList<Point>(); // Delgetsendeerh buh baij boloh tseg hadgalah
	static int tempRandom;
	static String show_position;
	static Point removed;
	static String message_win = "YOU WIN CONGRATS";
	static String message_lose = "GAME OVER";

	public static void main(String[] args) {
		JFrame J = new JFrame();
		Canvas canvas = new Canvas();
		J.setIgnoreRepaint(true);
		J.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.setSize(WIDTH_BG, HEIGHT_BG);
		J.add(canvas);
		J.pack();
		J.setVisible(true);
		J.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_LEFT) {

					left = true;
					right = false;
					up = false;
					down = false;
				} else if (key == KeyEvent.VK_RIGHT) {

					left = false;
					right = true;
					up = false;
					down = false;
				} else if (key == KeyEvent.VK_UP) {

					left = false;
					right = false;
					up = true;
					down = false;
				} else if (key == KeyEvent.VK_DOWN) {

					left = false;
					right = false;
					up = false;
					down = true;
				} else if (key == KeyEvent.VK_0) {
					gamespeed = 1000;
					gamespeedscoremodifier = 1;
				} else if (key == KeyEvent.VK_1) {
					gamespeed = 900;
					gamespeedscoremodifier = 2;
				} else if (key == KeyEvent.VK_2) {
					gamespeed = 800;
					gamespeedscoremodifier = 3;
				} else if (key == KeyEvent.VK_3) {
					gamespeed = 700;
					gamespeedscoremodifier = 4;
				} else if (key == KeyEvent.VK_4) {
					gamespeed = 600;
					gamespeedscoremodifier = 5;
				} else if (key == KeyEvent.VK_5) {
					gamespeed = 500;
					gamespeedscoremodifier = 6;
				} else if (key == KeyEvent.VK_6) {
					gamespeed = 400;
					gamespeedscoremodifier = 7;
				} else if (key == KeyEvent.VK_7) {
					gamespeed = 300;
					gamespeedscoremodifier = 8;
				} else if (key == KeyEvent.VK_8) {
					gamespeed = 200;
					gamespeedscoremodifier = 9;
				} else if (key == KeyEvent.VK_9) {
					gamespeed = 100;
					gamespeedscoremodifier = 10;
				} else if (key == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				} else if (key == KeyEvent.VK_NUMPAD0) {
					cheatpower = false;
				} else if (key == KeyEvent.VK_NUMPAD1) {
					cheatpower = true;
				} else if (key == KeyEvent.VK_NUMPAD4) {
					fastgrowth = true;
				} else if (key == KeyEvent.VK_NUMPAD5) {
					fastgrowth = false;
				} else if (key == KeyEvent.VK_MINUS) {
					gamespeed = 50;
					gamespeedscoremodifier = 10;
				} else {
					System.out.println("Wrong BUTTON");
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		canvas.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_LEFT) {

					left = true;
					right = false;
					up = false;
					down = false;
				} else if (key == KeyEvent.VK_RIGHT) {

					left = false;
					right = true;
					up = false;
					down = false;
				} else if (key == KeyEvent.VK_UP) {

					left = false;
					right = false;
					up = true;
					down = false;
				} else if (key == KeyEvent.VK_DOWN) {

					left = false;
					right = false;
					up = false;
					down = true;
				} else if (key == KeyEvent.VK_0) {
					gamespeed = 1000;
					gamespeedscoremodifier = 1;
				} else if (key == KeyEvent.VK_1) {
					gamespeed = 900;
					gamespeedscoremodifier = 2;
				} else if (key == KeyEvent.VK_2) {
					gamespeed = 800;
					gamespeedscoremodifier = 3;
				} else if (key == KeyEvent.VK_3) {
					gamespeed = 700;
					gamespeedscoremodifier = 4;
				} else if (key == KeyEvent.VK_4) {
					gamespeed = 600;
					gamespeedscoremodifier = 5;
				} else if (key == KeyEvent.VK_5) {
					gamespeed = 500;
					gamespeedscoremodifier = 6;
				} else if (key == KeyEvent.VK_6) {
					gamespeed = 400;
					gamespeedscoremodifier = 7;
				} else if (key == KeyEvent.VK_7) {
					gamespeed = 300;
					gamespeedscoremodifier = 8;
				} else if (key == KeyEvent.VK_8) {
					gamespeed = 200;
					gamespeedscoremodifier = 9;
				} else if (key == KeyEvent.VK_9) {
					gamespeed = 100;
					gamespeedscoremodifier = 10;
				} else if (key == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				} else if (key == KeyEvent.VK_NUMPAD0) {
					cheatpower = false;
				} else if (key == KeyEvent.VK_NUMPAD1) {
					cheatpower = true;
				} else if (key == KeyEvent.VK_NUMPAD4) {
					fastgrowth = true;
				} else if (key == KeyEvent.VK_NUMPAD5) {
					fastgrowth = false;
				} else if (key == KeyEvent.VK_MINUS) {
					gamespeed = 50;
					gamespeedscoremodifier = 10;
				} else {
					System.out.println("Wrong BUTTON");
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

		});
		// Olon zavsriin hadgalagch uusgeh bas ariin hadgalagchiig uusgeh
		canvas.createBufferStrategy(2);
		BufferStrategy buffer = canvas.getBufferStrategy();

		// anxdagch toxiruulga
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();

		// Delgetsnees gaduur zurah gadargui
		BufferedImage bi = gc.createCompatibleImage(WIDTH_BG, HEIGHT_BG);

		// Delgetsendeer zurah uildeliig aguulsan object uud
		Graphics graphics = null;
		Graphics2D g2d = null;
		// buh baij boloh tsegiig hiih
		for (int x = 0; x < WIDTH_B; x += nud) {
			for (int y = 0; y < HEIGHT_B; y += nud) {
				Point p = new Point(x, y);
				freePositions.add(p);
			}
		}
		while (game) {
			try {
				tick();
				g2d = bi.createGraphics();
				g2d.setColor(Color.ORANGE);
				g2d.fillRect(0, 0, WIDTH_B, HEIGHT_B);
				// Alimnii ongo bolon position
				g2d.setColor(Color.RED);
				g2d.fillRect(RX, RY, nud, nud);
				// Omnox score hesegiig darah har sambar
				g2d.setColor(Color.BLACK);
				g2d.fillRect(WIDTH_BG - 200, HEIGHT_BG - 125, 250, 25);
				// Cheatpowertoi ued Hanruu morgohod nogoo talaas garch ireh
				if (cheatpower) {
					if (snake.x >= WIDTH_B) {
						snake.x = 0;
					} else if (snake.x < 0) {
						snake.x = WIDTH_B;
						tick();
					} else if (snake.y >= HEIGHT_B) {
						snake.y = 0;
					} else if (snake.y < 0) {
						snake.y = HEIGHT_B;
						tick();
					}
				}
				// shine tolgoi nemegdeh
				snakeM.add(new Point(snake.x, snake.y));
				freePositions.remove(snake);
				if (!cheatpower) { // cheatpowergui ued
					// urt ni 4 bolood ehelheer mogoi baruun yavj bailla gehed
					// genet zuun zugruu chiglevel Over boloh nohtsol
					if (snakeM.size() > 3) {
						// suulee hazah
						for (int i = 0; i < snakeM.size() - 2; i++) {
							if (((snakeM.get(i).x == snakeM.get(snakeM.size() - 1).x))
									&& ((snakeM.get(i).y == snakeM.get(snakeM.size() - 1).y))) {
								game_OVER(J);
							}
						}
					}
				}
				// Mogoigoo zurah tseguud bolon ongo nuud
				for (int i = 0; i < snakeM.size(); i++) {
					if (i == (snakeM.size() - 1)) {
						// Mogoin tolgoi
						g2d.setColor(Color.BLUE);
						g2d.fillRect(snakeM.get(i).x, snakeM.get(i).y, nud, nud);
					} else {
						// suul
						g2d.setColor(Color.GREEN);
						g2d.fillRect(snakeM.get(i).x, snakeM.get(i).y, nud, nud);
					}
				}
				str = "Score: " + score + " Size:" + sizeShow;
				g2d.setColor(Color.WHITE);
				g2d.drawString(str, WIDTH_BG - 200, HEIGHT_BG - 100);// Score uzuuleh sambar
				g2d.drawString(tip, 50, HEIGHT_BG - 100);
				g2d.drawString(CheatTip, 50, HEIGHT_BG - 50);
				g2d.drawString(growth, 50, HEIGHT_BG - 75); // xar sambardeerh ugnuudiin bairlal
				show_position = snake.x + " " + snake.y;
				g2d.drawString(show_position, WIDTH_BG - 75, HEIGHT_BG - 100);
				// zuragnuudiig niiluuleed Ar bolon urd taliin Zuragiig solino
				graphics = buffer.getDrawGraphics();
				graphics.drawImage(bi, 0, 0, null);
				// bufferimage iig odoo baigaa bufferstrategy bufferimage bolgono
				buffer.show();
				// alimdeer ochihod
				if (snakeM.get(snakeM.size() - 1).x == RX && snakeM.get(snakeM.size() - 1).y == RY) {
					// alim hurehed hurdatstai osoh
					if (fastgrowth) {
						b += gamespeedscoremodifier;
						sizeShow += gamespeedscoremodifier;
					} else {
						// alim hurehed engiin 1 eer osoh
						b++;
						sizeShow++; // hemjeeg uzuulsen
					}
					// Delgets Duurehed hojloo gej garah message
					if (freePositions.size() < 1) {
						game_WIN(J);

					}
					// FreePointsoos element ee random songood alimaa bairluulax
					tempRandom = random.nextInt(freePositions.size());
					freePositions.get(tempRandom);
					RX = freePositions.get(tempRandom).x;
					RY = freePositions.get(tempRandom).y;
					score += gamespeedscoremodifier;
				}
				// b gesen limitnees hetereh ued suulnees [0] deer baigaagni
				if (a > b) {

					Point removed = snakeM.remove(0);
					if (!snakeM.contains(removed)) {
						freePositions.add(removed);//
					}
				} else {
					a++;
				}
				// Hana tsomloxod garch ireh Game OVER message
				if (snake.x < 0 || snake.x >= WIDTH_B || snake.y < 0 || snake.y >= HEIGHT_B) {
					game_OVER(J);
				}

				Thread.sleep(gamespeed);
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				// graphics aa tseverleh
				if (graphics != null)
					graphics.dispose();
				if (g2d != null)
					g2d.dispose();
			}
		}

	}

	// daraagiin yavah positioniig avan move
	static void tick() {
		if (left) {
			snake.x -= nud;
		} else if (right) {
			snake.x += nud;
		} else if (up) {
			snake.y -= nud;
		} else if (down) {
			snake.y += nud;
		}
	}

	static void game_OVER(JFrame J) {
		game = false;

		JOptionPane.showMessageDialog(J, message_lose);

		System.exit(0);
	}

	static void game_WIN(JFrame J) {
		game = false;
		JOptionPane.showMessageDialog(J, message_win);
		System.exit(0);
	}

}
