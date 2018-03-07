SpringBoot makes it easy to create stand-alone, production-grade spring based application that you can just run.

Spring is no more just a DI enabler, but.. 
	- It's a complete Application Framework
	- It's a programming and configuration model
	- It provides an infrastructure support like connecting and interacting with DB
However, 
	- It's a huge framework
	- Multiple setup steps
	- Multiple configuration steps
	- Multiple build and deploy steps

SpringBoot 
	- Convention over Configuration
	- Works by conventions for 80% of usecases
	- Standalone application
	- Production Ready

SpringBoot Framework Project:

	1. Add POM parent:

	org.springframework.boot > spring-boot-starter-parent > 1.4.2-RELEASE
	
	<parent>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-parent</artifactId>
	    <version>2.0.0.RELEASE</version>
	</parent>
	
	2. Dependencies:
	
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-web</artifactId>
	    <version>2.0.0.RELEASE</version>
	</dependency>

	3. Define latest java version

	<properties>
		<java.version>1.8</java.version>
	</properties>
	
	4. Create a new Main class, which is the entry point of the application

		a. Annotate the class with @SpringBootApplication
		b. In the main method call static method:
			i. SpringApplication.run(MainClassName.class, args[]);
	
What is the meaning of SpringApplication.run(MainClassName.class, args[]);

	1. It sets up the default configuration (80% use cases!)
	2. Starts the spring application context (container of the spring beans -  business service, repository, controller, etc.)
	3. Perform the class path scan - Identify the annotations for beans.
	4. Starts the tomcat server

Bill of material:
	
	Choose the version of spring-boot-parent and it itself uses a "certified" or "recommended" combination of versions of various jars that work well. That combination is known as BOM in spring language.
	
Benefits of Embedded tomcat server
	1. Convenience
	2. Servlet Container Configuration is now Application Configuration
	3. Standalone application - having its own server makes it easy to deploy, easy to run the application
	4. It's useful for microservices architecture

Customizing/Configuring Spring Boot (20% cases!)

Use application.properites in src/main/resources directory
	Identify the property that you may want to override (change) from below URL and define them here.
	https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
	
Working with Database

	1. Add dependency of spring-boot-starter-jpa

	<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
	<version>2.0.0.RELEASE</version>
	</dependency>

	2. Add in memory database - like Apache Derby

	<dependency>
	<groupId>org.apache.derby</groupId>
	<artifactId>derby</artifactId>
	<version>10.14.1.0</version>
	<scope>runtime</scope>
	</dependency>

	3. Define the entity class (like Topic, Course, Account, etc.) with @Entity
	4. Define the primary key attribute of the entity class with @Id annotation
	5. Now, we would want to write a layer where we would define crud operations like getTopics, createTopic, updateTopic, deleteTopic, etc.  But, these operations are very standard operations. And, hence, Spring gives us an option to not write that stereotypical code!

	Spring has an interface called CrudRepository that performs standard operations using generic datatypes.
	We should create an interface like EntityRepository or AccountRepository and extend it from the CrudRepository interface.
	
	Here, CrudRepository interface needs to be provided with two generic types:
		a. The Entity class
		b. The type of Primary key
	
	CrudRepository allows you to specify some extra specific methods in your own EntityRepository.
	
	Just declare the method with a specific name and arguments and Spring will automatically understand and apply the logic to it!!
	
	Example,
	
	findCourseByTopicId(String topicId)
	findCourseById (String courseId)
	findCourseByTopicIdAndId (String topicId, String courseId)
	deleteCourseById (String courseId)
	
	Here, Course, Topic are the names of the table (entity) and immediately next to the entity is the column name.
	
	IntelliJ helps you when you just do ctrl + space in repository class!
	
	6. Spring provides an actuator starter that provides you monitoring and management endpoints!

	Add below dependency:
	
	<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator -->
	<dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-actuator</artifactId>
	    <version>2.0.0.RELEASE</version>
	</dependency>
	
	This will provide various endpoints through which management functions can be performed.
	By default, for a web application only below endpoints are enabled:
	
		/actuator/health
		/actuator/info
		
	To enable other endpoints, one needs to enable them.
	
	To configure the enablement of an endpoint, use its management.endpoint.<id>.enabled property. The following example enables the shutdown endpoint:
	management.endpoint.shutdown.enabled=true
	
	From <https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html#production-ready-endpoints-enabling-endpoints> 
	

