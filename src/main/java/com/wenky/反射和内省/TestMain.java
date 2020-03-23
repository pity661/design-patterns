package com.wenky.反射和内省;

import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-02-27 16:39
 **/
public class TestMain {
    // 应该有的bean对象复制方法
    // 1.对象所有属性的复制。2.复制指定属性。3.除指定属性外的其余属性。

  public static void main(String[] args) throws Exception {
      BaseDO baseDO = new BaseDO();
      baseDO.setBo(Boolean.FALSE);
      baseDO.setStr("1");
      baseDO.setLo(2l);
      baseDO.setStr("new");

    //System.out.println(JSON.toJSON(baseDO).toString());

      OtherBaseDO otherBaseDO = new OtherBaseDO();
      otherBaseDO.setStr("111");
      otherBaseDO.setBoo(Boolean.TRUE);

      CopyDO copyDO = new CopyDO();
      // 自实现拷贝逻辑
      //copy(baseDO,copyDO);

      // 拷贝完整对象
      BeanUtils.copyProperties(copyDO,baseDO);
      // 拷贝单个属性
      BeanUtils.copyProperty(copyDO,"str",otherBaseDO.getStr());

      Map<String, String> map = BeanUtils.describe(copyDO);
      System.out.println(map);
      System.out.println(copyDO.getStr());
      System.out.println(copyDO.getIn());
      System.out.println(copyDO.getBo());
      System.out.println(copyDO.getBoo());


      BaseDO baseDO1 = new BaseDO();
      baseDO1.setStr("str");
      baseDO1.setLo(1l);
      baseDO1.setBo(false);

      CopyDO copyDO1 = new CopyDO();
      copyPropertiesContain(baseDO1,copyDO1,"str","lo");

    System.out.println(copyDO1.getBo());
    System.out.println(copyDO1.getLo());
    System.out.println(copyDO1.getStr());
  }

  // 拷贝两个对象所有的属性
  public static void copyProperties(Object source,Object target) throws Exception {
      // 获取对象的BeanInfo信息
      BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), Object.class);
      // 获取属性的描述器
      PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();

      BeanInfo targetBean = Introspector.getBeanInfo(target.getClass(), Object.class);
      PropertyDescriptor[] targetProperty = targetBean.getPropertyDescriptors();

      Arrays.asList(sourceProperty).stream().forEach(sourceSingle -> {
          Arrays.asList(targetProperty).stream().forEach(targetSingle -> {
              if (sourceSingle.getName().equals(targetSingle.getName())
                      && sourceSingle.getPropertyType() == targetSingle.getPropertyType()) {
                  try {
                      // 通过反射机制来调用getter/setter方法
                      targetSingle.getWriteMethod().invoke(target,sourceSingle.getReadMethod().invoke(source));
                  } catch (IllegalAccessException e) {
                      e.printStackTrace();
                  } catch (InvocationTargetException e) {
                      e.printStackTrace();
                  }
              }
          });
      });
  }

  // 拷贝两个对象除指定属性外的其余属性
    public static void copyPropertiesExcept(Object source,Object target,String ... properties) throws Exception {
        // 获取对象的BeanInfo信息
        BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), Object.class);
        // 获取属性的描述器
        PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();

        BeanInfo targetBean = Introspector.getBeanInfo(target.getClass(), Object.class);
        PropertyDescriptor[] targetProperty = targetBean.getPropertyDescriptors();

        List<String> exceptNames = Arrays.asList(properties);

        Arrays.asList(sourceProperty).stream().forEach(sourceSingle -> {
            Arrays.asList(targetProperty).stream().forEach(targetSingle -> {
                if (sourceSingle.getName().equals(targetSingle.getName())
                        && sourceSingle.getPropertyType() == targetSingle.getPropertyType() && !exceptNames.contains(sourceSingle.getName())) {
                    try {
                        // 通过反射机制来调用getter/setter方法
                        targetSingle.getWriteMethod().invoke(target,sourceSingle.getReadMethod().invoke(source));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });
        });
    }

    // 拷贝两个对象指定的属性
    public static void copyPropertiesContain(Object source,Object target,String ... properties) throws Exception {
        // 获取对象的BeanInfo信息
        BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), Object.class);
        // 获取属性的描述器
        PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();

        BeanInfo targetBean = Introspector.getBeanInfo(target.getClass(), Object.class);
        PropertyDescriptor[] targetProperty = targetBean.getPropertyDescriptors();

        List<String> containNames = Arrays.asList(properties);

        Arrays.asList(sourceProperty).stream().forEach(sourceSingle -> {
            Arrays.asList(targetProperty).stream().forEach(targetSingle -> {
                if (sourceSingle.getName().equals(targetSingle.getName())
                        && sourceSingle.getPropertyType() == targetSingle.getPropertyType()
                        && containNames.contains(sourceSingle.getName())) {
                    try {
                        // 通过反射机制来调用getter/setter方法
                        targetSingle.getWriteMethod().invoke(target,sourceSingle.getReadMethod().invoke(source));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            });
        });
    }
}
