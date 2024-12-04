use ifood;
CREATE TABLE endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(60),
    bairro VARCHAR(30),
    numero VARCHAR(10),
    cidade VARCHAR(60),
    estado VARCHAR(30),
    pontoReferencia VARCHAR(60),
    complemento VARCHAR(60),
    cep VARCHAR(11),
    tipo_endereco ENUM('casa', 'apartamento', 'comercial')
);
CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    descricao TEXT,
    tipo_categoria ENUM('restaurante', 'produto')
);
CREATE TABLE restaurante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    telefone VARCHAR(15),
    hora_funcionamento TIME,
    id_endereco_restaurante INT,
    is_retirada BOOLEAN,
    id_categoria INT,
    valorMinimoEntrega FLOAT,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id),
    FOREIGN KEY (id_endereco_restaurante) REFERENCES endereco(id)
);
CREATE TABLE promocao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60),
    codigo VARCHAR(30),
    valor FLOAT,
    validade DATE,
    tipo VARCHAR(30)
);
CREATE TABLE acompanhamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    descricao TEXT,
    valor FLOAT
);
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    preco FLOAT,
    id_categoria INT,
    id_restaurante INT,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id),
    FOREIGN KEY (id_restaurante) REFERENCES restaurante(id)
);

CREATE TABLE produtoAcompanhamento (
    id_produto INT, 
    id_acompanhamento INT,
    PRIMARY KEY(id_produto, id_acompanhamento),
    FOREIGN KEY (id_produto) REFERENCES produtos(id),
    FOREIGN KEY (id_acompanhamento) REFERENCES acompanhamento(id)
);

CREATE TABLE formaPagamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    forma VARCHAR(60)
);
CREATE TABLE restaurantePagamento (
    id_restaurante INT,
    id_forma_pagamento INT,
    PRIMARY KEY (id_restaurante, id_forma_pagamento),
    FOREIGN KEY (id_restaurante) REFERENCES restaurante(id),
    FOREIGN KEY (id_forma_pagamento) REFERENCES formaPagamento(id)
);
CREATE TABLE historicoDePagamento (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dataPagamento DATE,
    id_forma_pagamento INT,
    valor FLOAT,
    FOREIGN KEY (id_forma_pagamento) REFERENCES formaPagamento(id)
);

CREATE TABLE statusEntrega (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60)
);
CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    dataPedido DATE,
    id_restaurante INT,
    valor FLOAT,
    taxaEntrega FLOAT,
    id_promocao INT,
    id_forma_pagamento INT,
    observacoes TEXT,
    troco FLOAT,
    id_status_entrega INT,
    id_endereco INT,
    FOREIGN KEY (id_restaurante) REFERENCES restaurante(id),
    FOREIGN KEY (id_promocao) REFERENCES promocao(id),
    FOREIGN KEY (id_forma_pagamento) REFERENCES formaPagamento(id),
    FOREIGN KEY (id_status_entrega) REFERENCES statusEntrega(id),
    FOREIGN KEY (id_endereco) REFERENCES endereco(id)
);

CREATE TABLE historicoDeEntregas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_status_entrega INT,
    detalhes text,
    id_pedido INT,
    data_hora DATETIME, 
    FOREIGN KEY (id_status_entrega) REFERENCES statusEntrega(id),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id)
);
CREATE TABLE avaliacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nota INT,
    id_pedido INT,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id)
);
CREATE TABLE pedidoProduto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT,
    id_produto INT,
    quantidade INT,
    FOREIGN KEY (id_pedido) REFERENCES pedido(id),
    FOREIGN KEY (id_produto) REFERENCES produtos(id)
);

CREATE TABLE pedidoProdutoAcompanhamento (
    id_pedido_produto INT,
    id_acompanhamento INT,
    PRIMARY KEY (id_pedido_produto, id_acompanhamento),
    FOREIGN KEY (id_pedido_produto) REFERENCES pedidoProduto(id),
    FOREIGN KEY (id_acompanhamento) REFERENCES acompanhamento(id)
);

