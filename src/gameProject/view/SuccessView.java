package gameProject.view;

import java.util.ArrayList;

import gameProject.model.dto.Material;

public class SuccessView {

	public static void successMessage(String successMessage) {
		System.out.println(successMessage);
	}
	
	// 인벤토리에 소지한 광물 검색하여 출력
	public static void materialListView(ArrayList<Material> materialList){
		
		int index = 0;
		
		for(Material mt : materialList) {
			System.out.println("[인벤토리에 소지중인 광물 검색 완료 : " + (index+1) + "] " + mt.toString());
			index++;
		}
		
	}
	
}
