# phone-numbers-service
A project to list and categorize country phone numbers

TASK REQUIREMENTS

- Create a single page application in Java (Frameworks allowed) that uses the provided
database (SQLite 3) to list and categorize country phone numbers.
Phone numbers should be categorized by country, state (valid or not valid), country
code and number.

The page should render a list of all phone numbers available in the DB. It should be
possible to filter by country and state. Pagination is an extra.

**Topics to take into account:**
- Try to show your OOP skills
- Code standards/clean code
- Do not use external libs to validate the numbers.
- Unit Tests
- 
Regular expressions to validate the numbers:

Cameroon    | Country code: +237 | Regex = \(237\)\ ?[2368]\d{7,8}$

Ethiopia    | Country code: +251 | Regex = \(251\)\ ?[1-59]\d{8}$

Morocco     | Country code: +212 | Regex = \(212\)\ ?[5-9]\d{8}$

Mozambique  | Country code: +258 | Regex = \(258\)\ ?[28]\d{7,8}$

Uganda      | Country code: +256 | Regex = \(256\)\ ?\d{9}$

**HIGH LEVEL ARCHITECTURE**

<img width="787" alt="image" src="https://user-images.githubusercontent.com/15633518/169606778-fe9f4449-1d63-487e-874b-be7aab3b2049.png">
