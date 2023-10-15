# Credit Card Checker

> This project is to attend LevelUp take-home assignment, focused on the development
> of a small credit card checker, using Jakarta EE principles.

<hr>

## 💻 Prerequisites
Before trying to run this web-app, there are some prerequisites that your
local machine must have:
* You need to have `Java SE Development Kit 17` installed.
* preferable, the most recent version of `Apache Maven` installed and configured.
* At last, to run it on localhost server, you need to have `Apache Tomcat 10.1.14`.

<hr>

## 🚀 Installing project dependencies
First, to run this webapp, as mentioned above, you need to install 3 core requisites.
Here you will find the installation guide to each of those requisites.

<br>

### ☕ JDK 17.0.1 installation guide
* to install `Java SE Development Kit 17` you need to:<br><br>
    * Download the **JDK** file from [Oracle](https://download.oracle.com/java/17/archive/jdk-17.0.1_windows-x64_bin.exe)
      <br><br>
    * Follow the installation menu from Java **JDK** and **DONE!**<br><br>

<br>

### 🍂 Apache Maven installation guide
* to install `Apache Maven` you need to:<br><br>
    * Download it from [Apache Maven](https://dlcdn.apache.org/maven/maven-3/3.9.5/binaries/apache-maven-3.9.5-bin.zip) official website<br><br>
    * Extract the **.zip** file in your preferred directory, I suggest installing it in `C:\Program Files`<br><br>
    * Go to `Edit the system environment variables>Environment Variables...`<br><br>
    * in `User variables` click **New** and:
        * Set **Variable Name** as `MAVEN_HOME`
        * Set **Variable Value** as `C:/YourPathToMavenExtractedFolder`,
          <br>Example: `C:/Program Files/apache-maven-3.9.5`<br><br>
    * In the same window, go to `System Variables`, click in `Path` and **Edit**
        * Click in **New**
        * Add `C:/YourPathToMavenExtractedFolder/bin`
          <br>Example: `C:/Program Files/apache-maven-3.9.5/bin`
        * **Done**.

<br>

### 😺 Apache Tomcat installation guide
* to install `Apache Tomcat` you need to:<br><br>
    * Download it from [Apache Tomcat](https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.14/bin/apache-tomcat-10.1.14-windows-x64.zip) official website<br><br>
    * Extract the **.zip** file in your preferred directory, again I suggest installing it in `C:/Program Files`<br><br>
    * **Done**.

<hr>

## 🌠 Executing the web-app
Since **IntelliJ** only creates Servlet projects with **Maven** or **Gradle** automation tools,
to run this web-app is necessary to clean install it with one of them two (This project uses **Maven**)
and send the **.WAR** file to **Apache Tomcat** webapp folder.<br><br>
To facilitate this sketchy setup, Just execute the following files located in the project folder:
1. `maveninstall.bat`, to build the project compile files with **Maven**.
2. `runevtask.bat`, to run the web-app.
3. `evtaskshutdown.bat`, to shut down the server.<br><br>
* **BE AWARE** that those .bat files have important variables with folder paths, If you followed my suggestions
  everything should be fine. However, if you altered any path in the pre-requisites installation, **DO THIS**:<br><br>
    * In both `runevtask.bat` and `evtaskshutdown.bat`, open the **.bat** file and change
      `TOMCAT_DIR=` to the directory path you installed **Apache Tomcat**.


<hr>

## 👋 That's All
Thanks for your attention! For doubts or problems that may occur in the installation process,
contact me via<br>
<a href="mailto:viniciuspessonio@gmail.com"><img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white"></a>
<br><br>
Link to the **[task asked](https://gitlab.com/levelupschool/evaluation-task/-/blob/main/README.md#levelup-take-home-assignment-october-2023)**
