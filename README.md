# PHONE NUMBERS VALIDATOR

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

# **PROGRAMMING SOLUTION - USER GUIDE**

# **Introduction**

This task has two implementations, Backend service and Frontend service.

The backend is implemented in the Spring boot framework and the Frontend is implemented in React.

# **High-Level Architecture**

![image](https://user-images.githubusercontent.com/15633518/169708687-73914fb5-a916-483e-b058-14402d6cdea7.png)

– Spring Boot exports REST Apis using Spring Web MVC &amp; interacts with Database using Spring Data.

– React Client sends HTTP Requests and retrieves HTTP Responses using Axios, showing data on the components. React Router is used for navigating pages.

# 1. **Phone Number Validator-Backend**

This task was done in Spring boot for Java and it&#39;s using Maven for dependency management.

## **Repositories**

To run and test the working of this solution, _**git clone**_ the below public repositories from [here](https://github.com/Bobiology).

| Repository Name | Location |
| --- | --- |
| phone-numbers-validator-backend | [https://github.com/Bobiology/phone-numbers-validator-backend.git](https://github.com/Bobiology/phone-numbers-validator-backend.git) |
| phone-numbers-validator-frontend | [https://github.com/Bobiology/phone-number-validator-frontend.git](https://github.com/Bobiology/phone-number-validator-frontend.git) |

## **Requirements**

Before running this spring boot application, ensure the below have been installed and configured accordingly.

- Maven

- JDK 11+

- Docker (optional)

## **Start the Application**

- Git clone the repository below.

[https://github.com/Bobiology/phone-numbers-validator-backend.git](https://github.com/Bobiology/phone-numbers-validator-backend.git)

- Open a shell terminal &amp; navigate to the root of the _**[phone-numbers-validator](https://github.com/Bobiology/phone-numbers-validator-backend)-backend**_ spring-project.
- While on the terminal issue the below command and hit Enter key:

_mvn clean install_

![image](https://user-images.githubusercontent.com/15633518/169708908-bf6ff8a6-f4d1-4cb5-8585-05d99ddb4bce.png)


- After a successful build, issue the command below to start the application.

_mvn spring-boot:run_

![image](https://user-images.githubusercontent.com/15633518/169708936-960db4e6-8e6d-48e0-bcf8-5151dabb9d70.png)

- The application will start on port **8081**. If another service is using that port, locate the application.properties file at ‘_**src/main/resources/**_’ and assign the **server.port** property to a different port. 

_Remember to also change the same in the Frontend Application_.

![image](https://user-images.githubusercontent.com/15633518/169709069-2c1280b5-b34d-4fc9-8727-a98d12f2c5c7.png)

## **Docker Image (Optional)**

### a) **Build Image**

- To build a docker image from this project navigate to the root directory then issue the below command.

_docker build -f Dockerfile -t phone-numbers-validator ._

![image](https://user-images.githubusercontent.com/15633518/169709088-4ac4a118-8c6b-48e0-89e6-d62319a8e0d1.png)

![image](https://user-images.githubusercontent.com/15633518/169709102-6ac3b84b-ba81-4601-b88d-d7f6bf04f6ea.png)

OR

### b) **Pull Image**

_docker pull bobiologist/phone-numbers-validator:latest_

![image](https://user-images.githubusercontent.com/15633518/169709121-d3a6a71e-190c-4335-b587-a66a08d57903.png)

### c) **Run Image**

To start the application from a docker image issue the command below in a terminal.

_docker run -p 8081:8081 phone-numbers-validator_

![image](https://user-images.githubusercontent.com/15633518/169709130-04e50c9f-03d4-402e-8fe7-753aa58cb44e.png)

## **Simulation**

Interact with the API Using POSTMAN Client

**ENDPOINT** :[http://localhost:8081/customers](http://localhost:8081/customers)

**METHOD** : GET

![image](https://user-images.githubusercontent.com/15633518/169709169-16899b5c-87c1-4dab-bb86-c0c438118e71.png)

![image](https://user-images.githubusercontent.com/15633518/169709176-376aec70-bd39-4cfc-bc0f-bbfb8e673478.png)

# 2. **Phone Number Validator-Frontend**

The UI is written in React and it is meant to complement the Phone Number Validator API by displaying the API contents in a user-friendly interface.

## **Requirements**

- NodeJS V17.9

## **Starting the UI**

To start this UI, from the shell terminal, navigate to the root directory of the cloned project repo.

Type the below command and hit the ENTER key.

_npm install_

![image](https://user-images.githubusercontent.com/15633518/169709221-3f13ddee-bd89-4cfa-8d10-b8317adde6a6.png)

![image](https://user-images.githubusercontent.com/15633518/169709227-a3f2f55e-4bf2-4cec-831e-263ab56ef692.png)

After a successful installation of dependencies, run the command below to start the UI.

_npm start_

The application will start on **port 3000** by default.

On the browser type the below URL to access the UI.

**http://server:3000**  => [http://localhost:3000](http://localhost:3000/) and hit the Enter key.

![image](https://user-images.githubusercontent.com/15633518/169709308-3e885211-5d6c-4679-9e3f-5b9b3648e23f.png)

## **Simulation**

To **sort** , click on any the name of the column of interest. Sorting can be in ascending or descending orders.

**Countries sorted in Ascending order**

![image](https://user-images.githubusercontent.com/15633518/169709331-8b2a812d-669a-4d4f-8f3a-99019e6d7eef.png)

**Countries sorted in Descending Order**

![image](https://user-images.githubusercontent.com/15633518/169709341-0cd04aea-0466-4ad7-9929-538c737934a4.png)

To **filter** , type in the text field below the column name of interest.

![image](https://user-images.githubusercontent.com/15633518/169709346-51272859-f2d4-46fa-b666-55fece89f841.png)

**Filtering using multiple columns**

![image](https://user-images.githubusercontent.com/15633518/169709352-83ab12bb-22d2-421e-a432-d16eb374fa17.png)

To navigate to the next page, click on the **next page marker** ( **>** ) or **page number** below the list page.

![image](https://user-images.githubusercontent.com/15633518/169709360-fcffe235-850a-41ea-899c-f6f500bcaac6.png)

**END**
