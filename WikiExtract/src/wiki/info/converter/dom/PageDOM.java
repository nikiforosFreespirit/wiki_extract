package wiki.info.converter.dom;

import org.jsoup.nodes.Element;

import wiki.info.retriever.input.BaseRetrieverInputData;

public class PageDOM extends AbstractPageDOM<String> {

  public PageDOM(BaseRetrieverInputData data) {
    super(data);
  }

  @Override
  void putIntoDOM(Element topic, String content) {
    String sTopic = topic.text();
    documentDOM.put(sTopic, content);
  }
}
