# MySQL新版 JDBC Driver 設定

1. Driver

   ```java
   String driver = "com.mysql.jdbc.Driver"; 改成
   String driver = "com.mysql.cj.jdbc.Driver";
   ```

2. 無法辨識時區，加上serverTimezone的相關設定(CST是中原標準時間)

   ```java
   url = "jdbc:mysql://localhost:3306/myDB" 改成
   url = "jdbc:mysql://localhost:3306/myDB?serverTimezone=CST"
   ```

Reference: [MySQL新版 JDBC Driver 設定](https://carrie-lai.github.io/post/mysql_new_jdbcdriver/)
