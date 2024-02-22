@web
Feature: Test Automation Web

  @web
  Scenario: Test sign up normal
    Given user go to web page
    And user click sign up menu
    And user input sign up username
    And user input sign up pwd
    When user click sign up button
    Then validation get "alert" message "Sign up successful."

  @web
  Scenario: Test negative sign up user not input sign up username and password
    Given user go to web page
    And user click sign up menu
    When user click sign up button
    Then validation get "alert" message "Please fill out Username and Password."

  @web
  Scenario: Test login normal
    Given user go to web page
#    And user click sign up menu
#    And user input sign up username
#    And user input sign up pwd
#    When user click sign up button
#    Then validation get "alert" message "Sign up successful."
    And user click login menu
    And user input login username
    And user input login pwd
    When user click login button
    Then validation login successful

  @web
  Scenario: Test negative login user not input login username and password
    Given user go to web page
    And user click login menu
    When user click login button
    Then validation get "alert" message "Please fill out Username and Password."

  @web
  Scenario: Test logout normal
    Given user go to web page
#    And user click sign up menu
#    And user input sign up username
#    And user input sign up pwd
#    When user click sign up button
#    Then validation get "alert" message "Sign up successful."
    And user click login menu
    And user input login username
    And user input login pwd
    When user click login button
    Then validation login successful
    And user click logout button
    Then validation logout successful

  @web
  Scenario: Test sort by product categories normal
    Given user go to web page
#    And user click sign up menu
#    And user input sign up username
#    And user input sign up pwd
#    When user click sign up button
#    Then validation get "alert" message "Sign up successful."
    And user click login menu
    And user input login username
    And user input login pwd
    When user click login button
    Then validation login successful
    And user click categories "Phones"
    Then validation page display "Phones" product
    And user click categories "Laptops"
    Then validation page display "Laptops" product
    And user click categories "Monitors"
    Then validation page display "Monitors" product

  @web
  Scenario: Test add to cart normal
    Given user go to web page
#    And user click sign up menu
#    And user input sign up username
#    And user input sign up pwd
#    When user click sign up button
#    Then validation get "alert" message "Sign up successful."
    And user click login menu
    And user input login username
    And user input login pwd
    When user click login button
    Then validation login successful
    And user click product name
    And user click add to cart button
    Then validation get "alert" message "Product added."
    And user click home menu
    And user click product name
    And user click add to cart button
    Then validation get "alert" message "Product added."
    And user click cart menu
    Then validation cart page display equals 2 product
    Then validation total price is equals price of product

  @web
  Scenario: Test delete product from cart
    Given user go to web page
#    And user click sign up menu
#    And user input sign up username
#    And user input sign up pwd
#    When user click sign up button
#    Then validation get "alert" message "Sign up successful."
    And user click login menu
    And user input login username
    And user input login pwd
    When user click login button
    Then validation login successful
    And user click product name
    And user click add to cart button
    Then validation get "alert" message "Product added."
    And user click home menu
    And user click product name
    And user click add to cart button
    Then validation get "alert" message "Product added."
    And user click cart menu
    Then validation cart page display equals 2 product
    Then validation total price is equals price of product
    And user click delete product from cart
    Then validation cart page display equals 1 product
    Then validation total price is equals price of product
    And user click delete product from cart
    Then validation cart page display equals 0 product
    Then validation total price is equals price of product

  @web
  Scenario: Test place order normal
    Given user go to web page
#    And user click sign up menu
#    And user input sign up username
#    And user input sign up pwd
#    When user click sign up button
#    Then validation get "alert" message "Sign up successful."
    And user click login menu
    And user input login username
    And user input login pwd
    When user click login button
    Then validation login successful
    And user click product name
    And user click add to cart button
    Then validation get "alert" message "Product added."
    And user click home menu
    And user click product name
    And user click add to cart button
    Then validation get "alert" message "Product added."
    And user click cart menu
    Then validation cart page display equals 2 product
    Then validation total price is equals price of product
    And user click place order button
    And user input place order information
    And user click purchase button
    Then validation get "page" message "Thank you for your purchase!"
    Then validation order information is match
    And user click ok button
    Then validation user is on home page

  Scenario: Test negative place order with no input order information
    Given user go to web page
#    And user click sign up menu
#    And user input sign up username
#    And user input sign up pwd
#    When user click sign up button
#    Then validation get "alert" message "Sign up successful."
    And user click login menu
    And user input login username
    And user input login pwd
    When user click login button
    Then validation login successful
    And user click product name
    And user click add to cart button
    Then validation get "alert" message "Product added."
    And user click home menu
    And user click product name
    And user click add to cart button
    Then validation get "alert" message "Product added."
    And user click cart menu
    Then validation cart page display equals 2 product
    Then validation total price is equals price of product
    And user click place order button
    And user click purchase button
    Then validation get "alert" message "Please fill out Name and Creditcard."

