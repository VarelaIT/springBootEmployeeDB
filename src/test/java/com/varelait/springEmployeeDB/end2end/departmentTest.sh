echo "creating a valid department"
DEPARTMENT1="RRHH"
DESCRIPTION1="Human resources"
http -j post 127.0.0.1:8080/api/department department=$DEPARTMENT1 description="$DESCRIPTION1"

echo "creating an invalid department"
http -j post 127.0.0.1:8080/api/department description="$DESCRIPTION1"

echo "updating a valid department"
http -j patch 127.0.0.1:8080/api/department id=1 department="RD" description="$DESCRIPTION1"

echo "updating an invalid department"
http -j patch 127.0.0.1:8080/api/department id=0 department=$DEPARTMENT1 description="$DESCRIPTION1"

echo "Getting departments"
http get 127.0.0.1:8080/api/department?limit=10&offset=1

echo "Deleting invalid department"
http delete 127.0.0.1:8080/api/department/0

echo "Done"
