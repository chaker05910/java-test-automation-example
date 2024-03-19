package org.dmukhin.microservices.placeholder.models.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dmukhin.microservices.general.models.BaseDto;

/**
 * Data Transfer Object for user information. This class is used for storing and transferring
 * user-related data, especially in JSON format for API interactions.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto extends BaseDto {

  @JsonProperty(value = "id", access = JsonProperty.Access.READ_WRITE)
  private String id;

  @JsonProperty(value = "name", access = JsonProperty.Access.READ_WRITE)
  private String name;

  @JsonProperty(value = "username", access = JsonProperty.Access.READ_WRITE)
  private String username;

  @JsonProperty(value = "email", access = JsonProperty.Access.READ_WRITE)
  private String email;

  @JsonProperty(value = "address", access = JsonProperty.Access.READ_WRITE)
  private AddressDto address;

  @JsonProperty(value = "phone", access = JsonProperty.Access.READ_WRITE)
  private String phone;

  @JsonProperty(value = "website", access = JsonProperty.Access.READ_WRITE)
  private String website;

  @JsonProperty(value = "company", access = JsonProperty.Access.READ_WRITE)
  private CompanyDto company;

  /**
   * Provides a builder for constructing a UserDto instance.
   *
   * @return A new Builder instance for creating a UserDto object.
   */
  public static Builder newBuilder() {
    return new UserDto().new Builder();
  }

  /**
   * Gets the user's ID.
   *
   * @return The user's ID.
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the user's ID.
   *
   * @param id The ID to set.
   * @return The current instance of UserDto.
   */
  public UserDto setId(String id) {
    this.id = id;
    return this;
  }

  /**
   * Gets the user's name.
   *
   * @return The user's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the user's name.
   *
   * @param name The name to set.
   * @return The current instance of UserDto.
   */
  public UserDto setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Gets the user's username.
   *
   * @return The user's username.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the user's username.
   *
   * @param username The username to set.
   * @return The current instance of UserDto.
   */
  public UserDto setUsername(String username) {
    this.username = username;
    return this;
  }

  /**
   * Gets the user's email address.
   *
   * @return The user's email address.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the user's email address.
   *
   * @param email The email address to set.
   * @return The current instance of UserDto.
   */
  public UserDto setEmail(String email) {
    this.email = email;
    return this;
  }

  /**
   * Gets the user's address.
   *
   * @return The user's AddressDto.
   */
  public AddressDto getAddress() {
    return address;
  }

  /**
   * Sets the user's address.
   *
   * @param address The AddressDto to set.
   * @return The current instance of UserDto.
   */
  public UserDto setAddress(AddressDto address) {
    this.address = address;
    return this;
  }

  /**
   * Gets the user's phone number.
   *
   * @return The user's phone number.
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets the user's phone number.
   *
   * @param phone The phone number to set.
   * @return The current instance of UserDto.
   */
  public UserDto setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Gets the user's website URL.
   *
   * @return The user's website URL.
   */
  public String getWebsite() {
    return website;
  }

  /**
   * Sets the user's website URL.
   *
   * @param website The website URL to set.
   * @return The current instance of UserDto.
   */
  public UserDto setWebsite(String website) {
    this.website = website;
    return this;
  }

  /**
   * Gets the user's company information.
   *
   * @return The user's CompanyDto.
   */
  public CompanyDto getCompany() {
    return company;
  }

  /**
   * Sets the user's company information.
   *
   * @param company The CompanyDto to set.
   * @return The current instance of UserDto.
   */
  public UserDto setCompany(CompanyDto company) {
    this.company = company;
    return this;
  }

  /**
   * Compares this UserDto to another object for equality. The result is {@code true} if and only if
   * the argument is not {@code null} and is a UserDto object that has the same values for id, name,
   * username, email, address, phone, website, and company properties.
   *
   * @param o the object to compare this UserDto against.
   * @return true if the given object represents a UserDto equivalent to this user, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    UserDto userDto = (UserDto) o;

    return new EqualsBuilder().append(id, userDto.id)
        .append(name, userDto.name)
        .append(username, userDto.username)
        .append(email, userDto.email)
        .append(address, userDto.address)
        .append(phone, userDto.phone)
        .append(website, userDto.website)
        .append(company, userDto.company)
        .isEquals();
  }

  /**
   * Returns a hash code value for the user. This method is supported for the benefit of hash tables
   * such as those provided by {@link java.util.HashMap}. The hash code is computed using the hash
   * codes of the id, name, username, email, address, phone, website, and company properties.
   *
   * @return a hash code value for this user.
   */
  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(id)
        .append(name)
        .append(username)
        .append(email)
        .append(address)
        .append(phone)
        .append(website)
        .append(company)
        .toHashCode();
  }

  /**
   * The Builder inner class for constructing UserDto objects.
   */
  public class Builder {

    private Builder() {
      // Default initialization
    }

    /**
     * Sets the name for the UserDto being built.
     *
     * @param name The name to set.
     * @return The current Builder instance.
     */
    public Builder withName(String name) {
      UserDto.this.name = name;
      return this;
    }

    /**
     * Sets the username for the UserDto being built.
     *
     * @param userName The username to set.
     * @return The current Builder instance.
     */
    public Builder withUserName(String userName) {
      UserDto.this.username = userName;
      return this;
    }

    /**
     * Sets the email for the UserDto being built.
     *
     * @param email The email to set.
     * @return The current Builder instance.
     */
    public Builder withEmail(String email) {
      UserDto.this.email = email;
      return this;
    }

    /**
     * Sets the address for the UserDto being built.
     *
     * @param address The AddressDto to set.
     * @return The current Builder instance.
     */
    public Builder withAddress(AddressDto address) {
      UserDto.this.address = address;
      return this;
    }

    /**
     * Sets the phone number for the UserDto being built.
     *
     * @param phone The phone number to set.
     * @return The current Builder instance.
     */
    public Builder withPhone(String phone) {
      UserDto.this.phone = phone;
      return this;
    }

    /**
     * Sets the website for the UserDto being built.
     *
     * @param website The website URL to set.
     * @return The current Builder instance.
     */
    public Builder withWebsite(String website) {
      UserDto.this.website = website;
      return this;
    }

    /**
     * Sets the company information for the UserDto being built.
     *
     * @param name        The name of the company.
     * @param catchPhrase The catchphrase of the company.
     * @param bs          The business slogan of the company.
     * @return The current Builder instance.
     */
    public Builder withCompany(String name, String catchPhrase, String bs) {
      UserDto.this.company = new CompanyDto()
          .setName(name)
          .setCatchPhrase(catchPhrase)
          .setBs(bs);
      return this;
    }

    /**
     * Builds and returns the UserDto object.
     *
     * @return The constructed UserDto instance.
     */
    public UserDto build() {
      return UserDto.this;
    }
  }

}
