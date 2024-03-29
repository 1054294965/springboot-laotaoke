package com.example.accessingdatamysql;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SaveUtils {
	public static <T> T updateEntity(T entity, T oldEntity) {
		Class clazz = entity.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) { // 遍历属性
			try {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
				Method readMethod = pd.getReadMethod(); // 获取属性的get方法
				Method writeMethod = pd.getWriteMethod(); // 获取属性的set方法
				if (readMethod.invoke(entity) != null) { // 如果这个属性不为null
					// old对象set(entity.get()) old对象将属性值设置为entity的属性值
					writeMethod.invoke(oldEntity, readMethod.invoke(entity));
				}
			} catch (Exception e) {

			}
		}
		return oldEntity;
	}
}
