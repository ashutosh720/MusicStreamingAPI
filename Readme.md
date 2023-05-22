# Music streaming service API :-

# Swagger- http://13.211.58.141:8080/swagger-ui/index.html#/

# Frameworks and language used:
## Java with jdk version 17
## Spring Boot
## SQL database
## Postman
## Swagger
## Dependencies- 
### Springboot dev tools
### Spring Web
### Spring Data JPA
### Lombok
### Validation
### MySQl Driver

# Data Flow
## Model : There are Four Models class in this application.
### Users Model Class.
### Admin Model Class.
### Playlist Model Class.
### Songs Model Class.

## Controller :There are Five Controller classse in this application.
### AdminController Class.
### UsersController Class.
### PlaylistController Class.
### SongsController class.

## Service : There are Four Service class in this application.
### UsersService Class.
### AdminService Class.
### SongService Class.
### Playlist Service Class

## Repository :There are Four Repository Interfaces in this application.
### UsersRepository Interface.
### AdminRepository Interface.
### SongsRepository Interface.
### PlaylistRepository Interface

## Exception Classes-Exceptions are thrown and handled
### AlreadyExistsException
### NotFoundException
### UnauthorizedUserException

## Database
### I have used SQL Database to store the data.
### I have deployed this project on AWS EC2 machine.

# API Documentation
## UserController-
### POST-/api/v1/user/register
### POST- /api/v1/user/authenticate
### GET- /api/v1/user/findbyId/{user_id}

## AdminController-
### POST-/api/v1/admin/register
### POST- /api/v1/admin/authenticate
### GET- /api/v1/admin/findbyId/{admin_id}

## SongController-
### POST-/api/v1/songs/admin/{admin_id}/add_song
### PUT-/api/v1/songs/admin/{admin_id}/update_song/{songId}
### GET-/api/v1/songs
### GET-/api/v1/songs/{SongId}
### GET-/api/v1/songs/name/{name}

## PlaylistController-
### POST-/api/v1/playlist/{p_id}/song/{songId}
### DELETE-/api/v1/playlist/{p_id}/song/{songId}
### POST-/api/v1/playlist/add-playlist
### GET-/api/v1/playlist/user_id/{user_id}

# Project Summary
### This project is a music streaming service API that allows two types of users: Normal and Admin users. Admin users have the authority to perform CRUD (Create, Read, Update, and Delete) operations on songs, while  normal users can only add songs to their playlists and perform CRUD operations on their playlists.

### The API is built using MySQL database to store songs and user playlists, and its IP address of the deployment link must be static to ensure its availability. Additionally, the API uses annotation-based validation to ensure that all user inputs are valid before being processed.

### The project structure includes a controller service and a repository, providing a clear separation of concerns and making the code more modular. Furthermore.

### To ensure data security and user data privacy, normal users cannot create or do CRUD operations on songs, and only Admin users have the necessary permissions to perform these actions. This ensures that the API is both secure and user-friendly.

### Overall, this project provides a scalable and secure API for music streaming services that allows users to manage their playlists effectively while ensuring the safety of their data.
