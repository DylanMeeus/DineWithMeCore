set schema 'dinewithme';

select * 
from eventinvitees inner join events using(eventid) inner join users on events.hostid = users.userid
where inviteeid=17 and accepted=false;


--String selectString = "select * from eventinvitees inner join events using(eventid) inner join users on even