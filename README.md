# Test-Application-Interview
user CRUD operation API


API
1. Save User (POST /api/v1/user)

Method: POST
URL: http://localhost:8080/api/v1/user
{
  "username": "john_doe",
  "password": "password123",
  "active": true
}

2. Get All Users (GET /api/v1/user)
Method: GET
URL: http://localhost:8080/api/v1/user

3. Update User (PUT /api/v1/user/{id})

Method: PUT
URL: http://localhost:8080/api/v1/user/{id} 

{
  "username": "updated_user",
  "password": "updated_password",
  "active": false
}


4. Delete User (DELETE /api/v1/user/{id})

Method: DELETE
URL: http://localhost:8080/api/v1/user/{id}
