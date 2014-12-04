DineWithMeCore
==============

The core (model) logic of the DineWithMe application.

4/12/2014:
----------
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
