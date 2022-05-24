package gameProject.model.dto;

public class ProductionSkill {
	
	// 제작 스킬
	private String pSkill;
	
	// 필요 광물
	private Material pMaterial;
	
	// 만들어지는 아이템
	private String pItem;
	
	
	public ProductionSkill(String pSkill, Material pMaterial, String pItem) {
		super();
		this.pSkill = pSkill;
		this.pMaterial = pMaterial;
		this.pItem = pItem;
	}
	
	
	
}
