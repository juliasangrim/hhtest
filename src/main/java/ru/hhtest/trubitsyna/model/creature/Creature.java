package ru.hhtest.trubitsyna.model.creature;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import ru.hhtest.trubitsyna.model.damage.DamageGenerator;

import static ru.hhtest.trubitsyna.model.dice.DiceThrowSimulator.SUCCESS_BOUND;
import static ru.hhtest.trubitsyna.model.dice.DiceThrowSimulator.throwDice;

@SuperBuilder
@Getter
@Setter
@Slf4j
public abstract class Creature {

    private static final int MIN_ATTACK_MODIFIER = 1;

    private String name;
    private int attack;
    private int maxHp;
    private int currHp;
    private int defence;
    private int damageMinBound;
    private int damageMaxBound;

    public abstract void heal();

    public void attack(Creature enemy) {
        if (!isDead() && !enemy.isDead()) {
            int attackModifier = attack - enemy.defence + 1 > 0 ? attack - enemy.defence + 1 : MIN_ATTACK_MODIFIER;
            if (isAttackSuccessful(attackModifier)) {
                enemy.currHp -= DamageGenerator.countDamage(damageMinBound, damageMaxBound);
            }
            log.info("Creature {} attack creature {}! Current hp defender {}.", name, enemy.name, enemy.currHp);
        }
    }

    public boolean isDead() {
        return currHp <= 0;
    }

    private boolean isAttackSuccessful(int attackModifier) {
        boolean isSuccess = false;

        for (int i = 0; i < attackModifier; ++i) {
            if (throwDice() >= SUCCESS_BOUND) {
                isSuccess = true;
                break;
            }
        }
        return isSuccess;
    }

}