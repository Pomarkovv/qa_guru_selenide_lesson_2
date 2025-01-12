import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWikiTest {

    private static final String EXPECTED_JUNIT_CODE = "@ExtendWith({SoftAssertsExtension.class})\n" +
            "class Tests {\n" +
            "  @Test\n" +
            "  void test() {\n" +
            "    Configuration.assertionMode = SOFT;\n" +
            "    open(\"page.html\");\n" +
            "\n" +
            "    $(\"#first\").should(visible).click();\n" +
            "    $(\"#second\").should(visible).click();\n" +
            "  }\n" +
            "}";

    @Test
    void softAssertionsPageHasJunit5CodeSuccessfully() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();

        $("div.markdown-body").shouldHave(text("Soft assertions"));

        $$("a").findBy(text("Soft assertions")).click();

        $("*").shouldHave(text(EXPECTED_JUNIT_CODE));
    }
}
