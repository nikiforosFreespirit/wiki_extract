package wiki.page.info.components;

import java.util.List;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class TopicView extends ListView<String> {

	final MapInformationContent contentMap;

	/**
     *
     */
	private static final long serialVersionUID = 8672723938411338756L;
	
	public TopicView(String id, List<String> keyList, MapInformationContent contentMap) {
		super(id, keyList);
		this.contentMap = contentMap;
	}

	@Override
	protected void populateItem(ListItem<String> item) {
		String topicName = item.getModelObject();
		ShowTopicLink showTopicLink = contentMap.findEntry(topicName).getKey();
		TopicLabel contentLabel = contentMap.findEntry(topicName).getValue();
		
		item.add(showTopicLink);
		item.add(contentLabel);
	}

	final MapInformationContent getContentMap() {
		return contentMap;
	}
}
