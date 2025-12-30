package harkhorning.State;

import harkhorning.State.DeathScreen.DeathScreen;
import harkhorning.State.GameCycle.GameCycle;
import harkhorning.State.MainMenu.MainMenu;
import harkhorning.State.OptionMenu.OptionMenu;
import harkhorning.State.Quitting.Quitting;

public class StateMachine {

    private GameState currentState;
    ContextStream ctx;
    private final MainMenu mainMenu;
    private final GameCycle gameCycle;
    private final OptionMenu optionMenu;
    private final DeathScreen deathScreen;
    private final Quitting quitting;
    private boolean GAME_OVER = false;

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
        currentState.Update();
    }

    public void DrawGame()
    {
        currentState.Draw();
    }

    public void CLOSE_GAME()
    {
        GAME_OVER = true;
    }

    public boolean CHECK_GAME_OVER() { return GAME_OVER; }

    public GameState getCurrentState() { return currentState; }
}
