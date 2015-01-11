package wiki.info.converter.dom;

import org.jsoup.nodes.Element;

import wiki.info.retriever.input.BaseRetrieverInputData;

public class HeavyPageDOM extends AbstractPageDOM<Element> {

  public HeavyPageDOM(BaseRetrieverInputData data) {
    super(data);
  }

  @Override
  void putIntoDOM(Element topic, String content) {
    documentDOM.put(topic, content);
  }

}
