# Reto 4 · Torneo escolar por categorías

La organización de un torneo registra resultados de equipos con reglas de puntuación diferentes. Construyan un programa que calcule puntos por categoría y encuentre al líder sin consultar el tipo concreto de cada equipo.

**Modalidad:** trabajo grupal en casa. El docente asignará el reto, el tamaño del grupo y la fecha de entrega. Estos cinco retos son alternativas; cada grupo desarrolla el que le corresponda.

## Antes de escribir código

1. En el README del grupo, **identifiquen el problema**: ¿quién necesita la aplicación?, ¿qué dificultad tiene?, ¿qué debe resolver y qué queda fuera? Enumeren entradas, salidas y reglas que siempre deben cumplirse.
2. Identifiquen las responsabilidades y el estado de cada objeto. Propongan una base abstracta con dos variantes y una interfaz pequeña para producir fichas o reportes. Justifiquen «es un» frente a «usa». No creen herencia solo para compartir dos campos.
3. **Elaboren el diagrama UML de clases antes de programar.** Inclúyanlo en su README con Mermaid `classDiagram` o como imagen legible guardada en el repositorio. Debe mostrar clases, atributos importantes con tipos y visibilidad, métodos principales con parámetros y retornos, herencia, interfaz, relaciones de uso y la clase genérica con su parámetro de tipo. Ustedes diseñan el diagrama: no hay un UML resuelto para copiar.
4. Conserven el UML inicial en el historial Git o en una sección/archivo identificado. Al finalizar, actualicen el diagrama para que coincida con el código y expliquen brevemente los cambios, o indiquen que el diseño inicial sigue vigente.
5. Justifiquen una estructura para cada necesidad: **arreglo de cinco datos fijos**, **List tipada de objetos de cantidad variable** y **clase genérica propia**. No usen arreglos paralelos para separar los atributos de un mismo objeto.

## Condiciones de implementación

- Usen IntelliJ IDEA, JDK 21 o 17 y clases con constructor, campos privados y operaciones que protejan sus reglas. Main prepara los escenarios y muestra resultados; no debe contener toda la lógica.
- Una base abstracta y dos subclases deben expresar la variación indicada en el reto. Una interfaz de ficha o reporte debe tener al menos una implementación efectiva. Recorran objetos mediante referencias base y usen un cliente que reciba el contrato; eviten `if` para decidir qué subtipo ejecutar.
- Usen variables, decisiones, ciclos, operaciones y métodos de String. Programen contra `List<T>`, con `ArrayList<>` como opción inicial; expliquen por qué la eligen. No necesitan implementar también LinkedList.
- Diseñen una clase genérica propia, por ejemplo `Evidencia<T>`, que guarde una descripción y un contenido inicializado. Úsenla con `Integer` para el resumen numérico indicado y con `String` para una conclusión del reto; consulten y muestren ambos. Usar solo `List<Entidad>` no cumple este requisito. No usen tipos raw ni casts para mezclar tipos.
- Los IDs son obligatorios, no nulos ni en blanco. Normalicen con `strip()` y `toUpperCase(Locale.ROOT)` al registrar **y al buscar**. Rechacen IDs repetidos tras normalizar. Los nombres pueden repetirse; los IDs no se cambian después del registro. Busquen por ID con un ciclo y `equals`, sin depender de `contains` sobre objetos.
- Rechacen datos inválidos antes de agregarlos y operaciones inválidas antes de cambiar el estado. Las acciones aceptadas o rechazadas deben indicar su resultado, por ejemplo con `boolean`. Si una búsqueda no encuentra el ID, muestren `No encontrado` y no intenten usar un objeto inexistente.
- La lista vacía debe producir contadores y totales cero. Si no hay elementos para calcular un promedio, máximo o líder, indiquen `Sin datos`. No dividan entre cero. No entreguen acceso modificable a las listas o arreglos internos.
- Registren los cinco valores del arreglo en orden de días 1–5, correspondientes a índices 0–4. Cero es un dato válido. Antes de corregir o consultar una posición, comprueben su rango; rechacen posiciones inexistentes sin alterar el arreglo. Si empatan máximos, informen el **primer día**. No ordenen el arreglo: cada posición representa un día.
- Menús y Scanner son opcionales. Debe existir un Main que reproduzca las pruebas del enunciado con datos fijos. Si añaden entrada interactiva, validen los rangos; recuperar texto no numérico es opcional.
- No usen Map, Set, enum, streams, lambdas, patrones, bases de datos, archivos de persistencia, interfaces gráficas, Maven/Gradle ni dependencias externas. No se exige manejo formal de excepciones ni JUnit.