INSERT INTO endereco (rua, bairro, numero, cidade, estado, pontoReferencia, complemento, cep, tipo_endereco) VALUES 
('Av. Paulista', 'Bela Vista', '1578', 'São Paulo', 'SP', 'Próximo ao MASP', 'Bloco A, Apto 21', '01310-200', 'apartamento'),
('Rua das Flores', 'Centro', '85', 'Rio de Janeiro', 'RJ', 'Ao lado do mercado central', '', '20040-020', 'comercial'),
('Rua dos Pinhais', 'Boa Vista', '742', 'Curitiba', 'PR', 'Próximo ao parque', '', '80540-020', 'casa'),
('Av. das Torres', 'Jardim Primavera', '1050', 'Campinas', 'SP', 'Esquina com Rua Central', '', '13040-140', 'comercial'),
('Rua São José', 'Centro', '400', 'Belo Horizonte', 'MG', 'Em frente ao teatro', 'Loja 10', '30180-110', 'comercial'),
('Rua Esperança', 'Santa Clara', '567', 'Fortaleza', 'CE', 'Próximo à escola estadual', 'Casa 3', '60170-020', 'casa'),
('Rua Imperial', 'Jardins', '305', 'Salvador', 'BA', 'Perto do shopping', '', '40150-150', 'apartamento'),
('Rua Bahia', 'Boa Vista', '25', 'Recife', 'PE', 'Próximo à academia', '', '50060-250', 'casa'),
('Rua Aurora', 'Centro', '130', 'Porto Alegre', 'RS', 'Próximo ao hospital', '', '90020-070', 'comercial'),
('Av. do Contorno', 'Savassi', '900', 'Belo Horizonte', 'MG', 'Esquina com Rua da Serra', '', '30110-040', 'comercial');


INSERT INTO categoria (nome, descricao, tipo_categoria) VALUES 
('Lanches', 'Hambúrgueres, sanduíches e afins', 'restaurante'),
('Pizzas', 'Diversos tipos de pizzas', 'restaurante'),
('Doces', 'Sobremesas e confeitaria', 'produto'),
('Bebidas', 'Refrigerantes, sucos e afins', 'produto'),
('Pratos Executivos', 'Comidas completas para almoço', 'restaurante'),
('Salgados', 'Coxinhas, empadas e outros', 'produto'),
('Vegetariano', 'Pratos e produtos vegetarianos', 'restaurante'),
('Comida Japonesa', 'Sushis e outros pratos japoneses', 'restaurante'),
('Frutos do Mar', 'Pratos à base de frutos do mar', 'restaurante'),
('Italiano', 'Massas e pratos italianos', 'restaurante');


INSERT INTO restaurante (nome, telefone, hora_funcionamento, id_endereco_restaurante, is_retirada, id_categoria, valorMinimoEntrega) VALUES 
('Lanchonete Central', '11987654321', '10:00:00', 1, TRUE, 1, 20.0),
('Pizzaria Nova', '21912345678', '18:00:00', 2, FALSE, 2, 30.0),
('Doceria Amor', '41956789012', '09:00:00', 3, TRUE, 3, 10.0),
('Restaurante Gourmet', '31987654321', '11:30:00', 4, TRUE, 5, 40.0),
('Bistrô Elegância', '85912398765', '12:00:00', 5, TRUE, 6, 50.0),
('Café Colonial', '71945678901', '08:00:00', 6, TRUE, 4, 15.0),
('Vegano Verde', '31965432100', '11:00:00', 7, TRUE, 7, 35.0),
('Sushi Master', '51998765432', '17:00:00', 8, TRUE, 8, 45.0),
('Mariscos da Praia', '71978945612', '12:00:00', 9, TRUE, 9, 50.0),
('Cantina Italiana', '31912378900', '12:30:00', 10, TRUE, 10, 25.0);


