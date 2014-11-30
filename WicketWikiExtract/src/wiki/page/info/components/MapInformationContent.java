package wiki.page.info.components;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.wicket.markup.html.basic.Label;

@Deprecated
/**
 * @deprecated("not used yet, correct design to have it replace InformationContent")
 *
 */
public class MapInformationContent {
	
	final Map<ShowTopicLink, TopicLabel> contents;

	public MapInformationContent(List<? extends Entry<?, String>> list) {
		this.contents = new HashMap<ShowTopicLink, TopicLabel>();
		populateContent(list);
	}
	
	private void populateContent(List<? extends Entry<?, String>> list) {
		for(Entry<?, String> listItem : list) {
			// value: topic content
			TopicLabel contentLabel = new TopicLabel("topicInfo", listItem.getValue());
			
			// key: on/off link
			ShowTopicLink showTopicLink = new ShowTopicLink("showhide", listItem);
			showTopicLink.add(new Label("topicName", listItem.getKey().toString()));
			
			contents.put(showTopicLink, contentLabel);
		}

	}


}
