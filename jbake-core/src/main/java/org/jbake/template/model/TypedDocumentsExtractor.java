package org.jbake.template.model;

import org.jbake.app.ContentStore;
import org.jbake.app.DocumentList;
import org.jbake.model.DocumentTypeUtils;
import org.jbake.template.ModelExtractor;

import java.util.Map;

/**
 * Extracts all documents of a specific type by unpluralizing the provided model key.
 */

public class TypedDocumentsExtractor implements ModelExtractor<DocumentList> {

  /**
   * Retrieves a list of all content matching the unpluralized document type key.
   *
   * @param db the content store database
   * @param model the current template data model
   * @param key the pluralized key associated with the document type
   * @return a {@code DocumentList} containing all documents of the resolved type
   */
  @Override
  public DocumentList get(ContentStore db, Map model, String key) {
    // document types are pluralized in model, so unpluralize
    try {
      String type = DocumentTypeUtils.unpluralize(key);
      return db.getAllContent(type);
    } catch (UnsupportedOperationException e) {

      return new DocumentList();
    }
  }

}
