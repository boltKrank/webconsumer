#!/bin/bash
kubectl delete deployment webconsumer 
kubectl delete service webconsumer
./gradlew bootBuildImage
docker tag webconsumer:0.1 simonanderson/webconsumer
docker push simonanderson/webconsumer
kubectl apply -f deployment.yaml
kubectl get all
sleep 15
minikube service webconsumer --url


# kubectl port-forward svc/webconsumer 8080:8080
# kubectl expose deployment webconsumer --port=8080
# kubectl create deployment webconsumer --image=simonanderson/webconsumer --dry-run=client -o=yaml > deployment.yaml
# echo --- >> deployment.yaml
# kubectl create service clusterip webconsumer --tcp=8080:8080 --dry-run=client -o=yaml >> deployment.yaml