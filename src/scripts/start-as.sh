
echo `pwd`;

jbossas6_home=/opt/java/jboss-6.0.0.Final
jbossas7_home=/opt/java/jboss-as-web-7.0.1.Final
glassfish3_home=/opt/java/glassfish-3.1

case $1 in
g3)
$glassfish3_home/bin/asadmin start-domain
;;
j6)
export JBOSS_HOME=$jbossas6_home
$jbossas6_home/bin/run.sh &	
;;
j7)
export JBOSS_HOME=$jbossas7_home
$jbossas7_home/bin/standalone.sh &
;;
esac
