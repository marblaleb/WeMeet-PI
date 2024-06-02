CREATE TABLE actividad (
    dificultad FLOAT NOT NULL,
    duracion INT NOT NULL,
    tarifa FLOAT NOT NULL,
    fecha DATETIME NOT NULL,
    id BIGINT NOT NULL AUTO_INCREMENT,
    ofertante BIGINT NOT NULL,
    descripcion TEXT,
    hora VARCHAR(255) NOT NULL,
    lugar VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE actividad_consumidor (
    actividades_id BIGINT NOT NULL,
    consumidor_id_consumidor BIGINT NOT NULL,
    PRIMARY KEY (actividades_id, consumidor_id_consumidor)
);

CREATE TABLE categoria (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE categoria_actividades (
    actividades_id BIGINT NOT NULL,
    categorias_id BIGINT NOT NULL,
    PRIMARY KEY (actividades_id, categorias_id)
);

CREATE TABLE consumidor (
    id_consumidor BIGINT NOT NULL,
    PRIMARY KEY (id_consumidor)
);

CREATE TABLE foro (
    fecha DATE,
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_actividad BIGINT,
    id_ofertante BIGINT,
    descripcion VARCHAR(255),
    nombre VARCHAR(255),
    PRIMARY KEY (id),
    UNIQUE KEY UK_2hpp2ok4haoa33i0wx4hp2gxt (id_actividad),
    UNIQUE KEY UK_pu0q4wqnp6oa4cccbu9u45xhu (id_ofertante)
);

CREATE TABLE foro_consumidores (
    consumidores_id_consumidor BIGINT NOT NULL,
    foros_id BIGINT NOT NULL,
    PRIMARY KEY (consumidores_id_consumidor, foros_id)
);

CREATE TABLE intereses (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE intereses_consumidores (
    consumidores_id_consumidor BIGINT NOT NULL,
    intereses_id BIGINT NOT NULL,
    PRIMARY KEY (consumidores_id_consumidor, intereses_id)
);

CREATE TABLE intereses_ofertantes (
    intereses_id BIGINT NOT NULL,
    ofertantes_id_ofertante BIGINT NOT NULL,
    PRIMARY KEY (intereses_id, ofertantes_id_ofertante)
);

CREATE TABLE mensaje (
    foro_id BIGINT,
    id BIGINT NOT NULL AUTO_INCREMENT,
    usuario BIGINT,
    contenido VARCHAR(255) NOT NULL,
    titulo VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (foro_id) REFERENCES foro (id),
    FOREIGN KEY (usuario) REFERENCES usuario (id)
);

CREATE TABLE ofertantes (
    id_ofertante BIGINT NOT NULL,
    PRIMARY KEY (id_ofertante)
);

CREATE TABLE ofertas (
    consumidor BIGINT NOT NULL,
    id BIGINT NOT NULL AUTO_INCREMENT,
    ofertante BIGINT NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (consumidor) REFERENCES consumidor (id_consumidor),
    FOREIGN KEY (ofertante) REFERENCES ofertantes (id_ofertante)
);

CREATE TABLE rol (
    id BIGINT NOT NULL AUTO_INCREMENT,
    rol_nombre ENUM('ROLE_USER', 'ROLE_ADMIN') NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE rol_usuarios (
    roles_id BIGINT NOT NULL,
    usuarios_id BIGINT NOT NULL,
    PRIMARY KEY (roles_id, usuarios_id),
    FOREIGN KEY (usuarios_id) REFERENCES usuario (id),
    FOREIGN KEY (roles_id) REFERENCES rol (id)
);

CREATE TABLE usuario (
    activo BOOLEAN NOT NULL,
    id BIGINT NOT NULL AUTO_INCREMENT,
    apellidos VARCHAR(255) NOT NULL,
    ciudad VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    imagen_perfil VARCHAR(255),
    nombre VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255),
    telefono VARCHAR(255),
    usuario VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY UK_5171l57faosmj8myawaucatdw (email),
    UNIQUE KEY UK_i02kr8ui5pqddyd7pkm3v4jbt (usuario)
);

ALTER TABLE foro ADD CONSTRAINT FK_2hpp2ok4haoa33i0wx4hp2gxt FOREIGN KEY (id_actividad) REFERENCES actividad (id);
ALTER TABLE foro ADD CONSTRAINT FK_pu0q4wqnp6oa4cccbu9u45xhu FOREIGN KEY (id_ofertante) REFERENCES ofertantes (id_ofertante);
ALTER TABLE usuario ADD CONSTRAINT FK_5171l57faosmj8myawaucatdw FOREIGN KEY (email) REFERENCES usuario (id);
ALTER TABLE usuario ADD CONSTRAINT FK_i02kr8ui5pqddyd7pkm3v4jbt FOREIGN KEY (usuario) REFERENCES usuario (id);
ALTER TABLE actividad ADD CONSTRAINT FK_8a3rvfoq1o026pm79y93vne16 FOREIGN KEY (ofertante) REFERENCES ofertantes (id_ofertante);
ALTER TABLE actividad_consumidor ADD CONSTRAINT FK_qhb31y3w9j2mdmdu0sigkw9xq FOREIGN KEY (consumidor_id_consumidor) REFERENCES consumidor (id_consumidor);
ALTER TABLE actividad_consumidor ADD CONSTRAINT FK_gwqx83dht1pathruj72gc1u1v FOREIGN KEY (actividades_id) REFERENCES actividad (id);
ALTER TABLE categoria_actividades ADD CONSTRAINT FK_g71dnl8oxxjfaqaho5j9esbss FOREIGN KEY (actividades_id) REFERENCES actividad (id);
ALTER TABLE categoria_actividades ADD CONSTRAINT FK_4f1y5ymwebjwoqvawc6omicm3 FOREIGN KEY (categorias_id) REFERENCES categoria (id);
ALTER TABLE consumidor ADD CONSTRAINT FK_aomcp22eap9toykxctvaan2fo FOREIGN KEY (id_consumidor) REFERENCES usuario (id);
ALTER TABLE foro ADD CONSTRAINT FK_las1y392h3bh6xehwp9ysran FOREIGN KEY (id_actividad) REFERENCES actividad (id);
ALTER TABLE foro ADD CONSTRAINT FK_hnw5fmk3tyntxxv4cml119l8h FOREIGN KEY (id_ofertante) REFERENCES ofertantes (id_ofertante);
ALTER TABLE foro_consumidores ADD CONSTRAINT FK_ethymg70yh064fb4whf5c9o85 FOREIGN KEY (consumidores_id_consumidor) REFERENCES consumidor (id_consumidor);
ALTER TABLE foro_consumidores ADD CONSTRAINT FK_qoh1hc2cltwiy0omdmbl3v7mg FOREIGN KEY (foros_id) REFERENCES foro (id);
ALTER TABLE intereses_consumidores ADD CONSTRAINT FK_sy77wjsldkynks5vqqy7uy4u2 FOREIGN KEY (consumidores_id_consumidor) REFERENCES consumidor (id_consumidor);
ALTER TABLE intereses_consumidores ADD CONSTRAINT FK_28hx79ral1c0mry4rr486cgy0 FOREIGN KEY (intereses_id) REFERENCES intereses (id);
ALTER TABLE intereses_ofertantes ADD CONSTRAINT FK_5wmsa6d0qq7e2aeyihpf57kyq FOREIGN KEY (ofertantes_id_ofertante) REFERENCES ofertantes (id_ofertante);
ALTER TABLE intereses_ofertantes ADD CONSTRAINT FK_q9sebckroyjsdqv9cfh8owgla FOREIGN KEY (intereses_id) REFERENCES intereses (id);
ALTER TABLE mensaje ADD CONSTRAINT FK_npn2p2asveqjadyec0r0bp0ym FOREIGN KEY (foro_id) REFERENCES foro (id);
ALTER TABLE mensaje ADD CONSTRAINT FK_16b741pl8vmflu3s99ih92etr FOREIGN KEY (usuario) REFERENCES usuario (id);
ALTER TABLE ofertantes ADD CONSTRAINT FK_1jt5hi7e32so5dqnar373av7l FOREIGN KEY (id_ofertante) REFERENCES usuario (id);
ALTER TABLE ofertas ADD CONSTRAINT FK_o1sy76y9an5cau896l6wxv8f6 FOREIGN KEY (consumidor) REFERENCES consumidor (id_consumidor);
ALTER TABLE ofertas ADD CONSTRAINT FK_jvrh9jpv7hjxbm2uahl2boird FOREIGN KEY (ofertante) REFERENCES ofertantes (id_ofertante);
ALTER TABLE rol_usuarios ADD CONSTRAINT FK_v87dibmskom8m81onec3u3hv FOREIGN KEY (usuarios_id) REFERENCES usuario (id);
ALTER TABLE rol_usuarios ADD CONSTRAINT FK_7md72xqhxlgdsvphe4eqo7utt FOREIGN KEY (roles_id) REFERENCES rol (id);



INSERT INTO actividad (dificultad, duracion, tarifa, fecha, ofertante, descripcion, hora, lugar, nombre) 
VALUES (3.5, 120, 25.50, '2024-05-06 08:00:00', 1, 'Actividad de senderismo en las montañas', '08:00', 'Montañas de ejemplo', 'Senderismo en las Montañas');

INSERT INTO actividad (dificultad, duracion, tarifa, fecha, ofertante, descripcion, hora, lugar, nombre) 
VALUES (2.0, 90, 15.75, '2024-05-07 10:30:00', 2, 'Clase de cocina italiana', '10:30', 'Calle Principal, Ciudad', 'Clase de Cocina Italiana');

INSERT INTO actividad (dificultad, duracion, tarifa, fecha, ofertante, descripcion, hora, lugar, nombre) 
VALUES (4.0, 180, 35.00, '2024-05-08 18:00:00', 3, 'Concierto de jazz en vivo', '18:00', 'Teatro Municipal', 'Concierto de Jazz en Vivo');


INSERT INTO categoria (nombre) VALUES ('Deportes');
INSERT INTO categoria (nombre) VALUES ('Cocina');
INSERT INTO categoria (nombre) VALUES ('Música');
INSERT INTO categoria (nombre) VALUES ('Deportes Acuáticos');
INSERT INTO categoria (nombre) VALUES ('Postres');
INSERT INTO categoria (nombre) VALUES ('Clásica');
INSERT INTO categoria (nombre) VALUES ('Pintura');
INSERT INTO categoria (nombre) VALUES ('Aventura');
INSERT INTO categoria (nombre) VALUES ('Danza');





INSERT INTO intereses (nombre) VALUES ('Senderismo');
INSERT INTO intereses (nombre) VALUES ('Cocina Italiana');
INSERT INTO intereses (nombre) VALUES ('Jazz');
INSERT INTO intereses (nombre) VALUES ('Fútbol');
INSERT INTO intereses (nombre) VALUES ('Gastronomía Asiática');
INSERT INTO intereses (nombre) VALUES ('Rock');
INSERT INTO intereses (nombre) VALUES ('Arte');
INSERT INTO intereses (nombre) VALUES ('Viajes');
INSERT INTO intereses (nombre) VALUES ('Baile');
