create table hibernate_sequence (next_val bigint) engine=MyISAM;
insert into hibernate_sequence values ( 1 );
create table user (id bigint not null, email varchar(255) not null, name varchar(255) not null, phone varchar(255), user_name varchar(255) not null, primary key (id)) engine=MyISAM;

