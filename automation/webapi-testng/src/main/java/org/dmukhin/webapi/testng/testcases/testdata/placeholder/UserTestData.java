package org.dmukhin.webapi.testng.testcases.testdata.placeholder;

import com.github.javafaker.Faker;
import org.dmukhin.microservices.placeholder.models.user.AddressDto;
import org.dmukhin.microservices.placeholder.models.user.UserDto;

/**
 * The {@code UserTestData} class is a utility class that provides methods for generating test data
 * related to user entities. It makes use of the {@code Faker} library to generate random values for
 * various user attributes.
 */
public class UserTestData {

  private static final Faker faker = Faker.instance();

  /**
   * Default constructor for {@code UserTestData}. It is private to prevent instantiation of this
   * utility class.
   */
  UserTestData() {
    // default constructor
  }

  /**
   * Generates a {@code UserDto} object with random data.
   * <p>
   * This method utilizes the {@code Faker} library to generate a random email address. The address
   * is hard-coded to a specific location (Dublin, Guineas Street, Test suite, D01 0001). Other
   * attributes such as phone, website, and company are also set with predetermined values.
   * </p>
   *
   * @return A {@code UserDto} object populated with random and predefined data.
   */
  public UserDto randomUser() {
    return UserDto.newBuilder()
        .withName(faker.name().firstName())
        .withUserName(faker.name().username())
        .withEmail(faker.internet().emailAddress())
        .withAddress(new AddressDto()
            .setCity("Dublin")
            .setStreet("Guineas")
            .setSuite("Test suite")
            .setZipcode("D01 0001")
            .setAddressGeo("", "")
        )
        .withPhone("123-456-789")
        .withWebsite("www.userapisite.com.ua")
        .withCompany("Testing LC", "", "Testing bc")
        .build();
  }
}

