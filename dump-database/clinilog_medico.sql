create table medico
(
    id          bigint auto_increment
        primary key,
    crm         int          not null,
    crm_uf      varchar(255) null,
    id_employee bigint       null,
    constraint DOCTOR_UNIQUE_CRM_UF
        unique (crm, crm_uf),
    constraint DOCTOR_UNIQUE_ID_PESSOA
        unique (id_employee),
    constraint FKa0itnkqsnwmuwuunx1jtt3v9u
        foreign key (id_employee) references funcionario (id)
);

INSERT INTO clinilog.medico (id, crm, crm_uf, id_employee) VALUES (21, 0, null, 25);