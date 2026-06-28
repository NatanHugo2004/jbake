package org.jbake.template.model;

import org.jbake.app.ContentStore;
import org.jbake.app.DocumentList;
import org.jbake.template.ModelExtractor;

import java.util.Map;

/**
 * Extractor implementation that retrieves a list of published documents
 * associated with a specific tag from the content store.
 */
public class TaggedDocumentsExtractor implements ModelExtractor<DocumentList> {

  @Override
  public DocumentList get(ContentStore db, Map model, String key) {
    String tag = null;
    TemplateModel templateModel = new TemplateModel();
    templateModel.putAll(model);
    if (templateModel.getTag() != null) {
      tag = templateModel.getTag();
    }
    // fetch the tagged documents from db
    return db.getPublishedDocumentsByTag(tag);
  }

}
