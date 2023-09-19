Feature: Selecting a Checkbox on a Web Page

   @Test1
  Scenario: Selecting the checkbox for the row with the name Blue Band
    Given I navigate to the URL "https://www.primefaces.org/primereact-v5/#/datatable/selection"
    And I locate the table with checkbox section
    When I select the checkbox for the row with the "Name" "Blue Band"
    Then I close the web browser