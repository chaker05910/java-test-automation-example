package org.dmukhin.microservices.placeholder.models.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dmukhin.microservices.general.models.BaseDto;

/**
 * Data Transfer Object for company information. This class is used for storing and transferring
 * company-related data, particularly in the context of JSON serialization and deserialization.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto extends BaseDto {

  @JsonProperty(value = "name", access = JsonProperty.Access.READ_WRITE)
  private String name;

  @JsonProperty(value = "catchPhrase", access = JsonProperty.Access.READ_WRITE)
  private String catchPhrase;

  @JsonProperty(value = "bs", access = JsonProperty.Access.READ_WRITE)
  private String bs;

  /**
   * Gets the name of the company.
   *
   * @return The company name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the company.
   *
   * @param name The name to set for the company.
   * @return The current instance of CompanyDto.
   */
  public CompanyDto setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Gets the catchphrase of the company.
   *
   * @return The company's catchphrase.
   */
  public String getCatchPhrase() {
    return catchPhrase;
  }

  /**
   * Sets the catchphrase of the company.
   *
   * @param catchPhrase The catchphrase to set for the company.
   * @return The current instance of CompanyDto.
   */
  public CompanyDto setCatchPhrase(String catchPhrase) {
    this.catchPhrase = catchPhrase;
    return this;
  }

  /**
   * Gets the 'bs' (business slang) of the company.
   *
   * @return The company's bs.
   */
  public String getBs() {
    return bs;
  }

  /**
   * Sets the 'bs' (business slang) of the company.
   *
   * @param bs The bs to set for the company.
   * @return The current instance of CompanyDto.
   */
  public CompanyDto setBs(String bs) {
    this.bs = bs;
    return this;
  }

  /**
   * Compares this CompanyDto to another object for equality. The result is {@code true} if and only
   * if the argument is not {@code null} and is a CompanyDto object that has the same values for
   * name, catchPhrase, and bs properties.
   *
   * @param o the object to compare this CompanyDto against.
   * @return true if the given object represents a CompanyDto equivalent to this company, false
   * otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    CompanyDto that = (CompanyDto) o;

    return new EqualsBuilder().append(name, that.name)
        .append(catchPhrase, that.catchPhrase)
        .append(bs, that.bs)
        .isEquals();
  }

  /**
   * Returns a hash code value for the company. This method is supported for the benefit of hash
   * tables such as those provided by {@link java.util.HashMap}. The hash code is computed using the
   * hash codes of the name, catchPhrase, and bs properties.
   *
   * @return a hash code value for this company.
   */
  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(name)
        .append(catchPhrase)
        .append(bs)
        .toHashCode();
  }

}
