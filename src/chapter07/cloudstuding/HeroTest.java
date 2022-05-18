package chapter07.cloudstuding;

public class HeroTest {
	public static void main(String[] args) {
		// 두 싸움꾼 객체 생성
		Hero arthas = new Hero("아서스");
		Hero leona = new Hero("레오나");
		
		// 격투 시작
		Hero.battle(arthas, leona);
	}
}

class Hero {
	String name;
	int hp;
	
	public Hero(String str) {
		name = str;
		hp = 30;
	}
	
	public void punch(Hero enemy) {
		enemy.hp -= 10;
		if (enemy.hp < 10) { enemy.hp = 0;}
		System.out.printf("[%s]의 펀치\n\t%s: %d/30\n", 
					this.name, enemy.name, enemy.hp);
	}
	
	public static void battle(Hero a, Hero b) {
		Hero[] heros = { a, b };
		
		while (true) {
			int i = (int)(Math.random()*2);
			int j = (i == 0) ? 1 : 0;
			
			heros[i].punch(heros[j]);
			if (heros[j].hp <= 0) break;
		}
	}
}