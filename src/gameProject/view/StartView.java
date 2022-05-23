package gameProject.view;

import java.util.Scanner;

import gameProject.controller.Controller;
import gameProject.model.HeroPartyModel;
import gameProject.model.dto.AttackUnit;
import gameProject.model.dto.Material;
import gameProject.model.dto.Unit;

public class StartView {
	

	public static void main(String[] args) {
		// 마을 NPC들 생성
		Unit npc1 = new Unit("장로", 10, 3, 0);
		Unit npc2 = new Unit("상인", 15, 3, 0);
		Unit npc3 = new Unit("소년", 10, 3, 0);
		
		// 용사 생성
		AttackUnit hero1 = new AttackUnit("용사", 100, 10, 5, 30);
		AttackUnit hero2 = new AttackUnit("마법사", 50, 7, 2, 50);
		
		// 용사 파티 생성
		Controller.gameUnitInsert(npc1);
		Controller.gameUnitInsert(npc2);
		Controller.gameUnitInsert(npc3);
		Controller.gameUnitInsert(hero1);
		Controller.gameUnitInsert(hero2);
		
		// 몬스터 늑대, 마왕 생성
		AttackUnit monster1 = new AttackUnit("마왕", 500, 15, 10, 80);
		AttackUnit monster2 = new AttackUnit("늑대", 90, 3, 1, 5);
		
		
		// 광물 캐기
		Material mat1 = new Material("철광석", "상", 5000);
		Material mat2 = new Material("철광석", "상", 3000);
		Material mat3 = new Material("구리", "상", 4000);
		Material mat4 = new Material("백금", "하", 8000);
		
		// 선택지1 생성. 늑대와의 전투
		Scanner sc = new Scanner(System.in);
		System.out.println("용사는 숲속에서 광물을 캐다 소년을 쫓는 늑대를 발견하였습니다.");	// Controller로 넘겨야 할듯
		System.out.println("돕겠습니까? (Y/N)");	// Controller로 넘겨야 할듯
		Controller.choiceStory1(sc.next());
		
		// 늑대와의 전투
		Controller.attack(monster2);
		Controller.attack(monster2);
		
		// 광물 인벤토리에 수집
		Controller.gameItemInsert(mat1);		
		Controller.gameItemInsert(mat2);		
		Controller.gameItemInsert(mat3);		
		Controller.gameItemInsert(mat4);	
		
		// 재련 시도
		Controller.produce("재련기술1");
		System.out.println("용사의 공격력 : " + hero1.getUDamage());	// Controller로 넘겨야 할듯
		
		// 선택지2 생성. 마왕과의 전투.
		System.out.println("용사는 마왕과 그에게 잡혀있는 마을촌장의 딸을 발견하였습니다.");	// Controller로 넘겨야 할듯
		System.out.println("돕겠습니까? (Y/N)");	// Controller로 넘겨야 할듯
		Controller.choiceStory2(sc.next());
		
		
		// 용사파티 마왕 공격. 제한 시간 내 총 6번 공격 가능
		Controller.attack(monster1);
		Controller.attack(monster1);
		Controller.attack(monster1);
		Controller.attack(monster1);
		Controller.attack(monster1);
		Controller.attack(monster1);
		
		// 최종장
		Controller.lastStory(monster1);
		
	}

}
