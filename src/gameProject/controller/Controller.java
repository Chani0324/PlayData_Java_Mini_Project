package gameProject.controller;

import gameProject.exception.GameProjectException;
import gameProject.model.HeroPartyModel;
import gameProject.model.InventoryModel;
import gameProject.model.dto.Material;
import gameProject.model.dto.Unit;
import gameProject.view.FailView;
import gameProject.view.SuccessView;

public class Controller {
		
	public static HeroPartyModel heroParty = HeroPartyModel.getInstance();
	public static InventoryModel inven = InventoryModel.getInstance();
	
	public static void gameUnitInsert(Unit unit) {
		if (unit != null) {
			heroParty.gameUnitInsert(unit);
			SuccessView.successMessage(unit + "영웅 파티에 합류 완료");
		}else {
			FailView.printFail("해당 캐릭터 재확인 필요.");
		}
	}
	
	public static void gameItemInsert(Material material) {
		if (material != null) {
			inven.gameItemInsert(material);
			SuccessView.successMessage(material + " 인벤토리에 저장 완료.");
		}else {
			FailView.printFail("해당 재료 재확인 필요.");
		}
	}
	
	public static void attack(Unit unit) {
		if(unit != null && unit.getUHp() > 0) {
			try {
				heroParty.attack(unit);
				SuccessView.successMessage("공격받은 " + unit.getUName() + "의 체력이" + unit.getUHp() + "이(가) 되었습니다.");
			}catch(GameProjectException e) {
//				e.printStackTrace();
				FailView.printFail(e.getMessage()); 
			}
		}else {
			FailView.printFail("이미 죽었거나 없는 몬스터입니다.");
		}
	}
	
	public static void produce(String produceSkill) {
		try {
			inven.produce(produceSkill);
			SuccessView.successMessage("롱소드 재련에 성공하였습니다.");
			SuccessView.successMessage("재련 성공으로 용사의 공격력이 증가합니다.");
			
		}catch(GameProjectException e) {
//			e.printStackTrace();
			FailView.printFail(e.getMessage());
		}
	}
	
	public static void choiceStory1(String m) {
		if (m.equals("Y")) {
			SuccessView.successMessage("전투를 개시합니다.");
		}else if(m.equals("N")) {
			FailView.printFail("대장장이는 모른체하고 살다가 마왕에게 세계정복을 당하면서 같이 죽어버렸습니다.");
			System.exit(0);
		}else {
			System.out.println("Y / N 중에 입력하세요.");
		}
	}
	
	public static void choiceStory2(String m) {
		if (m.equals("Y")) {
			SuccessView.successMessage("새로운 모험을 떠납니다.");
		}else if(m.equals("N")) {
			FailView.printFail("대장장이는 모른체하고 살다가 마왕에게 세계정복을 당하면서 같이 죽어버렸습니다.");
			System.exit(0);
		}else {
			System.out.println("Y / N 중에 입력하세요.");
		}
	}
	
	public static void lastStory(Unit unit) {
		if (unit.getUHp() > 0) {
			FailView.printFail("재련 실패로 무기를 얻지 못해 마왕이 시간내에 죽지 못하여 세상의 멸망과 함께 다같이 죽습니다.");
			FailView.printFail("--Bad Ending--");
		}else {
			SuccessView.successMessage("용사일행은 세상을 구하고 평화를 지켜내었습니다.");
			SuccessView.successMessage("--Good Ending--");
		}

	}
	
}
