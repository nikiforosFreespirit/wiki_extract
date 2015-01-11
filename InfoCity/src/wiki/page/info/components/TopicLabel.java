package wiki.page.info.components;

import org.apache.wicket.markup.html.basic.Label;

final class TopicLabel extends Label {
    /**
     *
     */
    private static final long serialVersionUID = -6956072724198696097L;

    public TopicLabel(String id, String label) {
      super(id, label);
      // Hidden only at the creation (should happen only once)
      this.setVisible(false);
    }

  }
