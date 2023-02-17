package ru.hhtest.trubitsyna.simulator;

import lombok.extern.slf4j.Slf4j;
import ru.hhtest.trubitsyna.model.creature.Creature;

import java.util.List;
import java.util.Random;

@Slf4j
public class Simulator {
    private static final Random GENERATOR = new Random();

    private static int makeTurn(Creature player, List<Creature> monsters, boolean isPlayerTurn) {
        int deadMonstersCount = 0;
        if (isPlayerTurn) {
            boolean isTimeToHeal = GENERATOR.nextBoolean();
            if (isTimeToHeal) {
                player.heal();
            }
            for (var monster : monsters) {
                player.attack(monster);
                if (monster.isDead()) {
                    deadMonstersCount++;
                }
            }
        } else {
            for (var monster : monsters) {
                monster.attack(player);
            }
        }
        return deadMonstersCount;
    }
    public static void run(Creature player, List<Creature> monsters) {
        boolean isPlayerTurn = true;
        int deadMonstersCount = 0;
        while (!player.isDead() && deadMonstersCount != monsters.size()) {
            deadMonstersCount = makeTurn(player, monsters, isPlayerTurn);
            isPlayerTurn = !isPlayerTurn;
        }
        if (!player.isDead()) {
            log.info("Player win!");
        } else {
            log.info("Player loose!");
        }
    }
}