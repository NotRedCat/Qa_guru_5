package github.HomeWork_6;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestGitHubMenuAndPricing {
    @BeforeAll
    static void setConfig(){
        Configuration.browserSize = "1900x1000";
        //открыть страницу на github.com
        open("https://github.com");
    }
    @Test
    void testMenu() {
        //Навести мышь на пункт меню Open Source
        $(".header-menu-wrapper").$(byText("Open Source")).hover();
        //кликнуть по пункту выпадающего списка Trending
        $(byText("Trending")).click();
        //Проверить, что на открывшейся странице заголовок содержит Trending
        $(".h1").shouldHave(text("Trending"));
    }

    @Test
    void testPricing() {
        //Кликнуть на пункт меню Pricing
        $(".header-menu-wrapper").$(byText("Pricing")).hover().click();
        //Проверить, что на открывшейся странице заголовок содержит Get the complete developer platform.
        $(".h2-mktg").shouldHave(text("Get the complete developer platform."));
    }
}
