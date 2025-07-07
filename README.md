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
The app demonstrates both traditional ViewBinding approach and the new Jetpack Compose with Clean Architecture. 

**Launch Flow:**
1. Traditional splash screen (ViewBinding) 
2. → Full Compose application with Clean Architecture

**Features Showcased:**
- **Clean Architecture** with proper separation of concerns across 3 layers
- **Jetpack Compose UI** with Material Design 3 theming
- **Modern state management** using Compose State and StateFlow
- **Use cases** for business logic (GetUsersUseCase, GetUsersByGenderUseCase)
- **Repository pattern** with domain models and data mappers
- **Navigation Compose** for modern navigation
- **Dependency Injection** with Hilt for all layers
- **Reactive programming** with Kotlin Coroutines and Flow
- **Unit testing** setup for domain layer

**Architecture Benefits:**
- 📱 **Testable**: Domain layer is independent and easily testable
- 🔄 **Maintainable**: Clear separation of concerns and dependencies
- 🚀 **Scalable**: Easy to add new features and modify existing ones
- 🎨 **Modern UI**: Jetpack Compose with declarative UI paradigm
- 🏗️ **Robust**: Clean Architecture principles ensure long-term maintainability
