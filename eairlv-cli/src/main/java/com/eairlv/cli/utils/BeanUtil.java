package com.eairlv.cli.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BeanUtils工具
 *
 * @author lv
 * @date 2018-05-17
 */
@Log4j2
public class BeanUtil {

    private static Map<String, BeanCopier> beanCopierMap = new HashMap<>();

    /**
     * @param source 资源类
     * @param target 目标类
     * @Title: copyProperties
     */
    public static void copyProperties(Object source, Object target) {
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier;

        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }

        copier.copy(source, target, null);
    }

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.toString() + class2.toString();
    }

    /**
     * 复制Bean当中的相同名称的属性
     *
     * @param source 源
     * @param target 目标
     * @param <T>    类型
     * @return
     */
    public static <T> T copyProperties(Object source, Class<T> target) {
        if (source == null){
            return null;
        }
        T orig = null;
        try {
            orig = target.newInstance();
            copyProperties(source, orig);
        } catch (InstantiationException | IllegalAccessException e) {
            log.warn("BeanUtil copyProperties error");
        }
        return orig;
    }

    /**
     * 复制Bean当中的相同名称的属性（批量）
     * @param source
     * @param target
     * @param <T>
     * @return
     */
    public static <T> List<T> copyPropertiesBatch(List source, Class<T> target){
        if (source == null || source.isEmpty()){
            return new ArrayList<>();
        }
        List<T> result = new ArrayList<>();
        try {
            for (Object aSource : source) {
                T orig = target.newInstance();
                copyProperties(aSource, orig);
                result.add(orig);
            }
        } catch (InstantiationException | IllegalAccessException e){
            log.warn("BeanUtil copyPropertiesBatch error");
        }
        return result;
    }
}
