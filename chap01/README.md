# 1장. 연관

## 아이템1: @OneToMany 연관을 효과적으로 하는 방법



### 항상 부모 측에서 자식 측으로 CASCADE



### 부모 측에서 mappedBy 를 설정하는 것을 잊지 마세요!



### 부모 측에서 orphanRemoval 설정



### 연관의 양쪽을 동기화 상태로 유지



### equals() 및 hashCode() 오버라이드



### 연관의 양쪽에서 지연 가져오기(Lazy Fetching) 사용



### toString()이 재정의되는 방법에 주의하세요.



### @JoinColumn을 사용하여 조인 열 이름 지정



> 엔티티를 삭제할 때... `CascadeType.REMOVE`, orphanRemoval=true 가  작업을 수행하는 동안 너무 많은 SQL문을 생성할 수 있음.
> 이후 몇몇 장에 대량 작업 처리 관련해서 나오는데 아래장을 보라고 한다.
>
> * 일괄 삭제: 아이템 52, 53
> * 하위항목 삭제: 아이템 6



### 예제 프로젝트

* 저자님 프로젝트:  [HibernateSpringBootOneToManyBidirectional](https://github.com/AnghelLeonard/Hibernate-SpringBoot/tree/master/HibernateSpringBootOneToManyBidirectional)

* 

### 참조

* JPA 및 Hibernate를 사용하여 equals, hashCode 및 toString을 구현하는 가장 좋은 방법
  * https://vladmihalcea.com/the-best-way-to-implement-equals-hashcode-and-tostring-with-jpa-and-hibernate/



## 의견

* ...

