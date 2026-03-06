package harkhorning.Misc;

import harkhorning.state.State;
import harkhorning.state.StateMachine;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//@FunctionalInterface
//interface MyCustomOperation {
//    int perform(int a, int b);
//}

public class DeathTimer {

    int delay = 1000;

    public DeathTimer(int delay)
    {
        this.delay = delay;
    }

    public void startTimer(StateMachine s)
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            System.out.println("Task executed using ScheduledExecutorService!");
            s.NewGameState(State.DEATH_SCREEN);
            executor.shutdown(); // Optional: Stop the executor after the task runs
        };

        executor.schedule(task, delay, TimeUnit.MILLISECONDS);
    }

//    public void startTimer(MyCustomInterface operation)
//    {
//        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
//
//        Runnable task = () -> {
//            System.out.println("Task executed using ScheduledExecutorService!");
//            operation.perform(a, b)
//            executor.shutdown(); // Optional: Stop the executor after the task runs
//        };
//
//        executor.schedule(task, delay, TimeUnit.MILLISECONDS);
//    }
}
