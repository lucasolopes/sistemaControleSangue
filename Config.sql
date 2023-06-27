use wkdb;
insert into perfil (nome) values ('ROLE_USUARIO');
insert into perfil (nome) values ('ROLE_MODERADOR');
insert into usuario (email, nome, senha) values ('teste@teste.com','teste','$2a$12$wWpl6wGvf/e841IejjxVO.nhSX75ptf8QHk3fMJJroD/AarBqO72G');
insert into usuario_perfis (usuario_id,perfis_id) values (1,2);