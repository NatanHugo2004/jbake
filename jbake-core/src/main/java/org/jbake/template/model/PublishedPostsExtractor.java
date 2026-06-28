package org.jbake.template.model;

import org.jbake.app.ContentStore;
import org.jbake.app.DocumentList;
import org.jbake.template.ModelExtractor;

import java.util.Map;

/**
 * Extractor implementation that retrieves a list of published documents
 * associated with a specific tag from the content store.
 */
public class PublishedPostsExtractor implements ModelExtractor<DocumentList> {

  @Override
  public DocumentList get(ContentStore db, Map model, String key) {
    if (model.containsKey("numberOfPages")) {
      return db.getPublishedPosts(true);
    } else {
      return db.getPublishedPosts();
    }
  }

}
