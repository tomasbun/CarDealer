# assignment-two-tomasbun
assignment-two-tomasbun created by GitHub Classroom
## Weekly Updates 

**22/10/2020**
- Project added

**03/11/2020** 
-	Images folder added.
-	Data from excel file was normalised and converted to sql script, included in Supplementary materials folder.
-	Persistence unit added.
-	Connection pool added.
-	DBUtill class added. Entity classes from db created. Supplementary classes to deal with db crud operations added.
-	Interface CarDealerRepositoryAdded for repository pattern implementation. JPA queries edited.


**09/11/2020**
-	Db redesigned, sales and customer tables are added.
-	Header and footer jsp's added.
-	Responsive menu layout implemented.
-	View all cars functionality implemented.
-	View car details functionality implemented.



**16/11/2020**
-	Search using make, model, year and price criteria is added. Fields in form are populated using existing values from db and are saved ins session for further use.
-	Favourites list implemented using cookies. Cookie Wishlist created with expiry date of two year. User can add, remove cars to Wishlist. If car is in Wishlist user can only remove it. Removing car can be done from Wishlist page or car details page.
-	Shiro dependencies added to pom and Shiro ini file created. Users from db can log in using login form. Does not support encryption.
-	Navigation bar updated so that unauthorised users can see only a portion of links. Sales representatives can see more options and administrators are able to see all options. - - Reporting plugin cobertura-maven-plugin added to pom and unit test file for CarDB created.


**23/11/2020**
-	Records for sales and customers added to db, sql file is updated please use current version for testing.
-	Passwords are encrypted using sha-256. Users can login using encrypted passwords using Shiro. This was not working last week.
-	User can select option "remember me" in log form. Application will remember logged in user until he/she logs out.
-	When logged in user image is displayed on right side together with an option to log out.
-	New page "about us" added, it contains list of employees and google map that can be used directions.
-	Employee email link is clickable and will open default mail application.
-	Sales personnel can view sales that happened in sales page. This will display a table of sales that consists of listing number for car sold, customer id, salesperson that recorded sale etc. Clicking on listing numbers will show vehicle details, while clicking on staff name will show staff details.
-	If user is administrator he/she can view all staff in staff page. Clicking on employee will show his/her details that can be updated. Image upload is not supported yet. - ---- Administrator can reset password; it will be set to "password" and encrypted sha-256.
-	Administrator can create new employee by filling in new employee form.
-	Testing has been started using Junit. Class staffDB now has 6 test. Reporting however does not wok yet and code coverage cannot be displayed.


**30/11/2020**
-	Reporting added using maven-surefire-report-plugin. This builds html report site than contains a detailed information about unit test, dependencies and plugins. This report site can be generated using command mvn site:site in cmd or right click on project -> Run MAven -> Goals -> site:site. Same way surefire:test command can be executed, it creates txt files of unit test summary.
-	Helper classes added StaffValidationRules and CarsValidationRules. They contain methods that are used to validate data that will be inserted into database when creating or updating records in db.
-	SSL certificate was created and can be found in Supplementary Materials folder - TomasBunevicius.crt This allows secure communication between pages on port 8443.
-	Authorised users can change their passwords.
-	Authorised users can upload jpg and png images for their profile, they are resized to 60x60px. Images are copied to assignment-two tomasbun\Assignment2\src\main\webapp\images\Sales People directory. However it is not displayed straight away due to browser cache. NoCacheFilter was used to eliminate this problem but due to time problem was not resolved completely. In order to see uploaded image change please clear browser cache or logout and log in.
-	When a sales personnel views car details, they are allowed to edit some parameters.
-	Administrator can edit and remove authenticated users.
-	Authenticated users can download xlsx reports of sales and cars that are listed.
-	When creating new user, if validation fails form remains populated with details that were entered already.
-	For cars in Wishlist there is an indication if car is still available or sold.
## Summary
### Available Users
Username/password/type
- dave.lindale@moylishmotors.ie       dave2     sales
- connie.jackson@moylishmotors.ie     connie    sales
- mary.mckeown@moylishmotors.ie       mary      sales
- bianca.davie@moylishmotors.ie       bianca    sales
- terry.dunlee@moylishmotors.ie       terry     sales
- tomas.bunevicius@moylishmotors.ie   tomas     administration

