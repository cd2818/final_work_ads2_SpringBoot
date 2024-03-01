create database korelly;

use korelly;

CREATE TABLE persona (
    id_persona     BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nombre         VARCHAR(50) 	NOT NULL,
    ap_paterno     VARCHAR(50) 	NOT NULL,
    ap_materno     VARCHAR(50),
    nro_telefono   VARCHAR(9) 	NOT NULL,
    direccion      VARCHAR(70),
    nro_dni        CHAR(8)		NOT NULL,
    email          VARCHAR(70),
    estado         VARCHAR(70),
    
    CONSTRAINT digit_tlfn_ck CHECK (nro_telefono LIKE '%[0-9]%' AND nro_telefono NOT LIKE '%[^0-9]%'),
    CONSTRAINT length_tlfn_ck CHECK (CHAR_LENGTH(nro_telefono) >= 6 AND CHAR_LENGTH(nro_telefono) <= 9),
    CONSTRAINT length_tlfn_ck CHECK (CHAR_LENGTH(nro_dni)=8)
);

CREATE TABLE turno(
	id_turno	TINYINT		auto_increment	PRIMARY KEY NOT NULL,
    descripcion	VARCHAR(50)
	
);

CREATE TABLE empleado(
	id_empleado		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    hora_entrada	TIME,
    hora_salida		TIME,
    sueldo			float,
    id_turno		tinyint,
    id_persona 		BIGINT,
    
    CONSTRAINT turno_empleado_fk FOREIGN KEY(id_turno) REFERENCES turno(id_turno),
    CONSTRAINT persona_empleado_fk FOREIGN KEY(id_persona) REFERENCES persona(id_persona),
    CONSTRAINT sueldo_positivo_ck CHECK(sueldo>=0)
);

CREATE TABLE administrador(
	id_administrador	BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_empleado			BIGINT,
    
    CONSTRAINT empleado_administrador_fk FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado)
);

CREATE TABLE recepcionista(
	id_recepcionista	BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_empleado			BIGINT,
    
    CONSTRAINT empleado_recepcionista_fk FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado)
);

CREATE TABLE mesero(
	id_mesero	BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_empleado			BIGINT,
    
    CONSTRAINT empleado_mesero_fk FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado)
);

CREATE TABLE caja(
	id_caja 		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nro_caja		char(5) unique,
    monto_inicial	decimal(10,2),
    monto_final		decimal(10,2),
    
    CONSTRAINT montos_ck CHECK(monto_inicial>=0 and monto_final>=monto_inicial),
    CONSTRAINT nro_caja_ck CHECK(nro_caja like '[0-9][0-9][0-9][0-9][0-9]')
);

CREATE TABLE cajero(
	id_cajero	BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	id_empleado			BIGINT,
    
    CONSTRAINT empleado_cajero_fk FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado)
);
ALTER TABLE cajero add column id_caja BIGINT;
ALTER TABLE cajero ADD CONSTRAINT cajero_caja_fk FOREIGN KEY(id_caja) REFERENCES caja(id_caja);

CREATE TABLE cocinero(
	id_cocinero	BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    id_empleado	BIGINT,

	CONSTRAINT empleado_cocinero_fk FOREIGN KEY(id_empleado) REFERENCES empleado(id_empleado)
);	


CREATE TABLE tipo_cliente(
	id_tipo tinyint	AUTO_INCREMENT PRIMARY KEY NOT NULL,
    descripcion	varchar(50),
    estado	varchar(50)
);

CREATE TABLE cliente(
	id_cliente	BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    
    id_tipo		tinyint,
    id_persona  BIGINT,
    
    CONSTRAINT persona_cliente_fk FOREIGN KEY(id_persona) REFERENCES persona(id_persona),
    CONSTRAINT tipo_cliente_fk FOREIGN KEY(id_tipo) REFERENCES tipo_cliente(id_tipo)
);

