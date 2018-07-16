# Todo Application
## how to run the application
1. run docker-compose first to set up database docker container
```
docker-compose -f ./docker/common/docker-compose.yml up -d
```
2. log into the mysql container execute init.sql manually to create tables for mysql
./todo-app/src/main/resources/init.sql
```bash
# login to mysql conatainer
docker exec -it ${conater_id} /bin/bash
```
3. start configuration service (which listens on port 8888)
4. start serviceDiscoverySvr service (which listens on port 8761)
5. start todo service
