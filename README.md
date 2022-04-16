# Financial Utils #


Es una libreria que computa algunas funciones útiles para calcular el valor presente y futuro
de ahorros, flujos de efectivo, créditos, intereses, etc.


Cuenta con cuatro componentes:


__Rate__ : para cálculo de intereses.

__MoneysTimeValue__ : para cálculo del valor de una inversión o ahorro.

__Annuity__ : para los flujos de efectivo y/o créditos.

__Perpetuity__ : para flujos de efectivo perpetuos.


La aplicación cuenta con una mínima interfaz que permite el uso de los componentes y sus métodos a
través de la consola. 


Aún se sigue trabajando en el manejo de errores.

Se agregan las pruebas unitarias con Mockito y JUnit 5 para las siguientes clases:

CashFlow
StreamOfCashFlow
PerpetuityFixedCashFlow

Se agrega SreamOfCashFlow.futureValueWithInitialValue que calcula un flujo de dinero compuesto por pagos fijos pero además lo suma con el
valor futuro del monto inicial.

También se agregan __StreamOfCashFlow.periodsForGoal__ para obtener el número de periodos para obtener una meta con el interés y el pago fijo
hay además una versión __StreamOfCashFlow.periodsForGoalWithInitialValue__ para lo mismo pero cuando hay una cantidad inicial. 

Se agrega la clase __Log__ con el método __customBase__ que no hace más que obtener un logaritmo con una base distinta a __e__ y a __10__.

Se agregan las pruebas unitarias faltantes y se crea el paquete __bound__ que contiene el __AbstractBound__, __BoundFactory__, __CouponBound__, y __ZeroCouponBound__.


Cabe señalar que se iba a agregar un convertidor de años a meses y viceversa pero puede crear más confusión que soluciones así se que opta por retirarlo.

### Nos encontramos con algunos problemas ###

En primer lugar vamos a pedir de forma obligatoria el uso de __Rate__ en lugar de un double a menos que se requiera para
operaciones matemáticas.

Por otro lado vemos que hemos modificado __CompoundFactor__ y __SimpleFactor__ por lo que __CompoundRate__ está relacionado a 
__SimpleRate__ lo cual es incorrecto. 

Además de que debemos esclarecer el factor que es para el __StreamOfCashFlow__ y para el __CashFlow__.

### financialutils2 ###

Acabamos de rehacer todo jaja, con el paquete de financialutils2.

El objetivo ahora es terminar de implementar los métodos faltantes en las clases, falta del StreamOfCashFlow.

Luego falta hacer un barrido para verificar que no hayamos olvidado nada.

Posterior a eso vamos a hacer el código para el paquete de bound.

Luego siguen las pruebas unitarias.

### Posibles aplicaciones ###

Podemos dirigir el desarrollo para que obtengamos la ganancia aproximada de cada mes de un acción identificada
y compararlas en gráficas.

Por ejemplo para WALMEX y para BIMBO tener la ganancia proximada descontando la comisión de cada acción y luego
comparar cual es mayor.


### maven commands ###

skip tests: -Dmaven.test.skip=true



### Anotaciones ###

Actualizar la documentación
Agregar el código correspondiente

poner todos los parametros en final

la unica solución es colocar los parámetros del compoundRate para SimpleCashFlow dentro de la misma función de create de SimpleCashFlowFactory puesto que no tiene sentido crear un nuevo tipo de CashFlowRate para que sea utilizado solamente para el SimpleCashFlow. Si se trata de encapsular su comportamiento podemos crear una clase anidada dentro de SimpleCashFlowFactory con el mismo o diferente nombre. El objetivo es ya no crear un archivo nuevo pues no se va a utilizar.