# Mutants

La aplicación se desarrollo en Java 1.8 con Spring Boot, dado que ya viene integrado Apache Tomcat.
Se integraron las siguientes tecnologías: Servicios Rest, MySQL (dicha base se encuentra en un servidor), JPA.

Para los test se utilizó jUnit - Por falta de tiempo no se logró hacer la integración continua con Travis.
Coverage mayor a 80% (ver imagen o ejecutarlo).

Se utilizó Heroku para el servidor (tuve problemas con AWS a la hora de verificar mi celular para activar la cuenta).

Deben levantarlo como proyecto Maven.

URL de la API:
https://mutant-heroku.herokuapp.com/

URL que verifica si un humano es o no mutante:
https://mutant-heroku.herokuapp.com/mutant

URL que trae las estadisticas:
https://mutant-heroku.herokuapp.com/stats

URL que trae todos los humanos (con el flag mutant):
https://mutant-heroku.herokuapp.com/humans

La lógica que se aplicó es la siguiente: 
Al momento de llamar al método POST, se crea un humano. Según su ADN, se guarda un registro en la tabla "Human" con el atributo mutant en 0 o 1 (No mutante - Mutante). 
No se contempla si ese mismo ADN ya existe.

Actualmente hay 3 registros, 2 humanos mutantes y 3 humanos por lo que el servicio stats se encuentra devolviendo:

{"count_mutant_dna":2,"count_human_dna":3,"ratio":"0.67"}

Info a tener en cuenta:

(En caso de que llegue a fallar la BD, cosa que no creo) se deberá ejecutar el siguiente script en mySql:

create database mercadoLibre;
use mercadoLibre;

create table Human(
	id bigint(20) primary key auto_increment,
  mutant boolean not null,
  dna varchar(255) not null
);

Y modificar el siguiente archivo:

application.properties:

spring.datasource.url= jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/heroku_c0cc5b7a7f1db31?autoReconnect=true&useSSL=false
spring.datasource.username= b21b5e309c4aba
spring.datasource.password= b2a583be
spring.datasource.driver-class-name= com.mysql.jdbc.Driver

Por:

spring.datasource.url= jdbc:mysql://localhost/mercadoLibre?autoReconnect=true&useSSL=false
spring.datasource.username= root
spring.datasource.password= root
spring.datasource.driver-class-name= com.mysql.jdbc.Driver

------------------------------------------------------------------------------------------

Adn Mutante:
{
	"dna":[
		"ATGCGA",
		"CAGTGC",
		"TTATGT",
		"AGAAGG",
		"CCCCTA",
		"TCACTG"
	]
}

Adn Humano:
{
	"dna":[
		"ATGCGA", 
		"CAGTGC", 
		"TTATTT", 
		"AGACGG",
		"GCGTCA",
		"TCACTG"
	]
}
