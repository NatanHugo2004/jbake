package org.jbake.template.model;

import org.jbake.app.ContentStore;
import org.jbake.app.DocumentList;
import org.jbake.template.ModelExtractor;

import java.util.Map;

/**
 * Extracts published posts associated with a specific tag from the template model context.
 */

public class TagPostsExtractor implements ModelExtractor<DocumentList> {

  /**
   * Retrieves a list of published posts matching the active tag found in the model.
   *
   * @param db the content store database
   * @param model the current template data model
   * @param key the key associated with this extractor
   * @return a {@code DocumentList} containing the published posts for the tag
   */
  @Override
  public DocumentList get(ContentStore db, Map model, String key) {
    String tag = null;
    TemplateModel templateModel = new TemplateModel();
    templateModel.putAll(model);
    if (templateModel.getTag() != null) {
      tag = templateModel.getTag();
    }
    // fetch the tag posts from db
    return db.getPublishedPostsByTag(tag);
  }

}
