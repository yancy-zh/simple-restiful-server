# fundsaccess Case Study - todotxt Conversion Service

Hi Please find the submitted project in this folder (demo_webproj). The three tasks I have finished are: 
(A) allow to get all TODOs via API +casestudy type:feature
(A) allow to get a single TODO by ID (!) via API +casestudy type:feature
(A) show that you know how to unit test +casestudy type:constraint

# dependencies: 
I wrote the application in Eclipse, and installed the Java EE, dynamic web application support, NodeJs. Modules needed for NodeJs are listed in package.json, such as nodemon, body-parser, express, fs... They need to installed using?
``npm install PACKAGE_NAME --save``
Packages needed for the java app are listed in pom.xml, such as Gson, junit...
# preparation
- store the original todo file with the name "casestudy.todo.txt" in src/main/resources.

# running the program
- Go to the folder "src/main/java" (the Java app will parse the todo file), right click demo.java, choose "run as an application" , it will generate a db.json with the parsed result. 

Json object is an array and each task object has the following attributes: 
{
    "id": 4,
	"project": string,
    "context": string,
    "contentString": string,
	"priority": int
}

- Start the web application with live server with nodeJs, run command: 
 ``npm start``
- open the homepage at ``http://localhost:3000``
- 
# check the desired contents with APIs
To view all TODOs, go to the api ``http://localhost:3000/tasks``
To get a single TODO by ID, use api: ``http://localhost:3000/tasks/:id``

# unit test
The test case of the class "Task" is in the file src/main/java/TaskTest.java