package org.example.service.placeholder;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import org.example.service.general.AbstractWebService;
import org.example.service.placeholder.endpoints.CommentEndpoint;
import org.example.service.placeholder.endpoints.UserEndpoint;

/**
 * Service class for accessing the JSONPlaceholder API. This class extends AbstractWebService and
 * provides access to various endpoints like UserEndpoint and CommentEndpoint. It uses a ThreadLocal
 * instance for thread-safe operations.
 */
public class PlaceholderApi extends AbstractWebService {

  private static final String API_KEY = "placeholderService";

  private static final ThreadLocal<PlaceholderApi> webApi = new ThreadLocal<>();
  private RequestSpecification requestSpecification;

  /**
   * Constructor for PlaceholderApi. Initializes the request specification for the service.
   */
  protected PlaceholderApi() {
    super(API_KEY);
    initRequestSpecification();
  }

  /**
   * Provides a singleton instance of PlaceholderApi. This method ensures a single instance per
   * thread.
   *
   * @return An instance of PlaceholderApi.
   */
  @Step("Provides a singleton instance of PlaceholderApi")
  public static PlaceholderApi placeholderApi() {
    if (webApi.get() == null) {
      initPlaceholderApi();
    }
    return webApi.get();
  }

  /**
   * Initializes a singleton instance of PlaceholderApi for the current thread.
   */
  private static void initPlaceholderApi() {
    webApi.set(new PlaceholderApi());
  }

  /**
   * Initializes the request specification for the API. This specification is used for making HTTP
   * requests to the JSONPlaceholder API.
   */
  @Override
  protected void initRequestSpecification() {
    requestSpecification = getDefaultSpecification();
  }

  /**
   * Provides access to the User endpoint of the JSONPlaceholder API.
   *
   * @return An instance of UserEndpoint.
   */
  @Step("Provides access to the User endpoint of the JSONPlaceholder API")
  public UserEndpoint user() {
    return new UserEndpoint(requestSpecification);
  }

  /**
   * Provides access to the Comment endpoint of the JSONPlaceholder API.
   *
   * @return An instance of CommentEndpoint.
   */
  @Step("Provides access to the Comment endpoint of the JSONPlaceholder API")
  public CommentEndpoint comment() {
    return new CommentEndpoint(requestSpecification);
  }

  /**
   * Removes the thread-local instance of the web API.
   * This method is typically called when the web API instance is no longer needed, to clean up resources
   * and prevent memory leaks.
   */
  public void unload() {
    webApi.remove();
  }
}
