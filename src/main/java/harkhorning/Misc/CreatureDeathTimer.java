package harkhorning.Misc;

import harkhorning.physics.creature.Creature;
import harkhorning.state.State;
import harkhorning.state.StateMachine;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CreatureDeathTimer {

    int delay = 1000;

    public CreatureDeathTimer(int delay)
    {
        this.delay = delay;
    }

    public void startTimer(Creature c)
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("Creature Death");
            c.destroy();
            executor.shutdown(); // Optional: Stop the executor after the task runs
        };

        executor.schedule(task, delay, TimeUnit.MILLISECONDS);
    }
}
