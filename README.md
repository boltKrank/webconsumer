# webconsumer

A springboot web interface for a Java app that deliberately consumes resources

## Prerequisites

- Java 17 or above: `brew install openjdk@17`  (17 can be replaced with 21 if you want a higher version)
- Gradle:  `brew install gradle`

## Build boot image

**NOTE** Docker needs to be running for this to work

```bash
./gradlew bootBuildImage
```

Tag the image so it can be deployed to k8s

```bash
docker tag webconsumer:0.1 simonanderson/webconsumer
docker push simonanderson/webconsumer
```

Check the image has been build with the command

```
docker image ls -a]
```
"webconsumer" should come up in the list of images  

To test this image, run the command

```bash
docker run -it -p8080:8080 webconsumer:0.0.1-SNAPSHOT
```

**NOTE** the part "0.0.1-SNAPSHOT" may be different check the output of the previous command

To deploy it to the cluster
```bash
kubectl create deployment webconsumer-node --image=docker.io/library/webconsumer --dry-run=client -o=yaml > deployment.yaml
echo --- >> deployment.yaml
kubectl create service clusterip webconsumer-node --tcp=8080:8080 --dry-run=client -o=yaml >> deployment.yaml
```

Deploy:
```bash
kubectl apply -f deployment.yaml
```

kubectl create deployment hello-node --image=registry.k8s.io/e2e-test-images/agnhost:2.39 -- /agnhost netexec --http-port=8080


Check deployment with
```bash
kubectl get pods
```

```bash
kubectl port-forward svc/webconsumer-node 8080:8080
```