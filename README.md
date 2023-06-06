# UserApp
A simple Spring Boot Security application, which saves two users (user, admin) to the In-Memory Database H2 at start up.  
ManyToMany relationship to UserRole Entity.  
Uses UserDetailsService and UserDetails to retrieve the saved users for authentication and authorization.  

Accessible Endpoints at http://localhost:8080:

| HTTP Methode | URL | Decription | Authorized users after login |
| --- | --- | --- | --- |
| GET: | "/home" | Home path | user, admin
| GET: | "/user" | User path | user, admin
| GET: | "/admin" | Admin path | admin


Tests are in the Test Folder:

| File name |
| --- |
| UserRepositoryTests |
| UserRoleRepositoryTests |

CI/CD:  
Java with Maven  
Build & Push Docker image  
  
Linter:  
Super-Linter
