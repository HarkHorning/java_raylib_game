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
//        SetConfigFlags(FLAG_FULLSCREEN_MODE);
        InitWindow(1280, 720, "Gnome Survivor");
        this.ctx = new ContextStream();
        this.s = new StateMachine(ctx);
        this.updateThread = new UpdateThread(s);
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