INSERT INTO promocao (nome, codigo, valor, validade, tipo) VALUES 
('Desconto Especial', 'DESC20', 20.0, '2024-12-31', 'Desconto'),
('Black Friday', 'BLACK50', 50.0, '2024-11-30', 'Desconto'),
('Frete Grátis', 'FRETEGRATIS', 15.0, '2024-12-31', 'Frete'),
('Combo Família', 'FAMILIA10', 10.0, '2024-12-31', 'Combo'),
('Promoção Dia dos Pais', 'PAIS15', 15.0, '2024-08-31', 'Desconto'),
('Cupom de Verão', 'VERAO20', 20.0, '2024-03-31', 'Desconto'),
('Inverno Quentinho', 'INVERNO10', 10.0, '2024-07-31', 'Desconto'),
('Aniversário da Cidade', 'CIDADE30', 30.0, '2024-10-31', 'Desconto'),
('Amigos Reunidos', 'AMIGOS25', 25.0, '2024-05-31', 'Combo'),
('Prato do Dia', 'PRATODIA5', 5.0, '2024-12-31', 'Desconto');



INSERT INTO acompanhamento (nome, descricao, valor) VALUES 
('Molho Especial', 'Molho da casa feito com ingredientes secretos', 2.50),
('Batata Frita', 'Porção de batata frita crocante', 8.00),
('Salada Verde', 'Mix de folhas frescas com molho opcional', 5.00),
('Arroz', 'Porção de arroz branco', 3.00),
('Feijão', 'Porção de feijão temperado', 3.00),
('Molho Apimentado', 'Molho com pimenta especial', 2.00),
('Farofa', 'Farofa crocante com bacon', 4.00),
('Pão de Alho', 'Porção de pão de alho assado', 6.00),
('Refrigerante', 'Lata de refrigerante 350ml', 5.00),
('Bebida Gelada', 'Opções de bebidas como água e sucos', 4.00);


INSERT INTO produtos (nome, preco, id_categoria, id_restaurante) VALUES
('Cheeseburguer Especial', 28.00, 1, 1),
('Batata Frita Grande', 10.00, 1, 1),
('Milkshake de Morango', 12.00, 1, 1),
('Pizza Marguerita', 38.00, 2, 2),
('Pizza Portuguesa', 42.00, 2, 2),
('Pizza Doce com Chocolate', 35.00, 2, 2),
('Brownie com Sorvete', 18.00, 3, 3),
('Cheesecake de Frutas Vermelhas', 20.00, 3, 3),
('Mousse de Maracujá', 12.00, 3, 3),
('Refrigerante Lata', 6.00, 4, 6),
('Água com Gás', 4.50, 4, 6),
('Cerveja Artesanal', 15.00, 4, 6),
('Peito de Frango Grelhado', 32.00, 5, 4),
('Arroz à Piamontese', 38.00, 5, 4),
('Carne de Panela com Legumes', 40.00, 5, 4),
('Kibe Frito', 4.00, 6, 5),
('Empada de Palmito', 6.00, 6, 5),
('Mini Pastel Variado', 8.00, 6, 5),
('Quiche de Espinafre', 25.00, 7, 7),
('Hambúrguer de Grão-de-Bico', 35.00, 7, 7),
('Cuscuz Marroquino com Legumes', 30.00, 7, 7),
('Temaki de Salmão', 20.00, 8, 8),
('Uramaki Califórnia', 22.00, 8, 8),
('Yakissoba de Frango', 25.00, 8, 8),
('Risoto de Camarão', 75.00, 9, 9),
('Filé de Peixe ao Molho', 65.00, 9, 9),
('Lagosta Grelhada', 120.00, 9, 9),
('Fettuccine Alfredo', 50.00, 10, 10),
('Ravioli de Queijo', 55.00, 10, 10),
('Nhoque ao Sugo', 45.00, 10, 10);


INSERT INTO statusEntrega (nome) VALUES 
('Aguardando Confirmação'),
('Preparando Pedido'),
('Saiu para Entrega'),
('Entregue'),
('Cancelado');


INSERT INTO formaPagamento (forma) VALUES
('Cartao de Crédito'),
('Cartao de Débito'),
('Dinheiro'),
('Pix'),
('Vale Refeiçao'),
('Vale Alimentaçao'),
('Crédito Online');
SELECT * FROM formaPagamento;

