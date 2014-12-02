create table event(
eventid serial primary key,
name varchar(40),
eventdate date,
hostid int references users(userid)
)