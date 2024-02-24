#!/bin/sh
#
VERSION=$(head -n 1 version.txt)
DESTINATION=/Users/joncaulfield/Scratch/Metacode/v${VERSION}/

mkdir -pv ${DESTINATION} 

cp application/mc-cli/build/libs/metacode-${VERSION}-all.jar ${DESTINATION}

