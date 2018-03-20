package com.example.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 实现 请求过滤
 */
public class AccessFilter extends ZuulFilter {
    /**
     * 过滤器类型，它决定过滤器在请求的哪个生命周期中执行，这里定义为pre，代表会在请求被路由之前执行
     *
     * pre 可以在请求被路由之前调用
     * routing 在路由请求时被调用
     * post 在routing和error过滤器之后被调用
     * error 在处理请求时发生错误时被调用
     *
     * @return 生命周期
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行的顺序，当请求在一个阶段中存在多个过滤器时，需要根据该方法的返回值来依次执行
     * 数值越小优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤器是否需要被执行，true则为需要执行，false则为不执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑，这里 ctx.setSendZuulResponse(false) 令zuul过滤该请求，然后通过设置code 401 设置其错误码
     *
     * @return
     */
    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println("send " + request.getMethod() + " request to " + request.getRequestURI());
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            System.out.println("accessToken is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        System.out.println("accessToken is ok");
        return null;
    }
}
