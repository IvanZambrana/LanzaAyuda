<?xml version="1.0" encoding="ISO-8859-1" standalone="no"?>
<!DOCTYPE helpset PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN"
"http://java.sun.com/products/javahelp/helpset_2_0.dtd">
<helpset version="2.0">
    <title>Ayuda AppAcademia Sparta</title>
    <maps>
		<!-- Pagina por defecto al mostrar la ayuda -->
		<homeID>manual</homeID>
		<!-- Que mapa deseamos -->
		<mapref location="fichero_map.jhm"/>
	</maps>
    <!-- Las Vistas que deseamos mostrar en la ayuda -->
	<view>
		<name>Tabla Contenidos</name>
		<label>Tabla de contenidos</label>
		<type>javax.help.TOCView</type>
		<data>fichero_toc.xml</data>
	</view>
    <view>
		<name>Indice</name>
		<label>Indice</label>
		<type>javax.help.IndexView</type>
		<data>fichero_index.xml</data>
	</view>
   <view>
		<name>Buscar</name>
		<label>Buscar</label>
		<type>javax.help.SearchView</type>
		<data engine="com.sun.java.help.search.DefaultSearchEngine"> 
			JavaHelpSearch
		</data>
	</view>
</helpset>