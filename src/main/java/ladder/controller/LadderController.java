package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.PlayerGroup;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {

    private InputView inputView;
    private ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        String playerNames = inputView.readPlayerNames();
        int height = inputView.readHeight();

        PlayerGroup playerGroup = new PlayerGroup(playerNames);
        Ladder ladder = new Ladder(height, playerGroup.size());

        resultView.printLadder(ladder, playerGroup);
    }
}
