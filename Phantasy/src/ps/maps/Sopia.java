package ps.maps;

import static ps.oo.PSGame.*;
import ps.oo.City;
import ps.oo.PSGame;
import ps.oo.Item;
import ps.oo.PSGame.Flags;
import ps.oo.PSLibItem.OriginalItem;
import ps.oo.PSMenu;
import ps.oo.PSMenu.EntityClothes;
import ps.oo.PSMenu.EntityType;
import ps.oo.PSMenu.Scene;
import ps.oo.PSMenu.SpecialEntity;

public class Sopia {

	public static void hospital() {
		PSMenu.startScene(Scene.HOSPITAL_VILLAGE, EntityType.VILLA_WMN_BROWN, EntityClothes.WHITE);
		PSGame.Hospital(2); // More expensive
		PSMenu.endScene();
	}
	
	public static void house1() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.VILLA_WMN_BROWN, EntityClothes.BLUE);
		PSMenu.Stext(getString("Sopia_House_1"));
		PSMenu.endScene();
	}

	public static void house2() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.VILLA_MAN_BLUE, EntityClothes.RED);
		PSMenu.Stext(getString("Sopia_House_2"));
		PSMenu.endScene();
	}
	public static void house3() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, SpecialEntity.OLDMAN);
		if(PSMenu.Prompt(getString("Sopia_House_3"), getYesNo()) == 1) {
			if(PSGame.getParty().mst < 400) {
				PSMenu.StextLast(getString("Sopia_House_3NotEnough"));
			}
			else {
				PSMenu.StextLast(getString("Sopia_House_3Yes"));
				PSGame.getParty().mst-=400;
				PSGame.setFlag(Flags.INFO_PERSEUS);
			}
		} else {
			PSMenu.StextLast(getString("Sopia_House_3No"));
		}
		PSMenu.endScene();
	}

	public static void house4() {
		PSMenu.startScene(Scene.RUINED_HOUSE, EntityType.VILLA_WMN_BROWN, EntityClothes.GREEN);
		if(PSMenu.Prompt(getString("Sopia_House_4"), getYesNo()) == 1) {
				PSMenu.StextLast(getString("Sopia_House_4Yes"));
		} else {
			PSMenu.StextLast(getString("Sopia_House_4No"));
		}
		PSMenu.endScene();
	}	
	
	
	public static void house5() {
		PSMenu.startScene(Scene.RUINED_HOUSE, SpecialEntity.BEGGAR);
		if(PSMenu.Prompt(getString("Sopia_House_5"), getYesNo()) == 1) {
			
			boolean foundCola = PSGame.findItemWithParty(OriginalItem.Inventory_Monomate, true);
			if(foundCola) {
				PSMenu.StextLast(getString("Sopia_House_5Yes"));				
			} else {
				PSMenu.StextLast(getString("Sopia_House_5NotEnough"));
			}
		} else {
			PSMenu.StextLast(getString("Sopia_House_5No"));	
		}

		PSMenu.endScene();
	}
	public static void house6() {
		PSMenu.startScene(Scene.VILLAGE_HOUSE, EntityType.VILLA_MAN_BROWN, EntityClothes.BLUE);
		PSMenu.Stext(getString("Sopia_House_6"));
		PSMenu.endScene();
	}
	public static void house7() {
		PSMenu.startScene(Scene.RUINED_HOUSE, SpecialEntity.BEGGAR);
		if(PSMenu.Prompt(getString("Sopia_House_7"), getYesNo()) == 1) {
				PSMenu.StextLast(getString("Sopia_House_7Yes"));
		} else {
			PSMenu.StextLast(getString("Sopia_House_7No"));
		}
		PSMenu.endScene();
	}	
	
	

	
	public static void exit() {
		mapswitch(Planet.MOTAVIA, City.SOPIA.getX(), City.SOPIA.getY());
	}
}
