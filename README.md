# eTable: Sistema de Reservación de Mesas para Restaurantes 
Aplicación Web que consiste en la administración del negocio básico de un retaurante, administración de las mesas disponibles, gestión de clientes, realizar reservacion, anular reservacion, aceptar reservaciones realizadas, entre otros.


```
USUARIO ADMINISTRADOR
Nombre de usuario: administrador
Contraseña: 123456

USUARIO CLIENTE
Nombre de usuario: nataly
Contraseña: 123456
Nombre de usuario: joel
Contraseña: 123456
```

### 📋 Pre-requisitos 
_Front-end_
```
angular cli version: 8.3.3
node versión: v12.10.0
npm  versión: 6.11.3
```
_Back-end_
```
Apache maven version: 3.6.2
Java JDK version: 1.8.0_191
```
_Base de Datos_
```
MySQL
```
### ⚙️ Herramientas y Entornos de Desarrollo

```
Eclipse / Sprint Tools Suite
Visual Code Studio
Git Bash
Sublime Text
MySQL Workbench
```
### ⚙️ Base de Datos en Azure, para visualizar las tablas, poner los siguientes en MySQL Workbench
```
Hostname : dev-fisi.mysql.database.azure.com
Username : dev01@dev-fisi
Contraseña Servidor123456
```


## 🚀 Construyendo el Sistema
_El Sistema de Reservaciones está dividido en 3 módulos_

* [eTable-web](https://github.com/ISETH1998/eTable/tree/master/eTable-web) - Proyecto Angular para el cliente. FRONT-END
* [eTable-server](https://github.com/ISETH1998/eTable/tree/master/eTable-server) - Proyecto Maven para el servidor. BACK-END
* [eTable-mysql](https://github.com/ISETH1998/eTable-mysql) - Administración de la Base de datos.


## 📦 Distribución del Sistema

_El Módulo Web está dividido en 3 submódulos_

* **eTable-web** - *Administración General del Sistema* - [eTable-administracion](https://github.com/ISETH1998/eTable/tree/master/eTable-web/src/app/components/eTable-administracion/main)
* **eTable-reservaciones-web** - *Reservaciones del Cliente* - [eTable-reservacion-cliente](https://github.com/ISETH1998/eTable/tree/master/eTable-web/src/app/components/cliente-reserva)
* **eTable-reservaciones-web** - *Atender Clientes* - [eTable-atender-clliente](https://github.com/ISETH1998/eTable/tree/master/eTable-web/src/app/components/eTable-administracion/componentes/administracion-mesas/programacion-mesas)

### 🔧 Instalación 
_Realizar los siguientes comandos en Git Bash o CMD, seleccionar una carpeta donde tendrás el proyecto._

_Clonar el proyecto_
```
cd 'X:\nombre-carpeta\'
git https://github.com/ISETH1998/eTable.git

_Abrir el proyecto Front Angular en algún editor_ (El modulo de eTable-web)

      Ejemplo: Módulo _Administración de Mesas_: tiene 3 submódulos, el submódulo mesas:
      ```
      En esta carpeta se encuentran los archivos .html .ts .css del submódulo:
      X:\pnombre-carpeta\eTable\eTable-web\src\app\components\eTable-administracion\main\administracion-mesas\mesas
      ```
      Al levantar el proyecto e ir a la opción _Administración de Mesas_ visualizará una lista de Mesas, una opción de editar una mesa            seleccionada y una opción para crear una nueva mesa.
      Este módulo se encuentra en la carpeta indicada, donde al realizar algún cambio en el _.html_ podrá visualizar los cambios                  respectivos en este módulo.

_Abrir el proyecto Back en STS (El modulo de eTable-server)
