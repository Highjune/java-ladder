package ladder.domain.ladder;

import ladder.strategy.LineStrategy;
import ladder.strategy.RandomLineStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {

    private static final LineStrategy DEFAULT_STRATEGY = new RandomLineStrategy();
    private static final int MIN_WIDTH = 0;
    private List<Boolean> lines;
    private LineStrategy lineStrategy;

    public LadderRow(List<Boolean> lines) {
        this.lines = lines;
    }

    public LadderRow(int width) {
        this(width, DEFAULT_STRATEGY);
    }

    public LadderRow(int width, LineStrategy lineStrategy) {
        this.lineStrategy = lineStrategy;
        lines = generateLines(width);
    }

    public List<Boolean> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public boolean hasLine(int width) {
        if (width >= this.lines.size()) {
            return false;
        }
        return this.lines.get(width);
    }

    public boolean isNotEnd(int position) {
        return position >= MIN_WIDTH && position <= this.lines.size();
    }

    public boolean isLeftEnd(int position) {
        return position == MIN_WIDTH;
    }

    public boolean isRightEnd(int position) {
        return position >= this.lines.size();
    }

    private List<Boolean> generateLines(int width) {
        final List<Boolean> newLines = new ArrayList<>();
        newLines.add(generateLine());
        for (int i = 1; i < width; i++) {
            newLines.add(generateLine(newLines.get(i - 1)));
        }

        return newLines;
    }

    private Boolean generateLine() {
        return lineStrategy.isConnectable();
    }

    private Boolean generateLine(boolean preValue) {
        if (preValue) {
            return false;
        }
        return lineStrategy.isConnectable();
    }

    public int size() {
        return lines.size();
    }
}
