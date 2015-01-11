package wiki.info.extractor;

import wiki.info.converter.dom.AbstractPageDOM;
import wiki.info.converter.dom.BasicFilteredPageDOM;
import wiki.info.retriever.input.BaseRetrieverInputData;

public class WikiVoyageExtractor {

  public static AbstractPageDOM<?> extract(BaseRetrieverInputData inputData) {
    AbstractPageDOM<?> convertedInfo = new BasicFilteredPageDOM(inputData);
    return convertedInfo;
  }

}
