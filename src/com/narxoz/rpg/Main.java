package com.narxoz.rpg;

import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        Inventory armanInventory = new Inventory();
        armanInventory.addArtifact(new Weapon("Student Sword", 60, 5, 6));
        armanInventory.addArtifact(new Potion("Small Potion", 20, 1, 15));

        Hero arman = new Hero("Arman", 100, 40, 14, 8, 120, armanInventory);
        Hero dana = new Hero("Dana", 80, 70, 10, 5, 200, new Inventory());

        System.out.println("Starting heroes:");
        System.out.println(arman);
        System.out.println(dana);

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(List.of(arman, dana));

        System.out.println("\nFinal result:");
        System.out.println(result);
    }
}