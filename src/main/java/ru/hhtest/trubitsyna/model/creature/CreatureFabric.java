package ru.hhtest.trubitsyna.model.creature;

public class CreatureFabric {

    public static Creature getCreature(GameRole role, String name, int hp, int attack, int defence, int minDamage, int maxDamage) {
        if (attack < 1 || attack > 20 || defence < 1 || defence > 20) {
            throw new IllegalArgumentException("The range of defence or attack has to be from 1 to 20.");
        }
        if (hp < 0) {
            throw new IllegalArgumentException("Hp has to be positive value.");
        }
        if (minDamage > maxDamage) {
            throw new IllegalArgumentException("Invalid damage params.");
        }
        switch (role) {
            case PLAYER -> {
                return Player.builder()
                        .name(name)
                        .currHp(hp)
                        .maxHp(hp)
                        .healCount(0)
                        .attack(attack)
                        .defence(defence)
                        .damageMinBound(minDamage)
                        .damageMaxBound(maxDamage).build();
            }
            case MONSTER -> {
                return Monster.builder()
                        .name(name)
                        .currHp(hp)
                        .maxHp(hp)
                        .attack(attack)
                        .defence(defence)
                        .damageMinBound(minDamage)
                        .damageMaxBound(maxDamage).build();
            }
            default -> {
                throw new UnsupportedOperationException("Role " + role.name() + " doesn't exist!");
            }
        }
    }
}