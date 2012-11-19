echo "NEXT Tests run: glassfish-embedded"
mvn clean test -Pglassfish-embedded

echo "NEXT Tests run: glassfish-remote"
/opt/java/glassfish-3/bin/asadmin start-domain
mvn clean test -Pglassfish-remote
/opt/java/glassfish311/bin/asadmin stop-domain

echo "NEXT Tests run: openejb-embedded"
mvn clean test -Popenejb-embedded

echo "NEXT Tests run: weldse-embedded"
mvn clean test -Pweldse-embedded

echo "NEXT Tests run: jbossas7-managed"
mvn clean test -Pjbossas7-managed

echo "NEXT Tests run: jbossas7-remote"
nohup /opt/java/jboss-as-7/bin/standalone.sh
sleep 10
mvn clean test -Pjbossas7-remote
kill `jps | grep jboss-modules.jar | cut -f 1 -d ' '`

echo "NEXT Tests run: jbossas7-aws"
mvn clean test -Pjbossas7-aws

echo "NEXT Tests run: cloudbees"
mvn clean test -Pcloudbees
