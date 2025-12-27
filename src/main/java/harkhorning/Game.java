package harkhorning;

import harkhorning.state.ContextStream;
import harkhorning.state.StateMachine;
import harkhorning.state.UpdateThread;

import static com.raylib.Colors.RAYWHITE;
import static com.raylib.Raylib.*;

public class Game {

    StateMachine s;
    ContextStream ctx;
    UpdateThread updateThread;

    public Game()
    {
        InitWindow(800, 450, "Gnome Survivor");
        this.s = new StateMachine();
        this.ctx = new ContextStream();
        this.updateThread = new UpdateThread(s, ctx);
    }

    public void Run()
    {
        updateThread.startGameCycleThread();
        SetExitKey(KEY_NULL);
        SetTargetFPS(60);

        while (!WindowShouldClose() && !s.CHECK_GAME_OVER()) {
            BeginDrawing();
            ClearBackground(RAYWHITE);

            s.DrawGame();

            EndDrawing();
        }
        updateThread.stopRenderThread();
        CloseWindow();
    }
}
