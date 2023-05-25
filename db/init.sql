# 테스트 DB 생성
DROP DATABASE IF EXISTS tag__test;
CREATE DATABASE tag__test;
USE tag__test;

# 개발 DB 생성
DROP DATABASE IF EXISTS tag__dev;
CREATE DATABASE tag__dev;
USE tag__dev;

# DB 생성
DROP DATABASE IF EXISTS tag__prod;
CREATE DATABASE tag__prod;
USE tag__prod;