INSERT INTO pedido (dataPedido, id_restaurante, valor, taxaEntrega, id_promocao, id_forma_pagamento, observacoes, troco, id_status_entrega, id_endereco) VALUES
('2024-01-10', 3, 30.00, 5.00, 3, 1, 'Entrega rápida', 0.00, 4, 3),
('2024-01-15', 4, 70.00, 10.00, 4, 2, 'Troco para 100', 100.00, 2, 4),
('2024-01-20', 5, 85.00, 12.00, NULL, 1, '', 0.00, 3, 5),
('2024-01-22', 6, 25.00, 5.00, 5, 2, 'Sem salada', 0.00, 4, 6),
('2024-01-25', 7, 40.00, 7.00, NULL, 1, '', 0.00, 4, 7),
('2024-01-28', 8, 90.00, 15.00, 6, 2, 'Sem wasabi', 0.00, 3, 8),
('2024-01-30', 9, 110.00, 18.00, NULL, 1, '', 0.00, 4, 9),
('2024-01-31', 10, 65.00, 10.00, 7, 1, '', 0.00, 4, 10),
('2024-02-05', 1, 50.00, 5.00, 1, 2, '', 0.00, 4, 1),
('2024-02-08', 2, 45.00, 6.00, 2, 1, '', 0.00, 3, 2),
('2024-02-12', 3, 35.00, 5.00, NULL, 1, 'Sem glacê', 0.00, 4, 3),
('2024-02-15', 4, 100.00, 15.00, 3, 2, 'Troco para 120', 120.00, 2, 4),
('2024-02-18', 5, 80.00, 12.00, NULL, 1, '', 0.00, 4, 5),
('2024-02-20', 6, 20.00, 5.00, 4, 2, 'Adicionar molho', 0.00, 4, 6),
('2024-02-22', 7, 45.00, 8.00, NULL, 1, '', 0.00, 4, 7),
('2024-02-25', 8, 85.00, 15.00, 5, 2, '', 0.00, 4, 8),
('2024-02-28', 9, 100.00, 20.00, NULL, 1, '', 0.00, 4, 9),
('2024-02-29', 10, 60.00, 10.00, 6, 2, '', 0.00, 4, 10),
('2024-03-03', 1, 55.00, 5.00, 7, 1, '', 0.00, 4, 1),
('2024-03-07', 2, 60.00, 7.00, 1, 2, '', 0.00, 4, 2),
('2024-03-10', 3, 40.00, 5.00, NULL, 1, 'Sem cobertura', 0.00, 4, 3),
('2024-03-15', 4, 90.00, 10.00, 3, 2, 'Troco para 100', 100.00, 4, 4),
('2024-03-18', 5, 85.00, 12.00, NULL, 1, '', 0.00, 4, 5),
('2024-03-20', 6, 22.00, 5.00, 4, 2, '', 0.00, 4, 6),
('2024-03-22', 7, 50.00, 8.00, 2, 1, '', 0.00, 4, 7),
('2024-03-25', 8, 100.00, 15.00, NULL, 2, '', 0.00, 4, 8),
('2024-03-28', 9, 120.00, 20.00, NULL, 1, '', 0.00, 4, 9),
('2024-03-30', 10, 75.00, 10.00, 6, 1, '', 0.00, 4, 10),
('2024-04-02', 1, 60.00, 5.00, 1, 1, '', 0.00, 4, 1),
('2024-04-05', 2, 70.00, 8.00, NULL, 2, '', 0.00, 3, 2),
('2024-04-09', 3, 45.00, 6.00, NULL, 1, '', 0.00, 4, 3),
('2024-04-12', 4, 95.00, 10.00, 2, 2, '', 0.00, 4, 4),
('2024-04-15', 5, 85.00, 12.00, 5, 1, '', 0.00, 4, 5),
('2024-04-18', 6, 25.00, 5.00, 3, 2, 'Sem cebola', 0.00, 4, 6),
('2024-04-20', 7, 50.00, 7.00, NULL, 1, '', 0.00, 4, 7),
('2024-04-23', 8, 110.00, 15.00, NULL, 2, '', 0.00, 4, 8),
('2024-04-26', 9, 125.00, 20.00, NULL, 1, '', 0.00, 4, 9),
('2024-04-30', 10, 80.00, 10.00, 6, 1, '', 0.00, 4, 10),
('2024-05-03', 1, 65.00, 5.00, 7, 2, '', 0.00, 4, 1),
('2024-05-07', 2, 55.00, 6.00, NULL, 1, '', 0.00, 4, 2),
('2024-05-10', 3, 30.00, 5.00, NULL, 2, '', 0.00, 4, 3),
('2024-05-12', 4, 100.00, 12.00, 3, 1, '', 0.00, 4, 4),
('2024-05-15', 5, 80.00, 15.00, NULL, 2, '', 0.00, 4, 5),
('2024-05-18', 6, 20.00, 5.00, 2, 1, 'Troco para 50', 50.00, 4, 6),
('2024-05-20', 7, 60.00, 7.00, NULL, 1, '', 0.00, 4, 7),
('2024-05-22', 8, 120.00, 15.00, 5, 2, '', 0.00, 4, 8),
('2024-05-25', 9, 130.00, 20.00, NULL, 1, '', 0.00, 4, 9),
('2024-05-30', 10, 90.00, 10.00, NULL, 2, '', 0.00, 4, 10),
('2024-06-02', 1, 50.00, 5.00, 1, 2, '', 0.00, 4, 1),
('2024-06-05', 2, 65.00, 6.00, 2, 1, '', 0.00, 4, 2),
('2024-06-08', 3, 40.00, 5.00, NULL, 2, '', 0.00, 4, 3),
('2024-06-10', 4, 105.00, 15.00, 3, 1, '', 0.00, 4, 4),
('2024-06-13', 5, 90.00, 12.00, NULL, 2, '', 0.00, 4, 5),
('2024-06-16', 6, 22.00, 5.00, NULL, 1, '', 0.00, 4, 6),
('2024-06-19', 7, 55.00, 7.00, 4, 2, '', 0.00, 4, 7),
('2024-06-22', 8, 115.00, 15.00, NULL, 1, '', 0.00, 4, 8),
('2024-06-25', 9, 120.00, 20.00, NULL, 2, '', 0.00, 4, 9),
('2024-06-28', 10, 70.00, 10.00, 7, 1, '', 0.00, 4, 10),
('2024-07-03', 1, 60.00, 5.00, 6, 1, '', 0.00, 4, 1),
('2024-07-07', 2, 70.00, 6.00, 1, 2, '', 0.00, 4, 2),
('2024-07-10', 3, 35.00, 5.00, 2, 1, '', 0.00, 4, 3),
('2024-07-12', 4, 95.00, 10.00, 3, 2, '', 0.00, 4, 4),
('2024-07-14', 5, 85.00, 12.00, 4, 1, '', 0.00, 4, 5),
('2024-07-18', 6, 25.00, 5.00, NULL, 1, '', 0.00, 4, 6),
('2024-07-20', 7, 50.00, 8.00, NULL, 2, '', 0.00, 4, 7),
('2024-07-23', 8, 110.00, 15.00, 5, 1, '', 0.00, 4, 8),
('2024-07-27', 9, 120.00, 20.00, NULL, 2, '', 0.00, 4, 9),
('2024-07-30', 10, 75.00, 10.00, NULL, 1, '', 0.00, 4, 10),
('2024-08-01', 1, 65.00, 5.00, 1, 2, '', 0.00, 4, 1),
('2024-08-04', 2, 55.00, 6.00, NULL, 1, '', 0.00, 4, 2),
('2024-08-07', 3, 40.00, 5.00, 6, 2, '', 0.00, 4, 3),
('2024-08-10', 4, 90.00, 10.00, 7, 1, '', 0.00, 4, 4),
('2024-08-13', 5, 80.00, 12.00, NULL, 2, '', 0.00, 4, 5),
('2024-08-17', 6, 20.00, 5.00, 3, 1, '', 0.00, 4, 6),
('2024-08-20', 7, 55.00, 8.00, NULL, 2, '', 0.00, 4, 7),
('2024-08-22', 8, 115.00, 15.00, NULL, 1, '', 0.00, 4, 8),
('2024-08-26', 9, 125.00, 20.00, NULL, 2, '', 0.00, 4, 9),
('2024-08-30', 10, 80.00, 10.00, 4, 1, '', 0.00, 4, 10),
('2024-09-02', 1, 60.00, 5.00, NULL, 1, '', 0.00, 4, 1),
('2024-09-05', 2, 70.00, 6.00, 2, 2, '', 0.00, 4, 2),
('2024-09-07', 3, 45.00, 5.00, NULL, 1, '', 0.00, 4, 3),
('2024-09-10', 4, 100.00, 12.00, 3, 2, '', 0.00, 4, 4),
('2024-09-14', 5, 85.00, 15.00, 5, 1, '', 0.00, 4, 5),
('2024-09-17', 6, 22.00, 5.00, NULL, 2, '', 0.00, 4, 6),
('2024-09-20', 7, 50.00, 7.00, NULL, 1, '', 0.00, 4, 7),
('2024-09-23', 8, 110.00, 15.00, NULL, 2, '', 0.00, 4, 8),
('2024-09-26', 9, 120.00, 20.00, NULL, 1, '', 0.00, 4, 9),
('2024-09-30', 10, 70.00, 10.00, NULL, 2, '', 0.00, 4, 10),
('2024-10-02', 1, 65.00, 5.00, NULL, 2, '', 0.00, 4, 1),
('2024-10-05', 2, 60.00, 6.00, 7, 1, '', 0.00, 4, 2),
('2024-10-08', 3, 40.00, 5.00, NULL, 2, '', 0.00, 4, 3),
('2024-10-12', 4, 95.00, 10.00, 6, 1, '', 0.00, 4, 4),
('2024-10-14', 5, 90.00, 12.00, NULL, 2, '', 0.00, 4, 5),
('2024-10-18', 6, 25.00, 5.00, NULL, 1, '', 0.00, 4, 6),
('2024-10-21', 7, 55.00, 8.00, NULL, 2, '', 0.00, 4, 7),
('2024-10-23', 8, 120.00, 15.00, 4, 1, '', 0.00, 4, 8),
('2024-10-27', 9, 130.00, 20.00, NULL, 2, '', 0.00, 4, 9),
('2024-10-31', 10, 80.00, 10.00, NULL, 1, '', 0.00, 4, 10),
('2024-11-01', 1, 70.00, 5.00, 3, 1, '', 0.00, 4, 1),
('2024-11-04', 2, 50.00, 6.00, NULL, 2, '', 0.00, 4, 2),
('2024-11-08', 3, 35.00, 5.00, NULL, 1, '', 0.00, 4, 3),
('2024-11-12', 4, 105.00, 15.00, 5, 2, '', 0.00, 4, 4),
('2024-11-15', 5, 85.00, 12.00, NULL, 1, '', 0.00, 4, 5),
('2024-11-18', 6, 30.00, 5.00, 7, 2, '', 0.00, 4, 6),
('2024-11-20', 7, 60.00, 8.00, NULL, 1, '', 0.00, 4, 7),
('2024-11-23', 8, 115.00, 15.00, NULL, 2, '', 0.00, 4, 8),
('2024-11-26', 9, 125.00, 20.00, NULL, 1, '', 0.00, 4, 9),
('2024-11-30', 10, 75.00, 10.00, NULL, 2, '', 0.00, 4, 10),
('2024-12-01', 1, 65.00, 5.00, 6, 2, '', 0.00, 4, 1),
('2024-12-03', 2, 55.00, 6.00, NULL, 1, '', 0.00, 4, 2),
('2024-12-07', 3, 45.00, 5.00, 4, 2, '', 0.00, 4, 3),
('2024-12-10', 4, 95.00, 10.00, 5, 1, '', 0.00, 4, 4),
('2024-12-13', 5, 85.00, 12.00, NULL, 2, '', 0.00, 4, 5),
('2024-12-16', 6, 20.00, 5.00, 7, 1, '', 0.00, 4, 6),
('2024-12-19', 7, 60.00, 8.00, NULL, 2, '', 0.00, 4, 7),
('2024-12-22', 8, 120.00, 15.00, NULL, 1, '', 0.00, 4, 8),
('2024-12-27', 9, 130.00, 20.00, NULL, 2, '', 0.00, 4, 9),
('2024-12-31', 10, 90.00, 10.00, 3, 1, '', 0.00, 4, 10);


