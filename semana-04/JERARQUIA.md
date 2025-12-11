# Jerarquía de Clases - Semana 04

## Diagrama
Empleado
   |
----+----+
|         |
EmpleadoPlanta EmpleadoContrato

## Justificación
Modelo simple de recursos humanos para diferenciar empleados de planta con bonos por antigüedad y empleados por contrato sin bonos.

## Atributos Heredados
- nombre (String)
- identificacion (String)
- salarioBase (double)

## Métodos Sobrescritos
- calcularSalario(): EmpleadoPlanta agrega bono por años, EmpleadoContrato retorna salario base.
