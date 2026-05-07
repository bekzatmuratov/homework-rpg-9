package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class GoldAppraiser implements ArtifactVisitor {

    private int totalValue = 0;

    public int getTotalValue() {
        return totalValue;
    }

    @Override
    public void visit(Weapon weapon) {
        int price = weapon.getValue() + weapon.getAttackBonus() * 15;
        totalValue += price;
        System.out.println("[Gold] Weapon " + weapon.getName() + " appraised for " + price + " gold.");
    }

    @Override
    public void visit(Potion potion) {
        int price = potion.getValue() + potion.getHealing() * 3;
        totalValue += price;
        System.out.println("[Gold] Potion " + potion.getName() + " appraised for " + price + " gold.");
    }

    @Override
    public void visit(Scroll scroll) {
        int price = scroll.getValue() + 50;
        totalValue += price;
        System.out.println("[Gold] Scroll " + scroll.getName() + " with spell " + scroll.getSpellName()
                + " appraised for " + price + " gold.");
    }

    @Override
    public void visit(Ring ring) {
        int price = ring.getValue() + ring.getMagicBonus() * 25;
        totalValue += price;
        System.out.println("[Gold] Ring " + ring.getName() + " appraised for " + price + " gold.");
    }

    @Override
    public void visit(Armor armor) {
        int price = armor.getValue() + armor.getDefenseBonus() * 12;
        totalValue += price;
        System.out.println("[Gold] Armor " + armor.getName() + " appraised for " + price + " gold.");
    }
}