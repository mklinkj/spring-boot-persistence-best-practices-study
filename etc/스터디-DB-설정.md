# 스터디 DB 설정



### 공통사항

* DB 사용자: `sbp_user`
* 암호: `sbp_pass`
* 권한: 기본 권한에 테이블을 자유롭게 생성하고 삭제할 수 있는 권한



## MySQL 8.x
> Oracle은 나중에 생각해보고.... 저자님과 동일하게 MySQL 8 기준으로 하는 것이 낫겠다.

```sql
CREATE DATABASE sbp_study CHARACTER SET utf8mb4;

CREATE USER 'sbp_user'@'localhost' IDENTIFIED BY 'sbp_pass';
CREATE USER 'sbp_user'@'%' IDENTIFIED BY 'sbp_pass';

GRANT ALL PRIVILEGES ON sbp_study.* TO 'sbp_user'@'localhost';
GRANT ALL PRIVILEGES ON sbp_study.* TO 'sbp_user'@'%';
-- 위와 같이하면 GRANT OPTION 빼고 모든 권한을 준다.
```



## Oracle XE 18c

```sql
ALTER SESSION SET "_ORACLE_SCRIPT"=true;

CREATE USER sbp_user IDENTIFIED BY sbp_pass
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

GRANT CONNECT, RESOURCE TO sbp_user;

ALTER USER sbp_user DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;
```





## ...



## 의견

바로 사용가능한 DB는 여러가지가 동작 중이니 필요할 때마자 추가해자! 😎