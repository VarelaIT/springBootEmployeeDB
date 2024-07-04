echo "creating a valid payments"
echo '{"date":"2024-05-25", "salary":30000, "amount":2346.34, "employeeId":1}' | http -j post 127.0.0.1:8080/api/payment

echo '{"date":"2024-06-25", "salary":30000, "amount":2346.34, "employeeId":1}' | http -j post 127.0.0.1:8080/api/payment

echo '{"date":"2024-06-25", "salary":27000, "amount":2000.34, "employeeId":2}' | http -j post 127.0.0.1:8080/api/payment

echo '{"date":"2024-06-26", "salary":25000, "amount":1535.34, "employeeId":3}' | http -j post 127.0.0.1:8080/api/payment

echo '{"date":"2024-06-26", "salary":19000, "amount":1284.34, "employeeId":4}' | http -j post 127.0.0.1:8080/api/payment

echo '{"date":"2024-06-28", "salary":20000, "amount":1123.34, "employeeId":5}' | http -j post 127.0.0.1:8080/api/payment

echo "Getting payments with no page"
http get 127.0.0.1:8080/api/payment

echo "Getting payments page 1 size 3"
http get "127.0.0.1:8080/api/payment?page=1&size=3"

echo "Getting payment by id"
http get 127.0.0.1:8080/api/payment/1

echo "Getting payments by date pattern"
http get 127.0.0.1:8080/api/payment/by-date/2024-6-26

echo "Getting payments by employeeId"
http get 127.0.0.1:8080/api/payment/by-employee/1