CREATE TABLE atencion_al_cliente(
	id_atencion 		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    fecha_atencion		datetime,
    hora_inicio			time,
    hora_fin			time,
    estado				varchar(50),
    
    id_recepcionista	BIGINT,
    id_mesero			BIGINT,
    id_cliente			BIGINT,
    
    CONSTRAINT recepcionista_atencion_fk FOREIGN KEY(id_recepcionista) REFERENCES recepcionista(id_recepcionista),
    CONSTRAINT mesero_atencion_fk FOREIGN KEY(id_mesero) REFERENCES mesero(id_mesero),
    CONSTRAINT cliente_atencion_fk FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente)
    
);


CREATE TABLE pago_pedido(
	id_pago 		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    cod_pago		char(6)	unique,
    importe_total	decimal(10,2),

	id_atencion		BIGINT,
    id_cajero		BIGINT,
    
    CONSTRAINT pago_atencion_fk FOREIGN KEY(id_atencion) REFERENCES atencion_al_cliente(id_atencion),
    CONSTRAINT cajero_atencion_fk FOREIGN KEY(id_cajero) REFERENCES cajero(id_cajero)
);

CREATE TABLE comprobante(
	id_comprobante 	BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    cod_comprobante	char(5)		UNIQUE,
    descripcion 	varchar(50),
    
    id_pago			BIGINT,
    
    CONSTRAINT comprobante_pago FOREIGN KEY(id_pago) REFERENCES pago_pedido(id_pago),
    CONSTRAINT cod_comprobante_ck CHECK(cod_comprobante like '[0-9][0-9][0-9][0-9][0-9]')
);

CREATE TABLE mesa(
	id_mesa		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nro_mesa	varchar(2)	unique,
    capacidad	int,
    estado		VARCHAR(50),
    
    CONSTRAINT nro_mesa_ck CHECK(nro_mesa like '[0-9][0-9]')
);

CREATE TABLE reserva_mesa(
	id_reserva 		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    cod_reserva		char(5) unique,
    fecha_reserva	DATE,
    hora_reserva	TIME,
    estado			VARCHAR(50),
    
    id_atencion 	BIGINT,
    
    CONSTRAINT reserva_atencion_fk FOREIGN KEY(id_atencion) REFERENCES atencion_al_cliente(id_atencion),
    CONSTRAINT cod_reserva_ck CHECK(cod_reserva like '[0-9][0-9][0-9][0-9][0-9]')
);

CREATE TABLE motivo_cancelacion(
	id_mot_cancelacion 	BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    descripcion		VARCHAR(50)
);

CREATE TABLE cancelacion_reserva(
	id_cancelacion 		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    cod_cancelacion		CHAR(5) unique,
    fecha_cancelacion	DATE,
    hora_cancelacion	TIME,
    
    id_mot_cancelacion  BIGINT,
    id_reserva			BIGINT,
    
    CONSTRAINT motivo_cancelacion_fk FOREIGN KEY(id_mot_cancelacion) REFERENCES motivo_cancelacion(id_mot_cancelacion),
    CONSTRAINT reserva_cancelacion_fk FOREIGN KEY(id_reserva) REFERENCES reserva_mesa(id_reserva),
    CONSTRAINT cod_cancelacion_ck CHECK(cod_cancelacion like '[0-9][0-9][0-9][0-9][0-9]')
);

CREATE TABLE banco(
	id_banco		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	nombre_banco	VARCHAR(50),
    ubicacion		VARCHAR(50),
    estado			VARCHAR(50)
);

CREATE TABLE tipo_tarjeta(
	id_tipo_tarjeta		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    descripcion			VARCHAR(50),
    
    id_banco			BIGINT,
    
    CONSTRAINT tipo_banco_fk foreign key(id_banco) REFERENCES banco(id_banco)
);

