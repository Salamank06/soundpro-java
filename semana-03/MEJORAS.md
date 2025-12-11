# Mejoras - Semana 03

## Encapsulación Aplicada

### Clase: Client
- Atributos encapsulados: clientId, clientName, email, genre, history
- Validaciones agregadas: strings no vacíos, email válido, historial no nulo

### Clase: StudioBooth
- Atributos encapsulados: boothId, name, maxCapacity, available
- Validaciones agregadas: strings no vacíos, capacidad positiva

### Clase: RecordingSession
- Atributos encapsulados: sessionCode, sessionType, durationHours, pricePerHour, artistName, booth, bookingClient
- Validaciones agregadas: strings no vacíos, números positivos, reserva de cabina

### Clase: Invoice
- Atributos encapsulados: invoiceNumber, session, client, issueDate, finalAmount
- Validaciones agregadas: sesión/cliente no nulos, número válido, monto positivo

### Clase: SoundProManager
- Atributos encapsulados: name, clientPortfolio, boothList
- Validaciones agregadas: nombre no vacío, listas no nulas

## Constructores Sobrecargados

### Client
- Completo: id, nombre, email, género
- Básico: nombre, email
- Mínimo: nombre (email y género por defecto)

### StudioBooth
- Completo: id, nombre, capacidad
- Básico: id, nombre
- Mínimo: id

### RecordingSession
- Completo: todos los atributos
- Básico: código, duración, precio
- Mínimo: código

### Invoice
- Completo: número, sesión, cliente
- Básico: número, sesión
- Mínimo: sesión (número generado)

### SoundProManager
- Completo: nombre
- Mínimo: nombre por defecto

## Beneficios Logrados
- Mayor robustez por validaciones y estados coherentes
- Flexibilidad de construcción por sobrecarga de constructores
- Mejor mantenibilidad por encapsulación y métodos auxiliares privados
