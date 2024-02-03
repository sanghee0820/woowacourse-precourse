package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @Test
    @DisplayName("로또 서비스 : 구매 테스트")
    public void buyLotto() {
        LottoService lottoService = new LottoService(1000);
        lottoService.buyLotto();
        assertThat(lottoService.getLottos().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 서비스 : budget 오류테스트")
    public void budgetErrorTest() {
        assertThatThrownBy(() -> new LottoService(10)).isInstanceOf(IllegalArgumentException.class);
    }
}
