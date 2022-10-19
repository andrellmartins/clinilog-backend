create table medicamento
(
    id              bigint auto_increment
        primary key,
    deletado        bit          not null,
    principio_ativo varchar(255) null,
    id_produto      bigint       null,
    constraint MEDICINE_UNIQUE_ID_PRODUTO
        unique (id_produto),
    constraint FK9muu76eh41b5gqibq7lsa3m47
        foreign key (id_produto) references produto (id)
);

INSERT INTO clinilog.medicamento (id, deletado, principio_ativo, id_produto) VALUES (1, false, '123', null);
INSERT INTO clinilog.medicamento (id, deletado, principio_ativo, id_produto) VALUES (2, false, '123', null);
INSERT INTO clinilog.medicamento (id, deletado, principio_ativo, id_produto) VALUES (3, false, '123', null);
INSERT INTO clinilog.medicamento (id, deletado, principio_ativo, id_produto) VALUES (4, false, '123', null);
INSERT INTO clinilog.medicamento (id, deletado, principio_ativo, id_produto) VALUES (5, false, '123', null);
INSERT INTO clinilog.medicamento (id, deletado, principio_ativo, id_produto) VALUES (6, false, '123', null);
INSERT INTO clinilog.medicamento (id, deletado, principio_ativo, id_produto) VALUES (7, false, '123', null);
INSERT INTO clinilog.medicamento (id, deletado, principio_ativo, id_produto) VALUES (8, false, null, null);
INSERT INTO clinilog.medicamento (id, deletado, principio_ativo, id_produto) VALUES (9, false, '1234', 9);
INSERT INTO clinilog.medicamento (id, deletado, principio_ativo, id_produto) VALUES (10, false, '5555', 4);