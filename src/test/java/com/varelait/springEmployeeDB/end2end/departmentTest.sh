echo "creating a valid department"
http -j post 127.0.0.1:8080/api/department department="RRHH" description="Human resources"

echo "Getting departments"
http get 127.0.0.1:8080/api/department?limit=10&offset=1

echo "Done"
