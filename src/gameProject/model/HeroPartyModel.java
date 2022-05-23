package gameProject.model;

import java.util.ArrayList;

import gameProject.exception.GameProjectException;
import gameProject.model.dto.AttackUnit;
import gameProject.model.dto.Unit;

public class HeroPartyModel {

	private static HeroPartyModel instance = new HeroPartyModel();

	// 유닛을 array에 저장
	private ArrayList<Unit> heroParty = new ArrayList<Unit>();

	private HeroPartyModel() {}

	public static HeroPartyModel getInstance() {
		return instance;
	}
	
	public ArrayList<Unit> getHeroParty() {
		return heroParty;
	}

	// 용사 파티에 캐릭터 추가
	public void gameUnitInsert(Unit unit) {
		heroParty.add(unit);
	}

	// 유닛 공격
	/*
	 * Array에 저장된 공격유닛 찾아서 개별로 공격 실시. 공격당한 해당 유닛 Hp 0되면 파괴
	 * 
	 * case 1 : 공격하는 유닛이 있을 경우 공격 진행 case 1 : 공격받는 유닛의 피가 0 초과인경우 case 2 : 공격받는 유닛의
	 * hp가 0이하로 된 경우 0으로 인식. case 2 : 공격하는 유닛이 없을 경우 exception 호출
	 * 
	 * method 내에서 진행 순서는 한번에 되는것이 아니라 순차적으로 진행함.(if문 여러개 제외) 아래 구문 진행 순서 제대로 파악하기.
	 */

	public void attack(Unit unit) throws GameProjectException {
		int damagedHp = 0;
		int cnt = 0;

		for (Unit tp : heroParty) {
			if (tp.getClass().getSimpleName().equals("AttackUnit")) {
				damagedHp = unit.getUHp() - (((AttackUnit) tp).getUDamage() - unit.getUDef());
				cnt++;

				if (damagedHp > 0) {
					unit.setUHp(damagedHp);
				} else {
					unit.setUHp(0);
				}
			}
		}
		if (cnt == 0) {
			throw new GameProjectException("부대 내에 공격 유닛이 없습니다.");
		}
	}

}