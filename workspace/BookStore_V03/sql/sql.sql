
CREATE TABLE `bs_users` (
  `id` int(11) NOT NULL primary key auto_increment,
  `username` varchar(50) NOT NULL unique,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) default NULL
 )
ALTER TABLE bs_users ADD UNIQUE(username);

