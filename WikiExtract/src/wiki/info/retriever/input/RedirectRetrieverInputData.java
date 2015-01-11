package wiki.info.retriever.input;

public class RedirectRetrieverInputData extends BaseRetrieverInputData {

  public RedirectRetrieverInputData(String location, String language) {
    super(location, language);
  }

  @Override
  StringBuilder setEntryURL(String language) {
    return super.setEntryURL(language).append("?redirects");
  }

}
