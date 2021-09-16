# Running service

Just build with gradle and run WikiCreditApplication from your IDE or with `gradle :bootRun`.

Service should be available at [localhost:8080](http://localhost:8080/). 

Database console web GUI is available at http://localhost:8080/h2-console. 
This is an embedded [H2 database](https://www.h2database.com/html/main.html) 
which you can access with username = wikicredit and password = secretpass 
(defined in `resources/application.properties`). On startup in runs `resources/data.sql` 
to initialize schema and fill some data. 

You can use Swagger UI at http://localhost:8080/swagger-ui.html

Project uses Lombok, so you might need to "Enable annotation processing" in your IDE.

# Tasks

> On the refinement APO presented a new task: from now on, we will only work 
> with customers that have their own Wikipedia page as a way to ensure they are
> safe to work with.  
> We need to create a new service to load data from wikipedia and incorporate those 
> wiki articles with the rest of our systems. 
> Your task is to create a MVP 1 to present it to managers so that we will know 
> if we are on the right track.

1. Implement methods in `CompanyController` class to get and create new data entities from database
2. Implement methods in `WikiCreditApplication` class to fetch company data from Wikipedia REST API 
   and store it in wikipedia_data table 
3. Create a new controller (or modify existing) to return a report, in which you would link
   company name and company summary from both tables for one GET response
   

List of companies that can be used as example: https://en.wikipedia.org/wiki/List_of_companies_of_Latvia

REST endpoint to use: https://en.wikipedia.org/api/rest_v1/page/summary/{company} 
(e.g. https://en.wikipedia.org/api/rest_v1/page/summary/Swedbank)

Fields that you need from it: `pageid` and `extract`

Please upload the project to a private gitlab repo and give read permissions to user mrabar. Do not fork it, and do 
not make it public for the time of the recruitment. 

Feel free to modify database schema or java classes in any way that you see fit. 
You are also able to add new dependencies or plugins to a project, but be able to explain to us what they do and why 
are they needed.