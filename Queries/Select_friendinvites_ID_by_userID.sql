-- assume someone invites me

select user1 from users inner join friends 
on users.userid = friends.user2
where friends.user2 = 15 and accepted = false;

