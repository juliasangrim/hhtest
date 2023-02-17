package ru.hhtest.trubitsyna.model.damage;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * Class for generate damage point.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DamageGenerator {
    private static final Random DAMAGE_GENERATOR = new Random();

    /**
     * Method for generate damage point.
     *
     * @param minBound the low bound of damage.
     * @param maxBound the high bound of damage.
     * @return generated point of damage.
     */
    public static int countDamage(int minBound, int maxBound) {
        return DAMAGE_GENERATOR.nextInt(minBound, maxBound + 1);
    }

}