CREATE TABLE carros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    velocidade_maxima DECIMAL(10, 2) NOT NULL,
    descricao TEXT
);

SELECT * FROM plone.computador;
CREATE TABLE computador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    programa VARCHAR(50) NOT NULL
);

SELECT * FROM plone.computador_comp;
CREATE TABLE computador_comp (
    id INT AUTO_INCREMENT PRIMARY KEY,
    componentes VARCHAR(50) NOT NULL,
	uso TINYINT
);

ALTER TABLE computador DROP COLUMN componentes;

INSERT INTO computador (programa) VALUES ('Cs.exe');

INSERT INTO computador_comp (componentes, uso) VALUES ('GPU', 0);
INSERT INTO computador_comp (componentes, uso) VALUES ('CPU', 0);
