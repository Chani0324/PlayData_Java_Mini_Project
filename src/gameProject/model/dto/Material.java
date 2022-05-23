package gameProject.model.dto;

public class Material {
	private String matName;
	
	private String matState;
	
	private int matPrice;
	
	public Material(String matName, String matState, int matPrice) {
		super();
		this.matName = matName;
		this.matState = matState;
		this.matPrice = matPrice;
	}
	
	public String getMatName() {
		return matName;
	}
	
	public void setMatName(String matName) {
		this.matName = matName;
	}
	
	public String getMatState() {
		return matState;
	}
	
	public void setMatState(String matState) {
		this.matState = matState;
	}
	
	public int getMatPrice() {
		return matPrice;
	}
	
	public void setMatPrice(int matPrice) {
		this.matPrice = matPrice;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("재료 이름 : ");	// append() : 인수로 전달된 값을 문자열로 변환 후 
		builder.append(getMatName());						//				해당 문자열의 마지막에 추가
		builder.append(", 재료 상태 : ");
		builder.append(getMatState());
		builder.append(", 재료 가격 : ");
		builder.append(getMatPrice());
		return builder.toString();
	}
	
	
}
