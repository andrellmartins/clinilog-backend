create table funcionario
(
    id          bigint auto_increment
        primary key,
    pis         varchar(255) null,
    salario     float        not null,
    id_position bigint       null,
    id_pessoa   bigint       null,
    constraint EMPLOYEE_UNIQUE_ID_PESSOA
        unique (id_pessoa),
    constraint EMPLOYEE_UNIQUE_PIS
        unique (pis),
    constraint FK5or51s79bwg6urpitahjrq2ht
        foreign key (id_position) references cargo (id),
    constraint FKmflfgc1pxngkqvujs5c0rq4wm
        foreign key (id_pessoa) references pessoa (id)
);

INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (1, '12345678911', 1350.55, 1, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (2, '9999', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (5, '99991', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (6, '99992', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (7, '99993', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (8, '99994', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (9, '99995', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (11, '99996', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (12, '99997', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (13, '99998', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (15, '99999', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (17, '999910', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (19, '999911', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (20, '999912', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (21, '0001', 9999, 8, null);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (22, '0003', 9999, 8, 40);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (25, '0006', 9999, 9, 21);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (33, '4001', 9999, 8, 46);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (47, '9999111', 9999, 8, 62);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (48, '1234', 1234, 8, 35);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (54, '99991111', 9999, 8, 68);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (58, '123456789', 9999, 9, 73);
INSERT INTO clinilog.funcionario (id, pis, salario, id_position, id_pessoa) VALUES (59, '100000', 100000, 8, 75);