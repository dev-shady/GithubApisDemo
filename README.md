Problem: Show the List of Products as paginated response with infinite scrolling using clean architecture.  
Api: https://dummyjson.com/products?limit=20&skip=20

Accomplished:
1. Separation of ui, domain and data layer using SOLID principles.  
   /ui /domain /data  
   domain: pure kotlin, no android dependencies. Includes buisness logic and interfaces  
3. Used Hilt to provide dependencies like Retrofit, OkHttpClient and bind interface like ProductsApi with their implementation.  
   data/NetworkModule , data/RepositoryModule  
4. Used Retrofit for making api call.  
   interface ProductsApi.  
6. Used Kotlinx Serialization lib for retrofit serialization and deserialization. No reflection, faster than GSON.
7. Used Repository Pattern to connect with remote data source and expose cold flow. Can be easily extended to support local data source.  
8. Used state hoisting in composable to keep it stateless.  
9. Create hot flow in viewmodel using stateIn operator that can be observed by UI,following reactive UI UDF principle.
10. Run the App, App shows Loading text and then list of products (only title)

Libraries Used:
1. Kotlinx serialization, Hilt, Retrofit, Jetpack compose, Flow, Coroutines

Note:
AGP 9.2.0 used in project, so anyone with AGP 8.x.x will face some issues while building.
