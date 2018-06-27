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

Configuracion de la base de datos en el archivo application.properties:

spring.datasource.url= u373207304_mutan
spring.datasource.username=  u373207304_mutan
spring.datasource.password= nicolas0
spring.jpa.show-sql=false
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create

Única tabla:
create table Human(
	id bigint(20) primary key auto_increment,
  mutant boolean not null,
  dna varchar(255) not null
);

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

La lógica que se aplicó es la siguiente: 
Al momento de llamar al método POST, se crea un humano. Según su ADN, se guarda un registro en la tabla "Human" con el atributo mutant en 0 o 1 (No mutante - Mutante). 
No se contempla si ese mismo ADN ya existe.

Actualmente hay 3 registros, 2 humanos mutantes y 3 humanos por lo que el servicio stats se encuentra devolviendo:

{"count_mutant_dna":2,"count_human_dna":3,"ratio":"0.67"}


