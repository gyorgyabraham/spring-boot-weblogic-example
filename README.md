# spring-boot-weblogic-example
An example spring-boot application ready to be deployed in weblogic (tested in 12c).

This is a very minimalistic application, but it already has some basics:
- xsd file to define contract
- mock service providing soap endpoint, utilizing generated classes from xsd
- spring-boot and maven based build

1) Execute **mvn clean package**
2) Deploy resulting **.war** file into weblogic
3) You are all set! You can already **POST** request.xml to **http://localhost:7001/mockservice** (provided you have a running weblogic instance locally)

![alt text](https://raw.githubusercontent.com/gyorgyabraham/spring-boot-weblogic-example/master/weblogic.png "Deployed into weblogic")

```
[gyuszi@gyuszidev spring-boot-weblogic-example]$ curl -X POST -H "Content-Type: text/xml" --data-binary @request.xml http://localhost:7001/mockservice
<env:Envelope xmlns:env="http://schemas.xmlsoap.org/soap/envelope/">
    <env:Header/>
    <env:Body>
        <ResponseStructure xmlns="http://gyorgyabraham.hu">
            <rsuid>errer2323sdfsdf</rsuid>
            <message>Hello from example app!</message>
        </ResponseStructure>
    </env:Body>
</env:Envelope>
[gyuszi@gyuszidev spring-boot-weblogic-example]$
```