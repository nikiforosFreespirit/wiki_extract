package wiki.info.dump;

import java.util.TreeMap;

import wiki.info.converter.dom.AbstractPageDOM;
import wiki.info.extractor.WikiVoyageExtractor;
import wiki.info.retriever.input.BaseRetrieverInputData;
import wiki.info.retriever.input.RedirectRetrieverInputData;

public class WikiInfoExtractClient {

  public static void main(String[] args) {

    String language = "en   ";
    String location = "Athens";

    // prepare input
    BaseRetrieverInputData inputData = new RedirectRetrieverInputData(location, language);
    AbstractPageDOM<?> dom = WikiVoyageExtractor.extract(inputData);

    // // retrieve html document
    // String html = WikiVoyagePageRetriever.retrievePage(inputData);
    //
    // // parse html document
    // Element body = WikiVoyageHtmlPageParser.parse(html);
    //
    // // List<Element> topics = TopicIndex.getTopicList(body);
    //
    // // // convert to project data model
    // // TopicIndex.printIndex(doc);
    // AbstractPageDOM<?> dom = WikiVoyageBaseConverter.convertDocument(body);
    //
    TreeMap<?, String> sortedMap = dom.getSortedDOM();
    System.out.println(sortedMap);

    // String topic = topics.get(4);
    // String topicNext = topics.get(5);
    // printSpecificTopic(topic, topicNext, body);

    // System.out.println(childNodes);
  }

  // private static void printSpecificTopic(String topic, String nextTopic,
  // Element body) {
  //
  // Elements topicList = body.getElementsByAttributeValue("id", topic);
  // Element nextOne = topicList.get(0).parent().nextElementSibling();
  // while (nextOne != null && nextOne.children().size() > 0 &&
  // !nextOne.child(0).attr("id").equalsIgnoreCase(nextTopic)) {
  // if (nextOne.tagName().equalsIgnoreCase("p")) {
  // System.out.println((nextOne).text());
  // }
  // nextOne = nextOne.nextElementSibling();
  // }
  //
  // // List<Node> childNodes = body.childNodes();
  //
  // }
}
