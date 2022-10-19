create table cargo
(
    id                    bigint auto_increment
        primary key,
    cargo                 varchar(255) null,
    acesso_modulo_estoque bit          not null,
    acesso_modulo_pessoas bit          not null,
    constraint POSITION_UNIQUE_CARGO
        unique (cargo),
    constraint UK_l3h4y04nhui8x7620i18a40wo
        unique (cargo)
);

INSERT INTO clinilog.cargo (id, cargo, acesso_modulo_estoque, acesso_modulo_pessoas) VALUES (1, 'Médico', true, true);
INSERT INTO clinilog.cargo (id, cargo, acesso_modulo_estoque, acesso_modulo_pessoas) VALUES (8, 'Farmacêutico', true, true);
INSERT INTO clinilog.cargo (id, cargo, acesso_modulo_estoque, acesso_modulo_pessoas) VALUES (9, 'Assistente Administrativo', true, true);
INSERT INTO clinilog.cargo (id, cargo, acesso_modulo_estoque, acesso_modulo_pessoas) VALUES (10, 'Administrador', true, true);