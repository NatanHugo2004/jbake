package org.jbake.template.model;

import org.jbake.app.ContentStore;
import org.jbake.template.ModelExtractor;

import java.util.Map;

/**
 * Extracts the content store database instance for the template model.
 */

public class DBExtractor implements ModelExtractor<ContentStore> {

  /**
   * Retrieves the database instance directly from the parameters.
   *
   * @param db the content store database
   * @param model the current template data model
   * @param key the key associated with this extractor
   * @return the {@code ContentStore} database instance
   */
  @Override
  public ContentStore get(ContentStore db, Map model, String key) {
    return db;
  }

}