## Lo que deben construir

1. Modelen un equipo con ID, nombre y contadores privados de ganados, empatados y perdidos, inicialmente en cero. Puede registrar **como máximo 20 partidos en total**.
2. Usen una base abstracta y dos categorías: formativa da **2 puntos por victoria y 1 por empate**; competitiva **3 y 1**, respectivamente. Derrotas otorgan cero. El cálculo se resuelve por sobrescritura.
3. Mantengan una lista de equipos: registrar sin duplicados, buscar por ID y registrar un resultado. Acepten `G`, `E` o `P` después de quitar espacios y convertir a mayúsculas. Cualquier otro texto o una solicitud después de 20 partidos se rechaza sin cambiar contadores.
4. Cada solicitud afecta solo al equipo indicado. No se exige emparejar resultados entre equipos ni crear un calendario de partidos.
5. Listen fichas mediante el contrato común: ID, nombre, categoría, ganados, empatados, perdidos, partidos y puntos. Conserven el orden de registro. Localicen al líder con un ciclo; si hay empate, elijan al primer equipo registrado. Con lista vacía muestren `Sin datos`.
6. Guarden la asistencia de cinco fechas en un arreglo, de **0 a 500** espectadores por fecha; informen total, promedio decimal, máximo y primera fecha del máximo. Estos datos no se calculan a partir de los partidos.
7. Muestren evidencias genéricas con cantidad de equipos como Integer y conclusión textual como String. No usen ordenamiento con comparadores, lambdas ni streams.

## Escenario base obligatorio

Registren formativo `F-01`, nombre `Semillas`; y competitivo `C-01`, nombre `Halcones`. Para **cada equipo**, registren `G`, `E` y `P`.

| Equipo | Ganados | Empatados | Perdidos | Partidos | Puntos |
| --- | --- | --- | --- | --- | --- |
| F-01 | 1 | 1 | 1 | 3 | 3 |
| C-01 | 1 | 1 | 1 | 3 | 4 |

El líder es **C-01**. Intentar resultado `X` en F-01 se rechaza y conserva esos valores. La evidencia numérica contiene **2**.

Con asistencia `[30, 25, 40, 20, 35]`: total **150**, promedio **30.0**, máximo **40**, fecha **3**.

**Pruebas adicionales:** acepten ` g ` como victoria; rechacen resultado nulo o en blanco e ID duplicado normalizado. En otra ejecución, registren 20 derrotas a un equipo y comprueben que la solicitud 21 se rechaza: debe conservar 20 partidos y cero puntos. Prueben empate de puntos y comprueben que el líder sea el primero registrado. Lista vacía: cero equipos y líder `Sin datos`.

## Pruebas y entrega del grupo

1. Ejecuten el escenario base y comparen sus resultados con los de este enunciado. No mezclen las pruebas adicionales con ese escenario: usen objetos o ejecuciones nuevas.
2. Prueben al menos un caso normal, un límite exacto, un dato inválido, una operación rechazada que conserve el estado y la lista vacía. Agreguen la búsqueda de un ID inexistente y una posición fuera del arreglo.
3. Registren en el README: entradas, resultado esperado, resultado obtenido y si coincide. Expliquen un breakpoint utilizado en una regla y qué variable observaron antes y después; las capturas son opcionales.
4. Entreguen **un repositorio del grupo** con fuentes Java y README: integrantes y aportes, identificación del problema, reglas, UML inicial, decisiones de estructuras, instrucciones reales de ejecución (paquete y Main), pruebas y UML final coherente con el código.
5. Cada integrante debe poder explicar el flujo principal y una regla aunque repartan las tareas. Compartan el enlace por Campus según indique el docente. No incluyan compilados ni configuraciones personales del IDE.

Pueden elegir nombres y diseños distintos si cumplen las reglas y pueden explicarlos. El reto requiere analizar y diseñar; no hay plantilla TODO para completar.
