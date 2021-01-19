#!/bin/bash

mvn install:install-file -Dfile=lib/ojdbc8.jar -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=19.3 -Dpackaging=jar 
