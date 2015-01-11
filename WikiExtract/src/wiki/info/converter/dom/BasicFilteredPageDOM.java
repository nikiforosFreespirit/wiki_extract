package wiki.info.converter.dom;

import org.jsoup.nodes.Element;

import wiki.info.retriever.input.BaseRetrieverInputData;

public class BasicFilteredPageDOM extends PageDOM {

  private final int minSizeToShow;
  private static final int DEFAULT_MIN_SIZE_TO_SHOW = 200;

  public BasicFilteredPageDOM(BaseRetrieverInputData data) {
    super(data);
    this.minSizeToShow = DEFAULT_MIN_SIZE_TO_SHOW;
  }

  public BasicFilteredPageDOM(BaseRetrieverInputData data, int minSizeToShow) {
    super(data);
    this.minSizeToShow = minSizeToShow;
  }

  @Override
  void putIntoDOM(Element topic, String content) {
    if (content.length() > this.minSizeToShow) {
      super.putIntoDOM(topic, content);
    }
  }

}
