
Feature: User Registration
  user can make account on e-commerce website
  
  Scenario Outline: User register with valid user name & password
  Given user should be in home page
  When user click on register link
  And user enters data "<firstname>", "<lastname>", "<username>", "<email>","<confirmEmail>", "<pass>", "<confirmPass>"
  Then The registration page will be displayed success message
  
  Examples:
  | firstname | lastname | username | email | confirmEmail | pass | confirmPass | 
  | Radwa | Desouky | testuser4 | radwa123@gmail.com | radwa123@gmail.com | 123456 | 123456 | 

