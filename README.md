# Rendering Books

## Connecting to MySQL

- add the following to [application.properties](./src/main/resources/application.properties)
```
spring.datasource.url=jdbc:mysql://localhost:3306/book_schema
spring.datasource.username=root
spring.datasource.password=rootroot
spring.jpa.hibernate.ddl-auto=update
```

- not adding:

```
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency> 
```

to [pom.xml](pom.xml) caused an error!!

- create a model class: [Book.java](./src/main/java/tylermaxwell/renderingbooks/models/Book.java)
- create an interface: [BookRepository](src/main/java/tylermaxwell/renderingbooks/repositories/BookRepository.java)
- create a service class: [BookService](src/main/java/tylermaxwell/renderingbooks/services/BookService.java)
- create a BooksApi [controller](src/main/java/tylermaxwell/renderingbooks/controllers/BooksApi.java)


- had to watch the video for this one...

```
    	<dependency>
                <groupId>org.apache.tomcat.embed</groupId>
                <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
		<dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>jstl</artifactId>
        </dependency>


```

- don't forget to add:
```
spring.mvc.view.prefix=/WEB-INF/
```
to [application.properties](src/main/resources/application.properties)!! I sure did!!!

- add:

```html
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

to [show.jsp](src/main/webapp/WEB-INF/show.jsp)
## Tasks

- [ ] Create a second controller in your books project called [BookController](src/main/java/tylermaxwell/renderingbooks/controllers/BookController.java) that will have the `@Controller `annotation.

- [ ] Create a new JSP file called show.jsp inside your WEB-INF folder

- [ ] Include all the necessary dependencies and settings for using JSP.

- [ ] Add a route in your controller for "/books/3", where the number is a variable for the ID of the book.

- [ ] Render the JSP with the book information. To test, manually enter the ID of the book in the url. You can use Workbench to see what IDs exist.