package wiki.page.start.app;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import wiki.page.start.StartPage;

public class StartPageApp extends WebApplication {

  @Override
  public Class<? extends Page> getHomePage() {
    return StartPage.class;
  }

}
