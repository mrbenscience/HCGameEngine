import java.awt.Color;

public class Game extends HCLogic{
	
	HCGame game;
	int x = 0;
	int y = 0;
	
	public static void main(String[] args) {
		new Game();

	}
	
	public Game() {
		game = new HCGame("name goes here", 500, 500, this);
		game.setBackground(Color.BLACK);
		game.start();
	}
	
	public void update() {
		if(game.getKey('d')) {
			x++;
		}
		if(game.getKey('a')) {
			x--;
		}
		if(game.getKey('w')) {
			y--;
		}
		if(game.getKey('s')) {
			y++;
		}
		game.setDrawColor(Color.cyan);
		game.drawRect(x, y, 100, 100, true);
	}

}
