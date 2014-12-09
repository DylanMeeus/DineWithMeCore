

select * from users inner join friends 
on users.userid = friends.user2
where friends.user1 = 15 and accepted = false