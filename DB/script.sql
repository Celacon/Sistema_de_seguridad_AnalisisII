drop schema if exists Nomina;

create schema if not exists Nomina; 

use  Nomina;

create table EMPRESA(
	IdEmpresa int not null auto_increment,
	Nombre varchar(100) not null,
	Direccion varchar(200) not null,
	Nit varchar(20) not null,
	PasswordCantidadMayusculas int,
	PasswordCantidadMinusculas int,
	PasswordCantidadCaracteresEspeciales int,
	PasswordCantidadCaducidadDias int,
	PasswordLargo int,
	PasswordIntentosAntesDeBloquear int,
	PasswordCantidadNumeros int,
	PasswordCantidadPreguntasValidar int,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdEmpresa)
);

INSERT INTO EMPRESA (
    Nombre, Direccion, Nit, PasswordCantidadMayusculas,
    PasswordCantidadMinusculas, PasswordCantidadCaracteresEspeciales,
    PasswordCantidadCaducidadDias, PasswordLargo,
    PasswordIntentosAntesDeBloquear, PasswordCantidadNumeros,
    PasswordCantidadPreguntasValidar, FechaCreacion,
    UsuarioCreacion, FechaModificacion, UsuarioModificacion
)
VALUES (
    'Software Inc.', 'San Jose Pinula, Guatemala', '12345678-9', 1,
    1, 1, 60, 8,
    5, 2, 1, NOW(),
    'system', NULL, NULL
);

select * from empresa e ;

create table SUCURSAL(
	IdSucursal int not null auto_increment,
	Nombre varchar(100) not null,
	Direccion varchar(200) not null,
	IdEmpresa int not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdSucursal),
	foreign key (IdEmpresa) references EMPRESA(IdEmpresa)
);

INSERT INTO SUCURSAL (
    Nombre, Direccion, IdEmpresa, FechaCreacion,
    UsuarioCreacion, FechaModificacion, UsuarioModificacion
)
VALUES (
    'Oficinas Centrales', 'San Jose Pinula, Guatemala', 1, NOW(),
    'system', NULL, NULL
);

select * from sucursal s ;

create table STATUS_USUARIO(
	IdStatusUsuario int not null auto_increment,
	Nombre varchar(100) not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdStatusUsuario)
);

INSERT INTO STATUS_USUARIO (
    Nombre, FechaCreacion, UsuarioCreacion,
    FechaModificacion, UsuarioModificacion
)
VALUES 
('Activo', NOW(), 'system', NULL, NULL),
('Bloqueado por intentos de acceso', NOW(), 'system', NULL, NULL),
('Inactivo', NOW(), 'system', NULL, NULL);

select * from status_usuario su ;

create table GENERO(
	IdGenero int not null auto_increment,
	Nombre varchar(100) not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdGenero)
);

INSERT INTO GENERO (
    Nombre, FechaCreacion, UsuarioCreacion,
    FechaModificacion, UsuarioModificacion
)
VALUES
    ('Masculino', NOW(), 'system', NULL, null),
    ('Femenino', NOW(), 'system', NULL, null);
   
select * from genero g ;

create table USUARIO(
	IdUsuario varchar(100) not null,
	Nombre varchar(100) not null,
	Apellido varchar(100) not null,
	FechaNacimiento date not null,
	IdStatusUsuario int not null,
	Password varchar(100) not null,
	IdGenero int not null,
	UltimaFechaIngreso datetime,
	IntentosDeAcceso int,
	SesionActual varchar(100),
	UltimaFechaCambioPassword datetime,
	CorreoElectronico varchar(100),
	RequiereCambiarPassword int,
	Fotografia mediumblob,
	TelefonoMovil varchar(30),
	IdSucursal int not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdUsuario),
	foreign key (IdStatusUsuario) references STATUS_USUARIO(IdStatusUsuario),
	foreign key (IdGenero) references GENERO(IdGenero),
	foreign key (IdSucursal) references SUCURSAL(IdSucursal)
);

