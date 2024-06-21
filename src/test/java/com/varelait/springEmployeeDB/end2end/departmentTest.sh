echo "creating a valid department"
DEPARTMENT1="RRHH"
DESCRIPTION1="Human resources"
http -j post 127.0.0.1:8080/api/department department=$DEPARTMENT1 description="$DESCRIPTION1"

echo "Getting departments"
http get 127.0.0.1:8080/api/department?limit=10&offset=1

echo "Deleting invalid department"
http delete 127.0.0.1:8080/api/department/0

echo "Done"
