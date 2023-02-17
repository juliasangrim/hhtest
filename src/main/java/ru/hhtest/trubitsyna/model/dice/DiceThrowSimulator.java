package ru.hhtest.trubitsyna.model.dice;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DiceThrowSimulator {

    public static final int SUCCESS_BOUND = 5;
    private static final int MIN_DICE_VALUE = 1;
    private static final int MAX_DICE_VALUE = 6;
    private static final Random DICE_THROW_SIMULATOR = new Random();

    public static int throwDice() {
        return DICE_THROW_SIMULATOR.nextInt(MIN_DICE_VALUE, MAX_DICE_VALUE + 1);
    }

}