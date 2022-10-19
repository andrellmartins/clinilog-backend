create table produto
(
    id               bigint auto_increment
        primary key,
    data_cadastro    datetime(6)  not null,
    deletado         bit          not null,
    descricao        varchar(255) null,
    id_lote          bigint       null,
    is_med           bit          not null,
    id_func_cadastro bigint       null,
    qtd_disponivel   bigint       null,
    qtd_minima       bigint       not null,
    constraint FKoy09nl32m2vgm1n1clugs3nj3
        foreign key (id_func_cadastro) references funcionario (id)
);

INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (1, '2022-09-11 18:07:56.124000', true, '123', null, false, null, null, 0);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (2, '2022-09-11 18:08:54.497000', true, '123', null, false, null, null, 0);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (3, '2022-09-11 18:11:22.416000', false, '1234', null, false, null, 499, 15);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (4, '2022-09-11 18:13:23.376000', false, '123', null, true, null, null, 0);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (5, '2022-09-11 18:13:29.653000', false, '123', null, true, null, null, 0);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (6, '2022-09-11 18:13:43.844000', false, '123', null, true, null, null, 0);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (7, '2022-09-11 18:49:50.895000', false, 'asd', null, true, null, null, 0);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (8, '2022-09-11 18:51:16.121000', false, '123', null, false, null, null, 0);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (9, '2022-09-14 18:42:14.040000', false, '1234', null, true, null, null, 0);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (10, '2022-09-14 19:05:00.673000', false, '123', null, false, null, 0, 0);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (11, '2022-09-30 20:45:16.452000', false, '123', null, false, null, 0, 0);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (12, '2022-09-30 20:46:12.579000', false, '123', null, false, null, 6, 0);
INSERT INTO clinilog.produto (id, data_cadastro, deletado, descricao, id_lote, is_med, id_func_cadastro, qtd_disponivel, qtd_minima) VALUES (13, '2022-09-30 20:59:06.408000', false, 'teste12345', null, false, null, 0, 15);