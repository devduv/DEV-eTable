use db_etable;
-- Configuracion del Sistema en general
CREATE TABLE TBCONFIGURACIONSISTEMA(
CCONFIGURACION INT(11) NOT NULL AUTO_INCREMENT,
CEMPRESA INT(11) NOT NULL,
EMPNOMBRE VARCHAR(128),
EMPDESCRIPCION VARCHAR(256),
EMPDIRECCION VARCHAR(256),
EMPEMAIL VARCHAR(128),
EMPCELULAR INT(9),
EMPLOGO VARCHAR(128),
SIST_RESERVACION_CLIENTE INT(1),
SIST_ATENCION_CLIENTE INT(1),
MESAS_COMPUESTAS INT(1),
AGREGAR_CLIENTE_MANUAL INT(1),
PAGOS_TARJETA_CREDITO INT(1),
RESERVACION_PEDIDOS INT(1),
RESERVAS_ESPECIALES INT(1),
RESERVAS_NO_SESIONADAS INT(1),
CANT_MAX_MESAS INT(3),
CANT_MAX_US_REGISTRADOS INT(11),
HORARIO_INI_ATENCION VARCHAR(32),
HORARIO_FIN_ATENCION VARCHAR(32),
DIAS_ATENCION VARCHAR(128),
MAX_US_TRAB_CONECTADOS INT(2),
DATE_CONFIGURADO VARCHAR(128),
CONSTRAINT PRIMARY KEY (CCONFIGURACION)
) ENGINE=InnoDB;

-- Items del Menú -> Administración de Clientes
CREATE TABLE TBMENUITEMS(
CITEM INT(11) NOT NULL AUTO_INCREMENT,
ITEM VARCHAR(128),
CONSTRAINT PRIMARY KEY (CITEM)
) ENGINE=InnoDB;

-- SubItems de Items del Menú -> Tipo de Clientes -> Administración de Clientes
CREATE TABLE TBMENUSUBITEMS(
CSUBITEM INT(11) NOT NULL AUTO_INCREMENT,
CITEM INT(11) NOT NULL,
SUBITEM VARCHAR(128),
PRIMARY KEY (CSUBITEM),
FOREIGN KEY (CITEM) REFERENCES TBMENUITEMS (CITEM)
) ENGINE=InnoDB;


CREATE TABLE TBRESERVACION(
CRESERVA INT(11) NOT NULL AUTO_INCREMENT,
CCLIENTE INT(11) NOT NULL,
CESTADO INT(11) NOT NULL, -- ESPERA, EN DESPACHO,FINALIZADO,ANULADO
COMENTARIO VARCHAR(128),
FECHA DATE,
CANTIDAD INT(11) NOT NULL,
CONFIRMADA BOOLEAN ,  -- X DEFECTO FALSE

PRIMARY KEY (CRESERVA),
FOREIGN KEY (CCLIENTE) REFERENCES TBCLIENTES (CCLIENTE),
FOREIGN KEY (CESTADO) REFERENCES TBESTADORESERVACION (CESTADO)
) ENGINE=InnoDB;

CREATE TABLE TBPROGRAMACIONMESA(
CPROGRAMACION INT(11) NOT NULL AUTO_INCREMENT,
CRESERVA INT(11) NOT NULL ,
CMESA INT(11) NOT NULL,
PRIMARY KEY (CPROGRAMACION),
FOREIGN KEY (CRESERVA) REFERENCES TBRESERVACION (CRESERVA),
FOREIGN KEY (CMESA) REFERENCES TBMESA (CMESA)
) ENGINE=InnoDB;


CREATE TABLE TBESTADORESERVACION(
CESTADO INT(11) NOT NULL AUTO_INCREMENT,
NOMESTADO INT(11) NOT NULL,
DESCESTADO VARCHAR(255),

PRIMARY KEY (CESTADO)) ENGINE=InnoDB;

