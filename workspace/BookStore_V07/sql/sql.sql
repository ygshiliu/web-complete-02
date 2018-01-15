
CREATE TABLE `bs_users` (
  `id` int(11) NOT NULL primary key auto_increment,
  `username` varchar(50) NOT NULL unique,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) default NULL
 )
ALTER TABLE bs_users ADD UNIQUE(username);
----------------------------------------------
 CREATE TABLE `bs_books` (
  `id` int(11) primary key  auto_increment ,
  `title` varchar(50) ,
  `author` varchar(50) ,
  `price` double(11,2) ,
  `sale` int(10) ,
  `stock` int(10) ,
  `img_path` varchar(200) ,
)

-------------------------------

create table bs_orders(
    -> id varchar(100) primary key,
    -> createDate date,
    -> state int(2),
    -> total_amount double(11,2),
    -> total_count int(11),
    -> user_id int(11),
    -> foreign key (user_id) references bs_users(id)
    -> );

-----------------------------------
  create table bs_order_items(
    -> id int(11) primary key auto_increment,
    -> title varchar(50),
    -> author varchar(50),
    -> price double(11,2),
    -> img_path varchar(100),
    -> count int(11),
    -> amount double(11,2),
    -> order_id varchar(100),
    -> foreign key (order_id) references bs_orders(id)
    -> );