INSERT INTO historicoDePagamento (dataPagamento, id_forma_pagamento, valor) VALUES
('2024-11-25', 1, 120.50),
('2024-11-26', 2, 45.00),
('2024-11-27', 3, 78.25),
('2024-11-28', 4, 150.00),
('2024-11-29', 1, 60.75),
('2024-11-30', 2, 98.30),
('2024-12-01', 3, 250.00),
('2024-12-02', 4, 180.40),
('2024-12-03', 1, 300.90),
('2024-12-04', 2, 75.50);


INSERT INTO historicoDeEntregas (id_status_entrega, detalhes, id_pedido, data_hora) VALUES
(1, 'Pedido foi realizado e aguardando aprovação.', 1, '2024-01-10 12:00:00'),
(2, 'Pedido está sendo preparado pela cozinha.', 1, '2024-01-10 12:20:00'),
(3, 'Entregador saiu com o pedido.', 1, '2024-01-10 12:45:00'),
(4, 'Pedido foi entregue ao cliente.', 1, '2024-01-10 13:15:00'),
(1, 'Pedido foi realizado e aguardando aprovação.', 2, '2024-01-15 11:00:00'),
(2, 'Pedido está sendo preparado pela cozinha.', 2, '2024-01-15 11:30:00'),
(3, 'Entregador saiu com o pedido.', 2, '2024-01-15 11:50:00'),
(4, 'Pedido foi entregue ao cliente.', 2, '2024-01-15 12:30:00'),
(1, 'Pedido foi realizado e aguardando aprovação.', 3, '2024-01-20 19:00:00'),
(2, 'Pedido está sendo preparado pela cozinha.', 3, '2024-01-20 19:20:00'),
(3, 'Entregador saiu com o pedido.', 3, '2024-01-20 19:45:00'),
(4, 'Pedido foi entregue ao cliente.', 3, '2024-01-20 20:15:00'),
(1, 'Pedido foi realizado e aguardando aprovação.', 4, '2024-01-22 14:00:00'),
(2, 'Pedido está sendo preparado pela cozinha.', 4, '2024-01-22 14:20:00'),
(3, 'Entregador saiu com o pedido.', 4, '2024-01-22 14:50:00'),
(4, 'Pedido foi entregue ao cliente.', 4, '2024-01-22 15:30:00'),
(1, 'Pedido foi realizado e aguardando aprovação.', 5, '2024-01-25 16:10:00'),
(2, 'Pedido está sendo preparado pela cozinha.', 5, '2024-01-25 16:30:00'),
(3, 'Entregador saiu com o pedido.', 5, '2024-01-25 17:00:00'),
(4, 'Pedido foi entregue ao cliente.', 5, '2024-01-25 17:30:00');


