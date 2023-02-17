package ru.hhtest.trubitsyna.model.dice;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * Class for throw dice.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiceThrowSimulator {
    public static final int SUCCESS_BOUND = 5;
    private static final int MIN_DICE_VALUE = 1;
    private static final int MAX_DICE_VALUE = 6;
    private static final Random DICE_THROW_SIMULATOR = new Random();

    /**
     * Method for generated dice throw.
     *
     * @return amount of point on dice.
     */
    public static int throwDice() {
        return DICE_THROW_SIMULATOR.nextInt(MIN_DICE_VALUE, MAX_DICE_VALUE + 1);
    }

}