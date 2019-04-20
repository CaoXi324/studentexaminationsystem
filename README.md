# studentexaminationsys

### 数据库examination_management_sys中共有如下6张表：

**设置user_id为自增主键，score_id，subject_id，teacher_id，student_id为唯一索引**

**teacher**

| user_id | teacher_id | name   | sex  |
| ------- | ---------- | ------ | ---- |
| 3       | 2001       | 李老师 | 女   |
| 4       | 2002       | 刘老师 | 男   |


**Student**

| user_id | student_id | name   | sex |
|---------|------------|--------|-----|
|       2 |       1002 | 李四   | 女  |
|       3 |       1003 | 大白   | 男  |


**Score**

 | score_id | student_id | subject_id | point |
 |----------|------------|------------|-------|
 |        1 |       1001 |          1 |    98 |
 |        2 |       1002 |          1 |    94 |
 |        3 |       1001 |          2 |    92 |
 |        4 |       1002 |          2 |    97 |

 
 **Subject**
 
| subject_id | name   | teacher_id |
|------------|--------|------------|
|          1 | 语文   |       2001 |
|          2 | 数学   |       2002 |

**User**

| user_id | user_name | user_password | role_id |
|---------|-----------|---------------|---------|
|       2 | lisi      | 123           |       1 |
|       3 | lilaoshi  | 123           |       2 |
|       4 | liulaoshi | 123           |       2 |
|       5 | wangwu    | 123           |       3 |


**Role**

| role_id | role_name |
|---------|-----------|
|       1 | 学生      |
|       2 | 老师      |
|       3 | 管理员    |


