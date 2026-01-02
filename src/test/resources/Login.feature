Feature: Login Functionality
    In order to internet banking
    As a valid Para Bank customer
    I want to login successfully

  Scenario: Login Successful

    Given I am in the login page of the para Bank Application
    When I enter valid credential
    Then I should be taken to the Overview page

