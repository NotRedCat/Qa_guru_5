package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class WikiGitHub {
    @Test
    void shouldFindSoftAssertionsAsRepository() {
        //открыть страницу на githab.com
        open("https://github.com/");
        //ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //нажимаем на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        //check: в заголовке встречается selenide/selenide
        $("#wiki-tab").click();
        //переходим в раздел Wiki
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        //ищем в страницах SoftAssertions
        $$("ul.m-0 p-0 list-style-none filterable-active").find(text("SoftAssertions"));
        //Проверяем, что в списке есть SoftAssertions
        $(byLinkText("Soft assertions")).click();
        //кликаем на ссылку Soft assertions
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
        //Проверяем, что внутри есть пример кода для JUnit5
    }
}

