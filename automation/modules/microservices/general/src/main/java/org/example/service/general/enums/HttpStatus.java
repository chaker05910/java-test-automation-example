package org.example.service.general.enums;

/**
 * Enum representing HTTP status codes. Each enum constant corresponds to an HTTP status code and
 * its standard description. This enum is typically used in web applications to represent the status
 * of HTTP responses.
 */
public enum HttpStatus {

  OK(200, "OK"),
  CREATED(201, "Created"),
  ACCEPTED(202, "Accepted"),
  NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
  NO_CONTENT(204, "No Content"),

  MULTIPLE_CHOICES(300, "Multiple Choices"),
  MOVED_PERMANENTLY(301, "Moved Permanently"),
  FOUND(302, "Found"),

  BAD_REQUEST(400, "Bad Request"),
  UNAUTHORIZED(401, "Unauthorized"),
  PAYMENT_REQUIRED(402, "Payment Required"),

  INTERNAL_SERVER_ERROR(500, "Internal Server Error");

  private final int code;
  private final String desc;

  /**
   * Constructor for HttpStatus enum.
   *
   * @param code The integer code of the HTTP status.
   * @param desc The description of the HTTP status.
   */
  HttpStatus(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  /**
   * Retrieves the integer code of the HTTP status.
   *
   * @return The integer code of the status.
   */
  public int getCode() {
    return code;
  }

  /**
   * Retrieves the description of the HTTP status.
   *
   * @return The description of the status.
   */
  public String getDesc() {
    return desc;
  }

  @Override
  public String toString() {
    return String.format("%s: %s", getCode(), getDesc());
  }
}
