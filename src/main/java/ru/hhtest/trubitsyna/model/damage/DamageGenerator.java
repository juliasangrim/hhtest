package ru.hhtest.trubitsyna.model.damage;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DamageGenerator {
    private static final Random DAMAGE_GENERATOR = new Random();

    public static int countDamage(int minBound, int maxBound) {
        return DAMAGE_GENERATOR.nextInt(minBound, maxBound + 1);
    }

}