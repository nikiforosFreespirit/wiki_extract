package wiki.page.info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import wiki.info.converter.dom.AbstractPageDOM;
import wiki.info.extractor.WikiVoyageExtractor;
import wiki.info.retriever.input.BaseRetrieverInputData;
import wiki.info.retriever.input.RedirectRetrieverInputData;

public class InfoPage extends WebPage {

  private final static String LANGUAGE = "en";

  private final Map<ShowTopicLink, TopicLabel> contentMap;

  /**
   *
   */
  private static final long serialVersionUID = -3944965092181796662L;

  public InfoPage(String location) {

    TreeMap<?, String> contentMap = requestContentToDisplay(location);
    List<Entry<?, String>> contentList = new ArrayList<Entry<?, String>>();
    contentList.addAll(contentMap.entrySet());
    add(new TopicView("contents", contentList));
    this.contentMap = new HashMap<InfoPage.ShowTopicLink, InfoPage.TopicLabel>();
  }

  private TreeMap<?, String> requestContentToDisplay(String location) {

    BaseRetrieverInputData inputData = new RedirectRetrieverInputData(location, LANGUAGE);
    AbstractPageDOM<?> dom = WikiVoyageExtractor.extract(inputData);

    TreeMap<?, String> sortedMap = dom.getSortedDOM();

    return sortedMap;
  }

  public class TopicView extends ListView<Entry<?, String>> {
    /**
     *
     */
    private static final long serialVersionUID = 8672723938411338756L;

    public TopicView(String id, List<? extends Entry<?, String>> list) {
      super(id, list);
    }

    @Override
    protected void populateItem(ListItem<Entry<?, String>> item) {
      Entry<?, String> topic = item.getModelObject();

      TopicLabel contentLabel = new TopicLabel("topicInfo", topic.getValue());
      // contentLabel.setVisible(false);

      ShowTopicLink showTopicLink = new ShowTopicLink("showhide", contentLabel);
      showTopicLink.add(new Label("topicName", topic.getKey().toString()));

      item.add(showTopicLink);
      item.add(contentLabel);
    }
  }

  public final class TopicLabel extends Label {
    /**
     *
     */
    private static final long serialVersionUID = -6956072724198696097L;

    public TopicLabel(String id, String label) {
      super(id, label);
    }

    @Override
    public boolean isVisible() {
      return super.isVisible();
    }

  }

  public final class ShowTopicLink extends Link {

    private final TopicLabel associatedContent;

    /**
     *
     */
    private static final long serialVersionUID = -1531441411118510827L;

    public ShowTopicLink(String id, TopicLabel associatedContent) {
      super(id);
      this.associatedContent = associatedContent;
    }

    @Override
    public void onClick() {
      associatedContent.setVisible(!associatedContent.isVisible());
    }
  }

}
