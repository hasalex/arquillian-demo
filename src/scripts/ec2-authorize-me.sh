#!/bin/sh

# Open the JBoss ports on the quicklaunch-1 security group for the current ip
# Needs to have the demo war deployed under the /arq context root

ip=`curl -s http://aws.sewatech.net:8080/arq/ip`

export EC2_HOME=/opt/ec2-api-tools
export JAVA_HOME=/Library/Java/Home
export EC2_PRIVATE_KEY=$HOME/.amazon/pk-LGHQQAYUDJF2B667OVPBZHYT26WXTEZW.pem
export EC2_CERT=$HOME/.amazon/cert-LGHQQAYUDJF2B667OVPBZHYT26WXTEZW.pem

$EC2_HOME/bin/ec2-authorize JBoss -P tcp -p 1090-1091 -s $ip/32
$EC2_HOME/bin/ec2-authorize JBoss -P tcp -p 9990 -s $ip/32
$EC2_HOME/bin/ec2-authorize JBoss -P tcp -p 9999 -s $ip/32
