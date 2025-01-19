package software.ulpgc.kata3.clean.control;

import software.ulpgc.kata3.clean.view.BarchartDisplay;
import software.ulpgc.kata3.clean.io.BarchartLoader;

public class ToggleChartCommand implements Command {
    private final BarchartLoader loader;
    private final BarchartDisplay display;
    private int i = 1;

    public ToggleChartCommand(BarchartLoader loader, BarchartDisplay display) {
        this.loader = loader;
        this.display = display;
    }

    @Override
    public void execute() {
        display.display(loader.load(i++ % 2));
    }
}
