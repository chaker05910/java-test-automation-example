package org.dmukhin.microservices.placeholder.models.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dmukhin.microservices.general.models.BaseDto;

/**
 * Data Transfer Object for geographical information of an address. This class holds the latitude
 * and longitude coordinates.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressGeoDto extends BaseDto {

  @JsonProperty(value = "lat", access = JsonProperty.Access.READ_WRITE)
  private String lat;

  @JsonProperty(value = "lng", access = JsonProperty.Access.READ_WRITE)
  private String lng;

  /**
   * Gets the latitude of the geographical location.
   *
   * @return The latitude as a String.
   */
  public String getLat() {
    return lat;
  }

  /**
   * Sets the latitude of the geographical location.
   *
   * @param lat The latitude to set.
   * @return The current instance of AddressGeoDto for method chaining.
   */
  public AddressGeoDto setLat(String lat) {
    this.lat = lat;
    return this;
  }

  /**
   * Gets the longitude of the geographical location.
   *
   * @return The longitude as a String.
   */
  public String getLng() {
    return lng;
  }

  /**
   * Sets the longitude of the geographical location.
   *
   * @param lng The longitude to set.
   * @return The current instance of AddressGeoDto for method chaining.
   */
  public AddressGeoDto setLng(String lng) {
    this.lng = lng;
    return this;
  }

  /**
   * Compares this AddressGeoDto to another object for equality. The result is {@code true} if and
   * only if the argument is not {@code null} and is an AddressGeoDto object that has the same
   * values for latitude and longitude.
   *
   * @param o the object to compare this AddressGeoDto against
   * @return true if the given object represents an AddressGeoDto equivalent to this geolocation,
   * false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AddressGeoDto that = (AddressGeoDto) o;

    return new EqualsBuilder().append(lat, that.lat).append(lng, that.lng).isEquals();
  }

  /**
   * Returns a hash code value for the geolocation. This method is supported for the benefit of hash
   * tables such as those provided by {@link java.util.HashMap}. The hash code is computed using the
   * hash codes of the latitude and longitude properties.
   *
   * @return a hash code value for this geolocation
   */
  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(lat)
        .append(lng)
        .toHashCode();
  }
}
