package harkhorning.state;

public class UpdateThread implements Runnable {

    Thread updateThread;
    StateMachine s;
    private int FPS;

    public UpdateThread(StateMachine s) {
        this.s = s;
        FPS = 60;
    }

    public void startGameCycleThread() {
        updateThread = new Thread(this);
        updateThread.start();
    }

    public void stopRenderThread() {
        if (updateThread != null) {
            Thread.currentThread().interrupt();
            updateThread = null;
        }
    }

    @Override
    public void run() {

        double drawInterval = (double) 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (updateThread != null) {

            s.UpdateGame();

            try {
                double timeRemaining = (nextDrawTime - System.nanoTime()) / 1000000;
                if (timeRemaining < 0) {timeRemaining = 0;} // optional
                Thread.sleep((long) timeRemaining);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
