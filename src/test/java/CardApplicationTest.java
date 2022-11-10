import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardApplicationTest {

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:9999");
        $("[data-test-id=\"name\"] input").sendKeys("Елена Мартемьянова");
        $("[data-test-id=\"phone\"] input").sendKeys("+79964052875");
        $("[data-test-id=\"agreement\"] span").click();
        $("[class=\"button button_view_extra button_size_m button_theme_alfa-on-white\"]").click();

        $("[data-test-id=\"order-success\"]").shouldHave(Condition.text("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}
