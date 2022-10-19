create table movimentacao
(
    id              bigint auto_increment
        primary key,
    data_cadastro   datetime(6) not null,
    qtd_movimentada bigint      null,
    batch_id        bigint      null,
    product_id      bigint      null,
    constraint FK4l7e029chetmwp4mj1w59plne
        foreign key (batch_id) references lote (id),
    constraint FKdk2k6oighqj4cjw8acc00w6q6
        foreign key (product_id) references produto (id)
);

INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (1, '2022-09-21 22:16:38.490000', 9, 15, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (2, '2022-09-24 20:18:11.802000', 100, 16, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (5, '2022-09-28 19:33:18.988000', 500, 19, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (6, '2022-09-28 19:50:06.444000', 15, 20, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (16, '2022-09-28 20:18:57.866000', 10, 30, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (17, '2022-09-28 20:23:06.836000', 100, 31, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (18, '2022-09-28 20:25:40.251000', 10, 32, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (19, '2022-09-28 20:29:01.918000', 1234, 33, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (20, '2022-09-28 20:33:16.141000', 200, 34, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (21, '2022-09-28 20:35:48.765000', 1234, 35, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (22, '2022-09-28 20:38:47.613000', 12, 36, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (23, '2022-09-28 20:40:04.970000', 12, 37, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (24, '2022-09-28 20:42:59.761000', 123, 38, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (25, '2022-09-28 20:46:13.045000', 123, 39, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (26, '2022-09-28 20:47:54.197000', 1244, 40, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (27, '2022-09-28 20:49:06.860000', 100, 41, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (28, '2022-09-28 20:51:57.806000', 123, 42, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (29, '2022-09-28 20:54:49.158000', 100, 43, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (30, '2022-09-28 21:03:59.801000', 12, 44, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (31, '2022-09-28 21:05:53.364000', 1234, 45, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (32, '2022-09-28 21:20:13.856000', 20, 46, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (35, '2022-09-28 21:41:05.372000', 10, 49, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (36, '2022-09-28 21:43:23.645000', 10, 50, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (38, '2022-09-28 21:44:45.006000', 10, 52, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (39, '2022-09-28 21:51:19.393000', 10, 53, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (40, '2022-09-28 21:52:56.062000', 123, 54, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (43, '2022-09-28 22:22:04.441000', 123, 57, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (44, '2022-09-28 22:41:17.895000', 123, 58, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (45, '2022-09-28 22:42:15.357000', 123, 59, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (46, '2022-09-30 19:48:04.809000', 123, 60, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (47, '2022-09-30 20:10:00.956000', 123, 61, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (48, '2022-09-30 20:11:10.251000', 123, 62, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (49, '2022-09-30 20:12:51.346000', 123, 63, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (50, '2022-09-30 20:25:04.512000', 123, 64, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (51, '2022-09-30 20:28:43.218000', 123, 65, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (52, '2022-09-30 20:28:43.234000', 123, 65, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (54, '2022-09-30 20:30:34.010000', 123, 67, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (55, '2022-09-30 20:30:34.022000', 123, 67, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (56, '2022-09-30 20:31:17.585000', 123, 68, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (57, '2022-09-30 20:31:17.588000', 123, 69, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (58, '2022-09-30 20:31:17.590000', 123, 70, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (59, '2022-09-30 20:31:17.593000', 123, 68, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (60, '2022-09-30 20:31:17.595000', 123, 69, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (61, '2022-09-30 20:31:17.599000', 123, 70, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (62, '2022-09-30 20:33:36.814000', 1, 71, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (63, '2022-09-30 20:33:36.827000', 1, 71, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (64, '2022-09-30 20:33:48.164000', 1, 72, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (65, '2022-09-30 20:33:48.166000', 1, 73, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (66, '2022-09-30 20:33:48.178000', 1, 72, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (67, '2022-09-30 20:33:48.181000', 1, 73, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (68, '2022-09-30 20:34:31.744000', 123, 74, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (69, '2022-09-30 20:34:31.747000', 123, 75, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (70, '2022-09-30 20:34:31.748000', 123, 76, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (71, '2022-09-30 20:34:31.750000', 123, 74, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (72, '2022-09-30 20:34:31.752000', 123, 75, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (73, '2022-09-30 20:34:31.754000', 123, 76, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (74, '2022-09-30 20:36:02.690000', 123, 77, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (75, '2022-09-30 20:36:02.696000', 123, 78, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (76, '2022-09-30 20:36:02.712000', 123, 77, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (77, '2022-09-30 20:36:02.715000', 123, 78, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (78, '2022-09-30 20:36:16.483000', 123, 79, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (79, '2022-09-30 20:36:16.498000', 123, 79, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (80, '2022-09-30 20:36:33.081000', 123, 80, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (81, '2022-09-30 20:36:33.084000', 123, 80, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (82, '2022-09-30 20:39:15.125000', 123, 81, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (83, '2022-09-30 20:39:15.133000', 123, 82, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (84, '2022-09-30 20:39:15.145000', 123, 81, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (85, '2022-09-30 20:39:15.148000', 123, 82, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (86, '2022-09-30 20:39:34.447000', 123, 83, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (87, '2022-09-30 20:39:34.450000', 123, 83, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (88, '2022-09-30 20:40:47.096000', 123, 84, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (89, '2022-09-30 20:40:47.098000', 123, 85, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (90, '2022-09-30 20:40:47.101000', 123, 84, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (91, '2022-09-30 20:40:47.103000', 123, 85, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (92, '2022-09-30 20:40:54.685000', 123, 86, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (93, '2022-09-30 20:40:54.689000', 123, 86, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (94, '2022-09-30 20:41:13.406000', 123, 87, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (95, '2022-09-30 20:41:13.408000', 123, 88, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (96, '2022-09-30 20:41:13.413000', 123, 87, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (97, '2022-09-30 20:41:13.416000', 123, 88, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (98, '2022-09-30 20:41:22.788000', 1, 89, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (99, '2022-09-30 20:41:22.791000', 1, 89, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (100, '2022-09-30 20:43:01.750000', 123, 90, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (101, '2022-09-30 20:43:01.786000', 123, 90, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (102, '2022-09-30 20:43:11.572000', 123, 91, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (103, '2022-09-30 20:43:11.574000', 123, 92, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (104, '2022-09-30 20:43:11.583000', 123, 91, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (105, '2022-09-30 20:43:11.586000', 123, 92, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (106, '2022-09-30 20:43:18.647000', 1, 93, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (107, '2022-09-30 20:43:18.650000', 1, 93, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (108, '2022-09-30 20:46:33.117000', 1, 94, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (109, '2022-09-30 20:46:33.127000', 1, 94, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (110, '2022-09-30 20:46:45.086000', 1, 95, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (111, '2022-09-30 20:46:45.099000', 1, 95, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (112, '2022-09-30 20:52:15.948000', 1, 96, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (113, '2022-09-30 20:52:21.507000', 1, 97, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (114, '2022-09-30 20:52:31.260000', 1, 98, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (115, '2022-09-30 20:52:31.261000', 2, 99, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (116, '2022-09-30 21:45:10.075000', 1, 109, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (117, '2022-09-30 21:48:08.367000', -10, 112, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (118, '2022-09-30 21:48:47.394000', 5, 113, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (119, '2022-09-30 21:53:18.815000', 5, 114, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (120, '2022-09-30 21:54:05.611000', -1, 115, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (121, '2022-09-30 21:55:09.443000', -1, 116, null);
INSERT INTO clinilog.movimentacao (id, data_cadastro, qtd_movimentada, batch_id, product_id) VALUES (122, '2022-08-04 00:00:00.000000', 500, 117, null);