package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Map {

    public String [][] layout;
    public GameCharacter characters [] ;
 
    Map (int height, int width) {
        layout = new String[height][width];
        characters = new GameCharacter[4];

        initialiseArray();
        characters[0] = new Player("Player");
        characters[1] = new Monster("Monster1");
        characters[2] = new Monster("Monster2");
        characters[3] = new Monster("Monster3");

        characters[0].row = height - 1;
        characters[0].column = width - 1;

        characters[1].row = 0;
        characters[1].column = width - 1;

        characters[2].row = height - 1;
        characters[2].column = 0;

        characters[3].row = 0;
        characters[3].column = 0;

        layout[characters[1].row][characters[1].column] = "%";
        layout[characters[2].row][characters[2].column] = "%";
        layout[characters[3].row][characters[3].column] = "%";
        layout[characters[0].row][characters[0].column] = "*";
    
  }
    private void initialiseArray() {
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                layout[i][j] = ".";
            }
        }
    }

    public void nowPosition(){ 
        layout[characters[0].row][characters[0].column] = "*";

        if (characters[1].getHealth() <= 0) {
            layout[characters[1].row][characters[1].column] = "x";
        } else {
            layout[characters[1].row][characters[1].column] = "%";
        }

        if (characters[2].getHealth() <= 0) {
            layout[characters[2].row][characters[2].column] = "x";
        } else {
            layout[characters[2].row][characters[2].column] = "%";
        }

        if (characters[3].getHealth() <= 0) {
            layout[characters[3].row][characters[3].column] = "x";
        } else {
            layout[characters[3].row][characters[3].column] = "%";
        }
    }
    public void printLayout() { 
        for (int i = 0; i < layout.length; i++) {
            for  (int j = 0; j < layout[i].length; j++) {
                System.out.print(layout[i][j]);
            }
            System.out.println();
    }
}
}