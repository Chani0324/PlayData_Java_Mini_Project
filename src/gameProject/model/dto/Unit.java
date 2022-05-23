/*
 * 스타 게임 프로젝트
 * 
 * 유닛 정보 표시
 */

package gameProject.model.dto;


public class Unit {
	// 유닛 이름
	private String uName;
	
	// 유닛 체력
	private int uHp;
		
	// 유닛 이동속도
	private int uSpeed;
	
	// 유닛 방어력
	private int uDef;
	
//	public Unit() {
//		super();
//	}
	
	public Unit(String uName, int uHp, int uSpeed, int uDef) {
		super();
		this.uName = uName;
		this.uHp = uHp;
		this.uSpeed = uSpeed;
		this.uDef = uDef;
	}
	
	public String getUName() {
		return uName;
	}
	
	public void setUName(String uName) {
		this.uName = uName;
	}
	
	public int getUHp() {
		return uHp;
	}
	
	public void setUHp(int uHp) {
		this.uHp = uHp;
	}
	
	public int getUSpeed() {
		return uSpeed;
	}
	
	public void setUSpeed(int uSpeed) {
		this.uSpeed = uSpeed;
	}
	
	public int getUDef() {
		return uDef;
	}
	
	public void setUDef(int uDef) {
		this.uDef = uDef;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("유닛 이름 : ");	// append() : 인수로 전달된 값을 문자열로 변환 후 
		builder.append(uName);						//				해당 문자열의 마지막에 추가
		builder.append(", 유닛 HP : ");
		builder.append(uHp);
		builder.append(", 유닛 이동속도 : ");
		builder.append(uSpeed);
		builder.append(", 유닛 방어력 : ");
		builder.append(uDef);
		return builder.toString();
	}
}
