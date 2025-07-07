# Base source (kienca1199@gmail.com)

## Architecture:
This project now integrates **Clean Architecture** with **Jetpack Compose** and modern Android development practices.

### Layers:
- **Presentation Layer**: 
  - UI components using Jetpack Compose
  - ViewModels following MVVM pattern
  - Traditional View system (ViewBinding) for legacy support
- **Domain Layer**: 
  - Use Cases (business logic)
  - Domain Models
  - Repository interfaces
- **Data Layer**: 
  - Repository implementations
  - Remote data sources (Retrofit)
  - Local data sources (Room)
  - Data mappers

### Technologies:
+ **UI**: Jetpack Compose + ViewBinding (hybrid approach)
+ **Architecture**: Clean Architecture + MVVM
+ **DI**: Hilt
+ **Database**: Room + DataStore
+ **Navigation**: Navigation Component (traditional) + Compose Navigation
+ **Networking**: Retrofit + OkHttp
+ **Reactive Programming**: Kotlin Coroutines + Flow

### Project Structure:
```
app/src/main/java/com/base/base_source/
├── data/                     # Data Layer
│   ├── entities/            # Room entities
│   ├── local/              # Local data sources (Room DAOs)
│   ├── remote/             # Remote data sources (Retrofit)
│   ├── repository/         # Repository implementations
│   └── mapper/             # Data <-> Domain mappers
├── domain/                  # Domain Layer
│   ├── model/              # Domain models
│   ├── repository/         # Repository interfaces
│   └── usecase/            # Use cases (business logic)
├── presentation/           # Presentation Layer (Compose)
│   ├── compose/            # Compose activities
│   ├── home/               # Home screen (Compose)
│   └── theme/              # Compose theme
├── ui/                     # Legacy UI (ViewBinding)
├── di/                     # Dependency Injection
├── datastore/              # DataStore management
└── utils/                  # Utilities
```

### Demo:
The app demonstrates both traditional ViewBinding approach and the new Jetpack Compose with Clean Architecture. The splash screen navigates to the Compose version by default, showcasing:
- Clean Architecture with proper separation of concerns
- Jetpack Compose UI with Material Design 3
- Modern state management with Compose
- Use cases for business logic
- Repository pattern with domain models
