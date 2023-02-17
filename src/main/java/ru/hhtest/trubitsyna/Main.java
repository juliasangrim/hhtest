package ru.hhtest.trubitsyna;

import ru.hhtest.trubitsyna.model.creature.Creature;
import ru.hhtest.trubitsyna.model.creature.CreatureFabric;
import ru.hhtest.trubitsyna.model.creature.GameRole;
import ru.hhtest.trubitsyna.simulator.Simulator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int MONSTERS_COUNT = 5;

    public static void main(String[] args) {
        Creature player = CreatureFabric.getCreature(GameRole.PLAYER, "Harry Potter",
                100, 5, 10, 1, 6);
        List<Creature> monsters = new ArrayList<>();
        for (int  i = 0; i < MONSTERS_COUNT; ++i) {
            Creature monster = CreatureFabric.getCreature(GameRole.MONSTER, "Goblin " + i,
                    4, 15, 5, 1, 6);
            monsters.add(monster);
        }
        Simulator.run(player, monsters);
    }
}