echo "creating a company"
echo '{"company":"Eventum Artifex", "description":"Compañia de eventos."}' | http -j post 127.0.0.1:8080/api/company

echo "Getting company with no page"
http get 127.0.0.1:8080/api/company
