package harkhorning.graphics.ui;

import com.raylib.Raylib;
import harkhorning.core.HardGlobalVariables;

import static com.raylib.Colors.PINK;

public class Components {

    HardGlobalVariables hC = new HardGlobalVariables();
    public Raylib.Color colorMain = new Raylib.Color(PINK);
    public Raylib.Color colorSecondary;
    public Raylib.Color colorHighlight;
    public Raylib.Color colorMidTone;

    public void CenteredText(String text, int x, int y, int size, Raylib.Color color)
    {
        int textSize = Raylib.MeasureText(text, size);
        Raylib.DrawText(text, x - textSize / 2, y * hC.getScaler(), size, color);
    }
}
