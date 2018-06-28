# Todo Application
## how to run the application
1. run docker-compose first to set up database docker container
2. log into the mysql container execute init.sql manually to create tables for mysql
3. start configuration service (which listens on port 8888)
4. start serviceDiscoverySvr service (which listens on port 8761)
5. start todo service