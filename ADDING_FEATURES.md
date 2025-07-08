# Adding New Features with Clean Architecture

This guide shows how to add new features following Clean Architecture principles.

## Example: Adding "Search Entities" Feature

### 1. Domain Layer (Business Logic)
First, add business logic in the domain layer:

#### Add Use Case
```kotlin
// domain/usecase/SearchEntitiesUseCase.kt
class SearchEntitiesUseCase @Inject constructor(
    private val repository: EntityRepository
) {
    suspend operator fun invoke(query: String): Resource<List<DomainEntity>> {
        // Business logic: validate query, apply filters, etc.
        if (query.isBlank()) {
            return Resource.Err("Search query cannot be empty")
        }
        return repository.searchEntities(query)
    }
}
```

#### Update Repository Interface
```kotlin
// domain/repository/EntityRepository.kt
interface EntityRepository {
    fun getEntitiesAsFlow(): Flow<Resource<List<DomainEntity>>>
    suspend fun getEntityById(id: Int): Resource<DomainEntity>
    suspend fun searchEntities(query: String): Resource<List<DomainEntity>> // NEW
}
```

### 2. Data Layer (Data Access)
Implement the data access:

#### Update Repository Implementation
```kotlin
// data/repository/EntityRepositoryImpl.kt
class EntityRepositoryImpl : EntityRepository {
    // ... existing methods
    
    override suspend fun searchEntities(query: String): Resource<List<DomainEntity>> {
        return try {
            val localResults = dao.searchEntities("%$query%")
            Resource.Success(EntityMapper.mapToDomainList(localResults))
        } catch (e: Exception) {
            Resource.Err(e.message ?: "Search failed")
        }
    }
}
```

#### Update DAO
```kotlin
// data/local/EntityDao.kt
@Dao
interface EntityDao {
    // ... existing methods
    
    @Query("SELECT * FROM entity WHERE first_name LIKE :query OR last_name LIKE :query")
    suspend fun searchEntities(query: String): List<Entity>
}
```

### 3. Presentation Layer (UI)
Use the business logic in the UI:

#### Update ViewModel
```kotlin
// ui/home/HomeVM.kt
@HiltViewModel
class HomeVM @Inject constructor(
    private val getEntitiesUseCase: GetEntitiesUseCase,
    private val searchEntitiesUseCase: SearchEntitiesUseCase // NEW
) : ViewModel() {
    
    private val _searchResults = MutableStateFlow<Resource<List<DomainEntity>>>(Resource.Loading())
    val searchResults: StateFlow<Resource<List<DomainEntity>>> = _searchResults
    
    fun searchEntities(query: String) {
        viewModelScope.launch {
            _searchResults.value = searchEntitiesUseCase(query)
        }
    }
}
```

### 4. Dependency Injection
Wire everything together:

#### Update DI Module
```kotlin
// di/DomainModule.kt
@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    // ... existing providers
    
    @Provides
    fun provideSearchEntitiesUseCase(
        repository: EntityRepository
    ): SearchEntitiesUseCase {
        return SearchEntitiesUseCase(repository)
    }
}
```

## Benefits of This Approach

✅ **Separation of Concerns**: Each layer handles its responsibility  
✅ **Testability**: Can unit test SearchEntitiesUseCase independently  
✅ **Maintainability**: Changes are isolated to specific layers  
✅ **Consistency**: Follows the same pattern as existing features  
✅ **Dependency Rule**: Dependencies flow inward (UI → Domain ← Data)

## Testing Strategy

### Unit Tests
```kotlin
// Test Use Case (Business Logic)
class SearchEntitiesUseCaseTest {
    @Test
    fun `should return error when query is blank`() {
        // Test business logic independently
    }
}

// Test Repository Implementation (Data Logic)  
class EntityRepositoryImplTest {
    @Test
    fun `should search entities from database`() {
        // Test data access logic
    }
}

// Test ViewModel (Presentation Logic)
class HomeVMTest {
    @Test
    fun `should update search results when searching`() {
        // Test UI logic with mocked use case
    }
}
```

This approach ensures that each layer can be developed, tested, and maintained independently while following Clean Architecture principles.