INSERT INTO USUARIO (
    IdUsuario, Nombre, Apellido, FechaNacimiento, IdStatusUsuario,
    Password, IdGenero, UltimaFechaIngreso, IntentosDeAcceso,
    SesionActual, UltimaFechaCambioPassword, CorreoElectronico,
    RequiereCambiarPassword, Fotografia, TelefonoMovil,
    IdSucursal, FechaCreacion, UsuarioCreacion,
    FechaModificacion, UsuarioModificacion
)
VALUES 
(
    'system', 'Nologin', 'Nologin', '1990-05-15', 1,
    MD5('erpwijoeli'), 1, NULL, 0,
    NULL, NULL, 'system@example.com',
    1, NULL, '555-1234567',
    1, NOW(), 'system', NULL, NULL
),
(
    'Administrador', 'Administrador', 'IT', '1990-05-15', 1,
    MD5('ITAdmin'), 1, NULL, 0,
    NULL, NULL, 'itadmin@example.com',
    1, NULL, '555-1234567',
    1, NOW(), 'system', NULL, NULL
);

select * from usuario u ;

create table USUARIO_PREGUNTA(
	IdPregunta int not null auto_increment,
	IdUsuario varchar(100) not null,
	Pregunta varchar(100) not null,
	Respuesta varchar(100) not null,
	OrdenPregunta int not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdPregunta),
	foreign key (IdUsuario) references USUARIO(IdUsuario)
);

INSERT INTO USUARIO_PREGUNTA (
    IdUsuario, Pregunta, Respuesta, OrdenPregunta, FechaCreacion,
    UsuarioCreacion, FechaModificacion, UsuarioModificacion
)
VALUES (
'Administrador', '¿Nombre de tu primera mascota?', 'Rex', 1, NOW(),
'system', NULL, NULL
),
(
'Administrador', '¿Lugar de nacimiento de tu madre?','Guatemala', 2, NOW(),
'system', NULL, NULL
),
(
'Administrador', '¿Nombre del catedratico del curso de Analisis de Sistemas II', 'Jorge Lopez', 3, NOW(),
'system', NULL, NULL
),
(
'Administrador', '¿Nombre de tu curso preferido?', 'Analisis de Sistemas II', 4, NOW(),
'system', NULL, NULL
);

select * from usuario_pregunta up ;

create table ROLE(
	IdRole int not null auto_increment,
	Nombre varchar(50) not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (idRole)
);

INSERT INTO ROLE (
    Nombre, FechaCreacion, UsuarioCreacion,
    FechaModificacion, UsuarioModificacion
)
VALUES 
(
    'Administrador', NOW(), 'system', NULL, NULL
),
(
    'Sin Opciones', NOW(), 'system', NULL, NULL
);

select * from `role` r ;


create table USUARIO_ROLE(
	IdUsuario varchar(100) not null,
	IdRole int not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdUsuario, IdRole),
	foreign key (IdUsuario) references USUARIO(IdUsuario),
	foreign key (IdRole) references ROLE(IdRole)
);

INSERT INTO USUARIO_ROLE (
    IdUsuario, IdRole, FechaCreacion,
    UsuarioCreacion, FechaModificacion, UsuarioModificacion
)
VALUES
(
    'Administrador', 1, NOW(), 'system', NULL, NULL
),
(
    'system', 2, NOW(), 'system', NULL, NULL
);

select * from usuario_role ur ;

create table MODULO( 
	IdModulo int not null auto_increment,
	Nombre varchar(50) not null,
	OrdenMenu int not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdModulo)
);

INSERT INTO MODULO (
    Nombre, OrdenMenu, FechaCreacion, UsuarioCreacion 
)
VALUES
(
    'Seguridad', 1, NOW(), 'system'
),
(
    'Planilla', 2, NOW(), 'system'
);

select * from modulo;

create table MENU(
	IdMenu int not null auto_increment,
	IdModulo int not null,
	Nombre varchar(50) not null,
	OrdenMenu int not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdMenu),
	foreign key (IdModulo) references MODULO(IdModulo)
);

