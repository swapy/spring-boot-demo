drop database if exists db_example;
create database db_example; -- Creates the new database
create user IF NOT EXISTS 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database