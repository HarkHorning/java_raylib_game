package harkhorning.state;

import harkhorning.state.DeathScreen.DeathScreen;
import harkhorning.state.GameCycle.GameCycle;
import harkhorning.state.MainMenu.MainMenu;
import harkhorning.state.OptionMenu.OptionMenu;
import harkhorning.state.Quitting.Quitting;

public class StateMachine {

    private GameState currentState;
    private final MainMenu mainMenu;
    private final GameCycle gameCycle;
    private final OptionMenu optionMenu;
    private final DeathScreen deathScreen;
    private final Quitting quitting;
    private boolean GAME_OVER = false;

    public StateMachine()
    {
        mainMenu = new MainMenu(this);
        gameCycle = new GameCycle(this);
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
