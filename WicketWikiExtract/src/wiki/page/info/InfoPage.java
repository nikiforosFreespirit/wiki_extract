package wiki.page.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.wicket.markup.html.WebPage;

import wiki.info.converter.dom.AbstractPageDOM;
import wiki.info.extractor.WikiVoyageExtractor;
import wiki.info.retriever.input.BaseRetrieverInputData;
import wiki.info.retriever.input.RedirectRetrieverInputData;
import wiki.page.info.components.TopicView;

public class InfoPage extends WebPage {

	private final static String LANGUAGE = "en";

	/**
   *
   */
	private static final long serialVersionUID = -3944965092181796662L;

	public InfoPage(String location) {

		TreeMap<?, String> contentMap = requestContentToDisplay(location);
		List<Entry<?, String>> contentList = convertContentToEntryList(contentMap);
		add(new TopicView("contents", contentList));
	}

	private List<Entry<?, String>> convertContentToEntryList(
			TreeMap<?, String> contentMap) {
		List<Entry<?, String>> contentList = new ArrayList<Entry<?, String>>();
		contentList.addAll(contentMap.entrySet());
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
