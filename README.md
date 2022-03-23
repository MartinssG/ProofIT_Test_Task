# ProofIT_Test_Task
 This a Test Task for Proof IT Java Developer Position by Mārtiņš Gailis<br/>
### Used tech stack:<br/>
Java 1.8.0_202<br/>
Gradle 7.4.1<br/>
Spring framework<br/>
Eclipse IDE<br/>
### Implementation
When program is launched, a simple RESTful API is created with a single JSON object which contains key/value pairs of bus transport route, current tax rate and bus ticket price. API is accessible at endpoint - http://localhost:8080/busrouteandtax. After accessing the create RESTful API, JSON object is read, and ticket prices for: <br/>
Adult carrying two bags <br/>
Child carrying one bag <br/>
With tax rate of VAT = 21% <br/>

Are calculated and shown in the console. <br/>
Total price = 29.04 EUR

### Launching project multiple times
To launch the project multiple times you must close the used localhost port (8080). If you are running windows go to cmd and type commands: <br/>
netstat -ano <br/>
A list with used ports will show up, after that, find yours (8080) and the PID next to it and type in cmd: <br/>
TASKKILL /F /PID #typeyourpidnumberhere


### That's all, thank you! 
