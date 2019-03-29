@twofour54Application-Temp
Feature: Contact Feature

  Scenario Outline: Open Contact from Approver
    Given Verify, Approve contact from Approver <username> <password>

    Examples:
      | username | password    |
      | AP5      | Password123 |
