#!/bin/bash
./gradlew bootBuildImage
docker tag webconsumer:latest simonanderson/webconsumer
docker push simonanderson/webconsumer
kubectl apply -f deployment.yaml
