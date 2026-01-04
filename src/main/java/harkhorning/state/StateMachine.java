package harkhorning.state;

import harkhorning.state.deathScreen.DeathScreen;
import harkhorning.state.gameCycle.GameCycle;
import harkhorning.state.mainMenu.MainMenu;
import harkhorning.state.optionMenu.OptionMenu;
import harkhorning.state.quitting.Quitting;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static com.raylib.Colors.WHITE;
import static com.raylib.Raylib.DrawText;

public class StateMachine {

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private GameState currentState;
    ContextStream ctx;
    private final MainMenu mainMenu;
    private final GameCycle gameCycle;
    private final OptionMenu optionMenu;
    private final DeathScreen deathScreen;
    private final Quitting quitting;
    private boolean GAME_OVER = false;


    int updatesPS = 0;

    public StateMachine(ContextStream ctx)
    {
        this.ctx = ctx;
        mainMenu = new MainMenu(this);
        gameCycle = new GameCycle(this, ctx);
        optionMenu = new OptionMenu(this);
        deathScreen = new DeathScreen(this);
        quitting = new Quitting(this);

        currentState = mainMenu;
        currentState.Init();
    }

    private void ChangeState(GameState g)
    {
        currentState.Exit();
        currentState = g;
        currentState.Init();
    }

    public void NewGameState(State state)
    {
        switch (state)
        {
            case MAIN_MENU -> ChangeState(mainMenu);
            case RUNNING -> ChangeState(gameCycle);
            case OPTION_MENU ->  ChangeState(optionMenu);
            case DEATH_SCREEN -> ChangeState(deathScreen);
            case QUITE -> ChangeState(quitting);
        }
    }

    public void EndGame()
    {
        currentState.Exit();
    }

    public void UpdateGame()
    {
        rwLock.writeLock().lock();
        try {
            currentState.Update();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void DrawGame()
    {
        rwLock.readLock().lock();
        try {
            currentState.Draw();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void CLOSE_GAME()
    {
        GAME_OVER = true;
    }

    public boolean CHECK_GAME_OVER() { return GAME_OVER; }

    public GameState getCurrentState() { return currentState; }
}
