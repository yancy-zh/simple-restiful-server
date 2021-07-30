# Tasks Conversion Service
本项目依照标准的商业交付格式创建项目结构，生成一个具备基本的restiful API接口的服务器，实现TODO任务清单的分割和提供API接口进行按ID查询、按项目、标签类别筛选等功能。其以Java程序作为后端，Javascript网页程序作为前端，使用的工具有NodeJS（实时服务器），Maven（项目自动化管理），Gradle（项目构建）等.
This application provides a task log conversion service, while the task log has the following format in each line of its file(程序的输入文件每一行是一个任务的描述，且其中包含优先级、种类、项目标题的相关标签，每一行项目描述的格式如下): 
``(A) allow to get all TODOs via API +casestudy type:feature``
where ([A-Z]) indicates the priority of the task, +<PROJECT_NAME> stands for the project type, "type: <CATEGORY>" stands for the category of the task. 
The application mainly provides the following three features（该程序提供如下三个特性）:
(1) allow to get all TODOs via API
(2) allow to get a single TODO by ID (!) via API
(3) unit test of main classes

# Dependencies（依赖性）: 
I wrote the application in Eclipse, and installed the Java EE, dynamic web application support, NodeJs. Modules needed for NodeJs are listed in package.json, such as nodemon, body-parser, express, fs... They need to installed using:
``npm install PACKAGE_NAME --save``
Packages needed for the java app are listed in pom.xml, such as Gson, junit...

# Preparation（准备工作）
- store the original todo file with the name "casestudy.todo.txt" in src/main/resources.

# Running the program（运行）
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

# check the desired contents with APIs
To view all TODOs, go to the api ``http://localhost:3000/tasks``
To get a single TODO by ID, use api: ``http://localhost:3000/tasks/:id``

# unit test
The test case of the class "Task" is in the file src/main/java/TaskTest.java