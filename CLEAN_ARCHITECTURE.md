# Clean Architecture Structure

```
┌─────────────────────────────────────────────────────────────┐
│                    PRESENTATION LAYER                      │
├─────────────────────────────────────────────────────────────┤
│  HomeVM  →  GetEntitiesUseCase                             │
│  LoginVM                                                    │ 
│  HomeFragment, LoginFragment                               │
└─────────────────────────────────────────────────────────────┘
                              ↓ depends on
┌─────────────────────────────────────────────────────────────┐
│                      DOMAIN LAYER                          │
├─────────────────────────────────────────────────────────────┤
│  📋 USE CASES:                                             │
│  • GetEntitiesUseCase                                      │
│  • GetEntityByIdUseCase                                    │
│                                                             │
│  🏛️ REPOSITORY INTERFACES:                                 │
│  • EntityRepository (interface)                           │
│                                                             │
│  📦 DOMAIN MODELS:                                         │
│  • DomainEntity (pure business model)                     │
└─────────────────────────────────────────────────────────────┘
                              ↑ implements
┌─────────────────────────────────────────────────────────────┐
│                       DATA LAYER                           │
├─────────────────────────────────────────────────────────────┤
│  🔄 MAPPERS:                                               │
│  • EntityMapper (Data ↔ Domain)                           │
│                                                             │
│  🗄️ REPOSITORY IMPLEMENTATIONS:                            │
│  • EntityRepositoryImpl                                    │
│                                                             │
│  📡 DATA SOURCES:                                          │
│  • EntityRemoteDataSource (API)                           │
│  • EntityDao (Database)                                    │
│                                                             │
│  📄 DATA MODELS:                                           │
│  • Entity (Room/Retrofit entity)                          │
└─────────────────────────────────────────────────────────────┘
```

## Dependency Flow
- **Presentation Layer** depends on **Domain Layer** (Use Cases)
- **Data Layer** implements **Domain Layer** interfaces 
- **Domain Layer** has NO dependencies on other layers (pure business logic)

## Key Benefits
✅ **Testability**: Each layer can be tested independently  
✅ **Maintainability**: Changes in one layer don't affect others  
✅ **Scalability**: Easy to add new features following the same pattern  
✅ **Independence**: Business logic is framework-agnostic  
✅ **Flexibility**: Can swap data sources without affecting business logic