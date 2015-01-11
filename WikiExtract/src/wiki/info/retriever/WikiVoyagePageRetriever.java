package wiki.info.retriever;

import info.bliki.api.creator.DocumentCreator;
import info.bliki.api.creator.WikiDB;
import info.bliki.wiki.impl.APIWikiModel;

import java.io.IOException;

import wiki.info.dump.HTMLConstants;
import wiki.info.retriever.input.BaseRetrieverInputData;

public class WikiVoyagePageRetriever {

  /**
   * Return HTML document from the page specified by the input
   * 
   * @param inupt
   * @return the page content in HTML form
   */
  public static String retrievePage(BaseRetrieverInputData inupt) {

    StringBuilder render = new StringBuilder();
    WikiDB db = null;

    try {
      db = new WikiDB(inupt.getMainDirectory(), inupt.getDatabaseSubdirectory());
      APIWikiModel wikiModel = new APIWikiModel(inupt.getUser(), db, "${image}", "${title}", inupt.getImageDirectory());
      DocumentCreator creator = new DocumentCreator(wikiModel, inupt.getUser(), inupt.getListOfTitleStrings());
      creator.setHeader(HTMLConstants.HTML_HEADER1 + HTMLConstants.CSS_SCREEN_STYLE + HTMLConstants.HTML_HEADER2);
      creator.setFooter(HTMLConstants.HTML_FOOTER);
      wikiModel.setUp();
      creator.render(render);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    catch (Exception e1) {
      e1.printStackTrace();
    }
    finally {
      if (db != null) {
        try {
          db.tearDown();
        }
        catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return render.toString();
  }

}
