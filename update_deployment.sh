#!/bin/bash
kubectl delete deployment webconsumer 
kubectl delete service webconsumer
./gradlew bootBuildImage
docker tag webconsumer:0.1 simonanderson/webconsumer
docker push simonanderson/webconsumer
kubectl apply -f deployment.yaml
kubectl get all
sleep 20
kubectl port-forward svc/webconsumer 8080:8080
