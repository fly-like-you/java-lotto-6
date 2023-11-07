package lotto.domain;

import lotto.view.impl.LottoBuyView;

import static lotto.service.LottoGenerator.generateAutoLotto;

public class Store {
    private LottoBuyView lottoBuyView;


    public Store(LottoBuyView lottoBuyView) {
        this.lottoBuyView = lottoBuyView;
    }

    public Lottos sell() {
        Money money = requestMoneyAmount();
        Lottos lottos = lottoGenerate(money);
        informLotto(lottos);

        return lottos;
    }

    private void informLotto(Lottos lottos) {
        lottoBuyView.outputView(lottos);
    }

    private Money requestMoneyAmount(){
        return (Money) lottoBuyView.inputView();
    }

    private Lottos lottoGenerate(Money money) {
        int lottoCount = countLotto(money);

        Lottos lottos = new Lottos();
        for (int count = 0; count < lottoCount; count++) {
            lottos.addLotto(generateAutoLotto());
        }

        return lottos;
    }

    private int countLotto(Money money) {
        return money.calculateCount(money);
    }
}