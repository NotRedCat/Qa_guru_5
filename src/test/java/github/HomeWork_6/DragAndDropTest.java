package github.HomeWork_6;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @Test
    void dragAndDropTest(){
        Configuration.browserSize="1900x1000";
        //открыть страницу the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Проверяем, что А находится на месте А, а B на месте B
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        //Меняем элементы местами
        $("#column-a").dragAndDropTo($("#column-b"));
        /*actions()
                .clickAndHold($("#column-a"))
                .moveToElement($("#column-b"))
                .release();*/
        //Проверяем, что А находится на месте B, а B на месте A
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
}
}
