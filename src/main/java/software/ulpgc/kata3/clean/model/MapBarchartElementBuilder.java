package software.ulpgc.kata3.clean.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapBarchartElementBuilder <K> implements BarchartElementBuilder {
    private final Map<K, Integer> values;

    public MapBarchartElementBuilder(Map<K, Integer> values) {
        this.values = values;
    }

    @Override
    public List<BarchartElement> build() {
        List<BarchartElement> barchartElements = new ArrayList<>();
        for (K i : values.keySet()) {
            barchartElements.add(new BarchartElement(String.valueOf(i), values.get(i)));
        }
        return barchartElements;
    }
}
