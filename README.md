# Search Guard Offline TLS Tool

SSL/TLS certificate generation and validation tool for Search Guard

Documentation: [https://docs.search-guard.com/latest/offline-tls-tool#tls-tool](https://docs.search-guard.com/latest/offline-tls-tool#tls-tool)

Download: [Maven central](http://search.maven.org/#search%7Cga%7C1%7Csearch-guard-tlstool)

## Running in Docker
Add your config file, then mount it from the config directory.
```
docker build -t local/searchguard-tls .
docker run -it docker run --rm -v $PWD/config:/workspace/config -v $PWD/certs:/workspace/out local/searchguard-tls-build:latest tools/sgtlstool.sh -c config/example.yml -ca -crt
```
