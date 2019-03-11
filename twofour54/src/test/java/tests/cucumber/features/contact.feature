@twofour54Application-Contact
Feature: Contact Feature

  Scenario Outline: Login into twofour54 and create Contact


    Given Hover MyContacts add New Contacts
    And Upload PhotoGraph & Enter Basic Information
    Then Enter Mandatory Fields such as <FirstName>, <LastName>, <Mother's Name>, <Passport>, <PlaceOfBirth>, <UAEMobileNo>, <PhoneNoOrigin>, <DOB>, <PassportIDate>,   <PassportEDate>


    Examples:
      | FirstName | LastName | Mother's Name | Passport   | PlaceOfBirth | UAEMobileNo | PhoneNoOrigin | DOB | PassportIDate | PassportEDate |
      | Employe 1 | Employe1 | Mother        | HGTFR554RR | Bangalore    | 9876543     | 76543         |     |               |               |
