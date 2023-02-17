package ru.hhtest.trubitsyna.model.creature;

import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import static java.lang.Math.min;


/**
 * Class present creature with type Player.
 */
@SuperBuilder
@Slf4j
public class Player extends Creature {

    private static final int MAX_HEAL_COUNT = 3;
    private static final double HEAL_MODIFIER = 0.5;
    private int healCount;

    /**
     * Method for heal player.
     */
    @Override
    public void heal() {
        if (healCount < MAX_HEAL_COUNT) {
            int maxHp = super.getMaxHp();
            int currHp = super.getCurrHp();
            int newCurrHp = min(currHp + (int) (HEAL_MODIFIER * maxHp), maxHp);
            super.setCurrHp(newCurrHp);
            log.info("Creature {} heal {} point hp.", getName(), newCurrHp - currHp);
            healCount++;
        }
    }
}