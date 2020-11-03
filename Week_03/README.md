学习笔记

Week03-周四作业
1.整合你上次作业的 httpclient/okhttp
 在outbound.okhttp.OkhttpOutboundHandler中

Week03-周六作业
1.实现过滤器。
在HttpInboundHandler中添加：
```
new HttpRequestFilter() {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        HttpHeaders headers = fullRequest.headers();
        headers.add("nio", "chenk");
        fullRequest.headers().set(headers);
    }
}.filter(fullRequest, ctx);
```