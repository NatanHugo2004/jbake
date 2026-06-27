package org.jbake.template.model;

import org.jbake.app.ContentStore;
import org.jbake.app.DocumentList;
import org.jbake.template.ModelExtractor;

import java.util.Map;

/**
 * Extracts published custom documents of a specific type from the content store.
 */

public class PublishedCustomExtractor implements ModelExtractor<DocumentList> {

  String customDocumentType;

  /**
   * Constructs a new {@code PublishedCustomExtractor} for the specified document type.
   *
   * @param customDocumentType the custom document type to extract
   */

  public PublishedCustomExtractor(String customDocumentType) {
    this.customDocumentType = customDocumentType;
  }

  @Override
  public DocumentList get(ContentStore db, Map model, String key) {

    return db.getPublishedContent(customDocumentType);
  }

}