INSERT INTO MENU (
    IdModulo, Nombre, OrdenMenu, FechaCreacion, UsuarioCreacion 
)
VALUES
(
    1, 'Parametros Generales', 1, NOW(), 'system'
),
(
    1, 'Acciones', 2, NOW(), 'system'
),
(
    1, 'Estadisticas', 3, NOW(), 'system'
),
(
    1, 'Procedimientos Almacenados', 4, NOW(), 'system'
);

select * from menu;

create table OPCION(
	IdOpcion int not null auto_increment,
	IdMenu int not null,
	Nombre varchar(50) not null,
	OrdenMenu int not null,
	Pagina varchar(100) not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdOpcion),
	foreign key (IdMenu) references MENU(IdMenu)
);

INSERT INTO OPCION (
    IdMenu, Nombre, OrdenMenu, Pagina, FechaCreacion, UsuarioCreacion 
)
VALUES
(
    1, 'Empresas', 1, 'empresa.php', NOW(), 'system'
),
(
    1, 'Sucursales', 2, 'sucursal.php', NOW(), 'system'
),
(
    1, 'Generos', 3, 'genero.php', NOW(), 'system'
),
(
    1, 'Estatus Usuario', 4, 'status_usuario.php', NOW(), 'system'
),
(
    1, 'Roles', 5, 'role.php', NOW(), 'system'
),
(
    1, 'Modulos', 6, 'modulo.php', NOW(), 'system'
),
(
    1, 'Menus', 7, 'menu.php', NOW(), 'system'
),
(
    1, 'Opciones', 3, 'opcion.php', NOW(), 'system'
),
(
    2, 'Usuarios', 3, 'usuario.php', NOW(), 'system'
),
(
    2, 'Asignar Roles a un Usuario', 3, 'asignacion_role_usuario.php', NOW(), 'system'
),
(
    2, 'Asignar Opciones a un Role', 3, 'asignacion_opcion_role.php', NOW(), 'system'
);

select * from opcion o ;

create table ROLE_OPCION(
	IdRole int not null,
	IdOpcion int not null,
	Alta int not null,
	Baja int not null,
	Cambio int not null,
	Imprimir int not null,
	Exportar int not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdRole,IdOpcion),
	foreign key (IdRole) references ROLE(IdRole),
	foreign key (IdOpcion) references OPCION(IdOpcion)
);

create table TIPO_ACCESO(
	IdTipoAcceso int not null auto_increment,
	Nombre varchar(100) not null,
	FechaCreacion datetime not null,
	UsuarioCreacion varchar(100) not null,
	FechaModificacion datetime,
	UsuarioModificacion varchar(100),
	primary key (IdTipoAcceso)
);

INSERT INTO TIPO_ACCESO (
    Nombre, FechaCreacion, UsuarioCreacion,
    FechaModificacion, UsuarioModificacion
)
VALUES 
(
    'Acceso Concedido', NOW(), 'system', NULL, NULL
),
(
    'Bloqueado - Password incorrecto/Numero de intentos exedidos', NOW(), 'system', NULL, NULL
),
(
    'Usuario Inactivo', NOW(), 'system', NULL, NULL
),
(
    'Usuario ingresado no existe', NOW(), 'system', NULL, NULL
);

select * from tipo_acceso ta ;

create table BITACORA_ACCESO(
	IdBitacoraAcceso int not null auto_increment,
	IdUsuario varchar(100) not null,
	IdTipoAcceso int not null,
	FechaAcceso datetime not null,
	HttpUserAgent varchar(200),
	DireccionIp varchar(50),
	Accion varchar(100), 
	SistemaOperativo varchar(50),
	Dispositivo varchar(50),
	Browser varchar(50),
	Sesion varchar(100),
	primary key (IdBitacoraAcceso),
	foreign key (IdTipoAcceso) references TIPO_ACCESO(IdTipoAcceso)
);



CREATE USER 'GCharlie'@'%' IDENTIFIED BY 'AnalisisII';
GRANT ALL PRIVILEGES ON Nomina.* TO 'GCharlie'@'%';



