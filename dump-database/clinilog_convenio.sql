create table convenio
(
    id       bigint auto_increment
        primary key,
    convenio varchar(255) null,
    constraint INSURANCE_UNIQUE_CONVENIO
        unique (convenio),
    constraint UK_e3hl8b6ltvvsf4tqo118v8rfi
        unique (convenio)
);

