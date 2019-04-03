-- 1) Primeira questão:
--           
--    tb_customer          ->     id_customer
--    dm_address_type      ->     cd_address_type
--    tb_customer_address  ->     cd_address_type && id_customer



-- 2) Segunda Questão:
--
-- insert into tb_customer(nm_customer, cpf_cnpj) values('Joaozinho Silva', '88877766655');
--
-- insert into tb_customer_address (id_customer, cd_address_type, street, lot, reference, zip_code)
-- values( select id_customer from tb_customer where cpf_cnpj = '88877766655') , 'R', 'Rua das Flores', 1, NULL, '01234567')

--  
-- insert into tb_customer_address (id_customer, cd_address_type, street, lot, reference,zip_code)
-- values( select id_customer from tb_customer where cpf_cnpj = '88877766655') , 'C', 'Rua das Pedras', 100, 'Conjunto 200','01234567')



-- 3) Terceira questão:
-- R:) Considerando o modelo de dados, só podem existir três endereços diferentes, um para cada tipo de endereço.



-- 4)Quarta questão:

--  delete from tb_customer where cpf_cnpj = '88877766655';

