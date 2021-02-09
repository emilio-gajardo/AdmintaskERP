- Fecha de creación: 30-09-2020
- Autor: Emilio Gajardo
- Autor: Kevin Marshall
- Modelo de dearrollo: Arquiectura multinivel o Programaión por capas
- Documento: Documentación del sistema



Capas:
    1. Capa de presentación o capa usuario: la que ve el usuario
    2. Capa de negocio o capa aplicativa: lógica del negocio = controlador
    3. Capa de datos o capa de BD: comunicación con BD


Acronimos:
    1. bo = business object
    2. dao = data access object
    3. entity = entidades
    4. test = pruebas
    5. view = vistas
    6. db = data base
    7. ojdbc8.jar = Driver de conexion usada entre BD oracle y sistema


Packages:
    1. com.admintaskv2.cl.bo = capa de negocio 
    2. com.admintaskv2.cl.dao = capa de datos
    3. com.admintaskv2.cl.entity = capa de entidades
    4. com.admintaskv2.cl.test = capa de pruebas
    5. com.admintaskv2.cl.view = capa de presentación
    6. com.admintaskv2.cl.db = capa de conexion con BD
	
Librerías:
    1. JCalendar 1.4 : Librería para integrar boton de calendario a interfaces

Flujo de datos:
    1. La capa (TEST o View) usa la ca (BO)
    2. La capa (BO) usa la capa (DAO)
    3. La capa (DAO) usa la capa (Entiy)


Atribuciones de diseñode iconos:
    1. Por: Pixel perfect
    2. Url: https://www.flaticon.es/autores/pixel-perfect
