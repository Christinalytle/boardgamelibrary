create database if not exists board_game_database;  

use board_game_database ; 

drop table if exists games; 

create table games (
id int not null auto_increment, 
name varchar(300) not null,
min_number_players int not null, 
max_number_players int not null, 
play_time int not null,
difficulty_rating decimal (3,2), 
mechanism varchar(100) not null,
primary key(id)
); 

