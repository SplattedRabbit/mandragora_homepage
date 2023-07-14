package mandragora.pageobjects.pages;

import mandragora.pageobjects.components.homepage.Title;

/**
 * @author pfotenhauer
 */
public abstract class AbstractPageObject {
  public Title title = new Title();

  public void validateStructure() {}

  public abstract AbstractPageObject isExpectedPage();
}
