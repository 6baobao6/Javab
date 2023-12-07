package uoa.assignment.game;

import java.util.Scanner;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Player;
import uoa.assignment.character.Monster;

public class GameLogic {

	public static void moveCharacter(String input, Map gameMap, GameCharacter character) {
		if (character.getHealth() <= 0) {
		} else {
			if (input.equals("up")) {
				moveUp(character, gameMap);  //calling moveUp method
			} else if (input.equals("down")) {
				moveDown(character, gameMap);  //calling moveDown method
			} else if (input.equals("left")) {
				moveLeft(character, gameMap);  //calling moveLeft method
			}else if (input.equals("right")) {
				moveRight(character, gameMap);  //calling moveRight method
			} else {
				System.out.println("Use only keywords up, down, left, right");  //Tell user invalid move
			}
			gameMap.initialiseArray();
			gameMap.nowPosition();
		}
	}

	private static void moveRight(GameCharacter character, Map gameMap) {
		if (character.column + 1 == gameMap.layout[0].length) {
			System.out.println("Right is not able to move. You have to stay put.");
		}

		else if ("%".equals(gameMap.layout[character.row][character.column + 1])) {
			if (character.sayName().equals("P")) {
				if (gameMap.layout[character.row][character.column+1] == gameMap.layout[gameMap.characters[1].row][gameMap.characters[1].column]){
					character.hurtCharacter(gameMap.characters[1]);
				} else if (gameMap.layout[character.row][character.column+1] == gameMap.layout[gameMap.characters[2].row][gameMap.characters[2].column]) {
					character.hurtCharacter(gameMap.characters[2]);
				} else if (gameMap.layout[character.row][character.column+1] == gameMap.layout[gameMap.characters[3].row][gameMap.characters[3].column]) {
					character.hurtCharacter(gameMap.characters[3]);
				} else {
					System.out.println("Error!");
				}
			} else {
				System.out.println("Monster already there so can't move");
			}
		}

		else if ("x".equals(gameMap.layout[character.row][character.column+1])) {
			System.out.println("Character already dead");
		}

		else if ("*".equals(gameMap.layout[character.row][character.column + 1])) {
			character.hurtCharacter(gameMap.characters[0]);
		}

		else {  // Normal move
			String name = character.sayName();
			System.out.println(name+" is moving right");
			character.column ++;
		}
	}


}
