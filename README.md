# Base source (kienca1199@gmail.com)

Architecture: **Clean Architecture**

## Layers:

### Presentation Layer (UI)
- **ViewModels**: Handle UI-related data and business logic integration
- **Fragments/Activities**: Handle UI rendering and user interactions
- **Navigation Component**: Handle navigation between screens

### Domain Layer (Business Logic)
- **Use Cases**: Contain business logic and orchestrate data flow
- **Domain Models**: Business entities without framework dependencies  
- **Repository Interfaces**: Define contracts for data access

### Data Layer (Data Access)
- **Repository Implementations**: Implement domain repository contracts
- **Data Sources**: Remote (API) and Local (Database) data sources
- **Data Models**: Framework-specific entities (Room, Retrofit)
- **Mappers**: Convert between data and domain models

## Technologies:
+ Clean Architecture
+ MVVM Pattern
+ Repository Pattern
+ Use Cases/Interactors
+ Hilt (Dependency Injection)
+ Room Database
+ Retrofit (Networking)
+ Kotlin Coroutines & Flow
+ Datastore (Preferences)
+ Navigation Component
