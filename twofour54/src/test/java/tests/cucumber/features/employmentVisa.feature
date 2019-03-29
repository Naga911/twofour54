@twofour54Application-employment
Feature: EmploymentVisa Feature

  Scenario Outline: Create Employment visa

    Given Hover Services, Select Employment, Residence visa Service
    And Click on Start Service
    And Scroll, Access the service
    And Click on the Search Icon,click on Proceed button
    And Select <CurrentVisa>,<EmploymentVisa>,<MedicalTest>,<EmiratesID>,<ResidenceVisa>,<ResVisaDuration>,<HealthInsurance>,<HealthInsurancePlan>
    And Click on Next button

    Examples:
      | CurrentVisa | EmploymentVisa | MedicalTest | EmiratesID | ResidenceVisa | ResVisaDuration | HealthInsurance | HealthInsurancePlan |
      | New         | Normal         | Normal      | Yes        | Normal        | 2 Years         | Yes             | Enhanced Silver     |






