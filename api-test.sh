#!/bin/bash


#save

curl --header "Content-Type: application/json" \
  --request POST --data '{"id":0,"nombre":"pepe","apellidos":"perez","usuario":"pepe93","numColegiado":"1234"}' \
 http://localhost:3000/api/medico/
 
curl --header "Content-Type: application/json" \
  --request POST --data '{"id":0,"nombre":"pedro","apellidos":"ramirez","usuario":"pedro03","numColegiado":"1111"}' \
 http://localhost:3000/api/medico/
 
 #getaAll
 curl http://localhost:3000/api/medico/ && echo ""

 #getaOne
 curl http://localhost:3000/api/medico/1 && echo ""
 
 
 #delete
 
 curl --header "Content-Type: application/json" \
  --request DELETE \
 http://localhost:3000/api/medico/1
 
