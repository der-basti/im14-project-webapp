# im14-project-webapp

TH-Wildau - WIR - IM14 - WebApp - Java EE security project

Topic: Online-Personalvermittlung

## build

> git clone https://github.com/der-basti/im14-project-webapp.git
> mvn clean install

## deploy

http://www.mkyong.com/maven/how-to-deploy-maven-based-war-file-to-tomcat/
> mvn tomcat7:deploy
> mvn tomcat7:undeploy 
> mvn tomcat7:redeploy

https://docs.jboss.org/wildfly/plugins/maven/latest/deploy-mojo.html
> mvn wildfly:deploy

https://www.initworks.com/wiki/display/public/Deploying+to+Glassfish+from+Maven
> mvn glassfish:deploy

## run

* http://127.0.0.1:8080/im14-project-webapp/
* http://localhost:8080/im14-project-webapp/
