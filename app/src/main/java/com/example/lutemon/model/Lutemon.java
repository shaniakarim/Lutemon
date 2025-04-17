package com.example.lutemon.model;

public abstract class Lutemon {
    protected String name, color;
    protected int attack, defense, maxHealth, currentHealth;
    protected int experience, wins, losses;

    public Lutemon(String name, String color, int attack, int defense, int maxHealth) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.experience = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public int getAttackPower() {
        return attack + experience;
    }

    public void train() {
        experience++;
    }

    public void recover() {
        currentHealth = maxHealth;
    }

    public void takeDamage(int damage) {
        currentHealth -= Math.max(0, damage - defense);
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }

    public void addWin() {
        wins++;
    }

    public void addLoss() {
        losses++;
    }

    public String getName() { return name; }

}
