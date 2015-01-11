package wiki.page.start;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class CityInputForm extends Form {

  /**
   *
   */
  private static final long serialVersionUID = 3741785517099057680L;

  public CityInputForm(String id) {
    super(id);

    TextField<String> cityInput = new TextField<String>("city_input", new Model(""));
    add(cityInput);

    add(new SearchButton("search_button", cityInput));
  }

  @Override
  protected void onSubmit() {
    // not needed (done by the on submit button)
    // String location = cityInput.getModelObject().toString();
    // System.out.println(location);

  }

}
