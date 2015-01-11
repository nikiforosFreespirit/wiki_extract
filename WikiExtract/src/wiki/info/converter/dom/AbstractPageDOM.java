package wiki.info.converter.dom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import wiki.info.retriever.WikiVoyagePageRetriever;
import wiki.info.retriever.input.BaseRetrieverInputData;

public abstract class AbstractPageDOM<K> {

  Map<K, String> documentDOM;

  public AbstractPageDOM(BaseRetrieverInputData data) {
    String html = WikiVoyagePageRetriever.retrievePage(data);
    Element body = Jsoup.parse(html).body();
    initializePageDOM(body);
  }

  abstract void putIntoDOM(Element topic, String content);

  private void initializePageDOM(Element body) {
    documentDOM = new HashMap<K, String>();
    List<Element> topics = getTopicList(body);

    for (int i = 0; i < topics.size(); i++) {
      Element topic = topics.get(i);
      Element nextTopic = null;
      if (i + 1 < topics.size()) {
        nextTopic = topics.get(i + 1);
      }
      Element nextOne = topic.nextElementSibling();
      StringBuilder contentBuilder = new StringBuilder();
      while (nextOne != null && nextTopic != null && nextOne != nextTopic) {
        if (nextOne.tagName().equalsIgnoreCase("p")) {
          // System.out.println((nextOne).text());
          contentBuilder.append(nextOne.text()).append("\n");

        }
        String content = contentBuilder.toString();
        if (!content.isEmpty()) {
          putIntoDOM(topic, content);
        }
        nextOne = nextOne.nextElementSibling();
      }
      // System.out.println();
    }

  }

  /**
   * @param doc
   */
  private List<Element> getTopicList(Element body) {
    List<Element> topicList = new ArrayList<Element>();

    Elements link = body.getElementsByTag("H2");
    Iterator<Element> it = link.iterator();
    while (it.hasNext()) {
      Element topic = it.next();
      if (topic.children().size() > 0) {
        Element topicName = topic.child(0);
        String classKey = "mw-headline";
        if (topicName != null && topicName.hasClass(classKey)) {
          topicList.add(topic);
        }
      }
    }
    return topicList;
  }

  /**
   * @return the sorted documentDOM
   */
  public final TreeMap<K, String> getSortedDOM() {
    return new TreeMap<K, String>(this.documentDOM);
  }

}