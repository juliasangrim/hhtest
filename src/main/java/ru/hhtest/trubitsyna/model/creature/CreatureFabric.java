package ru.hhtest.trubitsyna.model.creature;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Class for creation creature of different types.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatureFabric {

    /**
     * Method for create creature.
     *
     * @param role the role of creature.
     * @param name the name of creature.
     * @param hp the health point.
     * @param attack the attack of creature.
     * @param defence the defence of creature.
     * @param minDamage the low bound of damage.
     * @param maxDamage the high bound of damage.
     * @return creature of specific type.
     */
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