package uoa.assignment.character;

import java.util.Random;

public class Player extends GameCharacter{

	public Player(String name) {
		this.name = name;
	}
	
	public
	void hurtCharacter(GameCharacter character) {
		if (!character.successfulDefense()){
            character.setHealth(getHealth() - 20);
        }
	}

	
	public
	boolean successfulDefense() {
		return random.nextInt(100) < 30;
	}

}
