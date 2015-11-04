package cn.shiroblue;

import cn.shiroblue.core.HaltException;
import cn.shiroblue.core.RouteMatcherFactory;
import cn.shiroblue.route.FilterRoute;
import cn.shiroblue.route.HandlerRoute;
import cn.shiroblue.route.HttpMethod;

/**
 * Description:
 * <p>
 * ======================
 * by WhiteBlue
 * on 15/10/30
 */
public class Action {

    private Action() {
    }

    public static void get(String path, HandlerRoute route) {
        RouteMatcherFactory.get().putRouteEntry(HttpMethod.GET, path, route);
    }

    public static void post(String path, HandlerRoute route) {
        RouteMatcherFactory.get().putRouteEntry(HttpMethod.POST, path, route);
    }

    public static void put(String path, HandlerRoute route) {
        RouteMatcherFactory.get().putRouteEntry(HttpMethod.PUT, path, route);
    }

    public static void patch(String path, HandlerRoute route) {
        RouteMatcherFactory.get().putRouteEntry(HttpMethod.PATCH, path, route);
    }

    public static void delete(String path, HandlerRoute route) {
        RouteMatcherFactory.get().putRouteEntry(HttpMethod.DELETE, path, route);
    }

    public static void before(String path, FilterRoute route) {
        RouteMatcherFactory.get().putRouteEntry(HttpMethod.before, path, route);
    }

    public static void after(String path, FilterRoute route) {
        RouteMatcherFactory.get().putRouteEntry(HttpMethod.after, path, route);
    }




    public static void halt() {
        throw new HaltException();
    }

    public static void halt(int status) {
        throw new HaltException(status);
    }

    public static void halt(String body) {
        throw new HaltException(body);
    }

    public static void halt(int status, String body) {
        throw new HaltException(status, body);
    }

}
