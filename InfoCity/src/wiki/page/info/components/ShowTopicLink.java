package wiki.page.info.components;

import java.util.Map.Entry;

import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

final class ShowTopicLink extends Link<String> {

	private static final String TOPIC_NAME_KEY = "topicName";
	final String linkLabelName;

	/**
     *
     */
	private static final long serialVersionUID = -1531441411118510827L;

	public ShowTopicLink(String id, Entry<?, String> linkPlusContent) {
		super(id);

		// "value": topic content
//		TopicLabel contentLabel = new TopicLabel("topicInfo",
//				linkPlusContent.getValue());

		// "key": on/off link
		this.linkLabelName = linkPlusContent.getKey().toString();
		Label linkLabel = new Label(TOPIC_NAME_KEY, this.linkLabelName);
		this.add(linkLabel);

//		this.associatedContent = contentLabel;
	}

	@Override
	public void onClick() {
//		associatedContent.setVisible(!associatedContent.isVisible());
		MarkupContainer topicViewAncestor = this.getParent().getParent();
		if(topicViewAncestor != null && topicViewAncestor instanceof TopicView) {
			TopicView parent = (TopicView) topicViewAncestor;
			TopicLabel label = parent.contentMap.contents.get(linkLabelName).getValue();
			label.setVisible(!label.isVisible());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((linkLabelName == null) ? 0 : linkLabelName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShowTopicLink other = (ShowTopicLink) obj;
		if (linkLabelName == null) {
			if (other.linkLabelName != null)
				return false;
		} else if (!linkLabelName.equals(other.linkLabelName))
			return false;
		return true;
	}

	boolean isTopicNamePresent(String topicName) {
		return linkLabelName.equalsIgnoreCase(topicName);
	}
}
