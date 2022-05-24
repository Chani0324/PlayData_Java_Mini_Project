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

	// 광물 이름으로 검색
	public ArrayList<Material> getMaterial(String materialName) throws GameProjectException {
		int cnt = 0;
		ArrayList<Material> list = new ArrayList<Material>();

		for (Material mt : inven) {
			if (mt.getMatName().equals(materialName)) {
				list.add(mt);
				cnt++;
			}
		}
		if (cnt == 0) {
			throw new GameProjectException("해당 광물이 없습니다.");
		}
		return list;

	}

	// 광물이름 검색 후 수정
	public void materialUpdate(String materialName, Material material) throws GameProjectException {
		for (Material mt : inven) {
			if (mt.getMatName().equals(materialName)) {
				mt.setMatName(materialName);
				return;
			}
		}
		throw new GameProjectException("수정하려는 광물이 미존재합니다.");
	}

	// 해당 광물 삭제
	public void materialDelete(String materialName) throws GameProjectException {
		for (Material mt : inven) {
			if (mt.getMatName().equals(materialName)) {
				inven.remove(mt);
				return;
			}
		}
		throw new GameProjectException("삭제하려는 광물은 미존재합니다.");
	}

	public void produce(String produceSkill) throws GameProjectException {
		int randint = random.nextInt(9);
		// 강화 확률 60퍼
		if (randint <= 5) {
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
