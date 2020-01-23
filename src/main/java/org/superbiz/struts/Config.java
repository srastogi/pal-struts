package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public FilterRegistrationBean<SiteMeshFilter> siteMeshFilterFilterRegistrationBean() {
        FilterRegistrationBean<SiteMeshFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new SiteMeshFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<StrutsPrepareAndExecuteFilter> strutsPrepareAndExecuteFilterFilterRegistrationBean() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new StrutsPrepareAndExecuteFilter());
        filterRegistrationBean.addUrlPatterns(
                "/",
                "/addUserForm.action",
                "/addUser.action",
                "/findUserForm.action",
                "/findUser.action",
                "/listAllUsers.action"
        );
        filterRegistrationBean.addInitParameter("actionPackages", "com.lq");
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }
}
