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

### maven commands ###

skip tests: -Dmaven.test.skip=true