mvn clean install
mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
docker build -t cake_api:latest .