package template.pageobjects.components.homepage;

import io.qameta.allure.Step;
import template.pageobjects.components.AbstractComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Header extends AbstractComponent {

    public NavigationBar navigationBar = new NavigationBar();

    @Override
    public void isComponentAvailable() {
        $(".main-header").shouldBe(visible);
    }

    @Step("Stelle sicher, dass der Header korrekt angezeigt wird")
    public void validatePageHeader(){
        navigationBar.isComponentAvailable();
    }
}
