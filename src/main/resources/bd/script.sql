-- create table USER(
--                      id_user bigint not null auto_increment primary key,
--                      email varchar(30),
--                      password varchar(30)
-- );
--
-- create table PERSONAL_DATA(
--                               id_personal_data bigint auto_increment primary key,
--                               name varchar(100) not null,
--                               last_name varchar(100) not null,
--                               cpf bigint not null,
--                               id_user bigint not null,
--                               constraint fk_user foreign key (id_user)
--                                   references USER(id_user)
--                                   on delete cascade
--                                   on update cascade
-- );
--
-- create  table ADRESS(
--                         id_adress bigint auto_increment primary key,
--                         street varchar(30),
--                         neighborhood varchar(30),
--                         city varchar(30),
--                         state varchar(30),
--                         cep bigint not null,
--                         id_personal_data bigint not null,
--                         constraint fk_personal_data foreign key (id_personal_data)
--                             references PERSONAL_DATA(id_personal_data)
--                             on delete cascade
--                             on update cascade
-- );
--         #drop table ADRESS;
--         #drop table PERSONAL_DATA;
--         #drop table USER;
--
-- insert into USER (id_user, email, password) values (11,"pedro@gmail.com", "pedro123");
-- insert into USER (id_user, email, password) values (22,"lucas@gmail.com", "lucas123");
-- insert into USER (id_user, email, password) values (33,"paulo@gmail.com", "paulo123");
-- insert into USER (id_user, email, password) values (44,"vinicius@gmail.com", "vinicius123");
-- insert into USER (id_user, email, password) values (55,"guilherme@gmail.com", "guilherme123");
--
-- insert into PERSONAL_DATA (id_personal_data, name, last_name, cpf, id_user) values (1,"Pedro", "Prado", 1234, 11);
-- insert into PERSONAL_DATA (id_personal_data, name, last_name, cpf, id_user) values (2,"Lucas", "Marinho", 2345, 22);
-- insert into PERSONAL_DATA (id_personal_data, name, last_name, cpf, id_user) values (3,"Paulo", "Coelho", 2333, 33);
-- insert into PERSONAL_DATA (id_personal_data, name, last_name, cpf, id_user) values (4,"Vinicius", "Santos", 3334, 44);
-- insert into PERSONAL_DATA (id_personal_data, name, last_name, cpf, id_user) values (5,"Guilherme", "Padilha", 4434, 55);
--
-- insert into ADRESS (id_adress, street, neighborhood, city, state, cep, id_personal_data)
-- values (1, "Rua Maria de Souza", "São Tomé", "São Pedro", "São Paulo", 02359, 1);
-- insert into ADRESS (id_adress, street, neighborhood, city, state, cep, id_personal_data)
-- values (2, "Rua Antônio de Bonis", "Vila Pirajussara", "São Paulo", "São Paulo", 55555, 2);
-- insert into ADRESS (id_adress, street, neighborhood, city, state, cep, id_personal_data)
-- values (3, "Rua Santa Rosa Júnior", "Jaguaré", "São Paulo", "São Paulo", 34532, 3);
-- insert into ADRESS (id_adress, street, neighborhood, city, state, cep, id_personal_data)
-- values (4, "Rua Nossa Senhora do Carmo", "José Menino", "Santos", "São Paulo", 02359, 4);
-- insert into ADRESS (id_adress, street, neighborhood, city, state, cep, id_personal_data)
-- values (5, "Accindino Souza Andrade", "Boqueirão", "Santos", "São Paulo", 62359, 5);
--
