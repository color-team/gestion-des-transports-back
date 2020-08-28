create table article (
id int not null auto_increment,
libelle VARCHAR(100) not null,
prix int not null,
primary key (id)
);
insert into article(libelle,prix) values ('vis', 2);
insert into article(libelle,prix) values ('boulons', 3);
insert into article(libelle,prix) values ('perceuse', 20);
insert into article(libelle,prix) values ('marteau', 8)