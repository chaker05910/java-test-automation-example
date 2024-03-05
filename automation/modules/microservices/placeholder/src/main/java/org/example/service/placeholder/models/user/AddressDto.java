package org.example.service.placeholder.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.example.service.general.models.BaseDto;


/**
 * Represents an address data transfer object. This class is used for storing and transferring
 * address data, especially in JSON format for API interactions.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto extends BaseDto {

  @JsonProperty(value = "street", access = JsonProperty.Access.READ_WRITE)
  private String street;

  @JsonProperty(value = "suite", access = JsonProperty.Access.READ_WRITE)
  private String suite;

  @JsonProperty(value = "city", access = JsonProperty.Access.READ_WRITE)
  private String city;

  @JsonProperty(value = "zipcode", access = JsonProperty.Access.READ_WRITE)
  private String zipcode;

  @JsonProperty(value = "geo", access = JsonProperty.Access.READ_WRITE)
  private AddressGeoDto geo;

  /**
   * Gets the street name of the address.
   *
   * @return The street name.
   */
  public String getStreet() {
    return street;
  }

  /**
   * Sets the street name of the address.
   *
   * @param street The street name to set.
   * @return The current instance of AddressDto.
   */
  public AddressDto setStreet(String street) {
    this.street = street;
    return this;
  }

  /**
   * Gets the suite number of the address.
   *
   * @return The suite number.
   */
  public String getSuite() {
    return suite;
  }

  /**
   * Sets the suite number of the address.
   *
   * @param suite The suite number to set.
   * @return The current instance of AddressDto.
   */
  public AddressDto setSuite(String suite) {
    this.suite = suite;
    return this;
  }

  /**
   * Gets the city of the address.
   *
   * @return The city name.
   */
  public String getCity() {
    return city;
  }

  /**
   * Sets the city of the address.
   *
   * @param city The city name to set.
   * @return The current instance of AddressDto.
   */
  public AddressDto setCity(String city) {
    this.city = city;
    return this;
  }

  /**
   * Gets the zipcode of the address.
   *
   * @return The zipcode.
   */
  public String getZipcode() {
    return zipcode;
  }

  /**
   * Sets the zipcode of the address.
   *
   * @param zipcode The zipcode to set.
   * @return The current instance of AddressDto.
   */
  public AddressDto setZipcode(String zipcode) {
    this.zipcode = zipcode;
    return this;
  }

  /**
   * Gets the geographical information of the address.
   *
   * @return The AddressGeoDto object containing latitude and longitude.
   */
  public AddressGeoDto getGeo() {
    return geo;
  }

  /**
   * Sets the geographical information of the address.
   *
   * @param geo The AddressGeoDto object to set.
   * @return The current instance of AddressDto.
   */
  public AddressDto setGeo(AddressGeoDto geo) {
    this.geo = geo;
    return this;
  }

  /**
   * Sets the geographical coordinates (latitude and longitude) of the address. This is a
   * convenience method that instantiates a new AddressGeoDto.
   *
   * @param lat The latitude.
   * @param lng The longitude.
   * @return The current instance of AddressDto.
   */
  @JsonIgnore
  public AddressDto setAddressGeo(String lat, String lng) {
    this.geo = new AddressGeoDto().setLat(lat).setLng(lng);
    return this;
  }


  /**
   * Compares this address DTO to another object for equality. The result is {@code true} if and
   * only if the argument is not {@code null} and is an AddressDto object that has the same values
   * for street, suite, city, zipcode, and geo properties.
   *
   * @param o the object to compare this AddressDto against
   * @return true if the given object represents an AddressDto equivalent to this address, false
   * otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    AddressDto that = (AddressDto) o;

    return new EqualsBuilder().append(street, that.street)
        .append(suite, that.suite)
        .append(city, that.city)
        .append(zipcode, that.zipcode)
        .append(geo, that.geo)
        .isEquals();
  }

  /**
   * Returns a hash code value for the address. This method is supported for the benefit of hash
   * tables such as those provided by {@link java.util.HashMap}. The hash code is computed using the
   * hash codes of the street, suite, city, zipcode, and geo properties.
   *
   * @return a hash code value for this address
   */
  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(street)
        .append(suite)
        .append(city)
        .append(zipcode)
        .append(geo)
        .toHashCode();
  }


}
