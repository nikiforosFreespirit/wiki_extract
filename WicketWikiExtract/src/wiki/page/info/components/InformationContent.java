package wiki.page.info.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class InformationContent {

	final List<ShowTopicLink> contents;

	public InformationContent(List<? extends Entry<?, String>> contentList) {
		this.contents = new ArrayList<ShowTopicLink>();
		populateContents(contentList);
	}

	private void populateContents(List<? extends Entry<?, String>> list) {
		for (Entry<?, String> listItem : list) {
			// "value": topic content
			// TopicLabel contentLabel = new TopicLabel("topicInfo",
			// listItem.getValue());

			// "key": on/off link
			ShowTopicLink showTopicLink = new ShowTopicLink("showhide",
					listItem);

			this.contents.add(showTopicLink);
		}

	}

	ShowTopicLink findLink(String topicName) {
		for(ShowTopicLink link : this.contents) {
			boolean flag = link.isTopicNamePresent(topicName);
			if(flag){ 
				return link;
			}
		}
		return null;
	}

}
