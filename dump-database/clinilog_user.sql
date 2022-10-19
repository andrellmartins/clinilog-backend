create table user
(
    id          bigint auto_increment
        primary key,
    dt_creation date         null,
    dt_update   date         null,
    first_name  varchar(255) null,
    last_name   varchar(255) null,
    login       varchar(255) null,
    password    varchar(255) null,
    id_pessoa   bigint       null,
    constraint USER_UNIQUE_ID_PESSOA
        unique (id_pessoa),
    constraint USER_UNIQUE_LOGIN
        unique (login),
    constraint FKp4y3mh5hu7th5re8hs6ev8n5a
        foreign key (id_pessoa) references pessoa (id)
);

INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (1, '2022-09-08', '2022-09-08', 'firstteste', 'lastTeste', 'loginteste', '$2a$10$wXHs8a4xDol91QvfTEMG1u.Q6bKfYBtWNimVbGGDG9KD576wQM9ae', null);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (2, '2022-09-10', '2022-09-10', null, null, 'teste', '$2a$10$FhhSz9N8ruR/E318T2L1DOf41KIrs7foblLXMLUffWIv.2WC59lL.', null);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (4, '2022-09-10', '2022-09-10', null, null, 'teste1', '$2a$10$xFzHA6r7hREqF8ARoQ2n6OfTNtdfSXyC.q.8BlO4JOMKY.7fJq/we', null);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (5, '2022-09-11', '2022-09-11', null, null, 'teste2', '$2a$10$LK6hnV2FUWOZ5zdWy1RakOCYQ5gDZolL1g55tvignvs6nrCMrSLlW', null);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (7, '2022-09-11', '2022-09-11', null, null, 'teste123', '$2a$10$9VBEXl5VFrudTI.2tFF8qOjbyWA.4APCegBG6IBaIC/JQe54.Gm8W', null);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (8, '2022-09-11', '2022-09-11', null, null, 'teste001', '$2a$10$GWPT/3rhcbzrT3hEiD00kOdA/F7z1ZY8CKyeDLYw8HYwEpCQOZHki', null);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (9, '2022-09-11', '2022-09-11', null, null, 'teste0001', '$2a$10$016KUCy96LoubtH0OxQpFuXgs6MCVnshy9qoyqgNddDlJZCDPX4Yi', null);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (10, '2022-09-11', '2022-09-11', null, null, 'teste0003', '$2a$10$j7HYR5AG/8m0KoeHBVgel.aXQZJ6XJOnDA67hnm6Y4227JWi7rpVa', 40);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (12, '2022-09-12', '2022-09-12', null, null, 'teste0006', '$2a$10$3BcxyrgCFmQ03/zoQrlq1ufxsB6LhP7bkNcq8i1ifyRIFY3uYAK8m', 21);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (13, '2022-09-14', '2022-09-14', null, null, 'teste4001', '$2a$10$.ZiR2hHICA6X7o9FF7keGO4p/7DajKSHOeO658uROF6cr/VCOT6tW', 46);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (14, '2022-09-14', '2022-09-14', null, null, '', '$2a$10$FhszkddugDF/QxzJgKamWeqejGKRaKUHBxOytseF8wNub3DUZtrG2', 56);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (17, '2022-09-14', '2022-09-14', null, null, 'teste1234', '$2a$10$HR0IF7VPniXR/Tqzsse6bO4QMAdvEsiKhbS/B3WusEgC0jKCO6uoe', 62);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (18, '2022-09-14', '2022-09-14', null, null, '1234', '$2a$10$KasQDZdNvipE8FzNIlfzVOYda8cqz7JYG0MQxnAEVuFafq7Cf9PFW', 35);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (21, '2022-09-14', '2022-09-14', null, null, 'teste1234567', '$2a$10$fQwf4bEopIV6YZEA4Mcfnecak32YNGZRxm7B.eNKCLahxRBa2D1nC', 68);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (24, '2022-09-21', '2022-09-21', null, null, 'teste12345', '$2a$10$GQ1h8BTL/C2OzmgIzeh8beXGz8J8JWnEIPmc2nmIBaRj2CVDlW8He', 73);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (26, '2022-09-17', '2022-09-17', null, null, 'teste555', '$2a$10$PEVNaws/M.x56543Ag65TeNIowCc.Pb4lw3uQsp46Bav288JGXZK2', 22);
INSERT INTO clinilog.user (id, dt_creation, dt_update, first_name, last_name, login, password, id_pessoa) VALUES (27, '2022-10-12', '2022-10-12', null, null, 'teste11111', '$2a$10$lIXL/QfHvpul5imqxHiA7OzhLkJNQxJagKm4Fp.PDyNuOwXIis3iq', 75);