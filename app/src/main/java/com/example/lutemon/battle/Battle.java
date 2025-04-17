package com.example.lutemon.battle;

import com.example.lutemon.model.Lutemon;

public class Battle {
    public static String startBattle(Lutemon a, Lutemon b) {
        StringBuilder log = new StringBuilder();
        boolean aTurn = true;

        while (a.isAlive() && b.isAlive()) {
            if (aTurn) {
                b.takeDamage(a.getAttackPower());
                log.append(a.getName()).append(" attacks ").append(b.getName()).append("\n");
            } else {
                a.takeDamage(b.getAttackPower());
                log.append(b.getName()).append(" attacks ").append(a.getName()).append("\n");
            }
            aTurn = !aTurn;
        }

        if (a.isAlive()) {
            a.train();
            a.addWin();
            b.addLoss();
            b.recover();  // Revive defeated
            log.append(b.getName()).append(" is defeated. ").append(a.getName()).append(" gains XP.\n");
        } else {
            b.train();
            b.addWin();
            a.addLoss();
            a.recover();  // Revive defeated
            log.append(a.getName()).append(" is defeated. ").append(b.getName()).append(" gains XP.\n");
        }

        return log.toString();
    }
}
