package github.HomeWork_6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class ContributorsTest {
    @Test
    void andreiSolntsevShouldContributorsTheMost(){
        Configuration.browserSize="1900x1000";
        //открыть страницу на github.com/selenide/selenide
        open("https://github.com/selenide/selenide");
        //ввести в поле поиска selenide и нажать Enter
        $(".Layout-sidebar").$(byText ("Contributors"))
                .ancestor(".BorderGrid-cell").$$("ul li").first()
                .hover();
       //Наводим мышь на нужный аватар
        $$(".Popover-message").find(visible).shouldHave(text("Andrei Solntsev"));
        //Проверяем, что в тексте есть Andrei Solntsev

    }
}
