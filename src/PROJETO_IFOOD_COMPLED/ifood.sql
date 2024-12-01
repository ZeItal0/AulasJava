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


INSERT INTO formaPagamento (forma) VALUES
('Cartao de Crédito'),
('Cartao de Débito'),
('Dinheiro'),
('Pix'),
('Vale Refeiçao'),
('Vale Alimentaçao'),
('Crédito Online');

SELECT * FROM formaPagamento;

SELECT * FROM historicoDeEntregas;

SELECT * FROM endereco;

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

SELECT * FROM pedido;

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

