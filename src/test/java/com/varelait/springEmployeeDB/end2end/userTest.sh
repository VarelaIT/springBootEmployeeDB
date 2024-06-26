echo "creating a valid user."
USER1="ismael@varelait.com"
PASSWD1="alfalfas"
http -j -h post 127.0.0.1:8080/api/user email="$USER1" password="$PASSWD1"

echo "creating an invalid user"
http -j post 127.0.0.1:8080/api/user password="$PASSWD1"

echo "updating a valid user"
USER2="info@varelait.com"
http -j patch 127.0.0.1:8080/api/user/1 email="$USER2" password="$PASSWD1"

echo "updating an invalid user"
http -j patch 127.0.0.1:8080/api/user/0 email="hello world" password="ala"

echo "Getting users"
http get 127.0.0.1:8080/api/user

echo "Deleting invalid user"
http delete 127.0.0.1:8080/api/user/0

echo "Authenticating a valid user"
http -j post 127.0.0.1:8080/api/user/auth email="$USER2" password="$PASSWD1"

echo "Authenticating with invalid password"
http -j post 127.0.0.1:8080/api/user/auth email="$USER2" password="PASSWD"

echo "Done"