package wiki.page.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.wicket.markup.html.WebPage;

import wiki.info.converter.dom.AbstractPageDOM;
import wiki.info.extractor.WikiVoyageExtractor;
import wiki.info.retriever.input.BaseRetrieverInputData;
import wiki.info.retriever.input.RedirectRetrieverInputData;
import wiki.page.info.components.MapInformationContent;
import wiki.page.info.components.TopicView;

public class InfoPage extends WebPage {

	private final static String LANGUAGE = "en";

	/**
   *
   */
	private static final long serialVersionUID = -3944965092181796662L;

	public InfoPage(String location) {

		Map<?, String> contentMap = requestContentToDisplay(location);
		add(new TopicView("contents", transformTopicSet(contentMap.keySet()),
				new MapInformationContent(contentMap)));
	}

	private List<String> transformTopicSet(Set<?> keySet) {
		List<String> contentList = new ArrayList<String>();
		for (Object topic : keySet) {
			contentList.add(topic.toString());
		}
		return contentList;
	}

	private TreeMap<?, String> requestContentToDisplay(String location) {

		BaseRetrieverInputData inputData = new RedirectRetrieverInputData(
				location, LANGUAGE);
		AbstractPageDOM<?> dom = WikiVoyageExtractor.extract(inputData);

		TreeMap<?, String> sortedMap = dom.getSortedDOM();

		return sortedMap;
	}

}
