Se configura servidor wildfly el usuario y contraseña

usuario: nexos
contraseña: 1234

Para desplegar el servidor ir a la carpeta donde se almacene el servidor e ir a la ruta wildfly-26.1.2.Final\bin para ejecutar el servidor con el comando standalone.bat (windows)
Para visualizar si cargo correctamente el servidor nos vamos a la ruta http://localhost:9990/ el cual va a pedir usuario y contarseña

Para desplegar el proyecto ir al ide, en este caso usando intelji, ubicarse en maven/plugins/wildfly y dar doble click en la opcion wildfly:deploy para desplegar el proyecto
una vez de despliega el proyecto este quedara almacenado en la pestaña Deployments de la ruta http://localhost:9990/

Ya para visualizar el proyecto solo nos vamos a la ruta http://localhost:8080/nexos/empleados/form.xhtml para visualizar el formulario

Proyecto en creado en maven con java 17, usando bd H2, arquitectura JBOSS y con dependencias de jakarta
