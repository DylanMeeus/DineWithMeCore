DineWithMeCore
==============

The core (model) logic of the DineWithMe application.

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



DISCLAIMER
=========
DineWithMeCore developped by me. Model packaged as a runnable jar can be found as well. Used in the DineWithMe android application developped by Vasco Felix and me.
Find me on www.it-ca.net/BlogDylan or send me a message on github / twitter (@DylanMeeus) if you have any questions / concerns. No copyright, play with it, use it however you like.
