# Spring Fun
This is a simple REST API that allows CRUD operations for Orders and Products using MongoDB.

#### Design Features
* *Create* Order.
* *Patch* Order.
* *Read*Order.
* *Delete* Order.
* *Create* Product.
* *Patch* Product.
* *Read*Product.
* *Delete* Product.

#### Technical Features
* *MVC pattern*.
* Java 11.
* Gradle 7.1.
* SpringBoot 2.7.1
* Mongo Atlas

## Running
0. Prerequisites
```
Be aware on having above versions
```
1. Get the repo
```
git clone git@github.com:zphoenixz/spring-fun.git
```
2. Go to the repo folder
```
cd spring-fun
```
3. Start MySQL
```

```
4. Start Spring Application
```
Run src/main/java/com/phoenix/springfun/SpringFunApplication Main Application
```
5. Test Api, Import Postman Collection (optional)
```
Copy from postman/.postman_collection.json
```
6. Test API, You can run the Frontend by following instructions on its repo:
```
https://github.com/zphoenixz/web-fun
```

#### Screenshots
<p align="center">
<img src="https://github.com/zphoenixz/web-fun/blob/master/screenshots/order.png" width="500" height="400">
</p>
<p align="center">
<img src="https://github.com/zphoenixz/web-fun/blob/master/screenshots/create-order.png" width="500" height="400">
</p>
<p align="center">
<img src="https://github.com/zphoenixz/web-fun/blob/master/screenshots/product.png" width="500" height="400">
</p>
<p align="center">
<img src="https://github.com/zphoenixz/web-fun/blob/master/screenshots/create-product.png" width="500" height="400">
</p>

## My comments
The pattern is well (not perfect) developed, you can see all the BL correctly ordered on models, services, controllers, using a pseudo Builder pattern just for decoupling purposes.
Nevertheless, there are lots of points where this can be improved, I will mention some of them on the following list:
* Use proper abstract schemas to validate straight from the concrete models.
* Write a proper way to Build Models for DB transactions.
* Implement an Authentication BL, although users are able to register with password, atm we are not using any Login BL.
* Enrich model fields, as of now our models have the least possible amount of fields.
* Although audit tracks like CreatedAt, UpdatedAt, are added still they are not well designed to fully work with the project for reasons other that ordering.
* more....