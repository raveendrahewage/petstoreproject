# Pet Store Mini Project

## Introduction

**This is an API that I have developed for a Pet Store using the Quarkus. Here I have used some openApi specification for generating the swagger documentation and some annotations of that for modifying the swagger documentation.**


**Link for the swagger documentation : http://localhost:8080/q/swagger-ui/**

## CategoryController Endpoints

## ``(POST) /data/pet-category/add-category/``


### *Adding a new category(pet type).*


###  curl -X 'POST' \
    'http://localhost:8080/data/pet-category/add-type' \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -d '{
        "name":"Bird",
        "dynasty":"Mamelia",
        "region":"Asian",
        "scientificName":"Birdano Birdiano"
    }'
---


## ``(GET) /data/pet-category/{id}``


### *Getting the data of a category by ID.*


###  curl -X 'DELETE' \


    'http://localhost:8080/data/pet-category/' \
    -H 'accept: */*'


---


## ``(GET) /data/pet-category/``


### *Getting all categories as a list.*


###  curl -X 'GET' \


    'http://localhost:8080/data/pet-category/' \
    -H 'accept: */*'


---


## ``(PUT) /data/pet-category/{id}``


### *Updating a category by ID.*


###  curl -X 'PUT' \


    'http://localhost:8080/data/pet-category/1' \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -d '{
        "name":"Iguana",
        "dynasty":"Reptile",
        "region":"East",
        "scientificName":"Reptile Reptilea"
    }'


---


## ``(DELETE) /data/pet-category/{id}``


### *Deleting a category by ID.*


###  curl -X 'DELETE' \


    'http://localhost:8080/data/pet-category/1' \
    -H 'accept: */*'


---


## PetController Endpoints


## ``(POST) /data/pet/add-pet/``


### *Adding the pet into the database.*


### curl -X 'POST' \


    'http://localhost:8080/data/pet/add' \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -d '{
        "typeId":1,
        "petName":"Tyna",
        "birthday":"2017-02-19",
        "gender":"Male",
        "owner":"David",
        "weight":14.35
    }'


---


## ``(GET) /data/pet/{id}``


### *Getting the data of a certain pet by ID.*


###  curl -X 'GET' \


    'http://localhost:8080/data/pet/1' \
    -H 'accept: */*'


---


## ``(GET) /data/pet/``


### *Getting all pets as a list.*


###  curl -X 'GET' \


    'http://localhost:8080/data/pet' \
    -H 'accept: */*'


---


## ``(PUT) /data/pet/{id}``


### *Updating certain pet by the ID.*


###  curl -X 'PUT' \


    'http://localhost:8080/data/pet/1' \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -d '{
        "petName": "Pinky",
        "birthday": "2012-10-23",
        "gender": "Female",
        "owner": "Kamal",
        "weight": 10.34
    }'


---


## ``(DELETE) /data/pet/{id}``


### *Deleting certain pet by ID.*


###  curl -X 'DELETE' \


    'http://localhost:8080/data/pet/delete/1' \
    -H 'accept: */*'


---


## ``(GET) /data/pet/search-all?content={Pinky}``


### *Searching a pet by pet name, gender or owner.*


###  curl -X 'GET' \


    'http://localhost:8080/data/pet/search-all?content=Pinky' \
    -H 'accept: */*'