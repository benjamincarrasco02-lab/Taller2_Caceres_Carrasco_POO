Antonia Cáceres - 22.050.742-4 - antoniacaceress  /  Benjamín Carrasco - 21.983.969-3 - benjamincarrasco02-lab

# Taller 2 Benjamín Carrasco y Antonia Cáceres
## Descripción del proyecto:
Se creó un programa en Java que le permite a un usuario crear una nueva partida, y continuar una misma, del juego Pokémon, en donde a la hora de iniciar nos pide el nombre de usuario el cual queda registrado en un archivo propio del programa. Una vez dentro de la opción de crear una nueva partida, se nos despliega un menú de opciones en donde podemos:

### -Batallar contra gimnasios y el Alto Mando:
Acá es donde pondremos a prueba nuestras habilidades peleando con nuestros pokemones previamente capturados.
### -Capturar pokemones:
Esto es requisito obligatorio para poder empezar a jugar, ya que debemos tener al menos 6 pokemones por usuario para poder empezar a batallar.
### -Revisar nuestro equipo, su salud, sus estadísticas y el estado de cada Pokémon:
Todo esto sirve para que a la hora de pelear podamos decidir a cuál elegir (siempre y cuando este se encuentre vivo).
### -Guardar la partida y guardar y salir:
En ambas prodremos guardar nuestro progreso de cada partida jugada, para posteriormente poder retomarla si así lo deseamos.


## Estructura del proyecto:
Se utilizaron 7 clases para distribuir nuestro trabajo. Creamos nuestros objetos los cuales vendrían siendo las clases: 
### -Pokemon: 
Contiene los atributos, estado y salud de cada pokemon.
### -Gimnasio:
Contiene la información respecto a los 8 gimnasios contra los que podremos pelear.
### -Habitats:
Contiene cada habitat presente en el juego.
### -Tabla tipos 
Esta se basa en una matriz que nos ayuda a trabajar las estadísticas de los pokemones mucho más fácil dependiendo del tipo de cada uno.
### -Alto Mando:
Esta clase contiene información respecto a los grupos contra los que podremos batallar en la etapa final del juego.
### -LectorArchivos: 
Clase creada para leer todos los archivos utilizados en el programa.

Todas estas clases, exceptuando LectorArchivos, tienen sus constructores, sus getters y sus respectivos setters.
La clase main es menuPrincipal, la cual contiene todas las listas cargadas gracias a la clase LectorArchivo. Acá encontramos todos los métodos utilizados para la creación tanto del menú continuar como el menú nueva partida.

## Instrucciones de ejecución: 

Una vez abrimos nuestro programa en nuestro editor de código de preferencia, debemos asociar nuestros archivos de texto con nuestras clases. Al tener todo eso listo, podemos empezar a utilizar nuestro programa, teniendo dos opciones a realizar: Continuar una partida o crear una nueva partida.
En ambos encontramos las mismas opciones pero debemos tener en consideración que si no tenemos datos guardados de alguna partida, es decir, si es la primera partida del usuario, la opción de continuar una partida no se encontrará disponible hasta que se juegue al menos una y se guarden sus datos. 
Una vez creado nuestro nombre de usuario, dentro del juego encontraremos las siguientes opciones:
### 1) Revisar equipo:
Podremos visualizar todos los pokemones que como usuarios poseamos, junto con su tipo y la suma de sus estadísticas.
### 2) Salir a capturar:
Acá podremos añadir los pokemones a nuestro equipo.
### 3) Acceso al PC:
Esta opción nos permitirá visualizar solo los pokemones que poseemos, con la opción de poder cambiarlos de lugar y así poder modificar nuestro equipo.
### 4) Retar un gimnasio:
Se nos mostrarán todos los gimnasios disponibles para enfrentar, teniendo como limitación que no podemos enfrentar un gimnasio sin haber enfrentado al anterior, es decir, debemos partir siempre con el primer gimnasio y así ir avanzando.
### 5) Desafío al Alto Mando:
Acá es donde podremos derrotar al Alto Mando para así poder declararnos campeones, sin embargo, como requisito debemos tener previamente derrotados los 8 gimnasios presentes. 
### 6) Curar Pokemon:
Esta opción nos permite curar a nuestros pokemones previamente debilitados en batalla.
### 7) y 8) Guardar y Guardar y Salir:
Ambas aseguran dejar nuestra partida guardada para así poder seguirla cuando deseamos accediendo al menú de Continuar.
