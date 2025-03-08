Feature: dataflow between doctor and patient module

Background:
Given user is on login page


Scenario Outline: Verify dashboard displayed based on user role
  When user enter "<username>" and "<password>"
  And click on login button
  Then the "<title>" should be displayed

Examples:
   | role         | username       | password       | title            |
      | doctor      | gautham@gmail.com     | 123456     | Doctor Dashboard - Hospital Management System      |
      | patient     | deva@gmail.com    | 123456    | Patient Dashboard - Hospital Management System     |
      | nurse       | latha@gmail.com      | 123456      | Nurse Dashboard - Hospital Management System       |
      | receptionist | gowri@gmail.com | 123456 | Receptionist Dashboard - Hospital Management System |
      | laboratorist | sahana@gmail.com | 123456 | Laboratorist Dashboard - Hospital Management System |
      | pharmacist  | mukund@gmail.com | 123456 | Pharmacist Dashboard - Hospital Management System  |

