# Jerarquía de Clases - Semana 04

## Diagrama
PersonalSoundPro
   |
+----+----+
|         |
PersonalPlanta PersonalContrato

## Justificación
Modelo de personal del estudio de grabación (SoundPro): personal de planta con bono por antigüedad y personal por contrato sin bonos.

## Atributos Heredados
- nombre (String)
- identificacion (String)
- salarioBase (double)

## Métodos Sobrescritos
- calcularSalario(): EmpleadoPlanta agrega bono por años, EmpleadoContrato retorna salario base.
