@twofour54Application-ChangeVisaStatus
Feature: Change of visa status

  Scenario Outline: Apply for change of visa status

    Given Employment visa should be completed
    And Navigate to Change of visa status service, start service
    Then Access the service
    And select applicant <firstname>,<lastname>
    Then Select service priority as <ServicePriority>
    And make payment using <PaymentMethod>


    Examples:
      | firstname  | lastname   | ServicePriority | PaymentMethod |
      | Employee01 | Employee01 | urgent          | cheque        |

@twofour54Application-CashierPortal
  Scenario Outline: Login to cashier internal portal

    Given Make bulk payment in cashier portal
    And Navigate to create reciept
    Then Search <AccountName>
    And Enter <SRnumber>

    Examples:
    |AccountName|SRnumber|
    |Sky new LLC|SRnumber|


