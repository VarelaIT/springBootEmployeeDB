echo "creating a valid employees"
echo '{"identification":"0234-234-22", "fullname":"Ismael J. Varela", "birth":"2000-12-22", "department":{"department":"R&D", "description":"Research"}}' | http -j post 127.0.0.1:8080/api/employee

echo '{"identification":"0234-8394-22", "fullname":"Samuel Varela", "birth":"2002-2-2", "department":null}' | http -j post 127.0.0.1:8080/api/employee

echo '{"identification":"001-23434-2", "fullname":"John Doe", "birth":"1999-1-27", "department":{"id":1, "department":"R&D", "description":"Research"}}' | http -j post 127.0.0.1:8080/api/employee

echo "Getting employees with no page"
http get 127.0.0.1:8080/api/employee