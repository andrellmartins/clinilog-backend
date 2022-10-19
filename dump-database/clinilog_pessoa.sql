create table pessoa
(
    id        bigint auto_increment
        primary key,
    cep       varchar(255) null,
    cpf       varchar(255) null,
    data_nasc datetime(6)  null,
    deletado  bit          not null,
    ender     varchar(255) null,
    nome      varchar(255) null,
    sexo      varchar(255) null,
    email     varchar(255) null,
    constraint PERSON_UNIQUE_CPF
        unique (cpf),
    constraint PERSON_UNIQUE_EMAIL
        unique (email)
);

INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (19, 'asd', '045.224.400-57', '2021-12-31 21:00:00.000000', true, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (20, 'asd', '535.873.340-05', '2021-12-31 21:00:00.000000', true, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (21, 'asd', '886.576.890-81', '2021-12-31 21:00:00.000000', true, 'teste', 'teste 1234', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (22, 'asd', '205.889.680-72', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (23, 'asd', '909.823.940-47', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (25, 'asd', '895.834.460-17', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (26, '99999999', '542.971.680-49', '2019-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (27, 'asd', '410.214.660-18', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (30, 'asd', '570.555.430-37', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (32, 'asd', '70360881416', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (34, 'asd', '65186611352', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (35, '1234', '1234', '1969-12-31 21:00:01.234000', false, '1234', '1234', '1234', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (36, 'asd', '81716123429', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (40, 'asd', '48587374460', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (46, 'asd', '45605120000', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (56, '', '99999999', null, false, '', 'teste', '', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (62, 'asd', '9999', '2021-12-31 21:00:00.000000', true, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (68, 'asd', '00908666900', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', null);
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (73, '999', '123456789', '2021-12-31 21:00:00.000000', false, '999', 'teste', 'F', 'dudu020300@gmail.com');
INSERT INTO clinilog.pessoa (id, cep, cpf, data_nasc, deletado, ender, nome, sexo, email) VALUES (75, '999999', '10850738580', '2021-12-31 21:00:00.000000', false, 'teste', 'teste', 'F', 'teste12345@teste.com');