INSERT INTO avaliacao (nota, id_pedido) VALUES
(5, 1),
(4, 2),
(3, 3),
(5, 4),
(2, 5),
(4, 6),
(5, 7),
(3, 8),
(1, 9),
(4, 10);


INSERT INTO pedidoProduto (id_pedido, id_produto, quantidade) VALUES
(1, 3, 2),
(2, 5, 1),
(3, 8, 4),
(4, 2, 3),
(5, 6, 1),
(6, 7, 5),
(7, 4, 2),
(8, 1, 1),
(9, 9, 3),
(10, 10, 2);

SELECT * FROM endereco;
UPDATE endereco
SET rua = 'Rua São José',
	bairro = 'Santa Clara'
WHERE id = 1;


SELECT * FROM categoria;
UPDATE categoria
SET nome = 'Comida Japonesa',
	descricao = 'Comidas completas para almoço'
WHERE id = 1;


SELECT * FROM restaurante;
UPDATE restaurante
SET nome = 'Lanchonete da odete',
	telefone = '45645635435'
WHERE id = 1;


SELECT * FROM promocao;
UPDATE promocao
SET nome = 'Desconto 10%',
	codigo = 'DESCONTAO10'
WHERE id = 1;


SELECT * FROM acompanhamento;
UPDATE acompanhamento
SET nome = 'Molho picante',
	descricao = 'Molho extra ardente'
