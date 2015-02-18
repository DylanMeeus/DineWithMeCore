DineWithMeCore
==============

The core (model) logic of the DineWithMe application.

Additional information
----------------------
- Javadoc now available on www.it-ca.net/DineWithMe/JavaDoc
- Code Metrics now available on www.it-ca.net/DineWithMe/Metrics


As of 18/02/2015
----------------

The project was finished almost two months ago now, apart from some documentation and diagrams that have been added later. However, now the project is back alive and being worked on. You might wonder why the reboot happened, or why it stopped in the first place? The original version was made for a final-year course at UCLL in Mobile Applications, this was the core which contained the business logic, and later a swing backend. When the exam term started, we had to stop working on our projects, so I stopped contributing code to both this and the android repository.

Now however, I am taking a course in "Internet Programming", for which we have a new 'final project', and I got the 'OK' to extend the current DineWithMe application into a full-fledged web application with some additional requirements. (Such as both offline and online data structures, which explains the recently added interface and classes.

Everything else will stay the same, Javadoc and code metrics will be updated on a regular base and made available on the link found under 'Additional information'.


As of 9/12/2014 milestone commit
--------------------------------
- Finished main functions of the core application
	- Event creation / accepting / deleting
	- Friend request sending / accepting / deleting
	- User login / logout / ..
	- Encryption, database encoding, ...
- Added necessary JPanels and controllers for the functions
- Minor fixes all around the project
- Javadoc now available on www.it-ca.net/DineWithMe/JavaDoc
- Code Metrics now available on www.it-ca.net/DineWithMe/Metrics


As of 7/12/2014:
----------------
- Refactored controllers to follow naming convention
- Refactored controllers to deal with exceptions thrown by the facade
- Added functionality to create events
- Added functionality to view user owned events
- Added a factory class now responsible for returning the correct database-handling class
- Facade now calls factory method, which can return a new ServiceTypeException if the service is not found
- Removed System.out.println() methods used for debugging
- Added UML of the complete DineWithMeCore application (MVC)

As of 4/12/2014:
----------------
- Added functionality to create recipes
- Added functionality to view recipes
- Added database functionality to add recipes
- Created new class that which extends database (RecipeService.java)

As of 3/12/2014:
----------------
- Main Menu
- Login functionality
- Create user functionality
- Correct handling of active sessions
- Correct encryption and database communcation
- Refactored the old database schema
- Refactored the old database connection handling
- Improved modularity in net.itca.core.data
- Facade directs calls to correct sub-database class
- Exception tunneling to controllers (instead of handling them in the facade)
- Removed DataSource interface - chose for inheritance for easier connection management
- Correct logout behaviour (Session no longer stores userID)
- Friend system completed:
	- Friend requests (sending, accepting, declining)
	- View friends
	- View invites
- Refactored database to deal with friend system functions
- Extending the facade to deal with new database system



DISCLAIMER
=========
DineWithMeCore developped by me. Model packaged as a runnable jar can be found as well. Used in the DineWithMe android application developped by Vasco Felix and me.
Find me on www.it-ca.net/BlogDylan or send me a message on github / twitter (@DylanMeeus) if you have any questions / concerns. No copyright, play with it, use it however you like.
