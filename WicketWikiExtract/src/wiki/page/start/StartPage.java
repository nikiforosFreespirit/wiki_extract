package wiki.page.start;

import org.apache.wicket.markup.html.WebPage;

public class StartPage extends WebPage {

  /**
   * city_input search_button
   */
  private static final long serialVersionUID = -3944965092181796662L;

  public StartPage() {

    CityInputForm form = new CityInputForm("wiki_input");
    add(form);

  }
}