WHERE id = 1;


SELECT * FROM produtos;
UPDATE produtos
SET nome = 'Mega burger',
	preco = '30.00'
WHERE id = 1;


SELECT * FROM statusEntrega;

SELECT * FROM pedido;
UPDATE pedido
SET observacoes = 'Mega burger',
	troco = '50.00'
WHERE id = 1;


SELECT * FROM historicoDeEntregas;
UPDATE historicoDeEntregas
SET detalhes = 'aprovacao concluida'
WHERE id = 1;


SELECT * FROM avaliacao;
UPDATE avaliacao
SET nota = '5'
WHERE id_pedido = 9;



SELECT * FROM pedidoProduto;
UPDATE pedidoProduto
SET quantidade = '6'
WHERE id_pedido = 9;

DELETE FROM pedidoProduto WHERE id_pedido = 1;
DELETE FROM pedidoProduto WHERE id_produto = 1;
DELETE FROM avaliacao WHERE id_pedido = 1;
DELETE FROM historicoDeEntregas WHERE id = 1;
DELETE FROM historicoDeEntregas WHERE id_status_entrega = 1;
DELETE FROM historicoDeEntregas WHERE id_pedido = 1;
DELETE FROM statusEntrega WHERE id = 1;
DELETE FROM pedido WHERE id = 1;
DELETE FROM produtos WHERE id = 1;
DELETE FROM acompanhamento WHERE id = 1;


