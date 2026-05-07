package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class CurseDetector implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getAttackBonus() > 10) {
            System.out.println("[Curse] " + weapon.getName() + " is suspiciously powerful. Possible blood curse.");
        } else {
            System.out.println("[Curse] " + weapon.getName() + " looks safe.");
        }
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() < 20) {
            System.out.println("[Curse] " + potion.getName() + " may be weak or spoiled.");
        } else {
            System.out.println("[Curse] " + potion.getName() + " looks safe.");
        }
    }

    @Override
    public void visit(Scroll scroll) {
        if (scroll.getSpellName().toLowerCase().contains("shadow")) {
            System.out.println("[Curse] " + scroll.getName() + " contains dark magic.");
        } else {
            System.out.println("[Curse] " + scroll.getName() + " looks safe.");
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() > 5) {
            System.out.println("[Curse] " + ring.getName() + " may drain the user's soul.");
        } else {
            System.out.println("[Curse] " + ring.getName() + " looks safe.");
        }
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getWeight() > 30) {
            System.out.println("[Curse] " + armor.getName() + " is too heavy. Movement curse suspected.");
        } else {
            System.out.println("[Curse] " + armor.getName() + " looks safe.");
        }
    }
}