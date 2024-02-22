@api
Feature: Test Automation Rest API

  @api
  Scenario: Test get list user normal
    Given prepare url for "get_list_user"
    And hit api get list user
    Then validation status code is equals 200
    Then validation response body get list user
    Then validation response json with JSONSchema "get_list_user_normal.json"

  @api
  Scenario: Test get list user normal by id
    Given prepare url for "create_user"
    And hit api post create new user
    Then validation status code is equals 200
    Then validation response body post create user
    And prepare url for "get_list_user"
    And hit api get list user by id
    Then validation status code is equals 200

  @api
  Scenario: Test negative get list user with wrong url
    Given prepare url for "wrong_url"
    And hit api get list user
    Then validation status code is equals 400
    Then validation response body negative get list user

  @api
  Scenario: Test create new user normal
    Given prepare url for "create_user"
    And hit api post create new user
    Then validation status code is equals 200
    Then validation response body post create user
    Then validation response json with JSONSchema "post_new_user_normal.json"

  @api
  Scenario: Test negative create a new user by leaving the required data blank
    Given prepare url for "create_user"
    And hit api negative post create new user
    Then validation status code is equals 400
    Then validation response body negative post create user

  @api
  Scenario: Test delete user normal
    Given prepare url for "create_user"
    And hit api post create new user
    Then validation status code is equals 200
    Then validation response body post create user
    And prepare url for "get_list_user"
    And hit api delete new user
    Then validation status code is equals 200
    Then validation response body delete user
    Then validation response json with JSONSchema "delete_user_normal.json"

  @api
  Scenario: Test negative delete user with unregistered user id
    Given prepare url for "get_list_user"
    And hit api delete user by id
    Then validation status code is equals 404
    Then validation response body negative delete user

  @api
  Scenario: Test update user normal
    Given prepare url for "create_user"
    And hit api post create new user
    Then validation status code is equals 200
    Then validation response body post create user
    And prepare url for "get_list_user"
    And hit api update user
    Then validation status code is equals 200
    Then validation response body update user