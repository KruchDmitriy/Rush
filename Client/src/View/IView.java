package View;

public interface IView {
    void greetingsDialog();
    void drawListRaces(List<RaceHandle> races);
    void startGame();
    void drawMap();
    void drawCars(List<CarHandle> cars);
    void gameOver();
    void showStatistics();
}
