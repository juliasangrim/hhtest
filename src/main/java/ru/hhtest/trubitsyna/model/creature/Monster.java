package ru.hhtest.trubitsyna.model.creature;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Monster extends Creature {
    @Override
    public void heal() {
        throw new UnsupportedOperationException("Monster can't heal.");
    }
}