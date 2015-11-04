package cn.shiroblue.route;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 * <p>
 * ======================
 * by WhiteBlue
 * on 15/10/29
 */
public class RouteMatcher {
    private static final Logger LOG = Logger.getLogger(RouteMatcher.class);

    private Set<RouteEntry> routes;

    public RouteMatcher() {
        this.routes = new HashSet<>();
    }

    /**
     * 清空路由表
     */
    public void clearRoutes() {
        routes.clear();
    }

    /**
     * 寻找适配组件
     *
     * @param httpMethod 请求类型
     * @param url        路径
     * @return List
     */
    public List<RouteMatch> findMatchRote(HttpMethod httpMethod, String url) {
        List<RouteMatch> matchSet = new ArrayList<>();

        for (RouteEntry entry : this.routes) {
            if (entry.matches(httpMethod, url)) {
                RouteMatch routeMatch = new RouteMatch(entry.httpMethod, entry.matchPath, url, entry.route, entry.routeType);
                matchSet.add(routeMatch);
            }
        }

        return matchSet;
    }


    /**
     * 添加路由组件
     *
     * @param httpMethod 请求类型
     * @param url        路径
     * @param target     映射对象
     */
    public void putRouteEntry(HttpMethod httpMethod, String url, Route target, RouteType routeType) {
        RouteEntry routeEntry = new RouteEntry(httpMethod, url, target, routeType);

        LOG.debug("RouteMap : [actionType : " + httpMethod + " , map : " + url + "]");

        this.routes.add(routeEntry);
    }


}
