@twofour54Application-Temp
Feature: Contact Feature

  Scenario Outline: Open Contact from Approver
    Given Verify, Approve contact from Approver <username> <password> <FirstName> <LastName>

    Examples:
      | username | password    | FirstName  | LastName   |
      | AP5      | Password123 | Employe 11 | Employe 11 |
