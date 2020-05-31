# springcloud
## docker config rabbitmq
```
docker run -d --hostname my-rabbit --name rabbit -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=root -e RABBITMQ_DEFAULT_PASS=123456 rabbitmq:3-management

```

## post request to refresh config
```
http://localhost:9002/actuator/bus-refresh
```

## github set webhook
```
http://XXX.XX/monitor
```

## 内网穿透
https://natapp.cn/
