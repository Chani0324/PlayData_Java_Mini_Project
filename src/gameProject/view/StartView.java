package gameProject.view;

import java.util.Scanner;

import gameProject.controller.Controller;
import gameProject.model.dto.AttackUnit;
import gameProject.model.dto.Material;
import gameProject.model.dto.Unit;

public class StartView {
	

	public static void main(String[] args) {
		// 마을 NPC들 생성
		// ("이름", hp, 이동속도, 방어력)
		Unit npc1 = new Unit("장로", 10, 3, 0);
		Unit npc2 = new Unit("상인", 15, 3, 0);
		Unit npc3 = new Unit("소년", 10, 3, 0);
		
		// 용사 생성
		// ("이름", hp, 이동속도, 방어력, 공격력)
		AttackUnit hero1 = new AttackUnit("용사", 100, 10, 5, 30);
		AttackUnit hero2 = new AttackUnit("마법사", 50, 7, 2, 50);
		
		// 용사 파티 생성
		Controller.gameUnitInsert(npc1);
		Controller.gameUnitInsert(npc2);
		Controller.gameUnitInsert(npc3);
		Controller.gameUnitInsert(hero1);
		Controller.gameUnitInsert(hero2);
		
		// 캐릭터 CRUD
		Scanner sc = new Scanner(System.in);
		System.out.println("*********************************************");
		System.out.println("유닛 변경사항을 확인하지 않고 스토리를 진행하시겠습니까? (Y / N)");
		Controller.storySkipOption(sc.next());
		
		// 몬스터 늑대, 마왕 생성
		// ("이름", hp, 이동속도, 방어력, 공격력)
		AttackUnit monster1 = new AttackUnit("마왕", 500, 15, 10, 80);
		AttackUnit monster2 = new AttackUnit("늑대", 90, 3, 1, 5);
		
		// 선택지1 생성. 늑대와의 전투
		System.out.println("*********************************************");
		System.out.println("용사는 숲속에서 광물을 캐다 소년을 쫓는 늑대를 발견하였습니다.");	
		System.out.println("돕겠습니까? (Y/N)");	
		Controller.choiceStory1(sc.next());
		
		// 늑대와의 전투
		Controller.attack(monster2);
		Controller.attack(monster2);
		
		// 광물 캐기
		// ("이름", "상태", 가격) 
		System.out.println("*********************************************");
		Material mat1 = new Material("철광석", "상", 5000);
		Material mat2 = new Material("철광석", "상", 3000);
		Material mat3 = new Material("구리", "중", 4000);
		Material mat4 = new Material("백금", "하", 8000);
		Material mat5 = new Material("다이아몬드", "하", 200000);
		Material mat6 = new Material("돌", "하", 100);
		
		// 광물 인벤토리에 수집
		Controller.gameItemInsert(mat1);		
		Controller.gameItemInsert(mat2);		
		Controller.gameItemInsert(mat3);		
		Controller.gameItemInsert(mat4);	
		
		// 인벤토리에 광물 검색
		System.out.println("인벤토리에서 검색하려는 광물 이름을 입력하세요");
		Controller.getMaterial(sc.next());
		
		
		// 인벤토리에 광물 수정
		Controller.materialUpdate("백금", mat5);
		
		// 인벤토리에 광물 삭제
		System.out.println("삭제하려는 광물 이름을 입력하세요");
		Controller.materialDelete(sc.next());
		System.out.println("검색하려는 광물 이름을 입력하세요");
		Controller.getMaterial(sc.next());
		
		
		// 재련 시도, 재련 성공 확률 60%
		System.out.println("*********************************************");
		Controller.produce("재련기술1");
		System.out.println("용사의 공격력 : " + hero1.getUDamage());	
		
		// 선택지2 생성. 마왕과의 전투.
		System.out.println("*********************************************");
		System.out.println("용사는 마왕과 그에게 잡혀있는 마을촌장의 딸을 발견하였습니다.");	
		System.out.println("돕겠습니까? (Y/N)");	
		Controller.choiceStory2(sc.next());
		
		
		// 용사파티 마왕 공격. 제한 시간 내 총 6번 공격 가능
		Controller.attack(monster1);
		Controller.attack(monster1);
		Controller.attack(monster1);
		Controller.attack(monster1);
		Controller.attack(monster1);
		Controller.attack(monster1);
		
		// 최종장
		System.out.println("*********************************************");
		Controller.lastStory(monster1);
		
	}

}
