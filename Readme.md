# 📚 Spring Boot Book Management API

A simple **Spring Boot REST API** to manage books in memory.  
This project demonstrates basic **CRUD operations** and filtering with **Spring Web**.

---

## 🚀 Features

- **List all books** or filter by category
- **Get a book by title**
- **Add a new book** (preventing duplicates by title)
- **Update a book** by title
- **Delete a book** by title
- In-memory storage using `List<Book>` (no database)

---

## 📂 Project Structure

src/main/java/com/luv2code/books
│
├── controller
│ └── BookController.java # REST endpoints for managing books
│
└── entity
└── Book.java # Book entity (title, author, category)


---

## ⚙️ Endpoints

| Method | Endpoint               | Description | Query Params / Path Variables |
|--------|------------------------|-------------|--------------------------------|
| GET    | `/api/books`           | Get all books | `category` _(optional)_ - filter by category |
| GET    | `/api/books/{title}`   | Get book by title | `{title}` - book title |
| POST   | `/api/books/create`    | Add a new book | JSON body with `title`, `author`, `category` |
| PUT    | `/api/books/{title}`   | Update a book | `{title}` - existing title, JSON body for new data |
| DELETE | `/api/books/{title}`   | Delete a book | `{title}` - book title |

---

## 📝 Example Requests

### 1️⃣ Get all books
```bash
curl -X GET "http://localhost:8080/api/books"


2️⃣ Get books by category
curl -X GET "http://localhost:8080/api/books?category=math"

3️⃣ Add a book
curl -X POST "http://localhost:8080/api/books/create" \
-H "Content-Type: application/json" \
-d '{"title":"Title five","author":"Author five","category":"biology"}'

4️⃣ Update a book
curl -X PUT "http://localhost:8080/api/books/Title%20one" \
-H "Content-Type: application/json" \
-d '{"title":"Updated Title","author":"Updated Author","category":"science"}'

5️⃣ Delete a book
curl -X DELETE "http://localhost:8080/api/books/Title%20one"

🛠️ Requirements
Java 17+
Maven (for building)
Spring Boot (Spring Web dependency)

▶️ Running the Application
Clone the repo
git clone https://github.com/yourusername/book-management-api.git
Navigate to project
cd book-management-api
Run using Maven
mvn spring-boot:run
API will be available at:
http://localhost:8080/api/books




📌 Notes
The data is stored in-memory and will reset when the application restarts.

Titles are case-insensitive when matching.



📜 License
This project is licensed under the MIT License.





