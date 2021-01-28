#!/bin/bash


#save medico

curl --header "Content-Type: application/json" \
  --request POST --data '{"id":0,"nombre":"pepe","apellidos":"perez","usuario":"pepe93","numColegiado":"1234"}' \
 http://localhost:3000/api/medico/ && echo ""
 
curl --header "Content-Type: application/json" \
  --request POST --data '{"id":0,"nombre":"pedro","apellidos":"ramirez","usuario":"pedro03","numColegiado":"1111"}' \
 http://localhost:3000/api/medico/ && echo ""
 
 #getaAll
 curl http://localhost:3000/api/medico/ && echo ""

 #getaOne
 curl http://localhost:3000/api/medico/1 && echo ""
 
 #findByNombre
 curl http://localhost:3000/api/medico/nombre/fr && echo ""
 
 
 #delete
 
 curl --header "Content-Type: application/json" \
  --request DELETE \
 http://localhost:3000/api/medico/1 && echo ""
 
#save paciente

curl --header "Content-Type: application/json" \
  --request POST --data '{"id":0,"nombre":"pepe","apellidos":"perez","usuario":"pepe93","NSS":"1234","numTarjeta":"7895","telefono":"600112233","direccion":"calle vacia 123"}' \
 http://localhost:3000/api/paciente/
 
curl --header "Content-Type: application/json" \
  --request POST --data '{"id":0,"nombre":"francisco","apellidos":"ramirez","usuario":"fran83","NSS":"1111","numTarjeta":"7869","telefono":"600223344","direccion":"calle nula 456"}' \
 http://localhost:3000/api/paciente/  && echo ""
 
 #getaAll
 curl http://localhost:3000/api/paciente/ && echo ""

 #getaOne
 curl http://localhost:3000/api/paciente/1 && echo ""

 #findByNombre
 curl http://localhost:3000/api/paciente/nombre/fr && echo ""
 
 #delete
 
 curl --header "Content-Type: application/json" \
  --request DELETE \
 http://localhost:3000/api/paciente/51 && echo ""
