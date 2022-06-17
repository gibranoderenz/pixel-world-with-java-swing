package src.main;

import src.objects.Furniture;

public class ObjectSetter {
    GamePanel gp;

    public ObjectSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject(String mapName) {
        // instantiate new object and place in map based on map name
        switch (gp.tileM.mapName) {
            case "lobby":
                // furnitures
                gp.objects[0] = new Furniture("/res/objects/manor/furnitures/s_curtain.png");
                gp.objects[0].x = gp.tileSize * 3;
                gp.objects[0].y = gp.tileSize * 2;
                gp.objects[0].width = gp.tileSize * 2;
                gp.objects[0].height = gp.tileSize * 2;

                gp.objects[1] = new Furniture("/res/objects/manor/furnitures/s_window.png");
                gp.objects[1].x = gp.tileSize * 5;
                gp.objects[1].y = gp.tileSize + 64;
                gp.objects[1].width = gp.tileSize;
                gp.objects[1].height = gp.tileSize + 16;

                gp.objects[2] = new Furniture("/res/objects/manor/furnitures/l_curtain.png");
                gp.objects[2].x = gp.tileSize * 6 + 7;
                gp.objects[2].y = gp.tileSize * 2;
                gp.objects[2].width = gp.tileSize + 80;
                gp.objects[2].height = gp.tileSize * 2;

                gp.objects[3] = new Furniture("/res/objects/manor/furnitures/s_window.png");
                gp.objects[3].x = gp.tileSize * 9;
                gp.objects[3].y = gp.tileSize + 64;
                gp.objects[3].width = gp.tileSize;
                gp.objects[3].height = gp.tileSize + 16;

                gp.objects[4] = new Furniture("/res/objects/manor/furnitures/s_curtain.png");
                gp.objects[4].x = gp.tileSize * 10 - 7;
                gp.objects[4].y = gp.tileSize * 2;
                gp.objects[4].width = gp.tileSize * 2;
                gp.objects[4].height = gp.tileSize * 2;

                gp.objects[5] = new Furniture("/res/objects/manor/furnitures/front_open_door.png");
                gp.objects[5].collisionOn = true;
                gp.objects[5].triggerChangeMap = true;
                gp.objects[5].x = gp.tileSize * 13;
                gp.objects[5].y = gp.tileSize - 2;
                gp.objects[5].width = gp.tileSize * 2;
                gp.objects[5].height = gp.tileSize * 3;
                gp.objects[5].solidArea.x = gp.tileSize * 13;
                gp.objects[5].solidArea.y = gp.tileSize * 2;
                gp.objects[5].solidArea.width = gp.objects[5].width;
                gp.objects[5].solidArea.height = gp.tileSize;

                gp.objects[6] = new Furniture("/res/objects/manor/furnitures/s_bookshelf.png");
                gp.objects[6].collisionOn = true;
                gp.objects[6].x = gp.tileSize * 16;
                gp.objects[6].y = gp.tileSize * 3;
                gp.objects[6].width = gp.tileSize;
                gp.objects[6].height = gp.tileSize * 2;
                gp.objects[6].solidArea.x = gp.objects[6].x;
                gp.objects[6].solidArea.y = gp.objects[6].y;
                gp.objects[6].solidArea.width = gp.objects[6].width;
                gp.objects[6].solidArea.height = gp.objects[6].height;

                gp.objects[7] = new Furniture("/res/objects/manor/furnitures/m_bookshelf.png");
                gp.objects[7].collisionOn = true;
                gp.objects[7].x = gp.tileSize * 17;
                gp.objects[7].y = gp.tileSize * 2;
                gp.objects[7].width = gp.tileSize;
                gp.objects[7].height = gp.tileSize * 3;
                gp.objects[7].solidArea.x = gp.objects[7].x;
                gp.objects[7].solidArea.y = gp.objects[7].y;
                gp.objects[7].solidArea.width = gp.objects[7].width;
                gp.objects[7].solidArea.height = gp.objects[7].height;

                gp.objects[8] = new Furniture("/res/objects/manor/furnitures/l_bottom_sofa.png");
                gp.objects[8].collisionOn = true;
                gp.objects[8].x = gp.tileSize * 4 + 8;
                gp.objects[8].y = gp.tileSize * 4 + 16;
                gp.objects[8].width = gp.tileSize * 3;
                gp.objects[8].height = gp.tileSize * 2;
                gp.objects[8].solidArea.x = gp.objects[8].x;
                gp.objects[8].solidArea.y = gp.objects[8].y;
                gp.objects[8].solidArea.width = gp.objects[8].width;
                gp.objects[8].solidArea.height = gp.objects[8].height;

                gp.objects[9] = new Furniture("/res/objects/manor/furnitures/rect_carpet.png");
                gp.objects[9].x = gp.tileSize * 4 + 8;
                gp.objects[9].y = gp.tileSize * 7;
                gp.objects[9].width = gp.tileSize * 3;
                gp.objects[9].height = gp.tileSize + 32;

                gp.objects[10] = new Furniture("/res/objects/manor/furnitures/l_right_sofa.png");
                gp.objects[10].collisionOn = true;
                gp.objects[10].x = gp.tileSize * 2 + 8;
                gp.objects[10].y = gp.tileSize * 6;
                gp.objects[10].width = gp.tileSize + 32;
                gp.objects[10].height = gp.tileSize * 3;
                gp.objects[10].solidArea.x = gp.objects[10].x;
                gp.objects[10].solidArea.y = gp.objects[10].y + 10;
                gp.objects[10].solidArea.width = gp.objects[10].width;
                gp.objects[10].solidArea.height = gp.objects[10].height - 20;

                gp.objects[11] = new Furniture("/res/objects/manor/furnitures/l_left_sofa.png");
                gp.objects[11].collisionOn = true;
                gp.objects[11].x = gp.tileSize * 7 + 16;
                gp.objects[11].y = gp.tileSize * 6;
                gp.objects[11].width = gp.tileSize + 32;
                gp.objects[11].height = gp.tileSize * 3;
                gp.objects[11].solidArea.x = gp.objects[11].x;
                gp.objects[11].solidArea.y = gp.objects[11].y + 5;
                gp.objects[11].solidArea.width = gp.objects[11].width;
                gp.objects[11].solidArea.height = gp.objects[11].height - 10;

                gp.objects[12] = new Furniture("/res/objects/manor/furnitures/circle_carpet.png");
                gp.objects[12].x = gp.tileSize * 13;
                gp.objects[12].y = gp.tileSize * 9;
                gp.objects[12].width = gp.tileSize * 2;
                gp.objects[12].height = gp.tileSize * 2;

                gp.objects[13] = new Furniture("/res/objects/manor/furnitures/s_left_sofa.png");
                gp.objects[13].collisionOn = true;
                gp.objects[13].x = gp.tileSize * 15 + 10;
                gp.objects[13].y = gp.tileSize * 8 + 25;
                gp.objects[13].width = gp.tileSize + 20;
                gp.objects[13].height = gp.tileSize * 2 + 20;
                gp.objects[13].solidArea.x = gp.objects[13].x;
                gp.objects[13].solidArea.y = gp.objects[13].y + 10;
                gp.objects[13].solidArea.width = gp.objects[13].width;
                gp.objects[13].solidArea.height = gp.objects[13].height - 20;
                break;
            case "kitchen":
                // furnitures
                gp.objects[0] = new Furniture("/res/objects/kitchen/furnitures/topside_door.png");
                gp.objects[0].collisionOn = true;
                gp.objects[0].triggerChangeMap = true;
                gp.objects[0].x = gp.tileSize * 13 - 5;
                gp.objects[0].y = gp.tileSize * 12 + 12;
                gp.objects[0].width = gp.tileSize * 2 + 5;
                gp.objects[0].height = gp.tileSize * 2 - 2;
                gp.objects[0].solidArea.x = gp.objects[0].x + 10;
                gp.objects[0].solidArea.y = gp.objects[0].y + 20;
                gp.objects[0].solidArea.width = gp.objects[0].width - 20;
                gp.objects[0].solidArea.height = gp.tileSize;

                gp.objects[1] = new Furniture("/res/objects/kitchen/furnitures/fireplace.png");
                gp.objects[1].collisionOn = true;
                gp.objects[1].x = gp.tileSize * 13;
                gp.objects[1].y = gp.tileSize + 30;
                gp.objects[1].width = gp.tileSize * 3;
                gp.objects[1].height = gp.tileSize * 3 + 30;
                gp.objects[1].solidArea.x = gp.objects[1].x;
                gp.objects[1].solidArea.y = gp.objects[1].y;
                gp.objects[1].solidArea.width = gp.objects[1].width;
                gp.objects[1].solidArea.height = gp.objects[1].height - 20;

                gp.objects[2] = new Furniture("/res/objects/kitchen/furnitures/l_window.png");
                gp.objects[2].x = gp.tileSize * 6;
                gp.objects[2].y = gp.tileSize * 2 + 15;
                gp.objects[2].width = gp.tileSize * 2 - 10;
                gp.objects[2].height = gp.tileSize + 10;

                gp.objects[3] = new Furniture("/res/objects/kitchen/furnitures/dual_cupboard.png");
                gp.objects[3].collisionOn = true;
                gp.objects[3].x = gp.tileSize * 2;
                gp.objects[3].y = gp.tileSize * 3 - 30;
                gp.objects[3].width = gp.tileSize * 3 - 20;
                gp.objects[3].height = gp.tileSize * 3 - 30;
                gp.objects[3].solidArea.x = gp.objects[3].x;
                gp.objects[3].solidArea.y = gp.objects[3].y;
                gp.objects[3].solidArea.width = gp.objects[3].width;
                gp.objects[3].solidArea.height = gp.objects[3].height;

                gp.objects[4] = new Furniture("/res/objects/kitchen/furnitures/combo_cupboard.png");
                gp.objects[4].collisionOn = true;
                gp.objects[4].x = gp.tileSize * 9;
                gp.objects[4].y = gp.tileSize * 2 + 10;
                gp.objects[4].width = gp.tileSize * 3 - 20;
                gp.objects[4].height = gp.tileSize * 2 + 10;
                gp.objects[4].solidArea.x = gp.objects[4].x;
                gp.objects[4].solidArea.y = gp.objects[4].y;
                gp.objects[4].solidArea.width = gp.objects[4].width;
                gp.objects[4].solidArea.height = gp.objects[4].height;

                gp.objects[5] = new Furniture("/res/objects/kitchen/furnitures/circle_table.png");
                gp.objects[5].collisionOn = true;
                gp.objects[5].x = gp.tileSize * 7;
                gp.objects[5].y = gp.tileSize * 6;
                gp.objects[5].width = gp.tileSize * 3 - 30;
                gp.objects[5].height = gp.tileSize * 2;
                gp.objects[5].solidArea.x = gp.objects[5].x + 10;
                gp.objects[5].solidArea.y = gp.objects[5].y + 10;
                gp.objects[5].solidArea.width = gp.objects[5].width - 20;
                gp.objects[5].solidArea.height = gp.objects[5].height - 20;

                gp.objects[6] = new Furniture("/res/objects/kitchen/furnitures/s_stool.png");
                gp.objects[6].collisionOn = true;
                gp.objects[6].x = gp.tileSize * 7 + 33;
                gp.objects[6].y = gp.tileSize * 8 + 10;
                gp.objects[6].width = gp.tileSize;
                gp.objects[6].height = gp.tileSize + 10;
                gp.objects[6].solidArea.x = gp.objects[6].x;
                gp.objects[6].solidArea.y = gp.objects[6].y + 3;
                gp.objects[6].solidArea.width = gp.objects[6].width;
                gp.objects[6].solidArea.height = gp.objects[6].height - 10;

                gp.objects[7] = new Furniture("/res/objects/kitchen/furnitures/right_chair.png");
                gp.objects[7].collisionOn = true;
                gp.objects[7].x = gp.tileSize * 5 + 30;
                gp.objects[7].y = gp.tileSize * 6;
                gp.objects[7].width = gp.tileSize;
                gp.objects[7].height = gp.tileSize * 2;
                gp.objects[7].solidArea.x = gp.objects[7].x;
                gp.objects[7].solidArea.y = gp.objects[7].y + 10;
                gp.objects[7].solidArea.width = gp.objects[7].width;
                gp.objects[7].solidArea.height = gp.objects[7].height - 20;

                gp.objects[8] = new Furniture("/res/objects/kitchen/furnitures/front_chair.png");
                gp.objects[8].collisionOn = true;
                gp.objects[8].x = gp.tileSize * 10 - 15;
                gp.objects[8].y = gp.tileSize * 6;
                gp.objects[8].width = gp.tileSize;
                gp.objects[8].height = gp.tileSize * 2;
                gp.objects[8].solidArea.x = gp.objects[8].x;
                gp.objects[8].solidArea.y = gp.objects[8].y + 10;
                gp.objects[8].solidArea.width = gp.objects[8].width;
                gp.objects[8].solidArea.height = gp.objects[8].height - 20;

                gp.objects[9] = new Furniture("/res/objects/kitchen/furnitures/brown_barrel.png");
                gp.objects[9].collisionOn = true;
                gp.objects[9].x = gp.tileSize * 15 + 10;
                gp.objects[9].y = gp.tileSize * 8 - 20;
                gp.objects[9].width = gp.tileSize;
                gp.objects[9].height = gp.tileSize + 5;
                gp.objects[9].solidArea.x = gp.objects[9].x + 2;
                gp.objects[9].solidArea.y = gp.objects[9].y + 7;
                gp.objects[9].solidArea.width = gp.objects[9].width - 7;
                gp.objects[9].solidArea.height = gp.objects[9].height - 10;

                gp.objects[10] = new Furniture("/res/objects/kitchen/furnitures/black_barrel.png");
                gp.objects[10].collisionOn = true;
                gp.objects[10].x = gp.tileSize * 3 + 13;
                gp.objects[10].y = gp.tileSize * 7 + 6;
                gp.objects[10].width = gp.tileSize + 3;
                gp.objects[10].height = gp.tileSize + 5;
                gp.objects[10].solidArea.x = gp.objects[10].x + 2;
                gp.objects[10].solidArea.y = gp.objects[10].y + 7;
                gp.objects[10].solidArea.width = gp.objects[10].width - 7;
                gp.objects[10].solidArea.height = gp.objects[10].height - 12;
                break;
        }
    }
}
