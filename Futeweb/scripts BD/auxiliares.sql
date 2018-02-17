use futeweb;

select * from endereco;
select * from Estabelecimento;
select * from Material;
select * from Quadra;
select * from Usuario;
select * from Pessoa_Fisica;
select * from Pessoa_Juridica;
select * from Estabelecimento_Pessoa_Juridica;
select * from Disponibilidade_Quadra;
select * from Disponibilidade_Material;
select * from Reserva;

commit;

delete from endereco;
delete from Estabelecimento where id >= 1;
delete from Material where id >= 1;
delete from Quadra where id >= 1;
delete from Usuario where id >= 1;
delete from Pessoa_Fisica where id >= 1;
delete from Pessoa_Juridica where id >= 1;
delete from Estabelecimento_Pessoa_Juridica where id_pessoa_juridica >= 1 or id_estabelecimento >= 1;
delete from Disponibilidade_Quadra where id >= 1;
delete from Disponibilidade_Material where id >= 1;
delete from Reserva where id >= 1;

commit;
