package wiki.page.info.components;

import java.util.List;
import java.util.Map.Entry;

import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class TopicView extends ListView<Entry<?, String>> {

	private final InformationContent contentMap;

	/**
     *
     */
	private static final long serialVersionUID = 8672723938411338756L;
	
	public TopicView(String id, List<? extends Entry<?, String>> list) {
		super(id, list);
		this.contentMap = new InformationContent(list);
	}

	@Override
	protected void populateItem(ListItem<Entry<?, String>> item) {
		Entry<?, String> topic = item.getModelObject();
		
		String topicName = topic.getKey().toString();
		ShowTopicLink showTopicLink = contentMap.findLink(topicName);
		
		item.add(showTopicLink);
		item.add(showTopicLink.associatedContent);
	}
}
