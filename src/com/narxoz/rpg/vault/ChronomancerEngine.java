package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.visitor.*;

import java.util.List;

public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("\n=== Chronomancer's Vault Run Started ===");

        Inventory vaultInventory = new Inventory();
        vaultInventory.addArtifact(new Weapon("Blade of Dawn", 120, 8, 12));
        vaultInventory.addArtifact(new Potion("Crystal Healing Potion", 40, 1, 30));
        vaultInventory.addArtifact(new Scroll("Ancient Shadow Scroll", 90, 1, "Shadow Flame"));
        vaultInventory.addArtifact(new Ring("Ring of Echoes", 150, 1, 7));
        vaultInventory.addArtifact(new Armor("Titan Plate Armor", 200, 35, 15));

        System.out.println("\n--- Visitor Pattern: Artifact Appraisal Started ---");

        GoldAppraiser goldAppraiser = new GoldAppraiser();
        EnchantmentScanner enchantmentScanner = new EnchantmentScanner();
        CurseDetector curseDetector = new CurseDetector();

        vaultInventory.accept(goldAppraiser);
        System.out.println("Total appraised value: " + goldAppraiser.getTotalValue() + " gold.");

        System.out.println();

        vaultInventory.accept(enchantmentScanner);

        System.out.println();

        vaultInventory.accept(curseDetector);

        System.out.println("\n--- Open/Closed Proof: 4th Visitor Added ---");
        WeightCalculator weightCalculator = new WeightCalculator();
        vaultInventory.accept(weightCalculator);
        System.out.println("Total inventory weight: " + weightCalculator.getTotalWeight());

        System.out.println("\n--- Visitor Pattern: Artifact Appraisal Finished ---");

        if (party == null || party.isEmpty()) {
            return new VaultRunResult(vaultInventory.size(), 0, 0);
        }

        Hero hero = party.get(0);
        Caretaker caretaker = new Caretaker();

        System.out.println("\n--- Memento Pattern: Snapshot Phase ---");
        System.out.println("Hero before snapshot: " + hero);

        HeroMemento snapshot = hero.createMemento();
        caretaker.save(snapshot);

        System.out.println("Snapshot saved. Caretaker size: " + caretaker.size());

        System.out.println("\n--- Vault Trap Triggered ---");
        hero.takeDamage(45);
        hero.spendMana(10);
        hero.spendGold(25);
        hero.getInventory().addArtifact(new Ring("Cursed Time Ring", 50, 1, 9));

        System.out.println("Hero after trap: " + hero);
        System.out.println("Inventory size after trap: " + hero.getInventory().size());

        System.out.println("\n--- Chronomancer Rewind Started ---");
        HeroMemento restoredSnapshot = caretaker.undo();
        hero.restoreFromMemento(restoredSnapshot);

        System.out.println("Hero after rewind: " + hero);
        System.out.println("Inventory size after rewind: " + hero.getInventory().size());
        System.out.println("Caretaker size after undo: " + caretaker.size());

        System.out.println("\n=== Chronomancer's Vault Run Finished ===");

        return new VaultRunResult(vaultInventory.size(), 1, 1);
    }
}