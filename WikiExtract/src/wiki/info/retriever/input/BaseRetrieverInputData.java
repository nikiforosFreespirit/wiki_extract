package wiki.info.retriever.input;

import info.bliki.api.User;
import info.bliki.wiki.filter.Encoder;

public class BaseRetrieverInputData {

  private final String[] listOfTitleStrings;

  private final String titleURL;

  private final User user;

  private final String mainDirectory = "./results/";

  // the following subdirectory should not exist if you would like to create a new database
  private final String databaseSubdirectory = "WikiDB/";

  // the following directory must exist for image downloads
  private final String imageDirectory = mainDirectory + "WikiImages/";

  // the generated HTML will be stored in this file name:
  private final String generatedHTMLFilename;

  public BaseRetrieverInputData(String location, String language) {
    this.listOfTitleStrings = new String[1];
    this.listOfTitleStrings[0] = location.trim();
    this.titleURL = Encoder.encodeTitleLocalUrl(location.trim());
    StringBuilder entryURL = setEntryURL(language.trim());
    this.user = new User("", "", entryURL.toString());
    this.generatedHTMLFilename = mainDirectory + titleURL + ".html";

    initialize();
  }

  StringBuilder setEntryURL(String language) {
    StringBuilder entryURL = new StringBuilder("http://").append(language).append(".wikivoyage.org/w/api.php");
    return entryURL;
  }

  private void initialize() {
    this.user.login();
  }

  public final String[] getListOfTitleStrings() {
    return listOfTitleStrings;
  }

  public final String getTitleURL() {
    return titleURL;
  }

  public final User getUser() {
    return user;
  }

  public final String getMainDirectory() {
    return mainDirectory;
  }

  public final String getDatabaseSubdirectory() {
    return databaseSubdirectory;
  }

  public final String getImageDirectory() {
    return imageDirectory;
  }

  public final String getGeneratedHTMLFilename() {
    return generatedHTMLFilename;
  }

}