use nomina;
select * from genero;
select * from usuario_pregunta;


select * from opcion;


select * from empresa;
select * from role;

select * from usuario_role;
select * from role_opcion;
select * from usuario;
select * from opcion;

/*SELECT  usuario_role.*,role.*, opcion.*, menu.*, modulo.* */
 SELECT modulo.*,menu.*,opcion.*,role_opcion.*
 FROM usuario 
                          JOIN usuario_role ON usuario.idUsuario = usuario_role.idUsuario
                        JOIN role ON usuario_role.idRole = role.idRole
						JOIN role_opcion ON role.idRole = role_opcion.idRole 
                          JOIN opcion ON role_opcion.idOpcion = opcion.idOpcion 
                          JOIN menu ON opcion.idMenu = menu.idMenu 
                          JOIN modulo ON menu.idModulo = modulo.idModulo
                          where usuario_role.idRole = 3
                          ;
                          use nomina;
                          
                          
	select *from modulo;
    select *from menu;
    select * from opcion;
    select * from role;
     select * from role_opcion;
    
    
    
    
    
    
    
    
    
    
    /*inserts en role opcion*/
    
    INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('1', '4', '1', '1', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('1', '5', '1', '1', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('1', '6', '1', '1', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('1', '7', '1', '1', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('1', '8', '1', '1', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('1', '9', '1', '1', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('1', '10', '1', '1', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('1', '11', '1', '1', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');

    
    
	DELETE FROM `nomina`.`role_opcion` WHERE (`IdRole` = '3') and (`IdOpcion` = '2');
DELETE FROM `nomina`.`role_opcion` WHERE (`IdRole` = '3') and (`IdOpcion` = '3');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('3', '4', '1', '0', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('3', '5', '1', '0', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('3', '6', '1', '0', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('3', '7', '1', '0', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('3', '8', '1', '0', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('3', '9', '1', '0', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('3', '10', '1', '0', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('3', '11', '1', '0', '1', '1', '1', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');

INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('4', '4', '1', '0', '1', '0', '0', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('4', '5', '1', '0', '1', '0', '0', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('4', '6', '1', '0', '1', '0', '0', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('4', '7', '1', '0', '1', '0', '0', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('4', '8', '1', '0', '1', '0', '0', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('4', '9', '1', '0', '1', '0', '0', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('4', '10', '1', '0', '1', '0', '0', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
INSERT INTO `nomina`.`role_opcion` (`IdRole`, `IdOpcion`, `Alta`, `Baja`, `Cambio`, `Imprimir`, `Exportar`, `FechaCreacion`, `UsuarioCreacion`, `FechaModificacion`, `UsuarioModificacion`) VALUES ('4', '11', '1', '0', '1', '0', '0', '2023-09-21 00:00:00', 'System', '2023-09-21 00:00:00', 'System');
                          
/*usuario */                          
                     
                     UPDATE `nomina`.`usuario` SET `Password` = 'HwcVAt+uufu8+chLdG5imA==', `UltimaFechaCambioPassword` = '2023-05-10' WHERE (`IdUsuario` = 'system');
UPDATE `nomina`.`usuario` SET `IdUsuario` = 'Gerente2', `Nombre` = 'Luis', `Apellido` = 'Martinez', `Password` = 'HwcVAt+uufu8+chLdG5imA==', `UltimaFechaCambioPassword` = '2023-09-01' WHERE (`IdUsuario` = 'Administrador8');
UPDATE `nomina`.`usuario` SET `Nombre` = 'Ferdin', `Apellido` = 'Cardona', `Password` = 'HwcVAt+uufu8+chLdG5imA==', `UltimaFechaCambioPassword` = '2023-07-10' WHERE (`IdUsuario` = 'Administrador');
UPDATE `nomina`.`usuario` SET `Nombre` = 'Rosa', `Apellido` = 'Maria', `Password` = 'HwcVAt+uufu8+chLdG5imA==', `IdGenero` = '2', `UltimaFechaCambioPassword` = '2023-08-30' WHERE (`IdUsuario` = 'Administrador7');
UPDATE `nomina`.`usuario` SET `Nombre` = 'Emanuel', `Apellido` = 'Lopez' WHERE (`IdUsuario` = 'Administrador9');
UPDATE `nomina`.`usuario` SET `Nombre` = 'Melvin', `Apellido` = 'Juarez', `IntentosDeAcceso` = '5' WHERE (`IdUsuario` = 'UsuarioPrueba');
UPDATE `nomina`.`usuario` SET `IdUsuario` = 'Gerente1', `Nombre` = 'Marvin ', `Apellido` = 'Soliz', `UltimaFechaCambioPassword` = '2023-06-01' WHERE (`IdUsuario` = 'UsuarioPrueba2');
INSERT INTO `nomina`.`usuario` (`IdUsuario`, `Nombre`, `Apellido`, `FechaNacimiento`, `IdStatusUsuario`, `Password`, `IdGenero`, `IntentosDeAcceso`, `UltimaFechaCambioPassword`, `CorreoElectronico`, `RequiereCambiarPassword`, `TelefonoMovil`, `IdSucursal`, `FechaCreacion`, `UsuarioCreacion`) VALUES ('SubGerente1', 'Nicolas', 'Juarez', '1990-05-14', '1', 'HwcVAt+uufu8+chLdG5imA==', '1', '0', '2023-07-11', 'itadmin@example.com', '1', '555-1234567', '1', '2023-09-10 00:00:00', 'system');
INSERT INTO `nomina`.`usuario` (`IdUsuario`, `Nombre`, `Apellido`, `FechaNacimiento`, `IdStatusUsuario`, `Password`, `IdGenero`, `IntentosDeAcceso`, `UltimaFechaCambioPassword`, `CorreoElectronico`, `RequiereCambiarPassword`, `TelefonoMovil`, `IdSucursal`, `FechaCreacion`, `UsuarioCreacion`) VALUES ('SubGerente2', 'Maria', 'Rosa', '1990-05-14', '2', 'HwcVAt+uufu8+chLdG5imA==', '2', '5', '2023-03-10', 'itadmin@example.com', '1', '555-1234567', '1', '2023-09-10 00:00:00', 'system');



select * from usuario_role;
select * from usuario;
select * from role;



/*usuariorole*/

UPDATE `nomina`.`usuario_role` SET `IdRole` = '1' WHERE (`IdUsuario` = 'system') and (`IdRole` = '2');
INSERT INTO `nomina`.`usuario_role` (`IdUsuario`, `IdRole`, `FechaCreacion`, `UsuarioCreacion`) VALUES ('Administrador7', '1', '2023-09-11 00:00:00', 'system');
INSERT INTO `nomina`.`usuario_role` (`IdUsuario`, `IdRole`, `FechaCreacion`, `UsuarioCreacion`) VALUES ('Administrador9', '1', '2023-09-11 00:00:00', 'system');
INSERT INTO `nomina`.`usuario_role` (`IdUsuario`, `IdRole`, `FechaCreacion`, `UsuarioCreacion`) VALUES ('Gerente1', '3', '2023-09-11 00:00:00', 'system');
INSERT INTO `nomina`.`usuario_role` (`IdUsuario`, `IdRole`, `FechaCreacion`, `UsuarioCreacion`) VALUES ('Gerente2', '3', '2023-09-11 00:00:00', 'system');
INSERT INTO `nomina`.`usuario_role` (`IdUsuario`, `IdRole`, `FechaCreacion`, `UsuarioCreacion`) VALUES ('SubGerente1', '4', '2023-09-11 00:00:00', 'system');
INSERT INTO `nomina`.`usuario_role` (`IdUsuario`, `IdRole`, `FechaCreacion`, `UsuarioCreacion`) VALUES ('SubGerente2', '4', '2023-09-11 00:00:00', 'system');

select * from opcion;



use nomina;

select * from usuario;

select * from usuario_pregunta;





