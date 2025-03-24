drop database if exists supers;
create database supers;
use supers;

create table tiendas(
	id int,
	nombre varchar(25),
	provincia varchar(25));

create table cajeros(
	id int,
	nombre varchar(30),
	apellidos varchar(60),
	fecha_nac date,
	dni char(9));
	
create table tiendas_cajeros(
	id_tienda int,
	id_cajero int);

create table productos(
	id int,
	nombre varchar(30),
	precio decimal(9,2));
	
create table tickets(
	id int,
	id_cajero int,
	fecha_tiq date,
	total decimal(15,2));
	
create table lineas_ticket(
	id int,
	id_ticket int,
	id_producto int,
	cantidad decimal(9,2),
	total decimal(15,2));

CREATE TABLE comision (
	id_cajero INT,
	comision DECIMAL(10, 2),
	mes INT),
	PRIMARY KEY (id_cajero, mes);
)

insert into tiendas values(1,'Carrefive','Lleida');
insert into tiendas values(2,'Comsom','Girona');
insert into tiendas values(3,'Semana','Girona');
insert into tiendas values(4,'Mercahome','Lleida');
insert into tiendas values(5,'Mal Area','Girona');
insert into tiendas values(6,'Explosió','Girona');
	
insert into cajeros values(1,'Eddard','Stark','1956/02/12','11111110A');
insert into cajeros values(2,'Petyr','Baelish','1987/06/23','11111111A');
insert into cajeros values(3,'Jaime','Lannister','1998/05/03','11111112A');
insert into cajeros values(4,'Sandor','Cleagne','1989/09/10','11111113A');
insert into cajeros values(5,'Robert','Baratheon','1988/04/19','11111114A');
insert into cajeros values(6,'Loras','Tyrell','1978/11/16','11111115A');
insert into cajeros values(7,'Daenerys','Targaryen','1979/05/24','11111116A');
insert into cajeros values(8,'Catelyn','Tully','1990/11/29','11111117A');
insert into cajeros values(9,'Theon','Greyjoy','1980/02/14','11111118A');
insert into cajeros values(10,'Cersei','Lannister','1983/06/22','11111119A');
insert into cajeros values(11,'Joffrey','Baratheon','1981/12/16','11111120A');
insert into cajeros values(12,'Jon','Snow','1998/07/04','11111121A');
insert into cajeros values(13,'Tyron','Lannister','1985/03/10','11111122A');

insert into tiendas_cajeros values(1,1);
insert into tiendas_cajeros values(2,2);
insert into tiendas_cajeros values(3,3);
insert into tiendas_cajeros values(1,4);
insert into tiendas_cajeros values(2,5);
insert into tiendas_cajeros values(3,6);
insert into tiendas_cajeros values(1,7);
insert into tiendas_cajeros values(2,8);
insert into tiendas_cajeros values(3,9);
insert into tiendas_cajeros values(1,10);
insert into tiendas_cajeros values(2,11);
insert into tiendas_cajeros values(3,12);
insert into tiendas_cajeros values(1,13);
	
insert into productos values(1,'tomates',1.25);
insert into productos values(2,'patates',0.95);
insert into productos values(3,'sebes',0.50);
insert into productos values(4,'mongetes',2.25);
	
insert into tickets values(1,1,'2018/01/02',135.95);
insert into tickets values(2,2,'2018/01/03',25.98);
insert into tickets values(3,3,'2018/01/09',325.21);
insert into tickets values(4,1,'2018/01/12',412.58);
insert into tickets values(5,2,'2018/02/02',23.95);
insert into tickets values(6,3,'2018/02/02',74.25);
insert into tickets values(7,1,'2018/02/02',91.24);
insert into tickets values(8,2,'2018/03/03',10.75);
insert into tickets values(9,3,'2018/03/03',9.86);

insert into lineas_ticket values(1,4,4,3,25);
insert into lineas_ticket values(2,4,2,6,15.24);
insert into lineas_ticket values(3,5,3,5,10.00);
insert into lineas_ticket values(4,5,1,8.00,30.98);
insert into lineas_ticket values(5,5,2,9,21.74);
insert into lineas_ticket values(6,5,3,12,14.20);
insert into lineas_ticket values(7,6,4,2.50,11.65);
insert into lineas_ticket values(8,6,3,15.02,20.68);
insert into lineas_ticket values(9,6,3,11.10,12.21);



