-- TODO
create database ${database.dbname} default character set utf8 default collate utf8_general_ci;
set storage_engine = InnoDB;
grant all privileges on ${database.dbname}.* to ${database.username}@'%' identified by '${database.password}';
