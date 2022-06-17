package src.main;

import src.chars.Entity;
import src.objects.SuperObject;

public class CollisionHandler {
    GamePanel gp;

    public CollisionHandler(GamePanel gp) {
        this.gp = gp;
    }

    public boolean checkTile(Entity entity) {
        int entityLeftCol = entity.solidArea.x / gp.tileSize;
        int entityRightCol = (entity.solidArea.x + entity.solidArea.width) / gp.tileSize;
        int entityTopRow = entity.solidArea.y / gp.tileSize;
        int entityBottomRow = (entity.solidArea.y + entity.solidArea.height) / gp.tileSize;

        int tileNum0, tileNum1;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entity.solidArea.y - entity.speed) / gp.tileSize;
                tileNum0 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tiles[tileNum0].collision || gp.tileM.tiles[tileNum1].collision) {
                    return true;
                }
                break;
            case "down":
                entityBottomRow = (entity.solidArea.y + entity.solidArea.height + entity.speed) / gp.tileSize;
                tileNum0 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tiles[tileNum0].collision || gp.tileM.tiles[tileNum1].collision) {
                    return true;
                }
                break;
            case "left":
                entityLeftCol = (entity.solidArea.x - entity.speed) / gp.tileSize;
                tileNum0 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tiles[tileNum0].collision || gp.tileM.tiles[tileNum1].collision) {
                    return true;
                }
                break;
            case "right":
                entityRightCol = (entity.solidArea.x + entity.solidArea.width + entity.speed) / gp.tileSize;
                tileNum0 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tiles[tileNum0].collision || gp.tileM.tiles[tileNum1].collision) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean checkObject(Entity entity) {
        for (SuperObject obj : gp.objects) {
            if (obj != null) {
                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(obj.solidArea) && obj.collisionOn) {
                            if (obj.triggerChangeMap) {
                                switch (gp.tileM.mapName) {
                                    case "lobby":
                                        gp.tileM.changeMap("kitchen");
                                        entity.y = gp.tileSize * 10;
                                        break;
                                    case "kitchen":
                                        gp.tileM.changeMap("lobby");
                                        entity.y = gp.tileSize * 3 - 10;
                                        break;
                                }
                                resetEntitySolidArea(entity);
                            }
                            return true;
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(obj.solidArea) && obj.collisionOn) {
                            if (obj.triggerChangeMap) {
                                switch (gp.tileM.mapName) {
                                    case "lobby":
                                        gp.tileM.changeMap("kitchen");
                                        entity.y = gp.tileSize * 10;
                                        break;
                                    case "kitchen":
                                        gp.tileM.changeMap("lobby");
                                        entity.y = gp.tileSize * 3 - 10;
                                        break;
                                }
                                resetEntitySolidArea(entity);
                            }
                            return true;
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(obj.solidArea) && obj.collisionOn) {
                            if (obj.triggerChangeMap) {
                                switch (gp.tileM.mapName) {
                                    case "lobby":
                                        gp.tileM.changeMap("kitchen");
                                        entity.y = gp.tileSize * 10;
                                        break;
                                    case "kitchen":
                                        gp.tileM.changeMap("lobby");
                                        entity.y = gp.tileSize * 3 - 10;
                                        break;
                                }
                                resetEntitySolidArea(entity);
                            }
                            return true;
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(obj.solidArea) && obj.collisionOn) {
                            if (obj.triggerChangeMap) {
                                switch (gp.tileM.mapName) {
                                    case "lobby":
                                        gp.tileM.changeMap("kitchen");
                                        entity.y = gp.tileSize * 10;
                                        break;
                                    case "kitchen":
                                        gp.tileM.changeMap("lobby");
                                        entity.y = gp.tileSize * 3 - 10;
                                        break;
                                }
                                resetEntitySolidArea(entity);
                            }
                            return true;
                        }
                        break;
                }
                resetEntitySolidArea(entity);
            }
        }
        return false;
    }

    private void resetEntitySolidArea(Entity entity) {
        entity.solidArea.x = entity.x + 57;
        entity.solidArea.y = entity.y + 64;
    }
}