select
p.nome as produto,
sum(pp.quantidade) as total
from pedidoProduto pp
inner join produtos p on pp.id_produto = p.id
group by produto
order by total desc
limit 6;

select 
p.nome as produto,
sum(pp.quantidade) as total
from pedidoProduto pp
inner join produtos p on pp.id_produto = p.id
group by produto
order by total asc
limit 5;

select
month(p.dataPedido) as mes,
count(p.id) as total
from pedido p
group by mes
order by total desc
limit 1;

SELECT 
COUNT(p.id) as total_usos,
fp.forma as pagamento
FROM pedido p
INNER JOIN formaPagamento fp ON p.id_forma_pagamento = fp.id
group by pagamento
order by total_usos desc
limit 1;


select
count(h.id) as total,
e.rua as lugar
from historicoDeEntregas h
inner join endereco e on h.id_pedido = e.id
group by lugar
order by total desc
limit 1;

select
p.id as numero_pedido,
sum(pp.quantidade) as quant,
ppp.nome as nomeDoProduto
from pedido p
inner join pedidoProduto pp on p.id = pp.id_pedido
inner join produtos ppp on p.id = ppp.id
group by numero_pedido, nomeDoProduto
order by quant desc
limit 1;

select
fp.forma as formadePagamento,
count(p.id) as totalDosPedidos,
month(dataPedido) as mes
from pedido p
inner join formaPagamento fp on p.id_forma_pagamento = fp.id
where month(dataPedido) = month(curdate())
group by formadePagamento, mes
order by totalDosPedidos desc
limit 1;

select
fp.forma as formadePagamento,
count(p.id) as totalDosPedidos,
month(dataPedido) as mes
from pedido p
inner join formaPagamento fp on p.id_forma_pagamento = fp.id
where month(dataPedido) = month(curdate())
group by formadePagamento, mes
order by totalDosPedidos desc
limit 1;







