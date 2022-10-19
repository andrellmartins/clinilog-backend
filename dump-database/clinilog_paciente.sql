create table paciente
(
    id          bigint auto_increment
        primary key,
    id_convenio bigint null,
    id_pessoa   bigint null,
    constraint PATIENT_UNIQUE_ID_PESSOA
        unique (id_pessoa),
    constraint FKjdgeb5ttsmqv1tu13yd6ujntn
        foreign key (id_convenio) references convenio (id),
    constraint FKr7gw7jr8c8fcg5cdjugjpkp8k
        foreign key (id_pessoa) references pessoa (id)
);

INSERT INTO clinilog.paciente (id, id_convenio, id_pessoa) VALUES (20, null, 21);
INSERT INTO clinilog.paciente (id, id_convenio, id_pessoa) VALUES (21, null, 56);
INSERT INTO clinilog.paciente (id, id_convenio, id_pessoa) VALUES (23, null, 22);