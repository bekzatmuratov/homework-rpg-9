package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class EnchantmentScanner implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        System.out.println("[Magic] " + weapon.getName() + " has battle enchantment +" + weapon.getAttackBonus());
    }

    @Override
    public void visit(Potion potion) {
        System.out.println("[Magic] " + potion.getName() + " restores " + potion.getHealing() + " HP.");
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("[Magic] " + scroll.getName() + " contains spell: " + scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring) {
        System.out.println("[Magic] " + ring.getName() + " gives magic bonus +" + ring.getMagicBonus());
    }

    @Override
    public void visit(Armor armor) {
        System.out.println("[Magic] " + armor.getName() + " has protection enchantment +" + armor.getDefenseBonus());
    }
}