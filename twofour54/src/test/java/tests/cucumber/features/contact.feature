@twofour54Application-Contact
Feature: Contact Feature

  Scenario Outline: Login into twofour54 and create Contact


    Given Hover MyContacts add New Contacts
    And Upload PhotoGraph & Enter Basic Information
    Then Enter Mandatory Fields such as <FirstName>, <LastName>, <Mother's Name>, <Passport>, <PlaceOfBirth>, <UAEMobileNo>, <PhoneNoOrigin>, <DOB>, <PassportIDate>, <PassportEDate>
    Then I enter Email Address as Email:<email>

    Examples:
      | FirstName | LastName  | Mother's Name | Passport   | PlaceOfBirth | UAEMobileNo | PhoneNoOrigin | DOB        | PassportIDate | PassportEDate | email   |
      | Employe 10 | Employe 10 | Mother        | HGTFR554RR | Bangalore    | 9876543     | 76543         | 11-03-2000 | 10-02-2019    | 21-03-2041    | Devan.M |


  Scenario Outline: Open Contact from Approver
    Given Verify, Approve contact from Approver <username> <password>

    Examples:
      | username | password    |
      | AP5      | Password123 |
