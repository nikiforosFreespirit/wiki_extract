package wiki.page.start;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.TextField;

import wiki.page.info.InfoPage;

public class SearchButton extends Button {

  private final TextField<String> cityInput;

  /**
   *
   */
  private static final long serialVersionUID = -1180372695013952264L;

  SearchButton(String id, TextField<String> cityInput) {
    super(id);
    this.cityInput = cityInput;
  }

  @Override
  public void onSubmit() {
    String location = cityInput.getModelObject();
    setResponsePage(new InfoPage(location));
  }

}
