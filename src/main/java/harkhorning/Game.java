package harkhorning;

import com.raylib.Raylib;
import harkhorning.core.HardGlobalVariables;
import harkhorning.state.ContextStream;
import harkhorning.state.StateMachine;

import static com.raylib.Colors.RAYWHITE;
import static com.raylib.Raylib.*;

public class Game { // make this a runnable

    StateMachine s;
    ContextStream ctx;
    HardGlobalVariables hC = new HardGlobalVariables();

    public Game()
    {
//        SetConfigFlags(FLAG_FULLSCREEN_MODE);
        InitWindow(448 * hC.getScaler(), 256 * hC.getScaler(), "Gnome Survivor");
        this.ctx = new ContextStream();
        this.s = new StateMachine(ctx);
    }

    public void Run()
    {
        Raylib r = new Raylib();
        SetExitKey(KEY_NULL);
        SetTargetFPS(60);

        while (!WindowShouldClose() && !s.CHECK_GAME_OVER()) {
            BeginDrawing();
            ClearBackground(RAYWHITE);

            s.UpdateGame();
            s.DrawGame();

            EndDrawing();
        }

        CloseWindow();
    }
}
