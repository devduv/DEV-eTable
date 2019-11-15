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
cd 'X:\nombre-carpeta\'
git https://github.com/ISETH1998/eTable.git
```

_Crear rama para realizar cambios y no alterar la rama principal_
```
git checkout -b 'feature/patrones'
```


### ⌨️ Desarrollar e implementar un módulo

_Abrir el proyecto Angular en algún editor_

Ejemplo: Módulo _Administración de Mesas_: tiene 3 submódulos, el submódulo mesas:
```
En esta carpeta se encuentran los archivos .html .ts .css del submódulo:
X:\pnombre-carpeta\eTable\eTable-web\src\app\components\eTable-administracion\main\administracion-mesas\mesas
```
Al levantar el proyecto e ir a la opción _Administración de Mesas_ visualizará una lista de Mesas, una opción de editar una mesa seleccionada y una opción para crear una nueva mesa.
Este módulo se encuentra en la carpeta indicada, donde al realizar algún cambio en el _.html_ podrá visualizar los cambios respectivos en este módulo.

_Para crear un Componente en este módulo_
```
ng g c components/eTable-administracion/main/administracion-mesas/mesas/NOMBRECOMPONENTE
```
Lo que acaba de crear lo podrá visualizar en la carpeta
```
X:\pnombre-carpeta\eTable\eTable-web\src\app\components\eTable-administracion\main\administracion-mesas\mesas\NOMBRECOMPONENTE
```

En el archivo _app-routing.module.ts_ agregar:
```
import { NOMBRECOMPONENTECOMPONENT } from ./.....;
const routes: Routes = [
  ....
   { path: 'mesas/CUALQUIER_NOMBRE', component: NOMBRECOMPONENTECOMPONENT},
  ....
```

ahora en cualquier _Button_ agregar:
```
 <button [routerLink]="['mesas/cCUALQUIER_NOMBRE']"> ir al componente </button>
 ```

 Al hacer clic en el botón se le mostrará el contenido del componente que agregó.