### Functionality
#### Unauthorised Users
-	View GetInTouch page that contains list of employees with email links that launch default email application and an embedded google map.
-	View car listings. Shows records of all cars with the help DataTables - a plug-in for the jQuery JavaScript library. User can choose how many records will be displayed per page in a table and can jump to following set of records using pagination. Records can be searched by any text typed in search field at the top right og the table.
-	Alternatively, filtering of records by make, body, year and price range using form on the left can be done. It contains populated dropdown lists of possible records to minimise data entry and empty search results. This was done using session. User does not have to use all filters in form. If option any will be left it will be ignored.
-	Search can be reverted back by clicking on reset button. Table will be populated with all records again.
-	When clicking on car image car details are displayed. With gallery of images and more detailed information. Green button at the top left will invite user to add it to a Wishlist if car is not in it yet. Otherwise it will give user an option to remove it from Wishlist.
-	Users favourite cars are stored in Wishlist that is implemented using cookies. First time car is added to Wishlist a cookie is created with life span of 2 years. It holds value of cars listing number. If more cars are added to Wishlist cookie value will be updated as follows: 4294194/4294195/4294191 etc. This way car details can be retrieved from db easily by separating cookie value into array using char '/' and using query to find car by listing number. Same way record can be removed from cookie value.
-	While in wish list, if car is still for sale message "Available will be displayed", else it will be in red and say "sold".
-	Cars can be removed from Wishlist directly as well.
-	Car details can be seen by clicking on "View Listing" button. -if Wishlist is empty, an image of empty garage will be displayed with a message "Your wish list is empty". -Users can attempt to log in using log in form.
#### Sales 
-	If logged in, sales people can see their profile image together with their email on the right side of navigation menu.
-	It is posible to change profile image in image upload form. At the moment only jpg and png formats are allowed. Imaged will be resised and displayed upon next login.
-	Sales personel can also change their password.
-	When viewing car details he can change some of it including notes and description. Sales people can also mark car as sold.
-	Sales personel can view sales records in a searchable table. Table contains mixed data from car, customer and staff tables in db.
-	Clicking on listing number or sales agent will display detailed view of car of an agent.
-	It is possible for sales users to download xlsx files with all records of cars and sales.
#### Administration
-	If logged in user is administrator he/she has given same functionality as sales personnel.
-	Additionally, administrators can view all staff in a searchable table.
-	Clicking on the record will show detailed information about staff.
-	Administrators can change details of staff.
-	If changes are not valid, message will be displayed informing about error. Form will remain populated.
-	Administrator can reset password for others. it will be set to "password".
-	Administrator can remove staff record from database.
### Security
-	Authentication and authorisation is done using Shiro plugin.
-	passwords are encrypted using google guava
-	SSL certificate was generated for secure communication and can be found in Supplementary materials folder.
-	Helper classes are created for forms validation. It allows easy extension for business rules.
- In some cases JSTL Core <c:out> tag was used to escape unwanted characters.
### Testing 
- Unit Testing was carried out on StaffDb class methods using JUnit.
- Surefire Reports site can be generated using mvn site:site command. 
- Testing reports in txt format can be generated using mvn surefire:test command
### Known issues/ limitations
-	index page contains links to "Get Finance" and "We pay cash for your car". A reasonable amount of time was spent investigating suitable third-party API's but due to lack of time this functionality is not implemented. Instead user will be redirected to Under construction page.
-	Unauthorised users can see a link "Inquiry" in card details page, it is not implemented.
-	All exceptions are caught and displayed in error page. This is left as is for faster development.
