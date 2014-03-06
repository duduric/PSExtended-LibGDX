package ps.oo;

import java.io.Serializable;
import java.util.Comparator;

import ps.oo.PSBattle.Action;
import ps.oo.PSLibSpell.Spell;
import ps.oo.menuGUI.MenuCHR;
import ps.oo.menuGUI.MenuLabelBox;

public abstract class Battler implements Serializable {
	
	public abstract String getName();
	public abstract int getAtk();
	public abstract int getDef();
	public abstract int getAgi();
	public abstract int getMental();
	public abstract int getStr();

	public abstract int getHp();
	public abstract int getMaxHp();
	public abstract void setHp(int i);

	public abstract int getLevel();

	// Battle only variables
	transient int boost = 0;
	transient int weak = 0;
	transient int paralyzed = 0;
	transient int position;
	transient Battler target;
	
	transient int precedence;
	transient int naturalOrder;
	
	transient Action action;
	transient PSEffect effect;
	transient Spell usedSpell;
	transient Item usedItem;
	transient MenuCHR sprite;
	transient MenuLabelBox enemyBox;
	
	public MenuCHR getSprite() {
		return sprite;
	}
	
	public void clean() {
		paralyzed = 0;
		boost = 0;
	}
	
	static Comparator<Battler> getNaturalComparator() {
		return new Comparator<Battler>() {
			@Override
			public int compare(Battler arg0, Battler arg1) {
				return arg0.naturalOrder - arg1.naturalOrder;
			}
		};
	}
	
	static Comparator<Battler> getPrecedenceComparator() {
		return new Comparator<Battler>() {
			@Override
			public int compare(Battler arg0, Battler arg1) {
				return arg1.precedence - arg0.precedence;
			}
		};
	}
		
}

