# eTable: Sistema de Reservación de Mesas para Restaurantes 
Aplicación Web que consiste en la administración del negocio básico de un retaurante, administración de las mesas disponibles, gestión de clientes, reservaciones realizadas, entre otros.

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


## 🚀 Construyendo el Sistema
_El Sistema de Reservaciones está dividido en 3 módulos_

* [eTable-web](https://github.com/ISETH1998/eTable/tree/master/eTable-web) - Proyecto Angular para el cliente.
* [eTable-server](https://github.com/ISETH1998/eTable/tree/master/eTable-server) - Proyecto Maven para el servidor.
* [eTable-mysql](https://github.com/ISETH1998/eTable-mysql) - Administración de la Base de datos.


## 📦 Distribución del Sistema

_El Módulo Web está dividido en 3 submódulos_

* **eTable-web** - *Administración General del Sistema* - [eTable-administracion](https://github.com/ISETH1998/eTable/tree/master/eTable-web/src/app/components/eTable-administracion/main)
* **eTable-reservaciones-web** - *Reservaciones del Cliente* - [eTable-reservacion-cliente](https://github.com/ISETH1998/eTable/tree/master/eTable-web/src/app/components/eTable-administracion/main)
* **eTable-reservaciones-web** - *Atender Clientes* - [eTable-atender-clliente](https://github.com/ISETH1998/eTable/tree/master/eTable-web/src/app/components/eTable-administracion/main)

### 🔧 Instalación 
_Realizar los siguientes comandos en Git Bash o CMD, seleccionar una carpeta donde tendrás el proyecto._

_Clonar el proyecto_
```
_cd X:\nombre-carpeta\_
git https://github.com/ISETH1998/eTable.git
```

_Crear rama para realizar cambios y no alterar la rama principal_
```
git checkout -b 'feature/usuarios'
```