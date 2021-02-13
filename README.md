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
