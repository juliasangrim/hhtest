package ru.hhtest.trubitsyna.model.creature;

import lombok.experimental.SuperBuilder;

/**
 * Class present creature with type Monster.
 */
@SuperBuilder
public class Monster extends Creature {

    /**
     * Method for heal monster.
     */
    @Override
    public void heal() {
        throw new UnsupportedOperationException("Monster can't heal.");
    }
}