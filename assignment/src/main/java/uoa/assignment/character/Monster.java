package uoa.assignment.character;

import java.util.Random;

public class Monster extends GameCharacter {

	public  Monster(String name) {
		this.name = name;
	}


	public void hurtCharacter(GameCharacter character) {
		if (!character.successfulDefense()) {
            character.setHealth(getHealth() - 50);
        }
	}

	
	public boolean successfulDefense() {
		
		if(random.nextInt(100)>50){
			return true
		}else{
			return false
		}
	}


	
	public String decideMove () {
		
		return "move";
	}

}