-- Permisos del Sistema -> Permiso en: Tipo de Cliente
CREATE TABLE TBPERMISOS(
CPERMISO INT(11) NOT NULL AUTO_INCREMENT,
CSUBITEM INT(11) NOT NULL,
PERMISO VARCHAR(128),
DESCRIPCION VARCHAR(256),
ESTADO INT(1),
PRIMARY KEY (CPERMISO),
FOREIGN KEY (CSUBITEM) REFERENCES TBMENUSUBITEMS (CSUBITEM)
) ENGINE=InnoDB;

-- Tipos de usuario -> Administrador, cliente, soporte, cajero...
CREATE TABLE TBTIPOUSUARIO(
CTIPOUSUARIO INT(11) NOT NULL AUTO_INCREMENT,
TIPONOMBRE VARCHAR(128),
TIPODESCRIPCION VARCHAR(128),
PRIMARY KEY (CTIPOUSUARIO)
) ENGINE=InnoDB;

-- Tipos de usuario con permisos -> Cajero con permiso Tipo de Cliente y permiso Crear Mesa
CREATE TABLE TBTIPOUSUARIOPERMISO(
CTIPOUSPERMISO INT(11) NOT NULL AUTO_INCREMENT,
CTIPOUSUARIO INT(11) NOT NULL,
CPERMISO INT(11) NOT NULL,
PRIMARY KEY (CTIPOUSPERMISO),
FOREIGN KEY (CTIPOUSUARIO) REFERENCES TBTIPOUSUARIO (CTIPOUSUARIO),
FOREIGN KEY (CPERMISO) REFERENCES TBPERMISOS (CPERMISO)
) ENGINE=InnoDB;

-- Tabla de usuarios del Sistema
CREATE TABLE TBUSUARIOS(
CUSUARIO INT(11) NOT NULL AUTO_INCREMENT,
NICKNAME VARCHAR(128),
PASSWORD VARCHAR(128),
CTIPOUSUARIO INT(11),
USNOMBRE VARCHAR(128),
USAPELLIDOS VARCHAR(128),
ESTADO INT(1),
PRIMARY KEY (CUSUARIO),
FOREIGN KEY (CTIPOUSUARIO) REFERENCES TBTIPOUSUARIO (CTIPOUSUARIO)) ENGINE=InnoDB;

CREATE TABLE TBPERFILMESA(
CPERFILMESA INT(11) NOT NULL AUTO_INCREMENT,
PMNOMBRE VARCHAR(64),
PMDESCRIPCION VARCHAR(128),
PMCAPACIDAD INT(2),
PMCOMPUESTA INT (1),
PRIMARY KEY (CPERFILMESA)) ENGINE=InnoDB;

CREATE TABLE TBESTADOMESA(
CESTADOMESA INT(11) NOT NULL,
EMDESCRIPCION VARCHAR(64),
PRIMARY KEY (CESTADOMESA)) ENGINE=InnoDB;

CREATE TABLE TBMESA(
CMESA INT(11) NOT NULL AUTO_INCREMENT,
NOMBREMESA VARCHAR(128),
CPERFILMESA INT (11),
CESTADOMESA INT(11),
PRIMARY KEY (CMESA),
FOREIGN KEY (CPERFILMESA) REFERENCES TBPERFILMESA (CPERFILMESA),
FOREIGN KEY (CESTADOMESA) REFERENCES TBESTADOMESA (CESTADOMESA)) ENGINE=InnoDB;

CREATE TABLE TBCLIENTES(
CCLIENTE INT(11) NOT NULL AUTO_INCREMENT,
DNI VARCHAR(10),
CUSUARIO INT(11),
EMAIL VARCHAR(128),
PHONE VARCHAR(11),
DATE DATE,
PRIMARY KEY (CCLIENTE, DNI),
FOREIGN KEY (CUSUARIO) REFERENCES TBUSUARIOS (CUSUARIO)
) ENGINE=InnoDB;
