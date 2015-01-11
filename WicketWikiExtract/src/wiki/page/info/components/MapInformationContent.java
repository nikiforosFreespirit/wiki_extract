package wiki.page.info.components;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 */
public class MapInformationContent {

	final Map<String, SimpleImmutableEntry<ShowTopicLink, TopicLabel>> contents;

	public MapInformationContent(Map<?, String> topicTextMap) {
		this.contents = new HashMap<String, SimpleImmutableEntry<ShowTopicLink, TopicLabel>>();
		populateContent(topicTextMap);
	}

	private void populateContent(Map<?, String> topicTextMap) {
		for (Entry<?, String> listItem : topicTextMap.entrySet()) {
			// key: on/off link
			String linkLabel = listItem.getKey().toString();
			ShowTopicLink showTopicLink = new ShowTopicLink("showhide",
					listItem);
			
			// value: topic content
			TopicLabel contentLabel = new TopicLabel("topicInfo",
					listItem.getValue());

			contents.put(linkLabel,
					new SimpleImmutableEntry<ShowTopicLink, TopicLabel>(
							showTopicLink, contentLabel));
		}

	}

	public Entry<ShowTopicLink, TopicLabel> findEntry(String topicName) {
		return contents.get(topicName);
	}

}
