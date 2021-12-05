package cn.xiaomizhou.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description: 默认资源加载类
 * @author: zyx
 * @create: 2021-12-05 20:46
 **/
public class DefaultResourceLoader implements ResourceLoader {

    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");

        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            //classpath下文件读取
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else {
            try {
                //读取url文件
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                //读取指定路径文件
                return new FileSystemResource(location);
            }
        }
    }
}
