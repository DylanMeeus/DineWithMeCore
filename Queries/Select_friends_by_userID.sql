

select username, firstname, lastname from users inner join friends 
on users.userid = friends.user2
where friends.user1 = 9