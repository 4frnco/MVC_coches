# Arquitectura MVCc

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {+muestraVelocidad(String, Integer)}
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
      
```

---

## Diagrama de Secuencia

Ejemplo básico del procedimiento, sin utilizar los nombres de los métodos


```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Creado!
    deactivate Model
    Controller->>+View: Muestra la velocidad, porfa
    activate View
    View->>-View: Mostrando velocidad
    View-->>Controller: Listo!
    deactivate View
```

El mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: crearCoche("Mercedes", "BXK 1234")
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View
    
```

Diagrama de secuencia:

classDiagram
class Coche {
-String matricula
-String modelo
-Integer velocidad
-double kilometrosRecorridos
-double gasolinaLitros
+Coche(String modelo, String matricula)
+getMatricula() String
+getModelo() String
+getVelocidad() Integer
+getKilometrosRecorridos() double
+getGasolinaLitros() double
+setters() void
}
class Controller {
+main(String[] args) void$
}
class View {
-Scanner sc
+View()
+muestraVelocidad(String matricula, Integer v) boolean
+muestraEstadoAvanzado(String matricula, double km, double gasolina) void
+menu() String[]
}
class Model {
-ArrayList~Coche~ parking
+crearCoche(String modelo, String matricula) Coche
+getCoche(String matricula) Coche
+cambiarVelocidad(String matricula, Integer v) int
+getVelocidad(String matricula) int
+avanzar(String matricula, double metros) boolean
+cargarGasolina(String matricula, double litros) boolean
}
Controller "1" *-- "1" Model : association
Controller "1" *-- "1" View : association
Model "1" *-- "0..n" Coche : association

