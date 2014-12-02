set schema 'dinewithme';

create table eventinvitees(
eventid int references event(eventid),
inviteeid int references users(userid)
)