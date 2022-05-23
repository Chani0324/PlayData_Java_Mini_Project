package gameProject.model;

import java.util.ArrayList;
import java.util.Random;

import gameProject.exception.GameProjectException;
import gameProject.model.dto.AttackUnit;
import gameProject.model.dto.Material;
import gameProject.model.dto.Unit;

public class InventoryModel {

	public static HeroPartyModel heroParty = HeroPartyModel.getInstance();

	private static InventoryModel instance = new InventoryModel();

	// 아이템을 inven에 저장
	private ArrayList<Material> inven = new ArrayList<Material>();

	private InventoryModel() {
	}

	public static InventoryModel getInstance() {
		return instance;
	}

	// 강화 확률 조정용 random 사용
	Random random = new Random();

	// 용사 파티에 캐릭터 추가
	public void gameItemInsert(Material material) {
		inven.add(material);
	}

	public void produce(String produceSkill) throws GameProjectException {
		int randint = random.nextInt(9);
		// 강화 확률 80퍼
		if (randint <= 7) {
			for (Material mt : inven) {
				if (mt.getMatName().equals("철광석") && mt.getMatState().equals("상") && produceSkill.equals("재련기술1")) {
					mt = null;
					for (Unit tp : heroParty.getHeroParty()) {
						if (tp.getUName().equals("용사")) {
							((AttackUnit) tp).setUDamage(((AttackUnit) tp).getUDamage() + 50);
						}
					}
				}
			}
		} else {
			throw new GameProjectException("재련에 실패하였습니다.");
		}

	}

}
