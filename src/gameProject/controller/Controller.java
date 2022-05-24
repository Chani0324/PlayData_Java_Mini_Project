package gameProject.controller;

import java.util.Scanner;

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

	// 영웅 파티에 캐릭터 넣기
	public static void gameUnitInsert(Unit unit) {
		if (unit != null) {
			heroParty.gameUnitInsert(unit);
			SuccessView.successMessage(unit + "영웅 파티에 합류 완료");
		} else {
			FailView.printFail("해당 캐릭터 재확인 필요.");
		}
	}

	// 파티 내에 캐릭터 검색
	public static void gameUnitRead(String unitName) {
		if (unitName != null) {
			try {
				heroParty.gameUnitRead(unitName);
				SuccessView.successMessage("\n" + unitName + "\n파티 내에 존재하는 캐릭터입니다.\n");
			} catch (GameProjectException e) {
//				e.printStackTrace();
				FailView.printFail(e.getMessage());
			}
		} else {
			FailView.printFail("\n...\n");
		}
	}

	// 파티 내 캐릭터 이름으로 수정
	public static void gameUnitUpdate(String unitName, String newName) {
		if (unitName != null && newName != null) {
			try {
				heroParty.gameUnitUpdate(unitName, newName);
				SuccessView.successMessage(unitName + " --> " + newName + "\n캐릭터 이름이 위와 같이 수정되었습니다.\n");
			} catch (GameProjectException e) {
//				e.printStackTrace();
				FailView.printFail(e.getMessage());
			}
		} else {
			FailView.printFail("\n...\n");
		}
	}

	// 파티 내 캐릭터 제외
	public static void gameUnitDelete(String unitName) {
		if (unitName != null) {
			try {
				heroParty.gameUnitDelete(unitName);
				SuccessView.successMessage(unitName + "\n해당 캐릭터가 삭제되었습니다.\n");
			} catch (GameProjectException e) {
//				e.printStackTrace();
				FailView.printFail(e.getMessage());
			}
		}else {
			FailView.printFail("\n...\n");
			
		}
	}

	// 인벤토리에 아이템 넣기
	public static void gameItemInsert(Material material) {
		if (material != null) {
			inven.gameItemInsert(material);
			SuccessView.successMessage(material + " 인벤토리에 저장 완료.");
		}else {
			FailView.printFail("해당 재료 재확인 필요.");
		}
	}

	// 인벤토리에 있는 아이템 검색
	public static void getMaterial(String materialName) {
		try {
			SuccessView.materialListView(inven.getMaterial(materialName));
		} catch(GameProjectException e) {
//			e.printStackTrace();
			FailView.printFail("해당 광물 재확인 필요.");
		}
	}

	// 인벤토리에 아이템 수정
	public static void materialUpdate(String materialName, Material material) {
		if(materialName != null & material != null) {
			try {
				inven.materialUpdate(materialName, material);
			}catch(GameProjectException e) {
//				e.printStackTrace();
				FailView.printFail(e.getMessage());
			}
		}else {
			FailView.printFail("수정하려는 광물을 재확인하세요.");
		}
	}

	// 인벤토리에 아이템 삭제
	public static void materialDelete(String materialName) {
		if(materialName != null) {
			try {
				inven.materialDelete(materialName);
				SuccessView.successMessage("해당 광물 삭제 완료");
			}catch(GameProjectException e) {
//				e.printStackTrace();
				FailView.printFail(e.getMessage());
			}
		}else {
			FailView.printFail("입력한 광물이 인벤토리에 있는지 재확인 해주세요.");
		}
		
	}

	// 용사파티의 공격유닛들로 공격
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

	// 아이템 제작
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

	// 스토리 선택
	public static void choiceStory1(String m) {
		if (m.equals("Y")) {
			SuccessView.successMessage("전투를 개시합니다.");
		}else if(m.equals("N")) {
			FailView.printFail("대장장이는 모른체하고 살다가 마왕에게 세계정복을 당하면서 같이 죽어버렸습니다.");
			System.exit(0);
		}else {
			System.out.println("Y / N 중에 입력하세요.");
			System.exit(0);
		}
	}

	// 스토리 선택
	public static void choiceStory2(String m) {
		if (m.equals("Y")) {
			SuccessView.successMessage("새로운 모험을 떠납니다.");
		}else if(m.equals("N")) {
			FailView.printFail("대장장이는 모른체하고 살다가 마왕에게 세계정복을 당하면서 같이 죽어버렸습니다.");
			System.exit(0);
		}else {
			System.out.println("Y / N 중에 입력하세요.");
			System.exit(0);
		}
	}

	// 엔딩
	public static void lastStory(Unit unit) {
		if (unit.getUHp() > 0) {
			FailView.printFail("재련 실패로 무기를 얻지 못해 마왕이 시간내에 죽지 못하여 세상의 멸망과 함께 다같이 죽습니다.");
			FailView.printFail("--Bad Ending--");
		}else {
			SuccessView.successMessage("용사일행은 세상을 구하고 평화를 지켜내었습니다.");
			SuccessView.successMessage("--Good Ending--");
		}

	}
	
	// 스토리 스킵 옵션
	public static void storySkipOption(String m) {
		Scanner sc = new Scanner(System.in);

		if (m.equals("N")) {
			SuccessView.successMessage("\n검색하고자 하는 유닛의 이름을 입력하세요 : ");
			gameUnitRead(sc.next());
			SuccessView.successMessage("\n변경하고자 하는 유닛의 이름을 입력하고 엔터, 그후 새로운 이름을 입력하세요 : ");
			gameUnitUpdate(sc.next(), sc.next());
			SuccessView.successMessage("\n삭제하고자 하는 유닛의 이름을 입력하세요 : ");
			gameUnitDelete(sc.next());
		}else if(m.equals("Y")) {
			SuccessView.successMessage("스토리를 진행합니다.");
		}else {
			System.out.println("Y / N 중에 입력하세요.");
			System.exit(0);
		}
	}

}
