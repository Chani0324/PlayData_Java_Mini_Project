package gameProject.model.dto;

public class AttackUnit extends Unit{
	private int uDamage;
	
//	public AttackUnit() {
//		super();
//	}
	
	public AttackUnit(String uName, int uHp,
		int uSpeed, int uDef, int uDamage){
	super(uName, uHp, uSpeed, uDef);
	this.uDamage = uDamage;
	}
	
	public int getUDamage() {
		return uDamage;
	}
	
	public void setUDamage(int uDamage) {
		this.uDamage = uDamage;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("유닛 이름 : ");	// append() : 인수로 전달된 값을 문자열로 변환 후 
		builder.append(getUName());						//				해당 문자열의 마지막에 추가
		builder.append(", 유닛 HP : ");
		builder.append(getUHp());
		builder.append(", 유닛 이동속도 : ");
		builder.append(getUSpeed());
		builder.append(", 유닛 방어력 : ");
		builder.append(getUDef());
		builder.append(", 유닛 공격력 : ");
		builder.append(getUDamage());
		return builder.toString();
	}

}