# 使用官方的 OpenJDK 17 基础镜像
FROM openjdk:17

# 维护者信息
LABEL maintainer="tangbaba"

# 设置工作目录
WORKDIR /service/jar

# 设置容器时区为当前时区（Asia/Shanghai）
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo 'Asia/Shanghai' > /etc/timezone

# 将宿主机的 /tmp 目录挂载为容器的数据卷
VOLUME /tmp

# 复制本地的 JAR 文件到容器中，并重命名为 app.jar
COPY target/thinking-one.jar app.jar

# 容器启动时运行的命令
CMD ["java", "-jar", "app.jar"]

# 声明容器提供服务的端口
EXPOSE 8888
