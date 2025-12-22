##Screenshots

###[Server Started]
![Server Started](screenshots/server.png)

### Client Connected
![Client Connected](screenshots/client.png)

### client1
![clientDemo](screenshots/client1.png)

### client2
![clientDemo](screenshots/client2.png)



\# 🚀 Broadcast Server (Spring Boot + WebSocket)



A \*\*CLI-based real-time broadcast server\*\* built using \*\*Spring Boot\*\*, \*\*Java 21\*\*, and \*\*WebSockets\*\*.  

Multiple clients can connect to the server and any message sent by one client is \*\*broadcast to all connected clients\*\* in real time.



This project demonstrates how real-time systems like \*\*chat applications\*\*, \*\*live notifications\*\*, and \*\*collaboration tools\*\* work internally.



---



\## 🧩 Features



\- Real-time communication using \*\*WebSockets\*\*

\- Supports \*\*multiple concurrent clients\*\*

\- CLI-based \*\*Server / Client modes\*\*

\- Username-based authentication (basic)

\- Graceful handling of client connect/disconnect

\- Built with \*\*Java 21\*\* and \*\*Spring Boot\*\*



---



\## 🛠️ Tech Stack



\- \*\*Java 21\*\*

\- \*\*Spring Boot 3.x\*\*

\- \*\*Spring WebSocket\*\*

\- \*\*Maven\*\*

\- \*\*CLI-based interaction\*\*



---



\## 📁 Project Structure



broadcast-server

├── src

│ └── main

│ └── java

│ └── com.broadcast.server

│ ├── BroadcastServerApplication.java

│ ├── cli

│ ├── websocket

│ └── registry

├── pom.xml

└── README.md





\## ▶️ How It Works



The application runs in \*\*two modes\*\*, controlled via program arguments:



| Mode | Argument | Description |

|---|---|---|

| Server | `start` | Starts the WebSocket broadcast server |

| Client | `connect` | Connects a client to the server |



---



\## 🚀 How to Run the Project



\### ✅ Prerequisites



\- Java \*\*21\*\*

\- Maven

\- IntelliJ IDEA (recommended)



Verify:

```bash

java -version

mvn -version

🟢 Step 1: Run the Server

Using IntelliJ IDEA:



Create a Run Configuration:



Main class:



pgsql

Copy code

com.broadcast.server.BroadcastServerApplication

Program arguments:



powershell

Copy code

start

JDK: 21



Click ▶️ Run



✅ Output:



nginx

Copy code

Tomcat started on port 8080

🟢 Step 2: Run the Client

Option A: IntelliJ (Duplicate Config)

Duplicate the Server run configuration



Change Program arguments to:



arduino

Copy code

connect

Run it multiple times to simulate multiple clients.



Option B: Terminal

bash

Copy code

mvn spring-boot:run -Dspring-boot.run.arguments=connect

🧪 Testing the Broadcast

Start Server



Start 2 or more Clients



Type a message in one client:



nginx

Copy code

Hello

✅ Message appears in all connected clients



🌐 WebSocket Endpoint

bash

Copy code

ws://localhost:8080/broadcast

🔐 Authentication (Basic)

Each client provides a username during connection



Server tracks connected users



Messages are broadcast with sender information



📦 Build JAR

bash

Copy code

mvn clean package

Run:



bash

Copy code

java -jar target/broadcast-server-0.0.1-SNAPSHOT.jar start



📌 Future Improvements

JWT-based authentication



Message history (Redis / DB)



Secure WebSockets (WSS)



Docker \& CI/CD pipeline



Web UI client



👨‍💻 Author/Devloper

Shubham Pandey







