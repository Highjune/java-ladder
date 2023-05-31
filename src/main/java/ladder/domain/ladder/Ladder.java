package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    public List<LadderRow> rows;

    public Ladder(LadderHeight ladderHeight, int countOfPlayers) {
        rows = generateRows(ladderHeight.getHeight(), countOfPlayers);
    }

    public int move(int index) {
        int position = index;
        for (LadderRow row : rows) {
            position = row.move(position);
        }
        return position;
    }

    private List<LadderRow> generateRows(int height, int countOfPlayers) {
        final List<LadderRow> newRows = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            newRows.add(new LadderRow(countOfPlayers));
        }

        return newRows;
    }

    public int height() {
        return rows.size();
    }

    public List<LadderRow> getRows() {
        return Collections.unmodifiableList(rows);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ladder)) {
            return false;
        }

        Ladder ladder = (Ladder) o;

        return rows.equals(ladder.rows);
    }

    @Override
    public int hashCode() {
        return rows.hashCode();
    }
}
