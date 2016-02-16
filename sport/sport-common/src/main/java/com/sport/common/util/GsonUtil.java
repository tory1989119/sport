package com.sport.common.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @ClassName: GsonUtil
 * @Package com.spark.core.utils.json
 * @Description: google json的工具包
 * @author rockyLee
 * @date 2015-7-14 下午3:02:48
 * 
 */
public class GsonUtil {

	/**
	 * @param <T>
	 * @Title: convertJson2Object
	 * @Description: 将标准json转换成obj对象
	 * @param jsonString
	 *            json字符串
	 * @param cls
	 *            目标obj class
	 * @return
	 * @throws GsonException
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T getObject(String json, Class clazz) {
		Type objectType = clazz;
		return getGson().fromJson(json, objectType);
	}


	public static <T> List<T> convertJson2List(String json, Class<T> clazz) throws JsonSyntaxException {

		Type type = new TypeToken<ArrayList<JsonObject>>() {}.getType();
		ArrayList<JsonObject> jsonObjs = new Gson().fromJson(json, type);

		ArrayList<T> listOfT = new ArrayList<T>();
		for(JsonObject jsonObj : jsonObjs) {
			listOfT.add(new Gson().fromJson(jsonObj, clazz));
		}

		return listOfT;
	}


	public static <T> Collection<T> convertJson2Collection(String json, Class<T> clazz) throws JsonSyntaxException {

		Type type = new TypeToken<Vector<JsonObject>>() {}.getType();
		ArrayList<JsonObject> jsonObjs = new Gson().fromJson(json, type);

		Vector<T> colOfT = new Vector<T>();
		for(JsonObject jsonObj : jsonObjs) {
			colOfT.add(new Gson().fromJson(jsonObj, clazz));
		}
		return colOfT;
	}

	/**
	 * 获取GsonBuilder对象对时间和null格式化
	 * @param obj
	 * @return
	 */
	public static Gson getGson() {
		return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
	}
	/**
	 * 将对象转成json字符串
	 * @param obj
	 * @return
	 */
	public static String getJsonFromObject(Object obj) {
		return getGson().toJson(obj);
	}
	/**
	 * 将list对象转成json字符串
	 * @param obj
	 * @return
	 */
	public static <T> String convertList2Json(List<T> obj) {
		return getGson().toJson(obj);
	}
}
