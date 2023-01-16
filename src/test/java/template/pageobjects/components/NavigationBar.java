package template.pageobjects.components;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class NavigationBar extends AbstractComponent{

    @Override
    @Step("Stelle sicher, dass die Navigationsleiste verfübar ist")
    public void isComponentAvailable() {
        $(".main-header .navbar").shouldBe(Condition.visible);
    }

    @Step("Stelle sicher, dass alle Menüpunkte vorhanden sind")
    public void validateMenubar(){

    }
}
