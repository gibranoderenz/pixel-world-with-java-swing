package src.tile;

import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

import src.main.GamePanel;

public class TileManager {
	GamePanel gp;
	public Tile[] tiles;
	public int[][] mapTileNum;
	public String mapName;

	public TileManager(GamePanel gp, String mapName) {
		this.gp = gp;
		this.tiles = new Tile[50];
		this.mapName = mapName;
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		getTileImage();
		loadMap(mapName);
	}

	// Loads the unique tiles to the tiles array
	public void getTileImage() {
		try {
			// manor tiles
			tiles[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/res/tiles/manor/blank.png")));
			tiles[0].collision = true;
			tiles[1] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/manor/left_bottom_arc_border.png")));
			tiles[2] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/manor/left_top_arc_border.png")));
			tiles[3] = new Tile(ImageIO
					.read(getClass().getResourceAsStream("/res/tiles/manor/main_floor.png")));
			tiles[4] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/manor/right_bottom_arc_border.png")));
			tiles[5] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/manor/right_top_arc_border.png")));
			tiles[6] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/manor/side_bottom_border.png")));
			tiles[7] = new Tile(ImageIO
					.read(getClass().getResourceAsStream("/res/tiles/manor/side_left_border.png")));
			tiles[7].collision = true;
			tiles[8] = new Tile(ImageIO.read(
					getClass().getResourceAsStream("/res/tiles/manor/side_right_border.png")));
			tiles[8].collision = true;
			tiles[9] = new Tile(ImageIO
					.read(getClass().getResourceAsStream("/res/tiles/manor/side_top_border.png")));
			tiles[9].collision = true;
			tiles[10] = new Tile(ImageIO
					.read(getClass().getResourceAsStream("/res/tiles/manor/wall_bottom.png")));
			tiles[10].collision = true;
			tiles[11] = new Tile(
					ImageIO.read(getClass().getResourceAsStream("/res/tiles/manor/wall_top.png")));
			tiles[12] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/manor/edge_bottom_left_border.png")));
			tiles[12].collision = true;
			tiles[13] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/manor/edge_bottom_right_border.png")));
			tiles[13].collision = true;
			tiles[14] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/manor/edge_top_left_border.png")));
			tiles[14].collision = true;
			tiles[15] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/manor/edge_top_right_border.png")));
			tiles[15].collision = true;
			tiles[16] = new Tile(ImageIO
					.read(getClass().getResourceAsStream("/res/tiles/manor/left_stairs.png")));
			tiles[17] = new Tile(ImageIO
					.read(getClass().getResourceAsStream("/res/tiles/manor/main_stairs.png")));

			// kitchen tiles
			tiles[18] = new Tile(
					ImageIO.read(getClass().getResourceAsStream("/res/tiles/kitchen/blank.png")));
			tiles[18].collision = true;
			tiles[19] = new Tile(ImageIO
					.read(getClass().getResourceAsStream("/res/tiles/kitchen/blue_floor.png")));
			tiles[20] = new Tile(ImageIO
					.read(getClass().getResourceAsStream("/res/tiles/kitchen/yellow_floor.png")));
			tiles[21] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/edge_bottom_left_border.png")));
			tiles[21].collision = true;
			tiles[22] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/edge_bottom_right_border.png")));
			tiles[22].collision = true;
			tiles[23] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/edge_top_left_border.png")));
			tiles[23].collision = true;
			tiles[24] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/edge_top_right_border.png")));
			tiles[24].collision = true;
			tiles[25] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/left_bottom_arc_border.png")));
			tiles[26] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/right_bottom_arc_border.png")));
			tiles[27] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/left_top_arc_border.png")));
			tiles[28] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/right_top_arc_border.png")));
			tiles[29] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/side_left_border.png")));
			tiles[29].collision = true;
			tiles[30] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/side_right_border.png")));
			tiles[30].collision = true;
			tiles[31] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/side_top_border.png")));
			tiles[31].collision = true;
			tiles[32] = new Tile(
					ImageIO.read(getClass().getResourceAsStream(
							"/res/tiles/kitchen/side_bottom_border.png")));
			tiles[32].collision = true;
			tiles[33] = new Tile(ImageIO
					.read(getClass().getResourceAsStream("/res/tiles/kitchen/wall_top.png")));
			tiles[34] = new Tile(ImageIO
					.read(getClass().getResourceAsStream("/res/tiles/kitchen/wall_bottom.png")));
			tiles[34].collision = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Loads the tile details to the mapTileNum array
	public void loadMap(String mapName) {
		try (Scanner sc = new Scanner(new File(String.format("res/maps/%s.txt", mapName)))) {
			int row = 0;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] numbers = line.split(" ");
				for (int col = 0; col < numbers.length; col++) {
					mapTileNum[col][row] = Integer.parseInt(numbers[col]);
				}
				row++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Welcome to the " + mapName + ".");
	}

	public void changeMap(String mapName) {
		this.mapName = mapName;
		gp.setupGame();
		loadMap(mapName);
	}

	// draws each tile to the screen with camera feature
	public void draw(Graphics2D g2) {
		for (int col = 0; col < gp.maxScreenCol; col++) {
			int x = col * gp.tileSize;
			for (int row = 0; row < gp.maxScreenRow; row++) {
				int tileNum = mapTileNum[col][row];
				int y = row * gp.tileSize;
				// draw the tile to the screen
				g2.drawImage(tiles[tileNum].image, x, y, gp.tileSize, gp.tileSize,
						null);
			}
		}
	}
}