CREATE TABLE tarjeta(
	id_tarjeta 		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nro_tarjeta 	CHAR(16) unique,
    cvv				char(3),
    nombre_titular	VARCHAR(50),
    saldo			DECIMAL(10,2),
    estado			VARCHAR(50),
    
    id_tipo_tarjeta BIGINT,
    
    CONSTRAINT tipo_tarjeta_fk FOREIGN KEY(id_tipo_tarjeta) REFERENCES tipo_tarjeta(id_tipo_tarjeta),
    CONSTRAINT saldo_ck CHECK(saldo>=0)
);

CREATE TABLE pago_tarjeta(
	id_pago_tarjeta		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    nro_transaccion		int,
    
    id_tarjeta			BIGINT,
    id_pago				BIGINT,
    
    CONSTRAINT tarjeta_pago_fk FOREIGN KEY(id_tarjeta) REFERENCES tarjeta(id_tarjeta),
    CONSTRAINT pago_pago_pedido_fk FOREIGN KEY(id_pago) REFERENCES pago_pedido(id_pago)
);

CREATE TABLE tipo_plato(
	id_tipo_plato		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    descripcion			VARCHAR(50),
    estado				VARCHAR(50)
);

CREATE TABLE plato(
	id_plato		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    cod_plato		CHAR(5) UNIQUE,
    nombre_plato	VARCHAR(50),
    precio_lista	DECIMAL(10,2),
    estado			VARCHAR(50),
    
    id_tipo_plato	BIGINT,
    
    CONSTRAINT tipo_plato_plato_fk FOREIGN KEY(id_tipo_plato) REFERENCES tipo_plato(id_tipo_plato),
    CONSTRAINT precio_ck CHECK(precio_lista>=0),
    CONSTRAINT cod_plato CHECK(cod_plato like '[A-Z][A-Z][A-Z][0-9][0-9]')
);


CREATE TABLE bebida(
	id_bebida		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    cod_bebida		CHAR(5) UNIQUE,
    nombre_bebida	VARCHAR(50),
    precio_lista	DECIMAL(10,2),
    estado			VARCHAR(50),
    
    CONSTRAINT precio_lista_ck CHECK(precio_lista>=0),
    CONSTRAINT cod_bebida CHECK(cod_bebida like '[A-Z][A-Z][A-Z][0-9][0-9]')
);


CREATE TABLE pedido(
	id_pedido		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    fecha_pedido	DATE,
    hora_pedido		TIME,
    estado			VARCHAR(50),
    
    id_plato		BIGINT,
    id_bebida		BIGINT,
    
    CONSTRAINT pedido_plato_fk FOREIGN KEY(id_plato) REFERENCES plato(id_plato),
    CONSTRAINT pedido_bebida_fk FOREIGN KEY(id_bebida) REFERENCES bebida(id_bebida)
);

CREATE TABLE reclamo(
	id_reclamo			BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    descripcion			VARCHAR(50),
    estado 				VARCHAR(50),
    
    id_pedido			BIGINT,
    id_administrador	BIGINT,
    id_motivo_reclamo	BIGINT,
    
    CONSTRAINT reclamo_pedido_fk FOREIGN KEY(id_pedido) REFERENCES pedido(id_pedido),
    CONSTRAINT reclamo_administrador FOREIGN KEY(id_administrador) REFERENCES administrador(id_administrador),
    CONSTRAINT reclamo_motivo FOREIGN KEY(id_motivo_reclamo) REFERENCES motivo_reclamo(id_motivo_reclamo)
);

CREATE TABLE motivo_reclamo(
	id_motivo_reclamo 	BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    descripcion			VARCHAR(50)
);

CREATE TABLE anulacion_pedido(
	id_anulacion_pedido		BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    fecha_anulacion			DATE,
    hora 					TIME,
    
    id_pedido				BIGINT,
    id_reclamo				BIGINT,
    
    CONSTRAINT pedido_anulacion_fk FOREIGN KEY(id_pedido) REFERENCES pedido(id_pedido),
    CONSTRAINT reclamo_anulacion_fk FOREIGN KEY(id_reclamo) REFERENCES reclamo(id_reclamo)
);