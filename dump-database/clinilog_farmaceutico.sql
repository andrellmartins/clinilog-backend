create table farmaceutico
(
    id          bigint auto_increment
        primary key,
    crf         int          not null,
    crf_uf      varchar(255) null,
    id_employee bigint       null,
    constraint PHARMA_UNIQUE_CRF_UF
        unique (crf, crf_uf),
    constraint PHARMA_UNIQUE_ID_EMPLOYEE
        unique (id_employee),
    constraint FKnm89pmkhjt8e8iwyipdmnj37
        foreign key (id_employee) references funcionario (id)
);

INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (1, 9999, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (3, 99991, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (4, 99992, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (5, 99993, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (6, 99994, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (7, 99995, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (8, 99996, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (9, 99997, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (10, 99998, '9999', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (12, 99999, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (13, 999910, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (15, 999911, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (16, 999912, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (17, 1, 'PR', null);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (18, 3, 'PR', 22);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (20, 6, '99999', 25);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (23, 4001, 'PR', 33);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (26, 999, '999', 47);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (27, 1234, '1234', 48);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (31, 9999999, '999', 54);
INSERT INTO clinilog.farmaceutico (id, crf, crf_uf, id_employee) VALUES (32, 654654, 'RR', 59);